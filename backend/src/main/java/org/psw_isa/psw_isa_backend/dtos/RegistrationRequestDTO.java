package org.psw_isa.psw_isa_backend.dtos;

import java.time.LocalDateTime;

import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.RegistrationRequest;

public class RegistrationRequestDTO {

	private Long id;
	private Patient patient;
	private boolean approved;
	private LocalDateTime time;
	
	
	
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	
	public RegistrationRequestDTO(RegistrationRequest registrationRequest) {
		this(registrationRequest.getId(), registrationRequest.getPatient(), registrationRequest.getApproved(), registrationRequest.getTime());   
	}
	
	public RegistrationRequestDTO(Long id, Patient patient, boolean approved, LocalDateTime time) {
		super();
		this.id = id;
		this.patient = patient;
		this.approved = approved;
		this.time = time;
	}
	public RegistrationRequestDTO() {
		
	}
	
	
	
	
	
}
