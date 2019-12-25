package org.psw_isa.psw_isa_backend.controller;

import org.psw_isa.psw_isa_backend.service.CareService;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.dtos.CareDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "care")
public class CareController {
	
	@Autowired 
	CareService careService;
		
	
	@GetMapping(value="/all")
	public ResponseEntity<List<Care>> findAllUnassignedAndUpcoming(){
		return new ResponseEntity<>(careService.findAllUnassignedAndUpcoming(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Care> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(careService.findOneByid(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody CareDTO careDTO){
		
		Care care = careService.save(careDTO);
		return new ResponseEntity<>(care.getId(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Long> saveWithReview(@RequestBody CareDTO careDTO){
		
		Care care = careService.save(careDTO);
		return new ResponseEntity<>(care.getId(),HttpStatus.OK);
	}
}
