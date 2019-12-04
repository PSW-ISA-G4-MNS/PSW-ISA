package org.psw_isa.psw_isa_backend.controller;

import org.psw_isa.psw_isa_backend.service.DoctorService;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "doctor")
public class DoctorController {
	
	@Autowired 
	DoctorService doctorService;
	
	@GetMapping(value="/")
	public ResponseEntity<List<Doctor>> findAll(){
		return new ResponseEntity<>(doctorService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Doctor> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(doctorService.findOneByid(id), HttpStatus.OK);
	}
	
	
}
