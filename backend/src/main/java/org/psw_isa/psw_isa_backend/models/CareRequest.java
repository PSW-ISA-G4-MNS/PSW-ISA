package org.psw_isa.psw_isa_backend.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CareRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	@ManyToOne
    @JoinColumn
	private Care care;
	
	@ManyToOne
    @JoinColumn
	private Patient patient;
	
	private LocalDateTime time; 
	
	private Boolean approved;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Care getCare() {
		return care;
	}

	public void setCare(Care care) {
		this.care = care;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public CareRequest(Long id, Care care, LocalDateTime time, Boolean approved) {
		super();
		this.id = id;
		this.care = care;
		this.time = time;
		this.approved = approved;
	} 
	
	public CareRequest(Patient patient, Care care, LocalDateTime time, Boolean approved) {
		super();
		this.patient = patient;
		this.care = care;
		this.time = time;
		this.approved = approved;
	} 
	
	public CareRequest() {
		
	}
	
}
