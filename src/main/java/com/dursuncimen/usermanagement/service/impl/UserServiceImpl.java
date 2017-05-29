package com.dursuncimen.usermanagement.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UsersDTO createUser(UsersDTO user) {
		logger.info("Create User {}.", user);		
		return UsersMapper.modelToDto(usersDao.createUser(UsersMapper.dtoToModel(user)));
	}

	@Override
	public void deleteUser(UsersDTO user) {
		logger.info("Delete User {}.", user);	
		usersDao.deleteUser(UsersMapper.dtoToModel(user));

	}

	@Override
	public void update(UsersDTO user) {
		logger.info("Update User {}.", user);	
		usersDao.update(UsersMapper.dtoToModel(user));

	}

	@Override
	public List<UsersDTO> findAllUsers() {
		logger.info("List All Users.");	
		return UsersMapper.modelToDtoList(usersDao.findAllUsers());
	}

	@Override
	public UsersDTO findById(String id) {
		logger.info("Find User With this {} Id.", id);	
		return UsersMapper.modelToDto(usersDao.findById(id));
	}

	@Override
	public void deleteUserById(String userId) {
		logger.info("Delete User With This {} Id.", userId);	
		usersDao.deleteUserById(userId);
	}

}
