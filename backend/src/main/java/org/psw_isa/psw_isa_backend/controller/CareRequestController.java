package org.psw_isa.psw_isa_backend.controller;

import javax.websocket.server.PathParam;

import org.psw_isa.psw_isa_backend.service.CareRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "careRequest")
public class CareRequestController {
	
	@Autowired
	private CareRequestService careRequestService;
	
	
	@PostMapping(value="new/{id}")
	public ResponseEntity<Long> createCareRequest(@PathParam("id")Long id){
		Long response = careRequestService.newCareRequest(id);
		if(response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
	}

}
