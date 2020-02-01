package org.psw_isa.psw_isa_backend.controller;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.OperationRequest;
import org.psw_isa.psw_isa_backend.service.OperationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "operationRequest")
public class OperationRequestController {

	@Autowired
	OperationRequestService operationRequestService;
	
	
	@GetMapping(value="")
	public ResponseEntity<List<OperationRequest>> findAll(){
		return new ResponseEntity<>(operationRequestService.findAll(), HttpStatus.OK);
	}
}