package org.psw_isa.psw_isa_backend.controller;

import javax.servlet.http.HttpSession;

import org.psw_isa.psw_isa_backend.dtos.LogInDTO;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@RequestMapping(value = "login")
public class LogInController {

	@Autowired
	UserService userService;
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> login(@RequestBody LogInDTO loginData){
	
		User user = userService.findOneByemail(loginData.getEmail());
		
		if(user != null) {
			Long id = user.getId();
		
			if(loginData.getPassword().equals(user.getPassword())) {
				
				ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
				HttpSession session = attr.getRequest().getSession(true); 
				
				session.setAttribute("user", user.getEmail());
				
				return new ResponseEntity<>(id, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		
	}
	
	
	
}
