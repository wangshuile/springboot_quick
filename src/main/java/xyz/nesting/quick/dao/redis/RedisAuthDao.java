package xyz.nesting.quick.dao.redis;

import org.springframework.stereotype.Component;

@Component
public class RedisAuthDao extends BaseRedisDao {
	
	public boolean overAuthIndividualTimes(String userUuid) {
		Object result = getHash(KEY_AuthIndividualTimes(), userUuid);
		Long times = result == null ? 0 : Long.parseLong(result.toString());
		if (times >= 5) {
			return true;
		}
		return false;
	}

	public void incAuthIndividualTimes(String userUuid) {
		increment(KEY_AuthIndividualTimes(), userUuid, 1L);
	}
}
