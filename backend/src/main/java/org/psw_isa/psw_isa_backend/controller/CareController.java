package org.psw_isa.psw_isa_backend.controller;

import org.psw_isa.psw_isa_backend.service.CareService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.dtos.CareDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(value="/getPredefindedCaresForClinic/{id}")
	public ResponseEntity<List<Care>> findAllUnassignedAndUpcomingforClinic(@PathVariable("id") Long id){
		return new ResponseEntity<>(careService.findAllUnassignedAndUpcomingForClinic(id), HttpStatus.OK);
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
	
	
	@PostMapping(value="/change", consumes = "application/json")
	public ResponseEntity<Long> saveWithReview(@RequestBody CareDTO careDTO){
		
		Care care = careService.save(careDTO);
		return new ResponseEntity<>(care.getId(),HttpStatus.OK);
	}

	

	@PostMapping(value="/reservate/{id}")
	public ResponseEntity<Long> reservatePredefined(@PathVariable("id") Long id){
		careService.assignPatientToCare(id);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}

	
	@PostMapping(value="/review", consumes = "application/json")
	public ResponseEntity<Long> updateCareReview(@RequestBody CareDTO careDTO){
		
		careService.updateCareReview(careDTO);
		return new ResponseEntity<>(careDTO.getCareId(),HttpStatus.OK);
	}
	
	@PostMapping(value="/reviewOld", consumes = "application/json")
	public ResponseEntity<Long> updateOldCareReview(@RequestBody CareDTO careDTO){
		
		careService.updateOldCareReview(careDTO);
		return new ResponseEntity<>(careDTO.getCareId(),HttpStatus.OK);
	}

	
	@GetMapping(value="/careForDoctor/{id}")
	public ResponseEntity<ArrayList<Care>> findCareForDoctor(@PathVariable("id") String date){
		System.out.println("OVO JE DATUM"+date+"OOOO");
		LocalDate dateReal=LocalDate.parse(date);
		return new ResponseEntity<>(careService.findAllAssignedForDateForDoctor(dateReal), HttpStatus.OK);
	}
	
	
	@GetMapping(value="/oldReviews")
	public ResponseEntity<ArrayList<Care>> findOldCareForDoctor(){
		
		
		
		return new ResponseEntity<>(careService.findAllOldCares(), HttpStatus.OK);
	}

}
