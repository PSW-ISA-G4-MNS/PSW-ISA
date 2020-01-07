package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Prescription;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.DiagnosisRepository;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.PrescriptionRepository;
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
	DiagnosisRepository diagnosisRepository;
	
	@Autowired
	RoomService roomService;
	
	@Autowired 
	PrescriptionRepository prescriptionRepository;
	
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
	
	public Care findOneByid(Long id) {
		return careRepository.findOneByid(id);
	}
	public Care save(CareDTO careDTO) {
		
		
		return careRepository.save(new Care( doctorRepository.findOneByid(careDTO.getDoctorId()), null, roomService.findOneByid(careDTO.getRoomId()), 
			careDTO.getStartTime(), careDTO.getEndTime(),careDTO.getPrice(),careDTO.getComment(),diagnosisRepository.findOneByid(careDTO.getDiagnosisId()),prescriptionRepository.findOneByid(careDTO.getPrescriptionId()),false));
	}
	
	public int updateCareApprovePrescription(boolean approved,Long id){
		return careRepository.updateCareApprovePrescription(approved, id);
	}
	
	public int updateCareReview(CareDTO careDTO) {
		return careRepository.updateCareReview(careDTO.getComment(),careDTO.getDiagnosisId(), careDTO.getPrescriptionId(), false,careDTO.getCareId());
	}
	
	
	public ArrayList<Care> findAllAssignedForDateForDoctor(LocalDate date) {
		List<Care> all = careRepository.findAll();
		List<Care> assigned = new ArrayList<>();
		ArrayList<Care> vreme=new ArrayList<Care>();
		
		Long userID = checkRoleService.getUser().getId();
		Long doctorID = null;
		
		for(Doctor doctor : doctorRepository.findAll()) {
			if(doctor.getUser().getId() == userID) {
				doctorID = doctor.getId();
				break;
			}
		}
		
		LocalDate startTime = null;
		for(Care care : all) {
			if(care.getDoctor().getClinic().getId() == doctorID) {
				startTime = care.getStartTime().toLocalDate();
				//(care.getPatient() != null) &&
				if( (startTime.isEqual(date))) {
					assigned.add(care);
				}
			}
				
		}
			
		Collections.sort(assigned, new Comparator<Care>()  {
			  @Override
			  public int compare(Care c1, Care c2) {
			    return c1.getStartTime().compareTo(c2.getStartTime());
			  }
			});
		
		for(Care care : assigned) {
			LocalDateTime zaConvert=care.getStartTime();
			
			LocalTime konvertovan=zaConvert.toLocalTime();
			
			String kljuc=konvertovan.toString();
			
			vreme.add(care);
			
		}
		
		
		return vreme;
	}

}
