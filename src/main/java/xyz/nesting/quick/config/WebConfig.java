package xyz.nesting.quick.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import xyz.nesting.quick.interceptor.ApiAccessTokenInterceptor;
import xyz.nesting.quick.interceptor.ApiPublicInterceptor;

/**
 * 定义MVC配置
 * @author zhengyue
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	private ApiPublicInterceptor apiPublicInterceptor;
	@Autowired
	private ApiAccessTokenInterceptor apiAccessTokenInterceptor;
	
	/**
	 * 进行拦截器的注册处理操作
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(apiPublicInterceptor).addPathPatterns("/**");
		registry.addInterceptor(apiAccessTokenInterceptor).excludePathPatterns("/public/**");
		super.addInterceptors(registry);
	}
	
}
