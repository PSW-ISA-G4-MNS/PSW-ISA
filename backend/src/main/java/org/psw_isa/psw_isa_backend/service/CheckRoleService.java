package org.psw_isa.psw_isa_backend.service;

import javax.servlet.http.HttpSession;

import org.psw_isa.psw_isa_backend.models.ClinicAdministrator;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Nurse;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.ClinicAdminRepository;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.NurseRepository;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class CheckRoleService {
	
	@Autowired
	ClinicAdminRepository clinicAdminRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	NurseRepository nurseRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	
	public boolean checkIfLogged() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
		HttpSession session = attr.getRequest().getSession(true); 
		
		String loggedEmail = (String) session.getAttribute("user");
		
		if(loggedEmail == null || loggedEmail.equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public boolean checkIfClinicAdministrator() {
		if(checkIfLogged()) {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
			HttpSession session = attr.getRequest().getSession(true); 
			
			String loggedEmail = (String) session.getAttribute("user");
			
			User loggedUser = userRepository.findOneByemail(loggedEmail);
			
			ClinicAdministrator loggedClinicAdmin = clinicAdminRepository.findOneByuser(loggedUser.getId());
			
			if(loggedClinicAdmin == null) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	public boolean checkIfDoctor() {
		if(checkIfLogged()) {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
			HttpSession session = attr.getRequest().getSession(true); 
			
			String loggedEmail = (String) session.getAttribute("user");
			
			User loggedUser = userRepository.findOneByemail(loggedEmail);
			
			Doctor loggedDoctor = doctorRepository.findOneByuser(loggedUser.getId());
			
			if(loggedDoctor == null) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
		
	}
	
	
	public boolean checkIfNurse() {
		if(checkIfLogged()) {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
			HttpSession session = attr.getRequest().getSession(true); 
			
			String loggedEmail = (String) session.getAttribute("user");
			
			User loggedUser = userRepository.findOneByemail(loggedEmail);
			
			Nurse loggedNurse = nurseRepository.findOneByuser(loggedUser.getId());
			
			if(loggedNurse == null) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	public boolean checkIfPatient() {
		if(checkIfLogged()) {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
			HttpSession session = attr.getRequest().getSession(true); 
			
			String loggedEmail = (String) session.getAttribute("user");
			
			User loggedUser = userRepository.findOneByemail(loggedEmail);
			
			Patient loggedPatient = patientRepository.findOneByuser(loggedUser.getId());
			
			if(loggedPatient == null) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	
}
