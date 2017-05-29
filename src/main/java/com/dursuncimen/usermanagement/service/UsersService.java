package com.dursuncimen.usermanagement.service;

import java.util.List;

import com.dursuncimen.usermanagement.dto.UsersDTO;

public interface UsersService {

	public UsersDTO createUser(UsersDTO user);

	public void deleteUser(UsersDTO user);

	public UsersDTO findById(String id);

	public void update(UsersDTO user);

	public List<UsersDTO> findAllUsers();
	
	public void deleteUserById(String userId);

}
