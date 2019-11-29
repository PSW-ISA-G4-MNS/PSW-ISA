package org.psw_isa.psw_isa_backend.service;

import org.psw_isa.psw_isa_backend.models.Diagnosis;
import org.psw_isa.psw_isa_backend.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisService {

	@Autowired 
	DiagnosisRepository diagnosisRepository;
	
	public Diagnosis save(Diagnosis diagnosis) {
		return diagnosisRepository.save(diagnosis);
	}
}
