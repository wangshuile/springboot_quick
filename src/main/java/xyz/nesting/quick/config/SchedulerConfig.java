package xyz.nesting.quick.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

@Configuration // 定时调度的配置类一定要实现指定的父接口
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) { // 开启一个线程调度池
		taskRegistrar.setScheduler(Executors.newScheduledThreadPool(20));
	}
}
