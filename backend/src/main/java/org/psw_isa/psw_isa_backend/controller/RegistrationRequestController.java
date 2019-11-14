package org.psw_isa.psw_isa_backend.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.psw_isa.psw_isa_backend.dtos.RegistrationRequestDTO;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.RegistrationRequest;
import org.psw_isa.psw_isa_backend.repository.RegistrationRequestRepository;
import org.psw_isa.psw_isa_backend.service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<RegistrationRequestDTO>> findAll (Pageable pageable){
		
		Page<RegistrationRequest> registrationRequests = registrationRequestService.findAll(pageable);
		
		List<RegistrationRequestDTO> registrationRequestDTOs = new ArrayList();
		
		for (RegistrationRequest registrationRequest : registrationRequests){
			registrationRequestDTOs.add(new RegistrationRequestDTO(registrationRequest));
		}
		
		
		return new ResponseEntity<>(registrationRequestDTOs, HttpStatus.OK);
	}
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<RegistrationRequestDTO> save(@RequestBody Patient patient){
		
		RegistrationRequest registrationRequest = new RegistrationRequest();
		registrationRequest.setPatient(patient);
		registrationRequest.setApproved(false);
		registrationRequest.setTime(LocalDateTime.now());
		
		registrationRequestService.save(registrationRequest);
		
		
		return new ResponseEntity<>(new RegistrationRequestDTO(registrationRequest), HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/approved/{id}")
	public ResponseEntity<Long> approve(@RequestBody Long id){
		RegistrationRequestDTO registrationRequestDTO = new RegistrationRequestDTO();
		
		
		
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/decline/{id}")
	public ResponseEntity<Long> decline(@RequestBody Long id){
		RegistrationRequestDTO registrationRequestDTO = new RegistrationRequestDTO();
		
		
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	
}
