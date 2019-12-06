package org.psw_isa.psw_isa_backend.repository;

import java.util.List;


import org.psw_isa.psw_isa_backend.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
	
	
	Prescription findOneByid(Long id);
	
	List<Prescription> findAll();
}
