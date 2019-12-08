package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import org.psw_isa.psw_isa_backend.dtos.ClinicFilterDTO;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Operation;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.OperationRepository;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	CareRepository careRepository;
	
	@Autowired
	OperationRepository operationRepository;
	
	
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}
	
	
	public Doctor findOneByid(Long id) {
		return doctorRepository.findOneByid(id);
	}
	

	public List<Doctor> findFreeDoctors(ClinicFilterDTO clinicFilterDTO){
		List<Doctor> res = new ArrayList<>();
		List<Doctor> allDoctors = doctorRepository.findAll();
		List<Care> allCares = careRepository.findAll();
		List<Operation> allOperations = operationRepository.findAll();
		
		int noCare = 0;
		
		for(Doctor doctor : allDoctors) {
			if(doctor.getClinic().getId() == clinicFilterDTO.getClinic().getId()) {
				if(doctor.getCareType().getId() == clinicFilterDTO.getType().getId()){
					for(Care care : allCares) {
						if(care.getDoctor().getId() == doctor.getId()) {
							if((care.getStartTime().isBefore(clinicFilterDTO.getTime()) && care.getEndTime().isBefore(clinicFilterDTO.getTime())) || (care.getStartTime().isAfter(clinicFilterDTO.getTime()) &&  care.getEndTime().isAfter(clinicFilterDTO.getTime()))) {
								noCare = 1;
							}
						}
					}
					if(noCare == 1) {
						for(Operation operation : allOperations) {
							if(operation.getDoctor().getId() == doctor.getId()) {
								if((operation.getStartTime().isBefore(clinicFilterDTO.getTime()) && operation.getEndTime().isBefore(clinicFilterDTO.getTime())) || (operation.getStartTime().isAfter(clinicFilterDTO.getTime()) &&  operation.getEndTime().isAfter(clinicFilterDTO.getTime()))) {
									res.add(doctor);
								}
							}
						}
					}
					
				}
			}
			
		}
		return res;
	}

	public List<Doctor> findAllByClinic(Clinic clinic) {
		List<Doctor> result = new ArrayList<Doctor>();
		for (Doctor doc  : this.findAll()) {
			if (doc.getClinic() != null && doc.getClinic().getId() == clinic.getId()) {
				result.add(doc);
			}
		}
		return result;
	}

}
