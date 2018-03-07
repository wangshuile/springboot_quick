package xyz.nesting.quick.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import xyz.nesting.quick.constant.ErrorCode;
import xyz.nesting.quick.domain.MgAuthIndividual;
import xyz.nesting.quick.exception.BusinessException;
import xyz.nesting.quick.service.AuthService;
import xyz.nesting.quick.service.BaseService;

@Service
public class AuthServiceImpl extends BaseService implements AuthService{

	@Override
	public void auth(String userUuid, String idName, String idNumber, String cardNumber) {
		
		if (redisAuthDao.overAuthIndividualTimes(userUuid) ) {
			BusinessException.error(ErrorCode.FAILED, "超过验证次数,验证失败");
		}
		
		MgAuthIndividual authIndividual = authIndividualDao.getByUserUuid(userUuid, MgAuthIndividual.class);
		if (authIndividual != null) {
			BusinessException.error(ErrorCode.FAILED, "该用户已认证");
		}
		
		authIndividual = authIndividualDao.getBy("id_number", idNumber, MgAuthIndividual.class);
		if (authIndividual != null) {
			BusinessException.error(ErrorCode.FAILED, "该身份证号已被认证,请更换");
		}
		
		//记录验证次数
		redisAuthDao.incAuthIndividualTimes(userUuid);
		
		//调用ping++认证接口
		
		//认证成功，插入数据
		authIndividual = new MgAuthIndividual();
		authIndividual.setUserUuid(userUuid);
		authIndividual.setIdName(idName);
		authIndividual.setIdNumber(idNumber);
		authIndividual.setCardNumber(cardNumber);
		authIndividual.setUpdateTime(new Date());
		authIndividualDao.insert(authIndividual);
		
	}

	@Override
	public MgAuthIndividual get(String userUuid) {
		return authIndividualDao.getByUserUuid(userUuid, MgAuthIndividual.class);
	}

}
