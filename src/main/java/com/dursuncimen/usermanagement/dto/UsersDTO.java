package com.dursuncimen.usermanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class UsersDTO {
	
	private String id;
	@NotNull(message="Kullanıcı Adı Boş Olamaz")
	@Length(max=50,message="Kullanıcı Adı En Fazla 30 Karakter Olabilir")
	private String firstName;
	@NotNull(message="Kullanıcı SoyAdı Boş Olamaz")
	@Length(max=50,message="Kullanıcı SoyAdı En Fazla 30 Karakter Olabilir")
	private String surName;
	@NotNull(message="Kullanıcı Telefonu Boş Olamaz")
	@Pattern(regexp="(^$|[0-9]{10})")
	private  String phone;
	
	public UsersDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UsersDTO [id=" + id + ", firstName=" + firstName + ", surName=" + surName + ", phone=" + phone + "]";
	}
	
	
	
}
