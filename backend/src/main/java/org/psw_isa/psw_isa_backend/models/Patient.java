package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.*;


@Entity
public class Patient {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	
	@ManyToOne
    @JoinColumn
	private User user; 
	
	
	private String insuranceID; 
	

	public Patient() 
	{
	}
	public Patient(User _user, String _insuranceID) {
		super();
		 
		this.user = _user;
		 
		this.insuranceID = _insuranceID;
		
	}
	
	 
	public User getUser() 
	{
		return this.user;
	}

	public void setUser(User newValue) 
	{
		this.user = newValue;
	}
	 
	public String getInsuranceID() 
	{
		return this.insuranceID;
	}

	public void setInsuranceID(String newValue) 
	{
		this.insuranceID = newValue;
	}
	
}