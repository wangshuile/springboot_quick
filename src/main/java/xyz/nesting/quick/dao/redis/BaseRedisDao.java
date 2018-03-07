package xyz.nesting.quick.dao.redis;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import xyz.nesting.quick.util.ZcJsonKit;

public abstract class BaseRedisDao extends KeyForRedis{
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	protected static ZcJsonKit _JSON = ZcJsonKit.nonNullCaseMapper();

	@Resource(name="stringRedisTemplate")
	protected StringRedisTemplate stringRedisTemplate;
	
	/**
	 * 根据key获取value
	 * 
	 * @param key
	 * @return
	 */
	protected String get(String key) {
		ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
		return opsForValue.get(key);
	}
	
	/**
	 * 设置key,value,expire
	 * @param key
	 * @param value
	 * @param expireTime
	 */
	protected void set(String key, String value, long expireTime) {
		ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
		operations.set(key, value);
		stringRedisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
	}
	
	/**
	 * 设置key,value
	 * 
	 * @param key
	 * @param value
	 */
	protected void set(String key, String value) {
		ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
		operations.set(key, value);
	}
	
	/**
	 * 删除对应的value
	 * 
	 * @param key
	 */
	protected void remove(final String key) {
		if (exists(key)) {
			stringRedisTemplate.delete(key);
		}
	}

	/**
	 * 判断缓存中是否有对应的value
	 * 
	 * @param key
	 * @return
	 */
	protected boolean exists(final String key) {
		return stringRedisTemplate.hasKey(key);
	}
	
	/**
	 * increment
	 * @param key
	 * @return
	 */
	public Double increment(final String key, final double delta){
		ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
		return operations.increment(key, delta);
	}
	
	/**
	 * 读取Hash缓存
	 * @param key
	 * @return
	 */
	public Map<String, Object> getHash(final String key){
		Map<String, Object> result = null;
		HashOperations<String, String, Object> opsForHash = stringRedisTemplate.opsForHash();
		result = opsForHash.entries(key);
		return result;
	}
	
	/**
	 * 读取Hash缓存
	 * @param key
	 * @return
	 */
	public Object getHash(final String key, String hashKey){
		HashOperations<String, String, Object> opsForHash = stringRedisTemplate.opsForHash();
		Object result = opsForHash.get(key, hashKey);
		return result;
	}
	
	/**
	 * 写Hash缓存
	 * @param key
	 * @return
	 */
	public void putHash(final String key, String hashKey, Object hashVal){
		HashOperations<String, String, Object> opsForHash = stringRedisTemplate.opsForHash();
		opsForHash.put(key, hashKey, hashVal);
	}
	
	/**
	 * 删除Hash缓存
	 * @param key
	 * @return
	 */
	public Long delHash(final String key, final Object... hashKeys){
		HashOperations<String, String, Object> opsForHash = stringRedisTemplate.opsForHash();
		Long result = opsForHash.delete(key, hashKeys);
		return result;
	}
	
	/**
	 * 增Hash值
	 * @param key
	 * @param hashKey
	 * @param delta
	 * 
	 * @return
	 */
	public Double increment(final String key, Object hashKey, Double delta){
		Double increment = stringRedisTemplate.opsForHash().increment(key, hashKey, delta);
		return increment;
	}
	
	/**
	 * 增Hash值
	 * @param key
	 * @param hashKey
	 * @param delta
	 * 
	 * @return
	 */
	public Long increment(final String key, Object hashKey, Long delta){
		Long increment = stringRedisTemplate.opsForHash().increment(key, hashKey, delta);
		return increment;
	}
}
