package org.psw_isa.psw_isa_backend.service;

import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {

	@Autowired 
	ClinicRepository clinicRepository;
	
	
	public Clinic save(Clinic clinic) {
		return clinicRepository.save(clinic);
	}

	public Clinic findOneByid(Long id) {
		return clinicRepository.findOneByid(id);
	}

	public List<Clinic> findAll() {
		return clinicRepository.findAll();
	}
}
