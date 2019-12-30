package org.psw_isa.psw_isa_backend.controller;


import org.psw_isa.psw_isa_backend.dtos.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "email")
public class SendEmailController {

	//@Autowired
	//SendEmailService sendEmailService;
	
	//@PostMapping(value="/sendReject", consumes = "application/json")
	//public ResponseEntity<String> sendRejectMail(@RequestBody EmailDTO emailDTO){
		
	//	sendEmailService.sendSimpleMessage(emailDTO.getTo(), emailDTO.getSubject(), emailDTO.getMessage());
	//	return new ResponseEntity<>(emailDTO.getTo(),HttpStatus.OK);
	//}
	
	
	@Autowired
    public JavaMailSender emailSender;
	
	@PostMapping(value="/sendReject", consumes = "application/json")
	public ResponseEntity<String> sendRejectMail(@RequestBody EmailDTO emailDTO)
	  {
		       
		        SimpleMailMessage message = new SimpleMailMessage(); 
		        message.setTo(emailDTO.getTo()); 
		        message.setSubject(emailDTO.getSubject()); 
		        message.setText(emailDTO.getMessage());
		        emailSender.send(message);
		        return new ResponseEntity<>(emailDTO.getTo(),HttpStatus.OK); 
		    }
}
