package com.xiwen_video.services.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiwen_common.util.MD5Utils;
import com.xiwen_common.util.service.TokenService;
import com.xiwen_common.util.AuthConstants;
import com.xiwen_common.util.model.TokenModel;
import com.xiwen_common.util.JedisUtils;
import com.xiwen_common.util.LogicalException;
import com.xiwen_video.mapper.UsersMapper;
import com.xiwen_video.model.Users;
import com.xiwen_video.services.UserServices;

/**
 * 用户Services实现
 * @author xiwen
 *
 */
@Service
@Transactional
public class UserServicesImpl implements UserServices {

	private static Logger log = LoggerFactory.getLogger(UserServicesImpl.class);
	
	@Autowired
	private UsersMapper userMapper;
	
	@Autowired
	private TokenService tokenService;
	@Override
	public String register(String mobile, String verificationCode, String password) throws LogicalException, Exception {
		if (StringUtils.isEmpty(mobile)) {
			throw new LogicalException("手机号码不能为空！");
		}
		if (StringUtils.isEmpty(verificationCode)) {
			throw new LogicalException("验证码不能为空！");
		}
		if (!JedisUtils.exists(mobile)) {
			throw new LogicalException("请先获取手机验证码！");
		}
		if (!JedisUtils.get(mobile).equals(verificationCode)) {
			throw new LogicalException("验证码错误，请重新输入！");
		}
		Users user = new Users();
		user.preInsert();
		user.setMobile(mobile);
		user.setType("0"); // 普通用户
		
		user.setPassword(MD5Utils.getMD5(password));
		userMapper.insert(user);
		
		TokenModel token = getUserToken(user);
		return token.getToken();
	}

	@Override
	public String login(String mobile, String password) throws LogicalException {
		if (StringUtils.isEmpty(mobile)) {
			throw new LogicalException("手机号码不能为空！");
		}
		if (StringUtils.isEmpty(password)) {
			throw new LogicalException("密码不能为空！");
		}
		int passwordInputCount = 5;
		double lockTime = 1;
		String key =  mobile + "_fail";
		

		int failTimes = 0;
		if (JedisUtils.exists(key)) {
			failTimes = Integer.parseInt(JedisUtils.get(key));
			if (failTimes >= passwordInputCount) {
				throw new LogicalException("登录密码已错误" + passwordInputCount + "次，登录名已锁定，请" + lockTime + "小时后再登录！");
			}
		}
		try {
			Users user = new Users();
			// 页面输入密码
			if (!StringUtils.isEmpty(password)) {
				user.setPassword(MD5Utils.getMD5(password));
			}
			user.setStatus(AuthConstants.DEL_FLAG_NORMAL);
			user.setMobile(mobile);
			
			Users userResult = userMapper.selectOne(user);
			if (userResult != null) {
				TokenModel token = getUserToken(userResult);
				
				return token.getToken();
			} else {
				// 登录错误次数+1
				failTimes = failTimes + 1;

				JedisUtils.set(key, String.valueOf(failTimes), (new Double(lockTime * 60 * 60)).intValue());
				throw new LogicalException(
						"登录用户名密码错误。该用户名还可以登录" + String.valueOf(passwordInputCount - failTimes) + "次。");
			}
		} catch (LogicalException e) {
			log.warn(e.getMessage());
			throw e;
		} catch (Exception e) {
			log.warn(e.getMessage());
			throw new LogicalException("登陆操作异常！");
		}
	}

	@Override
	public String loginByMobile(String mobile, String verificationCode) throws LogicalException {
		
		if (StringUtils.isEmpty(mobile)) {
			throw new LogicalException("手机号码不能为空！");
		}
		if (StringUtils.isEmpty(verificationCode)) {
			throw new LogicalException("验证码不能为空！");
		}
		if (!JedisUtils.exists(mobile)) {
			throw new LogicalException("请先获取手机验证码！");
		}
		if (!JedisUtils.get(mobile).equals(verificationCode)) {
			throw new LogicalException("验证码错误，请重新输入！");
		}
		
		try {
			Users user = new Users();
			user.setMobile(mobile);
			user.setStatus(AuthConstants.DEL_FLAG_NORMAL);
			Users userResult = userMapper.selectOne(user);
			if (userResult != null) {
				TokenModel token = getUserToken(userResult);
				
				return token.getToken();
			} else {
				throw new LogicalException("登录用户名密码错误。");
			}
		} catch (LogicalException e) {
			log.warn(e.getMessage());
			throw e;
		} catch (Exception e) {
			log.warn(e.getMessage());
			throw new LogicalException("登陆操作异常！");
		}
	}

	@Override
	public Users getUserInfoByUserId(String userId) throws LogicalException {
		if(StringUtils.isEmpty(userId)) {
			throw new LogicalException("主键不能为空！");
		}
		
		return userMapper.selectByPrimaryKey(userId);
	}

	/**
	 * 
	 * @param useraccount
	 * @return
	 * @throws Exception
	 */
	private TokenModel getUserToken(Users user) throws Exception {
		TokenModel tokenModel = tokenService.getTokenModelByUserId(user.getId());
		if (tokenModel != null) {
			// 清空token缓存
			tokenService.clearToken(tokenModel);
		}

		// 登录成功，记录token信息到redis中
		tokenModel = tokenService.createToken(user.getId(), user.getType());
		return tokenModel;
	}

}
