package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CareService {
	
	@Autowired
	CareRepository careRepository;
	
	
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

}
