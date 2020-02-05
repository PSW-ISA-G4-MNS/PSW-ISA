package org.psw_isa.psw_isa_backend.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Operation;
import org.psw_isa.psw_isa_backend.models.OperationRequest;
import org.psw_isa.psw_isa_backend.models.Room;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.OperationRepository;
import org.psw_isa.psw_isa_backend.repository.OperationRequestRepository;
import org.psw_isa.psw_isa_backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemService {

	@Autowired
	OperationRequestRepository operationRequestRepository;
	
	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	DoctorService doctorService;
	
	
	
	public void systemSchedule(){
		
		List<OperationRequest> allRequests = operationRequestRepository.findAll();
		List<Room> allRooms=roomRepository.findAll();
		int brojZahteva=allRequests.size();
		LocalDate wantedDate = LocalDate.now();
		LocalDateTime checkTime = null;
		
		String checkTimeStr = "";
		
		
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
		
		
		//IZBACI KADA SE BUDU RUCNO ZAKAZIVALI 
		for(Room room : allRooms) {
			room.setSchedule(new ArrayList<LocalDateTime>());
			roomRepository.save(room);
		}
		
		
		while(brojZahteva>0) {
		
			for(String time : times) {
				
				
				int ind = 0;
				checkTimeStr = wantedDate + time;
				checkTime = LocalDateTime.parse(checkTimeStr, formatter);
				System.out.println("PREEEEEEEEE  ");
				
				for(int i=0; i<allRooms.size();i++) {
					System.out.println("posle");
					
					if(allRooms.get(i).getSchedule()!=null) {
						System.out.println("NIJE null");
					ArrayList<LocalDateTime> schedule=allRooms.get(i).getSchedule();
					System.out.println("pokupi raspored");
					
					if(schedule.size()!=0) {
					for(int s=0;s<schedule.size();s++) {
						System.out.println("uDJE U RASPORED");
							if(schedule.get(s).equals(checkTime)) {
								
							System.out.println("NASAO ISTI: " + schedule.get(s)+ " = " + checkTime);
							
							
							}
							else {
								if(brojZahteva-1>=0) {
								Operation operacija=new Operation();
								operacija.setRoom(allRooms.get(i));
								operacija.setStartTime(checkTime);
								ArrayList<Doctor> doctors=doctorService.listAvailableDoctors((allRequests.get(brojZahteva-1)).getClinic().getId(), checkTime);
								operacija.setDoctors(doctors);
								operacija.setPatient(allRequests.get(brojZahteva-1).getPatient());
								allRooms.get(i).getSchedule().add(checkTime);
								roomRepository.save(allRooms.get(i));
								operationRepository.save(operacija);
								
								brojZahteva--;
								break;
								}
								break;
							}
							break;
					}
				}
					
					else {
						if(brojZahteva-1>=0) {
							Operation operacija=new Operation();
							operacija.setRoom(allRooms.get(i));
							operacija.setStartTime(checkTime);
							ArrayList<Doctor> doctors=doctorService.listAvailableDoctors((allRequests.get(brojZahteva-1)).getClinic().getId(), checkTime);
							operacija.setDoctors(doctors);
							operacija.setPatient(allRequests.get(brojZahteva-1).getPatient());
							allRooms.get(i).getSchedule().add(checkTime);
						
							roomRepository.save(allRooms.get(i));
							operationRepository.save(operacija);
							
							brojZahteva--;
							break;
						}
						break;
					}
				break;
					}
					else {
						if(brojZahteva-1>=0) {
						Operation operacija=new Operation();
						operacija.setRoom(allRooms.get(i));
						operacija.setStartTime(checkTime);
						ArrayList<Doctor> doctors=doctorService.listAvailableDoctors((allRequests.get(brojZahteva-1)).getClinic().getId(), checkTime);
						operacija.setDoctors(doctors);
						operacija.setPatient(allRequests.get(brojZahteva-1).getPatient());
						allRooms.get(i).getSchedule().add(checkTime);
						operationRepository.save(operacija);
						
						brojZahteva--;
						break;
						}
						break;
					}
					
				}
				
				wantedDate.plusDays(1);
			}
			
		

		}
		
		
	}
	
	
	
}
