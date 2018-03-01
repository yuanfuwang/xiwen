package com.xiwen_video.services;

import com.xiwen_common.util.LogicalException;
import com.xiwen_common.util.model.SmsConfig;

public interface SendSmsServices {

	/**
	 * 发送短信
	 * @param smsConfig
	 * @throws LogicalException
	 */
	public void sendMessage(SmsConfig smsConfig) throws LogicalException;
}
