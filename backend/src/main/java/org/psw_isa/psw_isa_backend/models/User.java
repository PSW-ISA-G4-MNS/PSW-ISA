package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.*;


@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	
	private String firstname; 
	
	
	private String lastname; 
	
	
	private String mobilePhone; 
	
	
	private String email; 
	
	
	private String address; 
	
	
	private LocalDate birthday; 
	

	public User() 
	{
	}
	public User(String _firstname, String _lastname, String _mobilePhone, String _email, String _address, LocalDate _birthday) {
		super();
		 
		this.firstname = _firstname;
		 
		this.lastname = _lastname;
		 
		this.mobilePhone = _mobilePhone;
		 
		this.email = _email;
		 
		this.address = _address;
		 
		this.birthday = _birthday;
		
	}
	
	 
	public String getFirstname() 
	{
		return this.firstname;
	}

	public void setFirstname(String newValue) 
	{
		this.firstname = newValue;
	}
	 
	public String getLastname() 
	{
		return this.lastname;
	}

	public void setLastname(String newValue) 
	{
		this.lastname = newValue;
	}
	 
	public String getMobilePhone() 
	{
		return this.mobilePhone;
	}

	public void setMobilePhone(String newValue) 
	{
		this.mobilePhone = newValue;
	}
	 
	public String getEmail() 
	{
		return this.email;
	}

	public void setEmail(String newValue) 
	{
		this.email = newValue;
	}
	 
	public String getAddress() 
	{
		return this.address;
	}

	public void setAddress(String newValue) 
	{
		this.address = newValue;
	}
	 
	public LocalDate getBirthday() 
	{
		return this.birthday;
	}

	public void setBirthday(LocalDate newValue) 
	{
		this.birthday = newValue;
	}
	
}
