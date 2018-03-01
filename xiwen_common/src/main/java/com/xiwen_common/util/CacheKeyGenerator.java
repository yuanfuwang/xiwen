package com.xiwen_common.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import com.xiwen_common.model.BaseModel;
import com.google.common.hash.Hashing;

public class CacheKeyGenerator implements KeyGenerator {  
	private static Logger log = LoggerFactory.getLogger(CacheKeyGenerator.class);
    // custom cache key  
    public static final int NO_PARAM_KEY = 0;  
    public static final int NULL_PARAM_KEY = 53;  
      
    @Override
    public Object generate(Object target, Method method, Object... params) {  
  
        StringBuilder key = new StringBuilder();  
        key.append(target.getClass().getSimpleName()).append(".").append(method.getName()).append(":");  
        if (params.length == 0) {  
            return key.append(NO_PARAM_KEY).toString();  
        }  
        for (Object param : params) {  
            if (param == null) {  
                log.warn("input null param for Spring cache, use default key={}", NULL_PARAM_KEY);  
                key.append(NULL_PARAM_KEY);  
            } else if (ClassUtils.isPrimitiveArray(param.getClass())) {  
                int length = Array.getLength(param);  
                for (int i = 0; i < length; i++) {  
                    key.append(Array.get(param, i));  
                    key.append(',');  
                }  
            } else if (ClassUtils.isPrimitiveOrWrapper(param.getClass()) || param instanceof String) {  
                key.append(param);  
            } else {  
                log.warn("Using an object as a cache key may lead to unexpected results. " +  
                        "Either use @Cacheable(key=..) or implement CacheKey. Method is " + target.getClass() + "#" + method.getName());
                String paramclass = param.getClass().getSimpleName();
                Field[] field = param.getClass().getDeclaredFields();
        		
        		Field[] baseFields = BaseModel.class.getDeclaredFields();
        		
        		Field[] fields = new Field[field.length + baseFields.length];// (Field[]) ArrayUtils.add(field, baseFields);
        		System.arraycopy(field, 0, fields, 0, field.length);
        		System.arraycopy(baseFields, 0, fields, field.length, baseFields.length);
        		for (Field item : fields) {
        			Object value = getFieldValueByName(item.getName(), param);
        			if (value != null ) {
        				paramclass = paramclass + "_" + item.getName() + "_" + String.valueOf(value);
					}
				}
                key.append(paramclass);  
            }  
            key.append('-');  
        }
        
        String finalKey = key.toString();  
        long cacheKeyHash = Hashing.murmur3_128().hashString(finalKey, Charset.defaultCharset()).asLong();  
        log.info("using cache key=" + finalKey);  
        return key.toString();  
    }
    
    private Object getFieldValueByName(String fieldName, Object o) {  
	       try {    
	           String firstLetter = fieldName.substring(0, 1).toUpperCase();    
	           String getter = "get" + firstLetter + fieldName.substring(1);    
	           Method method = o.getClass().getMethod(getter, new Class[] {});    
	           Object value = method.invoke(o, new Object[] {});    
	           return value;    
	       } catch (Exception e) {    
	           //log.error(e.getMessage(),e);    
	           return null;    
	       }    
	   }
} 