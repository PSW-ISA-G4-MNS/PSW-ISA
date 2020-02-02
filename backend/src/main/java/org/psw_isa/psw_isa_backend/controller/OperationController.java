package org.psw_isa.psw_isa_backend.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.psw_isa.psw_isa_backend.dtos.CareDTO;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Operation;
import org.psw_isa.psw_isa_backend.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "operation")
public class OperationController {

	
	@Autowired
	OperationService operationService;
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody Operation operation){
		
		Operation operation2=operationService.save(operation);
		
		return new ResponseEntity<>(operation2.getId(),HttpStatus.OK);
	}
	
	
	
	@GetMapping(value="/operationForDoctor/{id}")
	public ResponseEntity<ArrayList<Operation>> findOperationForDocktor(@PathVariable("id") String date){
		System.out.println("OVO JE DATUM"+date+"OOOO");
		LocalDate dateReal=LocalDate.parse(date);
		return new ResponseEntity<>(operationService.findAllOperationsForDateForDoctor(dateReal), HttpStatus.OK);
	}
}
