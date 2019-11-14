package org.psw_isa.psw_isa_backend.service;

import org.psw_isa.psw_isa_backend.models.RegistrationRequest;
import org.psw_isa.psw_isa_backend.repository.RegistrationRequestRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RegistrationRequestService {

	private RegistrationRequestRepository registrationRequestRepository;
	
	public Page<RegistrationRequest> findAll(Pageable pageable){
		return registrationRequestRepository.findAll(pageable);
	}
	
	public RegistrationRequest save (RegistrationRequest registrationRequest) {
		return registrationRequestRepository.save(registrationRequest);
	}
	
	public void remove(Long id) {
		registrationRequestRepository.deleteById(id);
	}
	
}
