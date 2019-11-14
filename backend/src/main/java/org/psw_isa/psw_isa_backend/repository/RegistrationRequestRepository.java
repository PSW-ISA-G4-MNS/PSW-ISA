package org.psw_isa.psw_isa_backend.repository;

import org.psw_isa.psw_isa_backend.models.RegistrationRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest, Long> {
	
	Page<RegistrationRequest> findAll(Pageable pageable);
	
	public RegistrationRequest findOneById(Long id);
	
	

}
