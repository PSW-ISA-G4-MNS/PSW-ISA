package org.psw_isa.psw_isa_backend.repository;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	Patient findOneByinsuranceID(Long id);
	
	List<Patient> findAll();
	
	//List<Patient> findAllByfirstnameAndlastnameAllIgnoringCase(String firstname, String lastname);


}
