package com.dursuncimen.usermanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users {
	
	
	@Id
	private String id;
	private String surName;
	private String firstName;
	private String phone;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getSurName() {
		return surName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setSurName(String surName) {
		this.surName = surName;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", surName=" + surName + ", firstName=" + firstName + ", phone=" + phone + "]";
	}
	
	
}
