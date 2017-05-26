package com.dursuncimen.usermanagement.service;

import java.util.List;

import com.dursuncimen.usermanagement.dto.UsersDTO;

public interface UsersService {
	
	public void createUser(UsersDTO user);

	public void deleteUser(UsersDTO user);

	public void update(UsersDTO user);

	public List<UsersDTO> findAllUsers();
	
}
