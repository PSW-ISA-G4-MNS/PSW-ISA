package org.psw_isa.psw_isa_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.psw_isa.psw_isa_backend.models.ClinicAdministrator;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.OperationRequest;
import org.psw_isa.psw_isa_backend.repository.OperationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.psw_isa.psw_isa_backend.dtos.OperationRequestDTO;

@Service
public class OperationRequestService {

	@Autowired
	OperationRequestRepository operationRequestRepository;
	
	@Autowired 
	PatientService patientService;

	@Autowired
	ClinicService clinicService;
	
	@Autowired
	CheckRoleService checkRoleService;
	
	@Autowired
	ClinicAdminService clinicAdminService;
	
	

	public List<OperationRequest> findAll() {
		return operationRequestRepository.findAll();
	}


	public OperationRequest save(OperationRequestDTO dto) 
	{
		OperationRequest operationRequest = new OperationRequest();
		operationRequest.setClinic(clinicService.findOneByid(dto.getClinicId()));
		operationRequest.setPatient(patientService.findOneByid(dto.getPatientId()));
		operationRequest.setTime(dto.getTime());
		return operationRequestRepository.save(operationRequest);
}

	
	public void deleteOneById(Long id) {
		operationRequestRepository.deleteById(id);

	}
	
	public ArrayList<OperationRequest> operationRequestForClinic(){
		
		Long userId=checkRoleService.getUser().getId();
		List<ClinicAdministrator> clinicAdministrators=clinicAdminService.findAll();
		List<OperationRequest> allOperationRequest=operationRequestRepository.findAll();
		ArrayList<OperationRequest> operationRequestClinic=new ArrayList<OperationRequest>();
		
		for(ClinicAdministrator admin: clinicAdministrators) {
			
			if(admin.getUser().getId()==userId) {
				
				
				for(OperationRequest operationRequest : allOperationRequest) {
					
					
					
					if(admin.getClinic().getId()==operationRequest.getClinic().getId()) {
						operationRequestClinic.add(operationRequest);
					}
					
				}
			}
		}
		
		
		
			
		
		
		return operationRequestClinic;
		
		
	}
}
