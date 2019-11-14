package org.psw_isa.psw_isa_backend.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.psw_isa.psw_isa_backend.models.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	Patient findOneByinsuranceID(Long id);
	
	Page<Patient> findAll(Pageable pageable);
	
	List<Patient> findAllByfirstnameAndlastnameAllIgnoringCase(String firstname, String lastname);
	
	
}
