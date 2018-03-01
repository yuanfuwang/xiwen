package com.xiwen_video.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiwen_common.util.JedisUtils;
import com.xiwen_common.util.LogicalException;
import com.xiwen_common.util.model.SmsConfig;
import com.xiwen_video.services.SendSmsServices;
import com.xiwen_video.services.UserServices;
import com.xiwen_common.util.ApiResult;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.RandomUtil;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private SendSmsServices sendSmsServices;
	
	@Autowired
	private UserServices userServices;
	
	@RequestMapping(value = "/addUser",method={RequestMethod.GET})
    public ApiResult Hello(HttpServletRequest request) {
		return ApiResult.success("Hello World!!!");
	}
	
	/**
	 * 获取验证码
	 * @param mobile 手机号码
	 * @param request
	 * @return
	 */
	@RequestMapping(value="sendVerificationCode", method= {RequestMethod.GET, RequestMethod.POST})
	public ApiResult sendVerificationCode(String mobile, HttpServletRequest request) {
		try {
			if (!JedisUtils.exists(mobile)) {
				SmsConfig smsConfig = new SmsConfig();
				smsConfig.setRecNum(mobile);
				smsConfig.setTemplateCode("SMS_126461222");//SMS_105955142
				smsConfig.setSignName("大课网");//新园素
				String code = Convert.toStr(RandomUtil.randomInt(1000,9999));
				JedisUtils.set(mobile, code, 300);
				Map<String, String> params = new HashMap<String, String>();
		        params.put("code", code);
		        smsConfig.setContent(params);
		        sendSmsServices.sendMessage(smsConfig);
			}
			return ApiResult.success();
		} catch(LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch(Exception e) {
			return ApiResult.fail("验证码获取错误，请重新获取！");
		}
	}
	
	/**
	 * 注册
	 * @param mobile 手机号码
	 * @param verificationCode 验证码
	 * @param password 密码
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/register", method= {RequestMethod.POST})
	public ApiResult register(String mobile, String verificationCode, String password, HttpServletRequest request) {
		try {
			return ApiResult.success(userServices.register(mobile, verificationCode, password));
		} catch(LogicalException e) {
			return ApiResult.fail(e.getMessage());
		}catch(Exception e) {
			return ApiResult.fail("注册失败，请重新注册!");
		}
		
	}
	
	/**
	 * 登录
	 * @param mobile 手机号码
	 * @param password 密码
	 * @param requst
	 * @return
	 */
	@RequestMapping(value="/login", method= {RequestMethod.POST})
	public ApiResult login(String mobile, String password, HttpServletRequest requst) {
		try {
			return ApiResult.success(userServices.login(mobile, password));
		} catch(LogicalException e) {
			return ApiResult.fail(e.getMessage());
		}catch(Exception e) {
			return ApiResult.fail("注册失败，请重新注册!");
		}
	}
	
	/**
	 * 使用手机验证码登录
	 * @param mobile 手机号码
	 * @param verificationCode 验证码
	 * @param requst
	 * @return
	 */
	@RequestMapping(value="/loginByVerificationCode", method= {RequestMethod.POST})
	public ApiResult loginByVerificationCode(String mobile, String verificationCode, HttpServletRequest requst) {
		try {
			return ApiResult.success(userServices.loginByMobile(mobile, verificationCode));
		} catch(LogicalException e) {
			return ApiResult.fail(e.getMessage());
		}catch(Exception e) {
			return ApiResult.fail("注册失败，请重新注册!");
		}
	}
	
//	public ApiResult changePassword(String mobile, String oldPass, String newPass, HttpServletRequest request) {
//		
//	}
}
