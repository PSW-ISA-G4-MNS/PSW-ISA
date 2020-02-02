package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.psw_isa.psw_isa_backend.dtos.CareRequestDTO;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.CareRequest;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.CareRequestRepository;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
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
	private UserRepository userRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private CareRequestRepository careRequestRepository;
	
	@Autowired
	private CheckRoleService checkRoleService;
	
	@Autowired
	private PatientRepository patientRepository;
	
	
	
	public int createRequest(CareRequestDTO careRequestDTO) {
		User user = checkRoleService.getUser();
		List<Patient> allPatients = patientRepository.findAll();
		if (user == null) 
		{
			return 0;
		}else {
			Patient patient = new Patient();
			
			for(Patient checkPatient : allPatients) {
				if(checkPatient.getUser().getId() == user.getId()) {
					patient = checkPatient;
				}
			}
			
			CareRequest careRequest = new CareRequest();
			careRequest.setApproved(false);
			careRequest.setDoctor(careRequestDTO.getDoctor());
			careRequest.setTime(careRequestDTO.getStartTime());
			careRequest.setPatient(patient);
			
			careRequestRepository.save(careRequest);
			
			return 1;
		}
	}
	
	
}
