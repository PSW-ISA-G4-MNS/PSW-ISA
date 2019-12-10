package org.psw_isa.psw_isa_backend.controller;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.CareType;
import org.psw_isa.psw_isa_backend.service.CareTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "careType")
public class CareTypeController {
	
	@Autowired 
	CareTypeService careTypeService;
	
	
	@GetMapping(value="")
	public ResponseEntity<List<CareType>> findAllUnassignedAndUpcoming(){
		return new ResponseEntity<>(careTypeService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<CareType> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<CareType>(careTypeService.findOneByid(id), HttpStatus.OK);
	}

}
