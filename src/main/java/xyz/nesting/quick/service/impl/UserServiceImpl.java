package xyz.nesting.quick.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import xyz.nesting.quick.constant.ErrorCode;
import xyz.nesting.quick.domain.MgUser;
import xyz.nesting.quick.exception.BusinessException;
import xyz.nesting.quick.service.BaseService;
import xyz.nesting.quick.service.UserService;

@Service
public class UserServiceImpl extends BaseService implements UserService{

	@Override
	public MgUser getUserByUserUuid(String userUuid) {
		return userDao.getByUserUuid(userUuid, MgUser.class);
	}

	@Override
	public MgUser add(String userUuid, String mobile) {
		
		MgUser user = userDao.getByUserUuid(userUuid, MgUser.class);
		if (null != user) {
			BusinessException.error(ErrorCode.FAILED, "用户已存在");
		}
		
		Date curDate = new Date();
		//初始化用户信息
		MgUser mgUser = new MgUser();
		mgUser.setUserUuid(userUuid);
		mgUser.setMobile(mobile);
		mgUser.setName("user"+userUuid);
		mgUser.setImage("https://www.intbee.com/static/img/login/small_logo.png");
		mgUser.setDescription("自我介绍");
		mgUser.setCreateTime(curDate);
		mgUser.setUpdateTime(curDate);
		userDao.insert(mgUser);
		
		log.debug("new user:{}", mgUser);
		return mgUser;
	}

	@Override
	public void updateProfile(String userUuid, String name, String description) {
		userDao.updateProfile(userUuid,name,description);
		redisUserDao.removeByUserUuid(userUuid);
		log.debug("updateProfile done");
	}

	@Override
	public void updateImage(String userUuid, String image) {
		userDao.updateImage(userUuid,image);
		redisUserDao.removeByUserUuid(userUuid);
		log.debug("updateImage done");
	}
	
}
