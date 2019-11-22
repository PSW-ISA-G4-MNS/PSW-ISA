package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.psw_isa.psw_isa_backend.dtos.LogInDTO;
import org.psw_isa.psw_isa_backend.models.RegistrationRequest;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.RegistrationRequestRepository;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RegistrationRequestRepository registrationRequestRepository;
	
	public User findOneByemail(String email) {
		return userRepository.findOneByemail(email);	
	}
	
	public User findOneByid(Long id) {
		return userRepository.findOneByid(id);	
	}

	public int updateUser(String firstname, String lastname, String address, LocalDate birthday, String mobile_phone, Long id){
		return userRepository.updateUser(firstname, lastname, address, birthday, mobile_phone, id);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public int login(LogInDTO loginData) {
		User user = userRepository.findOneByemail(loginData.getEmail());
		if(user != null) {
			Long id = user.getId();
			
			List<RegistrationRequest> registrationRequests = registrationRequestRepository.findAll();
			
			
			if(loginData.getPassword().equals(user.getPassword())) {
				
				for(RegistrationRequest request : registrationRequests) {
					if(request.getPatient().getUser().equals(id)) {
						if(request.getApproved() == true) {	
							ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
							HttpSession session = attr.getRequest().getSession(true); 
							
							session.setAttribute("user", user.getEmail());
							
							return 1;
						} else {
							return 0;
						}
					}
				}
				
			}else {
				return 0;
			}
		} else {
			return 0;
		}
		return 0;
		
		
	}
	
}
