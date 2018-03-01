package com.xiwen_common.util;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.RowBounds;
import com.xiwen_common.util.model.TokenModel;
import com.xiwen_common.util.service.impl.TokenServiceImpl;
import com.mysql.jdbc.StringUtils;

public class RequestUtils {
	 private static final String   OFFSET    = "offset";
	 private static final String   LIMITE    = "limit";
	/**
	 * 获取当前用户
	 *
	 * @param request
	 * @return String
	 */
	public static String CurrentUserId(HttpServletRequest request) throws Exception{
		String token = request.getHeader(AuthConstants.AUTH_TOKEN);
		TokenServiceImpl tokenService = new TokenServiceImpl();
		TokenModel tokenModel = tokenService.getTokenModel(token);
		return tokenModel.getUserId();

	}

	/**
	 * 获取当前用户类型
	 *
	 * @param request
	 * @return String
	 */
	public static String CurrentUserType(HttpServletRequest request) throws Exception{
		String token = request.getHeader(AuthConstants.AUTH_TOKEN);
		TokenServiceImpl tokenService = new TokenServiceImpl();
		TokenModel tokenModel = tokenService.getTokenModel(token);
		return tokenModel.getUserType();

	}
	
//	/**
//	 * 获取当前用户租户ID
//	 *
//	 * @param request
//	 * @return String
//	 */
//	public static String CurrentTenantId(HttpServletRequest request) throws Exception{
//		String token = request.getHeader(AuthConstants.AUTH_TOKEN);
//		TokenServiceImpl tokenService = new TokenServiceImpl();
//		TokenModel tokenModel = tokenService.getTokenModel(token);
//		return tokenModel.getTenantId();
//
//	}
	
	/**
	 * 设置分页信息
	 *
	 * @param request
	 * @return RowBounds
	 */
	public static RowBounds setPage(HttpServletRequest request) throws Exception{
		RowBounds rowBounds = new RowBounds();
		String page = request.getHeader(OFFSET);
		String limit = request.getHeader(LIMITE);
		if(!StringUtils.isNullOrEmpty(page) && !StringUtils.isNullOrEmpty(limit)){
			int offset = (Integer.parseInt(page) - 1) * Integer.parseInt(limit);
			rowBounds = new RowBounds(offset,Integer.parseInt(limit));
		}
		return rowBounds;
	}
}
