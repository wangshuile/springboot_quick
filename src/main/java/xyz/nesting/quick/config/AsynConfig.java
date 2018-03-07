/**
 * 
 */
package xyz.nesting.quick.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 
 * @Description: TODO(添加描述)
 * @Author zhengyue
 * @Version: 0.0.1
 * @CreateAt 2017年12月22日-下午5:47:42
 *
 */
@Configuration
@EnableAsync // 启动异步调用
public class AsynConfig {

	/**
	 * 自定义异步线程池
	 * 
	 * @return
	 */
	@Bean
	public AsyncTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setThreadNamePrefix("Anno-Executor");
		executor.setMaxPoolSize(10);

		// 设置拒绝策略
		executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				// .....
			}
		});
		// 使用预定义的异常处理类
		// executor.setRejectedExecutionHandler(new
		// ThreadPoolExecutor.CallerRunsPolicy());

		return executor;
	}

}
