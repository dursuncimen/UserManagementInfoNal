package com.dursuncimen.usermanagement.service;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dursuncimen.usermanagement.dto.UsersDTO;
import com.dursuncimen.usermanagement.mapper.UsersMapper;
import com.dursuncimen.usermanagement.model.Users;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class UsersMapperTest {
   
	@Test
	public void modelToDtoTest(){
		Users userModel = new Users();
		userModel.setFirstName("Dursun");
		userModel.setPhone("(555) 555-5555 ");
		userModel.setSurName("Çimen");
		userModel.setId(UUID.randomUUID().toString());
		UsersDTO usersDto = UsersMapper.modelToDto(userModel);
		Assert.assertSame("Id'ler Aynı Olmalıdır", userModel.getId(), usersDto.getId());
		Assert.assertSame("Telefon'lar Aynı Olmalıdır", userModel.getPhone(), usersDto.getPhone());
		Assert.assertSame("Ad'lar Aynı Olmalıdır", userModel.getFirstName(), usersDto.getFirstName());
		Assert.assertSame("Soyad'lar Aynı Olmalıdır", userModel.getSurName(), usersDto.getSurName());
	}
	
	@Test
	public void DtoTomodel(){
		UsersDTO userDto = new UsersDTO();
		userDto.setFirstName("Dursun");
		userDto.setPhone("(555) 555-5555 ");
		userDto.setSurName("Çimen");
		userDto.setId(UUID.randomUUID().toString());
		Users userModel = UsersMapper.dtoToModel(userDto);
		Assert.assertSame("Id'ler Aynı Olmalıdır", userDto.getId(), userModel.getId());
		Assert.assertSame("Telefon'lar Aynı Olmalıdır", userDto.getPhone(), userModel.getPhone());
		Assert.assertSame("Ad'lar Aynı Olmalıdır", userDto.getFirstName(), userModel.getFirstName());
		Assert.assertSame("Soyad'lar Aynı Olmalıdır", userDto.getSurName(), userModel.getSurName());
	}
	
}
