package xyz.nesting.quick.dao.redis;

import org.springframework.stereotype.Component;

import xyz.nesting.quick.domain.MgUser;

@Component
public class RedisUserDao extends BaseRedisDao {
	
	public MgUser getByUserUuid(String userUuid) {
		String value = get(KEY_UserInfo(userUuid));
		return _JSON.fromJson(value, MgUser.class);
	}

	public void setUser(String userUuid, MgUser mgUser, long expireTime) {
		set(KEY_UserInfo(userUuid), _JSON.toJson(mgUser), expireTime);
	}
	
	public void removeByUserUuid(String userUuid) {
		remove(KEY_UserInfo(userUuid));
	}

}
