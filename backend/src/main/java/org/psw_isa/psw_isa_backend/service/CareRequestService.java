package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.CareRequest;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.CareRequestRepository;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class CareRequestService {

	@Autowired
	private CareRepository careRepository;
	
	@Autowired
	private CareRequestRepository careRequestRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	
	public Long newCareRequest(Long id) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
		HttpSession session = attr.getRequest().getSession(true); 
		
        String email = (String) session.getAttribute("user");
        User user = userRepository.findOneByemail(email);
        Long userID = user.getId();
        Patient patient = patientRepository.findOneByuser(user);
        if(patient != null) {
			Care care = careRepository.findOneByid(id);
			
			CareRequest careRequest = new CareRequest(patient, care, LocalDateTime.now(), false);
			careRequestRepository.save(careRequest);
		
			return id;
        } else {
        	return null;
        }
		
		
	}
	
	
}
