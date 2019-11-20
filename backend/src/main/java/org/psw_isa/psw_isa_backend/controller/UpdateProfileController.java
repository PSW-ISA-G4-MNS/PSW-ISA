package org.psw_isa.psw_isa_backend.controller;


import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@RequestMapping(value = "updateProfile")
public class UpdateProfileController {

	
	@Autowired
	UserService userService;
	
	
	@PostMapping(value = "/submit/{firstname}/{lastname}/{address}/{birthday}/{mobile_phone}/")
	public ResponseEntity<Long> updateUser(@RequestBody String firstname, String lastname, String address, LocalDate birthday, String mobile_phone){
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
		HttpSession session = attr.getRequest().getSession(true); 
		
		User forChange = (User) session.getAttribute("user");
		Long id = forChange.getId();
		
		
		userService.updateUser(firstname, lastname, address, birthday, mobile_phone, id);
		
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@GetMapping(value = "")
	public ResponseEntity<User> populateUpdateData(){
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
		HttpSession session = attr.getRequest().getSession(true); 
		
		User forChange = (User) session.getAttribute("user");
		
		return new ResponseEntity<>(forChange, HttpStatus.OK);
	}

}
