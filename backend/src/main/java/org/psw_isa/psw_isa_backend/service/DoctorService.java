package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}
	
	
	public Doctor findOneByid(Long id) {
		return doctorRepository.findOneByid(id);
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
