package xyz.nesting.quick.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 路由拦截器
 * 
 * @author zhengyue
 *
 */
@Component
public class ApiPublicInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(ApiPublicInterceptor.class) ;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.debug("Request: [URL:{}, METHOD:{}]", request.getRequestURL(), request.getMethod());
		return true;
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
