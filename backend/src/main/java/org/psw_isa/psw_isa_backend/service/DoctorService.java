package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
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

}
