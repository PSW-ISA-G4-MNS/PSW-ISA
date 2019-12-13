package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.CareRequest;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.CareRequestRepository;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.psw_isa.psw_isa_backend.service.CheckRoleService;
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
	private CheckRoleService checkRoleService;
	
	@Autowired
	private PatientRepository patientRepository;
	
	
	public Long newCareRequest(Long id) {
	User user = checkRoleService.getUser();
	if (user == null) 
	{
		return null;
	}
        Optional<Patient> maybePatient = patientRepository.findAll().stream().filter(x -> x.getUser().getId() == user.getId()).findFirst();
        if(maybePatient.isPresent()) {
			Patient patient = maybePatient.get();
			Care care = careRepository.findOneByid(id);
			
			CareRequest careRequest = new CareRequest(patient, care, LocalDateTime.now(), false);
			careRequestRepository.save(careRequest);
		
			return id;
        } else {
        	return null;
        }
		
		
	}
	
	
}
