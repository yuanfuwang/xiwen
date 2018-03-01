package com.xiwen_common.util.model;

import java.io.Serializable;
import java.util.List;

/**
 * 基于Token认证的实体模型
 * 
 * @author shenjian
 */
public class TokenModel implements Serializable {

	private static final long serialVersionUID = 1L;

	// 用户编号
	private String userId;

	// 用户类型
	private String userType;
		
	// 随机生成的uuid
	private String token;
		
	public TokenModel(String userId, String token, String userType) {
		this.userId = userId;
		this.token = token;
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * 检测token是否有效
	 * 
	 * @return
	 */
	public boolean isValid() {
		// TODO : 可以增加字段提高安全性，例如时间戳、ip、url签名等
		return token != null;
	}
}
