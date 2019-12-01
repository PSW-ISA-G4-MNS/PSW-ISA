package org.psw_isa.psw_isa_backend.controller;

import org.psw_isa.psw_isa_backend.Logger;
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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RestController
@RequestMapping(value = "clinic")
public class ClinicControler {

	
	@Autowired
	private ClinicService clinicService;
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody Clinic clinic){
		
		Logger.getInstance().info("Saving clinic with location parameters: " + clinic.getLocationLat().toString() + " " + clinic.getLocationLon().toString());
		clinicService.save(clinic);
		
		return new ResponseEntity<>(clinic.getId(),HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json", value="/{id}")
	public ResponseEntity<Long> update(@PathVariable("id") Long id, @RequestBody Clinic clinic){
		
		Clinic clinic_old = clinicService.findOneByid(id);

		clinicService.save(clinic);
		clinic_old.assign(clinic);
		clinicService.save(clinic_old);
		return new ResponseEntity<>(clinic.getId(),HttpStatus.OK);
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Clinic> read(@PathVariable("id") Long id){
		
		Clinic clinic = clinicService.findOneByid(id);
		return new ResponseEntity<>(clinic,HttpStatus.OK);
	}
	@GetMapping(value="")
	public ResponseEntity<List<Clinic>> list(){
		
		return new ResponseEntity<>(clinicService.findAll(),HttpStatus.OK);
	}
}
