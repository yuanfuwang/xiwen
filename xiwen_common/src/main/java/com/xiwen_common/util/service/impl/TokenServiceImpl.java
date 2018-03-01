package com.xiwen_common.util.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.xiwen_common.util.AuthConstants;
import com.xiwen_common.util.JedisUtils;
import com.xiwen_common.util.MD5Utils;
import com.xiwen_common.util.model.TokenModel;
import com.xiwen_common.util.service.TokenService;


/**
 * 通过Redis存储和验证token的实现类
 * 
 * @author shenjian
 */
@Component
public class TokenServiceImpl implements TokenService {
	
	Logger logger = LoggerFactory.getLogger(TokenServiceImpl.class);
	// token存储前缀
	private final static String TOKEN_PREFIX = "token_";
	
	// 用户存储前缀
	private final static String USER_PREFIX = "user_";

	/**
     * 创建一个token关联上指定用户
     * @param userId 指定用户的id
     * @return 生成的token
     */
    public TokenModel createToken(
    		String userId
    		,String userType) throws Exception {

    	String token = MD5Utils.getMD5(userId);
		
        TokenModel tokenModel = new TokenModel(userId, token,userType);
        
        // 存储到redis并设置过期时间
        JedisUtils.setObject(TOKEN_PREFIX + token, tokenModel, AuthConstants.TOKEN_EXPIRES_TIME);
        JedisUtils.set(USER_PREFIX + userId, token, AuthConstants.TOKEN_EXPIRES_TIME);
        logger.info("token超时时间:"+ AuthConstants.TOKEN_EXPIRES_TIME +"s");
        
        return tokenModel;
    }
    
    /**
     * 获取token模型对象
     * @param token
     * @return 是否有效
     */
    public TokenModel getTokenModel(String token) {
    	TokenModel tokenModel = null;
    	if (token != null) {
    		tokenModel = (TokenModel) JedisUtils.getObject(TOKEN_PREFIX + token);
    	}
    	return tokenModel;
    }
    
    /**
     * 根据用户编号查询token模型
     * @param userId 用户编号
     * @return
     */
    public TokenModel getTokenModelByUserId(String userId) {
    	String token = JedisUtils.get(USER_PREFIX + userId);
    	if (token != null) {
    		return getTokenModel(token);
    	}
    	
    	return null;
    }
    
    /**
     * 检查token是否有效
     * @param token
     * @return 是否有效
     */
    public boolean checkToken(String token) {
        TokenModel tokenModel = getTokenModel(token);
        return checkToken(tokenModel);
    }
    
    /**
     * 检查token是否有效
     * @param tokenModel 
     * @return 是否有效
     */
	public boolean checkToken(TokenModel tokenModel) {
		if (tokenModel != null && tokenModel.isValid()) {
			String token = tokenModel.getToken();
        	// 验证成功，说明此用户进行了一次有效的操作，延长token的过期时间
            JedisUtils.setObject(TOKEN_PREFIX + token, tokenModel, AuthConstants.TOKEN_EXPIRES_TIME);
            JedisUtils.set(USER_PREFIX + tokenModel.getUserId(), token, AuthConstants.TOKEN_EXPIRES_TIME);
            
            return true;
        }
        
        return false;
	}

    /**
     * 清空token
     * @param token
     */
    public void clearToken(String token) {
    	TokenModel tokenModel = getTokenModel(token);
    	clearToken(tokenModel);
    }
    
    /**
     * 清除token
     * @param tokenModel token模型对象
     */
    public void clearToken(TokenModel tokenModel) {
    	if (tokenModel != null) {
    		JedisUtils.delObject(TOKEN_PREFIX + tokenModel.getToken());
    		JedisUtils.del(USER_PREFIX + tokenModel.getUserId());
    	}
    }
}