package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDate;

import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User findOneByemail(String email) {
		return userRepository.findOneByemail(email);	
	}

	public int updateUser(String firstname, String lastname, String address, LocalDate birthday, String mobile_phone, Long id){
		return userRepository.updateUser(firstname, lastname, address, birthday, mobile_phone, id);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
}
