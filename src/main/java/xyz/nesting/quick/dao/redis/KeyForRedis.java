package xyz.nesting.quick.dao.redis;

public abstract class KeyForRedis {
	
	protected String PREFIX_USER = "redis:gb:user:";
	protected String PREFIX_AUTH = "redis:gb:auth:";
	
	protected String KEY_UserInfo(String userUuid) {
		return PREFIX_USER + userUuid;
	}
	
	protected String KEY_AuthIndividualTimes() {
		return PREFIX_AUTH + "individual:times";
	}
}
