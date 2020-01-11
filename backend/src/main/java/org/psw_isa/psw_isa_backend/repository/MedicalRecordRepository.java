package org.psw_isa.psw_isa_backend.repository;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.MedicalRecord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
	
	
	public MedicalRecord findOneByid(Long id);
	public MedicalRecord findOneBypatient_id(Long id);
	List<MedicalRecord> findAll();
}
