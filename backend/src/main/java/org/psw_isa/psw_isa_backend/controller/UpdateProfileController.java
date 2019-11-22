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
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> updateUser(@RequestBody User user){
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
		HttpSession session = attr.getRequest().getSession(true); 
		
		User forChange = (User) session.getAttribute("user");
		Long id = forChange.getId();
		
		
		userService.updateUser(user.getFirstname(), user.getLastname(), user.getAddress(), user.getBirthday(), user.getMobilePhone(), id);
		
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@GetMapping(value = "")
	public ResponseEntity<User> populateUpdateData(){
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
		HttpSession session = attr.getRequest().getSession(true); 
		
		String email = (String) session.getAttribute("user");
		
		User user = userService.findOneByemail(email);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
