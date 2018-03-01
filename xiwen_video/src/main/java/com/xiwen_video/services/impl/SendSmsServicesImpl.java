package com.xiwen_video.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiwen_common.util.LogicalException;
import com.xiwen_common.util.model.SmsConfig;
import com.xiwen_video.services.SendSmsServices;
import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

@Service
@Transactional
public class SendSmsServicesImpl implements SendSmsServices {
	private static Logger logger = LoggerFactory.getLogger(SendSmsServicesImpl.class);
	
	public void sendMessage(SmsConfig smsConfig) throws LogicalException {
		
		String accessKey = smsConfig.ACCESS_KEY;
		String accessSecret = smsConfig.ACCESS_SECRET;
		String host = smsConfig.SMS_HOST;
        String signName = smsConfig.getSignName();
        String templateCode = smsConfig.getTemplateCode();
        String recNum = smsConfig.getRecNum();
        String content = JSON.toJSONString(smsConfig.getContent());
        
        logger.info(String.format("接收号码：%s，短信签名：%s，短信内容：%s，模板编号：%s", recNum,
                signName, content, templateCode));

		try {
			IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKey,
					accessSecret);
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", host);
			IAcsClient acsClient = new DefaultAcsClient(profile);
			 //组装请求对象
			 SendSmsRequest request = new SendSmsRequest();
			 //使用post提交
			 request.setMethod(MethodType.POST);
			 request.setPhoneNumbers(recNum);
			 //必填:短信签名-可在短信控制台中找到
			 request.setSignName(signName);
			 //必填:短信模板-可在短信控制台中找到
			 request.setTemplateCode(templateCode);
			 //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
			 //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
			 request.setTemplateParam(content);
			 SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
			 if(!"OK".equals(sendSmsResponse.getCode())) {
				 throw new LogicalException(sendSmsResponse.getMessage());
			 }
		} catch (ClientException e) {
			throw new LogicalException("发送失败");
		}      
		
	}
}
