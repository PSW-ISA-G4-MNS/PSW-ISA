package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.psw_isa.psw_isa_backend.dtos.CareDTO;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Operation;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

	
	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
    CheckRoleService checkRoleService;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	
	public Operation save(Operation operation) {
		return operationRepository.save(operation);
	}
	
	public ArrayList<Operation> findAllOperationsForDateForDoctor(LocalDate date) {
		List<Operation> all = operationRepository.findAll();
		List<Operation> assigned = new ArrayList<>();
		ArrayList<Operation> vreme=new ArrayList<Operation>();
		
		Long userID = checkRoleService.getUser().getId();
		Long doctorID = null;
		
		for(Doctor doctor : doctorRepository.findAll()) {
			if(doctor.getUser().getId() == userID) {
				doctorID = doctor.getId();
				break;
			}
		}
		
		LocalDate startTime = null;
		for(Operation operation : all) {
			
			for(Doctor doc :operation.getDoctors()) {
			if(doc.getClinic().getId() == doctorID) {
				startTime = operation.getStartTime().toLocalDate();
				//(care.getPatient() != null) &&
				if( (startTime.isEqual(date))) {
					assigned.add(operation);
				}
			}
		}
				
		}
			
		Collections.sort(assigned, new Comparator<Operation>()  {
			  @Override
			  public int compare(Operation c1, Operation c2) {
			    return c1.getStartTime().compareTo(c2.getStartTime());
			  }
			});
		
		for(Operation operation : assigned) {
			LocalDateTime zaConvert=operation.getStartTime();
			
			LocalTime konvertovan=zaConvert.toLocalTime();
			
			
			
			vreme.add(operation);
			
		}
		
		
		return vreme;
	}
}
