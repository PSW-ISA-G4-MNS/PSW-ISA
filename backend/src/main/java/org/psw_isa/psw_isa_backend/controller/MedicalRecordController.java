package org.psw_isa.psw_isa_backend.controller;

import java.util.ArrayList;

import org.psw_isa.psw_isa_backend.models.MedicalRecord;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.Prescription;
import org.psw_isa.psw_isa_backend.service.MedicalRecordService;
import org.psw_isa.psw_isa_backend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "medicalRecord")
public class MedicalRecordController {

	@Autowired 
	MedicalRecordService medicalRecordService;
	
	@Autowired
	PatientService patientService;

	 @GetMapping(value = "/{id}")
		public ResponseEntity<MedicalRecord> findOneById(@PathVariable("id") Long id){
		 
		List<MedicalRecord> listaKartona=medicalRecordService.findAll();
		MedicalRecord pacijentovKarton=null;
		
		for(MedicalRecord karton : listaKartona) {
			
			if(karton.getPatient().getId()==id) {
				pacijentovKarton=karton;
			}
		}
	    
		if(pacijentovKarton==null) {
			
			MedicalRecord novi=new MedicalRecord(patientService.findOneByid(id));
			
			medicalRecordService.save(novi);
			
			return new ResponseEntity<>(novi, HttpStatus.OK);
		}
		
		else {
			return new ResponseEntity<>(pacijentovKarton, HttpStatus.OK);
		}
		
		
			
		}
}
