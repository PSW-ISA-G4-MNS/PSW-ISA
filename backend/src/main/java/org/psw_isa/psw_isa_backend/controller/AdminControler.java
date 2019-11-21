package org.psw_isa.psw_isa_backend.controller;

import org.psw_isa.psw_isa_backend.dtos.AdminClinicDTO;
import org.psw_isa.psw_isa_backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "adminClinic")
public class AdminControler {

	@Autowired
	AdminService adminService;
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<AdminClinicDTO> saveClinic(@RequestBody AdminClinicDTO acDTO){
		
	adminService.updateAdminClinic(acDTO.getClinic_Id(),acDTO.getAdmin_Id());
		
	
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
