package com.dursuncimen.usermanagement.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dursuncimen.usermanagement.dto.UsersDTO;
import com.dursuncimen.usermanagement.model.Users;

public class UsersMapper {
	
	public static UsersDTO modelToDto(Users model) {
		if (model == null) {
			return null;
		}
		UsersDTO dto = new UsersDTO();
		dto.setId(model.getId());
		dto.setFirstName(model.getFirstName());
		dto.setSurName(model.getSurName());
		dto.setPhone(model.getPhone());
		return dto;
	}

	public static Users dtoToModel(UsersDTO dto) {
		if (dto == null) {
			return null;
		}
		Users model = new Users();
		model.setId(dto.getId());
		model.setFirstName(dto.getFirstName());
		model.setSurName(dto.getSurName());
		model.setPhone(dto.getPhone());
		return model;
	}

	public static List<UsersDTO> modelToDtoList(List<Users> modelList) {
		if (modelList == null) {
			return null;
		}
		List<UsersDTO> dtoList = new ArrayList<UsersDTO>();
		for (Users model : modelList) {
			dtoList.add(modelToDto(model));
		}
		return dtoList;
	}

	public static List<Users> dtoToModelList(List<UsersDTO> dtoList) {
		if (dtoList == null) {
			return null;
		}
		List<Users> modelList = new ArrayList<Users>();
		for (UsersDTO dto : dtoList) {
			modelList.add(dtoToModel(dto));
		}
		return modelList;
	}
}
