package xyz.nesting.quick.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {
	
	/**
	 * 配置StringRedisTemplate,使用Cache Redis
	 * @param redisConnectionFactory
	 * @return
	 */
	@Bean
	public StringRedisTemplate stringRedisTemplate(@Autowired RedisConnectionFactory redisConnectionFactory) {
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
		stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
		return stringRedisTemplate;
	}
	
}
