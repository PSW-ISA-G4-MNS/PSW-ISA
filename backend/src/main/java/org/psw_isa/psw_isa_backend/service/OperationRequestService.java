package org.psw_isa.psw_isa_backend.service;

import java.util.List;


import org.psw_isa.psw_isa_backend.models.OperationRequest;
import org.psw_isa.psw_isa_backend.repository.OperationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationRequestService {

	@Autowired
	OperationRequestRepository operationRequestRepository;
	
	
	public List<OperationRequest> findAll() {
		return operationRequestRepository.findAll();
	}
}
