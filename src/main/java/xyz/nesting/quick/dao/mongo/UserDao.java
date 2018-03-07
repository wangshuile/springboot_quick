package xyz.nesting.quick.dao.mongo;

import java.util.Date;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.WriteResult;

import xyz.nesting.quick.constant.ErrorCode;
import xyz.nesting.quick.domain.MgUser;
import xyz.nesting.quick.exception.BusinessException;

@Component
public class UserDao extends BaseMongoDao<MgUser>{

	public void updateProfile(String userUuid, String name, String description) {
		Update update = new Update();
		update.set("name", name);
		update.set("description", description);
		update.set("updateTime", new Date());
		WriteResult result = mongoTemplate.updateFirst(new Query().addCriteria(Criteria.where("user_uuid").is(userUuid)), update, MgUser.class);
		if (!result.isUpdateOfExisting()) {
			BusinessException.error(ErrorCode.FAILED, "update fail");
		}
	}

	public void updateImage(String userUuid, String image) {
		Update update = new Update();
		update.set("image", image);
		update.set("updateTime", new Date());
		WriteResult result = mongoTemplate.updateFirst(new Query().addCriteria(Criteria.where("user_uuid").is(userUuid)), update, MgUser.class);
		if (!result.isUpdateOfExisting()) {
			BusinessException.error(ErrorCode.FAILED, "update fail");
		}
	}

}
