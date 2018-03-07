package xyz.nesting.quick.dao.mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public abstract class BaseMongoDao<T> {

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired  
	protected MongoTemplate mongoTemplate;
	
	public T get(String id, Class<T> t) {
		return mongoTemplate.findOne(new Query().addCriteria(Criteria.where("_id").is(id)), t);
	}
	
	public T getByUserUuid(String userUuid, Class<T> t) {
		return mongoTemplate.findOne(new Query().addCriteria(Criteria.where("user_uuid").is(userUuid)), t);
	}

	public void insert(T t) {
		mongoTemplate.insert(t);
	}
	
	public void save(T t) {
		mongoTemplate.save(t);
	}
	
	public T getBy(String name, Object value, Class<T> t) {
		return mongoTemplate.findOne(new Query().addCriteria(Criteria.where(name).is(value)), t);
	}
	
	public long countBy(String name, Object value, Class<T> t) {
		return mongoTemplate.count(new Query().addCriteria(Criteria.where(name).is(value)), t);
	}
	
}
