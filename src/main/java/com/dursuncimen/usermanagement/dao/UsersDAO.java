package com.dursuncimen.usermanagement.dao;

import java.util.List;

import com.dursuncimen.usermanagement.model.Users;

public interface UsersDAO {

	public void createUser(Users user);

	public void deleteUser(Users user);

	public void update(Users user);

	public List<Users> findAllUsers();

}
