package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import org.hibernate.mapping.Array;
import org.psw_isa.psw_isa_backend.dtos.CareRequestDTO;
import org.psw_isa.psw_isa_backend.dtos.ClinicFilterDTO;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Operation;
import org.psw_isa.psw_isa_backend.models.Vacation;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.CareTypeRepository;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.OperationRepository;
import org.psw_isa.psw_isa_backend.repository.VacationRepository;
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

	@Autowired
	CheckRoleService checkRoleService;
	
	@Autowired
	CareTypeRepository careTypeRepository;
	
	@Autowired
	VacationRepository vacationRepository;
	
	
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}
	
	
	public Doctor findOneByid(Long id) {
		return doctorRepository.findOneByid(id);
	}
	
	
	
	public List<Doctor> listFreeDoctorsForClinic(Long clinicID, Long careTypeID, String date){
		List<Doctor> res = new ArrayList<>();
		List<Care> allCares = careRepository.findAll();
		List<Operation> allOperations = operationRepository.findAll();
		List<Doctor> allDoctors = doctorRepository.findAll(); 
		List<Care> doctorsCaresForDate = new ArrayList<>();
		List<Operation> doctorsOperationsForDate = new ArrayList<>();
		List<Vacation> allVacations = vacationRepository.findAll();
		List<Vacation> doctorsVacations = new ArrayList<Vacation>();
		LocalDate wantedDate = LocalDate.parse(date);
		LocalDate startTime = null;
		int onVacation = 0;
		

		for(Doctor doctor : allDoctors) {
			doctorsVacations.clear();
			doctorsCaresForDate.clear();
			doctorsOperationsForDate.clear();
			onVacation = 0;
			
			for(Vacation vacation : allVacations) {
				if(vacation.getUser().getId() == doctor.getUser().getId()) {
					doctorsVacations.add(vacation);
				}
			}
			
			
			for(Vacation vacation : doctorsVacations) {
				if(wantedDate.isAfter(vacation.getStartTime().toLocalDate()) && wantedDate.isBefore(vacation.getEndTime().toLocalDate())) {
					onVacation = 1;
				}
			}
			
			
			
			
			
			if(onVacation == 0) {
				if(doctor.getClinic().getId() == clinicID) {
					if(doctor.getCareType().getId() == careTypeID) {
						for(Care care : allCares) {	
							if(care.getDoctor().getId() == doctor.getId()) {
								startTime = care.getStartTime().toLocalDate();
								if((care.getPatient() != null) && (startTime.isEqual(wantedDate))) {
									System.out.println("nasao za taj dan");
									doctorsCaresForDate.add(care);
								}
							}
						}
						for(Operation operation : allOperations) {
							if(operation.getDoctor().getId() == doctor.getId()) {
								startTime = operation.getStartTime().toLocalDate();
								if(startTime.isEqual(wantedDate)) {
									doctorsOperationsForDate.add(operation);
								}
							}
						}
					}
					
					if(doctorsCaresForDate.size() + doctorsOperationsForDate.size() < 22) {
						System.out.println("nasao da je manje od dva : " + doctorsCaresForDate.size());
						if(!res.contains(doctor)) {
							res.add(doctor);
						}
					}
				}
			}
			
			
			
		}
		
		System.out.println("broj slobodnih doktora u klinici: " + res.size());
		
		return res;
	}
	
	
	public List<CareRequestDTO> listAvailableCaresForDoctor(Long careTypeID, Long doctorID, String date){
		List<CareRequestDTO> res = new ArrayList<CareRequestDTO>();
		List<Care> allCares = careRepository.findAll();
		List<Care> doctorsCares = new ArrayList<Care>();
		List<Care> doctorsCaresForDate = new ArrayList<Care>();
		List<Operation> allOperations = operationRepository.findAll();
		List<Operation> doctorsOperations = new ArrayList<Operation>();
		List<Operation> doctorsOperationsForDate = new ArrayList<Operation>();
		List<Vacation> allVacations = vacationRepository.findAll();
		List<Vacation> doctorsVacations = new ArrayList<Vacation>();
		LocalDate wantedDate = LocalDate.parse(date);
		LocalDateTime checkTime = null;
		LocalDate startTime = null;
		String checkTimeStr = "";
		
		int onVacation = 0;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		List<String> times = new ArrayList<String>() {{
			add(" 07:00");
			add(" 07:30");
			add(" 08:00");
			add(" 08:30");
			add(" 09:00");
			add(" 09:30");
			add(" 10:00");
			add(" 10:30");
			add(" 11:00");
			add(" 11:30");
			add(" 12:00");
			add(" 12:30");
			add(" 13:00");
			add(" 13:30");
			add(" 14:00");
			add(" 14:30");
			add(" 15:00");
			add(" 15:30");
			add(" 16:00");
			add(" 16:30");
			add(" 17:00");
			add(" 17:30");
		}};
		
		
		for(Vacation vacation : allVacations) {
			if(vacation.getUser().getId() == doctorRepository.findOneByid(doctorID).getUser().getId()) {
				doctorsVacations.add(vacation);
			}
		}
		
		
		for(Vacation vacation : doctorsVacations) {
			if(wantedDate.isAfter(vacation.getStartTime().toLocalDate()) && wantedDate.isBefore(vacation.getEndTime().toLocalDate())) {
				onVacation = 1;
			}
		}
		
		if(onVacation == 0) {	
			for(Care care : allCares) {
				if(care.getDoctor().getId() == doctorID && care.getPatient() != null) {
					doctorsCares.add(care);
				}
			}
			
			for(Care care : doctorsCares) {
				startTime = care.getStartTime().toLocalDate();
				if(wantedDate.equals(startTime)) {
					doctorsCaresForDate.add(care);
				}
			}
			
			
			for(Operation operation : allOperations) {
				if(operation.getDoctor().getId() == doctorID) {
					doctorsOperations.add(operation);
				}
			}
			
			for(Operation operation : doctorsOperations) {
				startTime = operation.getStartTime().toLocalDate();
				if(wantedDate.equals(startTime)) {
					doctorsOperationsForDate.add(operation);
				}
			}
			
			
			for(String time : times) {
				int ind = 0;
				checkTimeStr = date + time;
				checkTime = LocalDateTime.parse(checkTimeStr, formatter);
				
				for(Care care : doctorsCaresForDate) {
					if(care.getStartTime().equals(checkTime)) {
						System.out.println("NASAO ISTI: " + care.getStartTime() + " = " + checkTime);
						ind = 1;
					}
				}
				
				for(Operation operation : doctorsOperationsForDate) {
					if(operation.getStartTime().equals(checkTime)) {
						System.out.println("NASAO ISTI: " + operation.getStartTime() + " = " + checkTime);
						ind = 1;
					}
				}
				
				if(ind == 0) {
					res.add(new CareRequestDTO(checkTime, doctorRepository.findOneByid(doctorID), careTypeRepository.findOneByid(careTypeID))); 
				} 
				
			}
		
		}
		
		
		return res;
	}
	
	
	

	/*
	 * public List<Doctor> findFreeDoctors(ClinicFilterDTO clinicFilterDTO){
	 * List<Doctor> res = new ArrayList<>(); List<Doctor> allDoctors =
	 * doctorRepository.findAll(); List<Care> allCares = careRepository.findAll();
	 * List<Operation> allOperations = operationRepository.findAll();
	 * 
	 * int noCare = 0;
	 * 
	 * for(Doctor doctor : allDoctors) { if(doctor.getClinic().getId() ==
	 * clinicFilterDTO.getClinic().getId()) { if(doctor.getCareType().getId() ==
	 * clinicFilterDTO.getType().getId()){ for(Care care : allCares) {
	 * if(care.getDoctor().getId() == doctor.getId()) {
	 * if((care.getStartTime().isBefore(clinicFilterDTO.getTime()) &&
	 * care.getEndTime().isBefore(clinicFilterDTO.getTime())) ||
	 * (care.getStartTime().isAfter(clinicFilterDTO.getTime()) &&
	 * care.getEndTime().isAfter(clinicFilterDTO.getTime()))) { noCare = 1; } } }
	 * if(noCare == 1) { for(Operation operation : allOperations) {
	 * if(operation.getDoctor().getId() == doctor.getId()) {
	 * if((operation.getStartTime().isBefore(clinicFilterDTO.getTime()) &&
	 * operation.getEndTime().isBefore(clinicFilterDTO.getTime())) ||
	 * (operation.getStartTime().isAfter(clinicFilterDTO.getTime()) &&
	 * operation.getEndTime().isAfter(clinicFilterDTO.getTime()))) {
	 * res.add(doctor); } } } }
	 * 
	 * } }
	 * 
	 * } return res; }
	 */
	
	public Clinic getClinic() {
		for (Doctor d : findAll()) if (checkRoleService.getUser() != null && d.getUser().getId() == checkRoleService.getUser().getId()) return d.getClinic();
		return null;
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

	public void save(Doctor doctor) {
		doctorRepository.save(doctor);
	}

}
