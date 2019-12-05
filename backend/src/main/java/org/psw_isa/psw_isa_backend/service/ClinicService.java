package org.psw_isa.psw_isa_backend.service;

import org.psw_isa.psw_isa_backend.dtos.ClinicFilterDTO;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Operation;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.ClinicRepository;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClinicService {

	@Autowired 
	ClinicRepository clinicRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	CareRepository careRepository;
	
	@Autowired
	OperationRepository operationRepository;
	
	
	public Clinic save(Clinic clinic) {
		return clinicRepository.save(clinic);
	}

	public Clinic findOneByid(Long id) {
		return clinicRepository.findOneByid(id);
	}

	public List<Clinic> findAll() {
		return clinicRepository.findAll();
	}
	
	public List<Clinic> findClinicsWithFreeDoctors(ClinicFilterDTO clinicFilterDTO){
		List<Clinic> res = new ArrayList<>();
		List<Doctor> allDoctors = doctorRepository.findAll();
		List<Care> allCares = careRepository.findAll();
		List<Operation> allOperations = operationRepository.findAll();
		
		int noCare = 0;
		
		for(Doctor doctor : allDoctors) {
			if(doctor.getCareType().getId() == clinicFilterDTO.getType().getId()){
				for(Care care : allCares) {
					if(care.getDoctor().getId() == doctor.getId()) {
						if((care.getStartTime().isBefore(clinicFilterDTO.getTime()) && care.getEndTime().isBefore(clinicFilterDTO.getTime())) || (care.getStartTime().isAfter(clinicFilterDTO.getTime()) &&  care.getEndTime().isAfter(clinicFilterDTO.getTime()))) {
							noCare = 1;
							if(!res.contains(doctor.getClinic())) {
								res.add(doctor.getClinic());
							}
						}
					}
				}
				if(noCare == 1) {
					for(Operation operation : allOperations) {
						if(operation.getDoctor().getId() == doctor.getId()) {
							if((operation.getStartTime().isBefore(clinicFilterDTO.getTime()) && operation.getEndTime().isBefore(clinicFilterDTO.getTime())) || (operation.getStartTime().isAfter(clinicFilterDTO.getTime()) &&  operation.getEndTime().isAfter(clinicFilterDTO.getTime()))) {
								if(!res.contains(doctor.getClinic())) {
									res.add(doctor.getClinic());
								}
							}
						}
					}
				}
				
			}
			
		}
		return res;
	}
}
