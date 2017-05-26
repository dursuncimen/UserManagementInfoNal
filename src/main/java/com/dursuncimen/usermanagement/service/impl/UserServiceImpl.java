package com.dursuncimen.usermanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dursuncimen.usermanagement.dao.UsersDAO;
import com.dursuncimen.usermanagement.dto.UsersDTO;
import com.dursuncimen.usermanagement.mapper.UsersMapper;
import com.dursuncimen.usermanagement.service.UsersService;
@Service
public class UserServiceImpl implements UsersService {
	@Autowired
	private UsersDAO usersDao;
	@Override
	public void createUser(UsersDTO user) {
		usersDao.createUser(UsersMapper.dtoToModel(user));
		
	}

	@Override
	public void deleteUser(UsersDTO user) {
		usersDao.deleteUser(UsersMapper.dtoToModel(user));
		
	}

	@Override
	public void update(UsersDTO user) {
		usersDao.update(UsersMapper.dtoToModel(user));
		
	}

	@Override
	public List<UsersDTO> findAllUsers() {
		return UsersMapper.modelToDtoList(usersDao.findAllUsers());
	}

}
