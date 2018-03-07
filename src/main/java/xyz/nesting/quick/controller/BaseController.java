package xyz.nesting.quick.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import xyz.nesting.quick.dao.redis.RedisUserDao;
import xyz.nesting.quick.service.AuthService;
import xyz.nesting.quick.service.UserService;

public abstract class BaseController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected RedisUserDao redisUserDao;

	@Autowired
	protected UserService userService;

	@Autowired
	protected AuthService authService;
	
	@Resource(name="stringRedisTemplate")
	StringRedisTemplate stringRedisTemplate;
	
}
