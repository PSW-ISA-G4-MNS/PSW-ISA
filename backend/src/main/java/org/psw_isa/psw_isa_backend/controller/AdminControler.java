package org.psw_isa.psw_isa_backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.psw_isa.psw_isa_backend.dtos.AdminClinicDTO;
import org.psw_isa.psw_isa_backend.models.ClinicAdministrator;
import org.psw_isa.psw_isa_backend.service.AdminService;
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
@RequestMapping(value = "adminClinic")
public class AdminControler {

	@Autowired
	AdminService adminService;
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<AdminClinicDTO> saveClinic(@RequestBody AdminClinicDTO acDTO){
		
		adminService.updateAdminClinic(acDTO.getClinic_Id(),acDTO.getAdmin_Id());
		
	
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AdminClinicDTO> getAdmin(@PathVariable("id") Long id){
		
		ClinicAdministrator clinicAdministrator = adminService.findOneByid(id);
		
		AdminClinicDTO adminClinicDTO = new AdminClinicDTO(clinicAdministrator);
		
		return new ResponseEntity<>(adminClinicDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<AdminClinicDTO>> getFreeAdmins(){
		List<AdminClinicDTO>adminClinicDTOs = adminService.findAllFree();
		
		return new ResponseEntity<>(adminClinicDTOs, HttpStatus.OK);
		
	}
	
	
}
