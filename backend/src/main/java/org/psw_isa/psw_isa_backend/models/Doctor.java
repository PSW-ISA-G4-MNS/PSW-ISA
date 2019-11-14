package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.*;


@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	@ManyToOne
    @JoinColumn
	private User user; 
	
	@ManyToOne
    @JoinColumn
	private Specialization specialization; 
	
	
	private Integer yearsOfExperience; 
	

	public Doctor() 
	{
	}
	public Doctor(User _user, Specialization _specialization, Integer _yearsOfExperience) {
		super();
		 
		this.user = _user;
		 
		this.specialization = _specialization;
		 
		this.yearsOfExperience = _yearsOfExperience;
		
	}
	
	 
	public User getUser() 
	{
		return this.user;
	}

	public void setUser(User newValue) 
	{
		this.user = newValue;
	}
	 
	public Specialization getSpecialization() 
	{
		return this.specialization;
	}

	public void setSpecialization(Specialization newValue) 
	{
		this.specialization = newValue;
	}
	 
	public Integer getYearsOfExperience() 
	{
		return this.yearsOfExperience;
	}

	public void setYearsOfExperience(Integer newValue) 
	{
		this.yearsOfExperience = newValue;
	}
	
}