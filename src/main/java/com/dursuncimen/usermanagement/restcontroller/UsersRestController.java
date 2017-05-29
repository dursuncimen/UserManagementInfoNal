package com.dursuncimen.usermanagement.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dursuncimen.usermanagement.dto.UsersDTO;
import com.dursuncimen.usermanagement.service.UsersService;

@RestController
public class UsersRestController {
	@Autowired
	private UsersService usersService;
	private static final Logger logger = LoggerFactory.getLogger(UsersRestController.class);
	
	/*
	 * This method returns all users as JSON Object  with GET Request
	 */
	@RequestMapping(value = "/users/list", method = RequestMethod.GET)
	public @ResponseBody List<UsersDTO> findAllUsers() {
		logger.info("Return All Users.");	
		return (List<UsersDTO>) usersService.findAllUsers();
	}
	
	

	/*
	 * This method deletes user with user's id
	 * @param String userId in  request path
	 * @return HTTP 200 or HTTP 400
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/users/delete/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId) {
		try {	

			logger.info("Get Request For Delete User With This {} Id.", userId);	
			usersService.deleteUserById(userId);
			return new ResponseEntity(null, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Post Request For Delete User With This {} Id And Error {}", userId, e.getMessage());	
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}	
	}
	
	/*
	 * This method updates existing user or creates new user 
	 * @param UsersDTO in request body 
	 * @return Users and HTTP 200 or HTTP 400 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/users/add",method = RequestMethod.POST)
	public ResponseEntity<?>  addUser( @RequestBody @Valid  UsersDTO user, BindingResult result) {	
		if(result.hasErrors()){
			logger.error("Post Request For Add Or Update User With This {} User And Error {}", user, result.getAllErrors());
			return  new ResponseEntity(user, HttpStatus.BAD_REQUEST);
		}
		try {
			if(user.getId().equals(null) || user.getId() ==""){
				usersService.createUser(user);
				logger.info("Post Request For Add User With This {} User.", user);	}
			else{					
				usersService.update(user);
				logger.info("Post Request For Update User With This {} User.", user);}
			return  new ResponseEntity(user, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Post Request For Add Or User Update With This {} User And Error {}", user, e.toString());
			return  new ResponseEntity(user, HttpStatus.BAD_REQUEST);
		}		
		
	}

}
