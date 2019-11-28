package org.psw_isa.psw_isa_backend.controller;

import org.psw_isa.psw_isa_backend.models.Diagnosis;
import org.psw_isa.psw_isa_backend.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "medicine")
public class DiagnosisControler {
	
	@Autowired
	private DiagnosisService diagnosisService;
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody Diagnosis diagnosis){
		
		
		diagnosisService.save(diagnosis);
		
		return new ResponseEntity<>(diagnosis.getId(),HttpStatus.OK);
	}
}
