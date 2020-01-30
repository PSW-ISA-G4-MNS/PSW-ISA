package org.psw_isa.psw_isa_backend.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.psw_isa.psw_isa_backend.models.Operation;
import org.psw_isa.psw_isa_backend.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "operation")
public class OperationController {

	
	@Autowired
	OperationService operationService;
	
	
	
	
	@GetMapping(value="/operationForDoctor/{id}")
	public ResponseEntity<ArrayList<Operation>> findOperationForDocktor(@PathVariable("id") String date){
		System.out.println("OVO JE DATUM"+date+"OOOO");
		LocalDate dateReal=LocalDate.parse(date);
		return new ResponseEntity<>(operationService.findAllOperationsForDateForDoctor(dateReal), HttpStatus.OK);
	}
}
