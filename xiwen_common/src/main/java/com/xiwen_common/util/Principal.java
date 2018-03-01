package com.xiwen_common.util;

import java.io.Serializable;

/**
 * 授权用户信息
 * 
 * @author shenjian
 */
public class Principal implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id; // 编号
	private String username; // 登录名
	private String password; // 密码

//	public Principal(String id, String username, String password) {
//		this.id = id;
//		this.username = username;
//		this.password = password;
//	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取SESSIONID
	 */
	public String getSessionid() {
		return id;
	}

	@Override
	public String toString() {
		return id;
	}

}