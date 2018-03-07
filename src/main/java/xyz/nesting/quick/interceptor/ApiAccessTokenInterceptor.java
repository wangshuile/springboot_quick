package xyz.nesting.quick.interceptor;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import xyz.nesting.quick.constant.ErrorCode;
import xyz.nesting.quick.util.ZcApiResponse;
import xyz.nesting.quick.util.ZcJsonKit;


/**
 * 路由拦截器
 * 验证access_token
 * 
 * @author zhengyue
 *
 */
@Component
public class ApiAccessTokenInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(ApiAccessTokenInterceptor.class) ;
	
	@Resource(name="stringRedisTemplate")
	StringRedisTemplate stringRedisTemplate;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return isAccessAllowed(request, response) ? true : onAccessDenied(request, response);
	}
	
	/**
	 * 验证 access_token
	 * 
	 * @param httpRequest
	 * @param httpResponse
	 * @return
	 * @throws Exception
	 */
	protected boolean isAccessAllowed(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception {
		String accessToken = httpRequest.getHeader("access_token");
		logger.debug("Request: [access_token:{}]", accessToken);
		if (StringUtils.isNotBlank(accessToken)) {
			//根据access_token获取user_uuid
			String userUuid = "";
			httpRequest.setAttribute("user_uuid", userUuid);
			logger.debug("Request: [user_uuid:{}]", userUuid);
		}
		return false;
	}

	/**
	 * access_token 验证失败返回
	 * @param httpRequest
	 * @param httpresponse
	 * @return
	 * @throws Exception
	 */
	protected boolean onAccessDenied(HttpServletRequest httpRequest, HttpServletResponse httpresponse) throws Exception {
		
		httpresponse.setHeader("Access-Control-Allow-Origin", "*");
		httpresponse.setContentType("application/json"); 
		httpresponse.setStatus(200);
		
		PrintWriter writer = httpresponse.getWriter();
		ZcApiResponse resp = ZcApiResponse.error(ErrorCode.ACCESS_TOKEN_ERROR, "access_token invalid", null);
		writer.write(ZcJsonKit.nonNullCaseMapper().toJson(resp));
		writer.flush();
		writer.close();
		
		return false;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3)
			throws Exception {
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView arg3)
			throws Exception {
	}

}
