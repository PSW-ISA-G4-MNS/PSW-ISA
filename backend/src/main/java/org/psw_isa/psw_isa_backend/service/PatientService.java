package org.psw_isa.psw_isa_backend.service;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PatientService {
	
	@Autowired 
	PatientRepository patientRepository;
	
	Page<Patient> findAll(Pageable pageable){
		return patientRepository.findAll(pageable);
	}
	
	List<Patient> findAllByfirstnameAndlastnameAllIgnoringCase(String firstname, String lastname){
		return patientRepository.findAllByfirstnameAndlastnameAllIgnoringCase(firstname, lastname);
	}
	
	Patient findOneByinsuranceID(Long id) {
		return patientRepository.findOneByinsuranceID(id);
	}

}
