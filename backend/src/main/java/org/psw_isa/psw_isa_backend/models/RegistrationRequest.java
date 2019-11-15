package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.*;


@Entity
public class RegistrationRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	@ManyToOne
    @JoinColumn
	private Patient patient; 
	
	
	private LocalDateTime time; 
	
	
	private Boolean approved; 
	

	public RegistrationRequest() 
	{
	}
	public RegistrationRequest(Patient _patient, LocalDateTime _time, Boolean _approved) {
		super();
		 
		this.patient = _patient;
		 
		this.time = _time;
		 
		this.approved = _approved;
		
	}
	
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Patient getPatient() 
	{
		return this.patient;
	}

	public void setPatient(Patient newValue) 
	{
		this.patient = newValue;
	}
	 
	public LocalDateTime getTime() 
	{
		return this.time;
	}

	public void setTime(LocalDateTime newValue) 
	{
		this.time = newValue;
	}
	 
	public Boolean getApproved() 
	{
		return this.approved;
	}

	public void setApproved(Boolean newValue) 
	{
		this.approved = newValue;
	}
	
}