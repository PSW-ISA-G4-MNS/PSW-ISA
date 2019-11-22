package org.psw_isa.psw_isa_backend.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.psw_isa.psw_isa_backend.dtos.RegistrationDTO;
import org.psw_isa.psw_isa_backend.dtos.RegistrationRequestDTO;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.RegistrationRequest;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.RegistrationRequestRepository;
import org.psw_isa.psw_isa_backend.service.PatientService;
import org.psw_isa.psw_isa_backend.service.RegistrationRequestService;
import org.psw_isa.psw_isa_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "registrationRequests")
public class RegistrationRequestController {

	
	@Autowired
	private RegistrationRequestService registrationRequestService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private UserService userService;

	
	@GetMapping(value = "/all")
	public ResponseEntity<List<RegistrationRequestDTO>> findAll (Pageable pageable){
		
		Page<RegistrationRequest> registrationRequests = registrationRequestService.findAll(pageable);
		
		List<RegistrationRequestDTO> registrationRequestDTOs = new ArrayList();
		
		for (RegistrationRequest registrationRequest : registrationRequests){
			if(!registrationRequest.getApproved()) {
			registrationRequestDTOs.add(new RegistrationRequestDTO(registrationRequest));
			}
		}
		
		
		return new ResponseEntity<>(registrationRequestDTOs, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RegistrationRequestDTO> findOneById(@PathVariable("id") Long id){
		
		RegistrationRequest registrationRequest = registrationRequestService.findOneById(id);
		RegistrationRequestDTO registrationRequestDTO = new RegistrationRequestDTO(registrationRequest);
		
		return new ResponseEntity<>(registrationRequestDTO, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<RegistrationRequestDTO> save(@RequestBody RegistrationDTO registrationDTO){
		
		User user = new User(registrationDTO.getName(), registrationDTO.getLastname(), registrationDTO.getMobile_phone(), registrationDTO.getEmail(), registrationDTO.getAddress(), registrationDTO.getBirthday(), registrationDTO.getPassword());
		
		Patient patient = new Patient(user, registrationDTO.getInsuranceid());
		
		userService.save(user);
		patientService.save(patient);
		
		RegistrationRequest registrationRequest = new RegistrationRequest();
		registrationRequest.setPatient(patient);
		registrationRequest.setApproved(false);
		registrationRequest.setTime(LocalDateTime.now());
		
		registrationRequestService.save(registrationRequest);
		
		
		return new ResponseEntity<>(new RegistrationRequestDTO(registrationRequest), HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/approve/{id}")
	public ResponseEntity<Long> approve(@PathVariable("id") Long id){		
		RegistrationRequest registrationRequest = registrationRequestService.findOneById(id);
		
		registrationRequest.setApproved(true);
		registrationRequestService.save(registrationRequest);
		
		Patient patient = registrationRequest.getPatient();
		User user = patient.getUser();
		
		userService.save(user);
		patientService.save(patient);
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/decline/{id}")
	public ResponseEntity<Long> decline(@PathVariable("id") Long id){		
		RegistrationRequest registrationRequest = registrationRequestService.findOneById(id);
		
		registrationRequest.setApproved(false);
		registrationRequestService.save(registrationRequest);
		
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	
}
