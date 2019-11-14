package org.psw_isa.psw_isa_backend.service;

import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User findOneByemail(String email) {
		return userRepository.findOneByemail(email);	
	}
	
}
