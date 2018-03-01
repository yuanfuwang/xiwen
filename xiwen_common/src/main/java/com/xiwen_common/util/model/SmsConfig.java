package com.xiwen_common.util.model;

import java.util.Map;

public class SmsConfig {

	private static final long serialVersionUID = 5472582167230465255L;
	
	public final String ACCESS_KEY = "LTAIJgk5hDj3eLtq"; //"LTAIXdnmwr6T9CUb";
	
	public final String ACCESS_SECRET = "JXYk4WfqSimY5Y7WX4opP0ovjKFbgS";//"GxRfXHjqfuk589K8bIiW45ApphpynG";
	
	public final String SMS_HOST = "dysmsapi.aliyuncs.com";

	/**
	 * mail内容
	 */
	private Map<String, String> content;
	/**
	 * 手机号
	 */
	private String recNum;
	/**
	 * 模板code
	 */
	private String templateCode;
	
	
	private String signName; // 
	
	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	/**
	 * @return the content
	 */
	public Map<String, String> getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(Map<String, String> content) {
		this.content = content;
	}

	/**
	 * @return the templateCode
	 */
	public String getTemplateCode() {
		return templateCode;
	}

	/**
	 * @param templateCode the templateCode to set
	 */
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getRecNum() {
		return recNum;
	}

	public void setRecNum(String recNum) {
		this.recNum = recNum;
	}
	
}
