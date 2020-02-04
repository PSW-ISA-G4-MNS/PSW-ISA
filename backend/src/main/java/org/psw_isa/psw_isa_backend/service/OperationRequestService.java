package org.psw_isa.psw_isa_backend.service;

import java.util.List;


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
}
