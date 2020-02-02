package org.psw_isa.psw_isa_backend.controller;

import org.psw_isa.psw_isa_backend.service.DoctorService;
import org.psw_isa.psw_isa_backend.service.ClinicService;
import org.psw_isa.psw_isa_backend.models.Patient;

import java.util.List;

import org.psw_isa.psw_isa_backend.dtos.ClinicFilterDTO;
import org.psw_isa.psw_isa_backend.models.Doctor;
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
@RequestMapping(value = "doctor")
public class DoctorController {
	
	@Autowired 
	DoctorService doctorService;

	@Autowired
	ClinicService clinicService;
	
	@GetMapping(value="/")
	public ResponseEntity<List<Doctor>> findAll(){
		return new ResponseEntity<>(doctorService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Doctor> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(doctorService.findOneByid(id), HttpStatus.OK);
	}
	
	@GetMapping(value="/patients")
	public ResponseEntity<List<Patient>> findPatients(){
		return new ResponseEntity<>(clinicService.findPatientsForClinic(doctorService.getClinic()), HttpStatus.OK);
	}
	/*
	@PostMapping(value="/filter", consumes = "application/json")
	public ResponseEntity<List<Doctor>> FreeDoctorsFromClinic(@RequestBody ClinicFilterDTO clinicFilterDTO){
		return new ResponseEntity<>(doctorService.findFreeDoctors(clinicFilterDTO), HttpStatus.OK);
	}
	*/
	
  @GetMapping(value="/getFreeDoctorsForClinic/{clinicID}/{careTypeID}/{date}") 
  	public ResponseEntity<List<Doctor>>listFreeDoctorsForClinic(@PathVariable("clinicID") Long clinicID, @PathVariable("careTypeID") Long careTypeID, @PathVariable("date") String date){
  
	  return new ResponseEntity<>(doctorService.listFreeDoctorsForClinic(clinicID, careTypeID, date), HttpStatus.OK);
	  }
}
