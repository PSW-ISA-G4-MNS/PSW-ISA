package org.psw_isa.psw_isa_backend.controller;

import java.time.LocalDateTime;

import org.psw_isa.psw_isa_backend.dtos.RegistrationRequestDTO;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.RegistrationRequest;
import org.psw_isa.psw_isa_backend.service.ClinicService;
import org.psw_isa.psw_isa_backend.service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "clinic")
public class ClinicControler {

	
	@Autowired
	private ClinicService clinicService;
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody Clinic clinic){
		
		
		clinicService.save(clinic);
		
		return new ResponseEntity<>(clinic.getId(),HttpStatus.OK);
	}
}
