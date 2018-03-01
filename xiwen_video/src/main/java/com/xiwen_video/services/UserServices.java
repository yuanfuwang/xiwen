package com.xiwen_video.services;

import com.xiwen_common.util.LogicalException;
import com.xiwen_video.model.Users;

public interface UserServices {

	/**
	 * 注册
	 * @param mobile 手机号码
	 * @param verificationCode 验证码
	 * @param password 密码
	 * @return
	 * @throws LogicalException
	 */
	public String register(String mobile, String verificationCode, String password) throws LogicalException, Exception;
	
	/**
	 * 登录
	 * @param mobile 手机号
	 * @param password 密码
	 * @return
	 * @throws LogicalException
	 */
	public String login(String mobile, String password) throws LogicalException;
	
	/**
	 * 手机验证码登录
	 * @param mobile 手机号码
	 * @param verificationCode 验证码
	 * @return
	 * @throws LogicalException
	 */
	public String loginByMobile(String mobile, String verificationCode) throws LogicalException;
	
	/**
	 * 根据ID获取用户信息
	 * @param userId 用户ID
	 * @return
	 * @throws LogicalException
	 */
	public Users getUserInfoByUserId(String userId) throws LogicalException;
}
