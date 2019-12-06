package org.psw_isa.psw_isa_backend.controller;


import org.psw_isa.psw_isa_backend.models.Prescription;
import org.psw_isa.psw_isa_backend.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "prescription")
public class PrescriptionController {
	
		
		@Autowired
		private PrescriptionService prescriptionService;
		
		
		@PostMapping(consumes = "application/json")
		public ResponseEntity<Long> save(@RequestBody Prescription prescription){
			
			
			prescriptionService.save(prescription);
			
			return new ResponseEntity<>(prescription.getId(),HttpStatus.OK);
		}
}
