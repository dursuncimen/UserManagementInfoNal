package com.dursuncimen.usermanagement.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.dursuncimen.usermanagement.dao.UsersDAO;
import com.dursuncimen.usermanagement.model.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {

	public static final String COLLECTION_NAME = "Users";

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void createUser(Users user) {
		if (mongoTemplate.collectionExists(Users.class)) {
			mongoTemplate.createCollection(Users.class);
		}
		user.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(user, COLLECTION_NAME);
	}

	@Override
	public void deleteUser(Users user) {
		mongoTemplate.remove(user, COLLECTION_NAME);
	}

	@Override
	public void update(Users user) {
		Query qry = new Query(Criteria.where("id").is(user.getId()));
		Update update = new Update();
		update.set("firstName", user.getFirstName());
		update.set("surName", user.getSurName());
		update.set("phone", user.getPhone());
		mongoTemplate.updateFirst(qry, update,COLLECTION_NAME);	

	}

	@Override
	public List<Users> findAllUsers() {
		return mongoTemplate.findAll(Users.class, COLLECTION_NAME);
	}
	

}
