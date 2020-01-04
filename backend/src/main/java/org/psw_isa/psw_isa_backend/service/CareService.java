package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.psw_isa.psw_isa_backend.service.DoctorService;
import org.psw_isa.psw_isa_backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.psw_isa.psw_isa_backend.dtos.CareDTO;

@Service
public class CareService {
	
	@Autowired
	CareRepository careRepository;

	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	CheckRoleService checkRoleService;
	
	
	public List<Care> findAll() {
		return careRepository.findAll();
	}
	
	public List<Care> findAllUnassignedAndUpcoming() {
		List<Care> all = careRepository.findAll();
		List<Care> unassigned = new ArrayList<>();
		
		for(Care care : all) {
			if((care.getPatient() == null) && (care.getStartTime().isAfter(LocalDateTime.now()))) {
				unassigned.add(care);
			}
		}
			
		return unassigned;
	}
	
	public List<Care> findAllUnassignedAndUpcomingForClinic(Long id) {
		List<Care> all = careRepository.findAll();
		List<Care> unassigned = new ArrayList<>();
		
		for(Care care : all) {
			if(care.getDoctor().getClinic().getId() == id) {
				if((care.getPatient() == null) && (care.getStartTime().isAfter(LocalDateTime.now()))) {
					unassigned.add(care);
				}
			}
				
		}
			
		Collections.sort(unassigned, new Comparator<Care>()  {
			  @Override
			  public int compare(Care c1, Care c2) {
			    return c1.getStartTime().compareTo(c2.getStartTime());
			  }
			});
		
		
		return unassigned;
	}
	
	public Care findOneByid(Long id) {
		return careRepository.findOneByid(id);
	}
	public Care save(CareDTO careDTO) {
		return careRepository.save(new Care(null, doctorRepository.findOneByid(careDTO.getDoctorId()), null, roomService.findOneByid(careDTO.getRoomId()), 
			careDTO.getStartTime(), careDTO.getEndTime(),careDTO.getPrice()));
	}
	
	public void assignPatientToCare(Long careID) {
		
		Long userID = checkRoleService.getUser().getId();
		Long patientID = null;
		for(Patient patient : patientRepository.findAll()) {
			if(patient.getUser().getId() == userID) {
				patientID = patient.getId();
				break;
			}
		}
		
		System.out.println("patient: " + patientID + " care: " + careID);
		careRepository.carePatientUpdate(patientID, careID);
		 
	}

}
