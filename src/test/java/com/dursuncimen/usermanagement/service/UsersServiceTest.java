package com.dursuncimen.usermanagement.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.dursuncimen.usermanagement.dto.UsersDTO;
import com.dursuncimen.usermanagement.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@Transactional
public class UsersServiceTest {

	@Autowired
	private UsersService usersService;
	
	@Test
	@Transactional
	@Rollback(true)
	public void  createUser() {
		int rowCount = usersService.findAllUsers().size();
		UsersDTO user = new UsersDTO();
		user.setFirstName("Dursun");
		user.setSurName("Çimen");
		user.setPhone("05555555555");		
		user = usersService.createUser(user);				
		Assert.assertEquals("Object Sayisi +1 olmalıdir.", rowCount+1, usersService.findAllUsers().size());	
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void  deleteUser() {
		UsersDTO user = new UsersDTO();
		user.setFirstName("Dursun");
		user.setSurName("Çimen");
		user.setPhone("05555555555");		
		user = usersService.createUser(user);		
		int rowCount = usersService.findAllUsers().size();
		usersService.deleteUser(user);
		Assert.assertEquals("Object Sayisi -1 olmalıdir.", rowCount, usersService.findAllUsers().size()+1);
	}
	@Test
	@Transactional
	@Rollback(true)
	public void  findUser() {
		UsersDTO user = new UsersDTO();
		user.setFirstName("Dursun");
		user.setSurName("Çimen");
		user.setPhone("05555555555");		
		user = usersService.createUser(user);				
		UsersDTO newUser = usersService.findById(user.getId());
		Assert.assertNotNull("Nesne null olmamalidir.", newUser);;
		Assert.assertEquals("Property değerleri ayni olmalidir.",user.toString(),newUser.toString());		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void  updateUser() {
		UsersDTO user = new UsersDTO();
		user.setFirstName("Dursun");
		user.setSurName("Çimen");
		user.setPhone("05555555555");		
		user = usersService.createUser(user);				
		UsersDTO newUser = usersService.findById(user.getId());
		newUser.setFirstName("Ufuk");
		newUser.setSurName("Dağ");
		newUser.setPhone("05555554444");	
		usersService.update(newUser);
		newUser = usersService.findById(user.getId());
		Assert.assertNotSame("Property değerleri ayni olmamalidir.",user.toString(),newUser.toString());
	}
	
}
