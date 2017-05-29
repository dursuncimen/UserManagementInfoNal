package com.dursuncimen.usermanagement.dao;

import java.util.List;

import com.dursuncimen.usermanagement.model.Users;

public interface UsersDAO {

	public Users createUser(Users user);

	public void deleteUser(Users user);

	public void deleteUserById(String userId);
	
	public void update(Users user);
	
	public Users findById(String id);

	public List<Users> findAllUsers();

}
