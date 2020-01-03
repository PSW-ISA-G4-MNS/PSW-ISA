package org.psw_isa.psw_isa_backend.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.psw_isa.psw_isa_backend.dtos.RegistrationDTO;
import org.psw_isa.psw_isa_backend.dtos.RegistrationRequestDTO;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.RegistrationRequest;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.psw_isa.psw_isa_backend.repository.RegistrationRequestRepository;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RegistrationRequestService {

	@Autowired
	private RegistrationRequestRepository registrationRequestRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PatientRepository patientRepository;
	
	public List<RegistrationRequestDTO> findAllNotApproved(){
		List<RegistrationRequest> registrationRequests = registrationRequestRepository.findAll();
		List<RegistrationRequestDTO> registrationRequestDTOs = new ArrayList();
		
		for (RegistrationRequest registrationRequest : registrationRequests){
			if(!registrationRequest.getApproved()) {
				
				if(!registrationRequest.getRejected())
				registrationRequestDTOs.add(new RegistrationRequestDTO(registrationRequest));
			}
		}
		
		return registrationRequestDTOs;
	}
	
	public List<RegistrationRequest> findAll(){
		return registrationRequestRepository.findAll();
	}
	
	public RegistrationRequest save (RegistrationRequest registrationRequest) {
		return registrationRequestRepository.save(registrationRequest);
	}
	
	public RegistrationRequest newRegistrationRequest(RegistrationDTO registrationDTO) {
		User user = new User(registrationDTO.getName(), registrationDTO.getLastname(), registrationDTO.getMobile_phone(), registrationDTO.getEmail(), registrationDTO.getAddress(), registrationDTO.getBirthday(), registrationDTO.getPassword());
		
		Patient patient = new Patient(user, registrationDTO.getInsuranceid());
		
		User validator = userRepository.findOneByemail(registrationDTO.getEmail());
		if(validator == null) {
			userRepository.save(user);
			patientRepository.save(patient);
			
			RegistrationRequest registrationRequest = new RegistrationRequest();
			registrationRequest.setPatient(patient);
			registrationRequest.setApproved(false);
			registrationRequest.setRejected(false);
			registrationRequest.setTime(LocalDateTime.now());
			
			registrationRequestRepository.save(registrationRequest);
			
			
			return registrationRequest;
		} else {
			return null;
		}
		
	}
	
	public void remove(Long id) {
		registrationRequestRepository.deleteById(id);
	}
	
	public RegistrationRequestDTO findOneByIdDTO(Long id) {
		RegistrationRequestDTO registrationRequestDTO = new RegistrationRequestDTO(registrationRequestRepository.findOneById(id));
		return registrationRequestDTO;
	}
	
	public RegistrationRequest findOneById(Long id) {
		return registrationRequestRepository.findOneById(id);
	}
	
	public Long approve(Long id) {
		RegistrationRequest registrationRequest = registrationRequestRepository.findOneById(id);
		
		registrationRequest.setApproved(true);
		registrationRequestRepository.save(registrationRequest);
		
		return registrationRequest.getId();
	}
	
	public Long decline(Long id) {
		RegistrationRequest registrationRequest = registrationRequestRepository.findOneById(id);
		
		registrationRequest.setRejected(true);
		registrationRequestRepository.save(registrationRequest);
		
		return registrationRequest.getId();
	}
	
}
