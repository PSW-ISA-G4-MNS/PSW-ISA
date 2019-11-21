package org.psw_isa.psw_isa_backend.service;

import org.psw_isa.psw_isa_backend.models.ClinicAdministrator;
import org.psw_isa.psw_isa_backend.models.RegistrationRequest;
import org.psw_isa.psw_isa_backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminClinicRepository;
	
	public String updateAdminClinic(Long clinic, Long id) {
		
		return adminClinicRepository.updateAdminClinic( clinic, id);
	}
}
