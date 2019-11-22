package org.psw_isa.psw_isa_backend.service;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.psw_isa.psw_isa_backend.Logger;

@Service
public class PatientService {
	
	@Autowired 
	PatientRepository patientRepository;
	
	@Autowired 
	UserRepository userRepository;

	List<Patient> findAll(){
		return patientRepository.findAll();
	}
	
	//List<Patient> findAllByfirstnameAndlastnameAllIgnoringCase(String firstname, String lastname){
	//	return patientRepository.findAllByfirstnameAndlastnameAllIgnoringCase(firstname, lastname);
	//}
	
	public Patient findOneByinsuranceID(Long id) {
		return patientRepository.findOneByinsuranceID(id);
	}
	
	public Patient findOneByuser(User user) {
		for (Patient u : patientRepository.findAll()) {
			if (u.getUser().getEmail().equals(user.getEmail())) return u;
		}
		return null;
	}
	
	public Patient save(Patient patient) {
		return patientRepository.save(patient);
	}

}
