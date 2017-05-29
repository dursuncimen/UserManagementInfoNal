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
	/*
	 * Insert new User in mongodb
	 * @param Users 
	 * Users's id should be null
	 * return same Users object
	 */	
	@Override
	public Users createUser(Users user) {
		if (mongoTemplate.collectionExists(Users.class)) {
			mongoTemplate.createCollection(Users.class);
		}
		user.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(user, COLLECTION_NAME);
		return user;
	}
	
	/*
	 * Delete existing user 
	 * @param Users 
	 */	
	@Override
	public void deleteUser(Users user) {
		mongoTemplate.remove(user, COLLECTION_NAME);
	}
	
	/*
	 * Update existing user	
	 * @Param Users	 *   
	 */
	@Override
	public void update(Users user) {
		Query qry = new Query(Criteria.where("id").is(user.getId()));
		Update update = new Update();
		update.set("firstName", user.getFirstName());
		update.set("surName", user.getSurName());
		update.set("phone", user.getPhone());
		mongoTemplate.updateFirst(qry, update,COLLECTION_NAME);	

	}
	
	/*
	 * Find all user 
	 * @return list Users
	 */	
	@Override
	public List<Users> findAllUsers() {
		return mongoTemplate.findAll(Users.class, COLLECTION_NAME);
	}
	
	/*
	 * Find user by user's id
	 * @param string id
	 * @return Users 
	 */
	@Override
	public Users findById(String id) {
		Query qry = new Query(Criteria.where("_id").is(id));
		return (Users) mongoTemplate.findOne(qry, Users.class,COLLECTION_NAME);
		
	}
	/*
	 * Delete User by user's id
	 * @param String userId
	 */
	@Override
	public void deleteUserById(String userId) {
		Query qry = new Query(Criteria.where("_id").is(userId));
		deleteUser(mongoTemplate.findOne(qry, Users.class,COLLECTION_NAME));
		
	}
	

}
