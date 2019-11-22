package org.psw_isa.psw_isa_backend.service;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.RegistrationRequest;
import org.psw_isa.psw_isa_backend.repository.RegistrationRequestRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RegistrationRequestService {

	@Autowired
	private RegistrationRequestRepository registrationRequestRepository;
	
	public Page<RegistrationRequest> findAll(Pageable pageable){
		return registrationRequestRepository.findAll(pageable);
	}
	
	public List<RegistrationRequest> findAll(){
		return registrationRequestRepository.findAll();
	}
	
	public RegistrationRequest save (RegistrationRequest registrationRequest) {
		return registrationRequestRepository.save(registrationRequest);
	}
	
	public void remove(Long id) {
		registrationRequestRepository.deleteById(id);
	}
	
	public RegistrationRequest findOneById(Long id) {
		return registrationRequestRepository.findOneById(id);
	}
	
}
