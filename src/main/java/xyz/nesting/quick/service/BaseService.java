package xyz.nesting.quick.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.nesting.quick.dao.mongo.AuthIndividualDao;
import xyz.nesting.quick.dao.mongo.UserDao;
import xyz.nesting.quick.dao.redis.RedisAuthDao;
import xyz.nesting.quick.dao.redis.RedisUserDao;

public abstract class BaseService {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired  
	protected UserDao userDao;
	
	
	@Autowired
	protected RedisUserDao redisUserDao;

	
	@Autowired
	protected AuthIndividualDao authIndividualDao;
	
	@Autowired
	protected RedisAuthDao redisAuthDao;
	
}
