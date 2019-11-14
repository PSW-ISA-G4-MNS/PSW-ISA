package org.psw_isa.psw_isa_backend.controller;

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
@RequestMapping(value = "login")
public class LogInController {

	@Autowired
	UserService userService;
	
	@PostMapping(value = "/{email}/{password}")
	public ResponseEntity<Long> login(@RequestBody String email, String password){
	
		User user = userService.findOneByemail(email);
		
		Long id = user.getId();
		
		if(password.equals(user.getPassword())) {
			
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
			HttpSession session = attr.getRequest().getSession(true); 
			
			session.setAttribute("user", user.getPassword());
			
			return new ResponseEntity<>(id, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		
		
	}
	
	
	
}
