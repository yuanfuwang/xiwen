package com.xiwen_common.util;

import java.io.File;
import java.io.OutputStream;  
import java.util.List;
import java.util.Map;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelWriter;  
  
public class ExcelUtil {  
	
	public static List<List<Object>> readExcel2007(File f){
		ExcelReader reader = cn.hutool.poi.excel.ExcelUtil.getReader(f);
		return reader.read();
	}
	
    public static void downloadExcel(Iterable<?> data,Map<String, String> title,OutputStream out){ 
    	ExcelWriter writer = cn.hutool.poi.excel.ExcelUtil.getWriter();
    	if(title != null){
    		writer.setHeaderAlias(title);
    	}
    	
    	writer.write(data);
    	writer.flush(out);
    	writer.close();
    }
}
