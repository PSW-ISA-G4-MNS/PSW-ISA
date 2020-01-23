package org.psw_isa.psw_isa_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.psw_isa.psw_isa_backend.dtos.AdminClinicDTO;
import org.psw_isa.psw_isa_backend.models.ClinicAdministrator;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.RegistrationRequest;
import org.psw_isa.psw_isa_backend.repository.ClinicAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.psw_isa.psw_isa_backend.models.Doctor;

import java.util.stream.Collectors;

@Service
public class ClinicAdminService {

	@Autowired
	ClinicAdminRepository adminClinicRepository;

	@Autowired
	DoctorService doctorService;

	
	@Autowired
	CheckRoleService checkRoleService;

	public String updateAdminClinic(Long clinic, Long id) {
		
		return adminClinicRepository.updateAdminClinic( clinic, id);
	}
	
	public ClinicAdministrator findOneByid(Long id) {
		return adminClinicRepository.findOneByid(id);
	}

	public ClinicAdministrator findOneById(Long id) {
		return adminClinicRepository.findOneByid(id);
	}
	public List<ClinicAdministrator> findAll() {
		return adminClinicRepository.findAll();
	}

	public ClinicAdministrator getCurrent() {
		if (checkRoleService.getUser() != null) 
		{
			for (ClinicAdministrator admin : findAll()) {
				if (admin.getUser().getId() == checkRoleService.getUser().getId()) 
				{
					return admin;
				}
			}
			return null;
		}
		else return null;
	}

	public Clinic getClinic()  
	{
		if (getCurrent() == null) return null;
		return getCurrent().getClinic();
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

	public List<Doctor> getDoctors() 
	{
		return doctorService.findAll().stream().filter(x -> x.getClinic() == getClinic()).collect(Collectors.toList());
	}
	
	public Doctor addDoctor(Doctor doctor){
		Doctor d = doctorService.findOneByid(doctor.getId());
		d.setClinic(getClinic());
		doctorService.save(d);
		return d;
	}
	public Doctor deleteDoctor(Long id){
		Doctor d = doctorService.findOneByid(id);
		d.setClinic(null);
		doctorService.save(d);
		return d;
	}
}
