package org.psw_isa.psw_isa_backend.service;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Diagnosis;
import org.psw_isa.psw_isa_backend.models.MedicalRecord;
import org.psw_isa.psw_isa_backend.models.Prescription;
import org.psw_isa.psw_isa_backend.repository.MedicalRecordRepository;
import org.psw_isa.psw_isa_backend.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {

	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	
	public MedicalRecord save(MedicalRecord medicalRecord) {
		return medicalRecordRepository.save(medicalRecord);
	}
	
	
	public List<MedicalRecord> findAll() {
		return medicalRecordRepository.findAll();
	}
	
	
	public MedicalRecord findOneByid(Long id) {
		return medicalRecordRepository.findOneByid(id);
	}
}
