package org.psw_isa.psw_isa_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.psw_isa.psw_isa_backend.dtos.AdminClinicDTO;
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
	
	public ClinicAdministrator findOneByid(Long id) {
		return adminClinicRepository.findOneByid(id);
	}
	
	public List<AdminClinicDTO> findAllFree(){
		List<ClinicAdministrator> all = adminClinicRepository.findAll();
		List<ClinicAdministrator> free = new ArrayList<>();
		List<AdminClinicDTO> adminClinicDTOs = new ArrayList<>();
		
		for(ClinicAdministrator clinicAdministrator : all) {
			if(clinicAdministrator.getClinic() == null) {
				free.add(clinicAdministrator);
			}
		}
		
		for(ClinicAdministrator clinicAdministrator : free) {
			adminClinicDTOs.add(new AdminClinicDTO(clinicAdministrator));
		}
		
		
		return adminClinicDTOs;
	}
}
