package com.xiwen_common.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.xiwen_common.util.model.TokenModel;
import com.xiwen_common.util.service.TokenService;
import com.mysql.jdbc.StringUtils;

public class Interceptor implements HandlerInterceptor{
	
	@Autowired
	private TokenService tokenService;
	
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
    	
    	// 从请求头的header中得到token
        String token = request.getHeader(AuthConstants.AUTH_TOKEN);
        
        if(!StringUtils.isNullOrEmpty(token)){
        	// 验证token
            TokenModel tokenModel = tokenService.getTokenModel(token);
            if (tokenService.checkToken(tokenModel)) {
            	// 如果token验证成功，将token对应的用户id存在request中，便于后续的使用
            	request.setAttribute(AuthConstants.CURRENT_USER_ID, tokenModel.getUserId());
            } else {
            	// 验证token失败，则返回直接返回用户未登录错误
            	errorResponse(response, ApiResult.fail(ApiCode.USER_NOT_LOGIN));
            	return false;
            }
        }else{
        	// 验证token失败，则返回直接返回用户未登录错误
        	errorResponse(response, ApiResult.fail(ApiCode.USER_NOT_LOGIN));
        	return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {

    }
    
    /**
     * 错误输出
     * @param response
     * @param apiResult
     */
    public void errorResponse(HttpServletResponse response, ApiResult apiResult) throws IOException {
        response.setContentType("application/json; charset=utf-8");  
        PrintWriter out = response.getWriter();
        out.println(JsonMapper.nonDefaultMapper().toJson(apiResult));
        out.flush();
        out.close();
    }
}
