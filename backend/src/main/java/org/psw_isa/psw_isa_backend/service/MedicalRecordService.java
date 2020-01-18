package org.psw_isa.psw_isa_backend.service;

import java.util.List;
import org.psw_isa.psw_isa_backend.dtos.MedicalRecordDTO;
import org.psw_isa.psw_isa_backend.models.MedicalRecord;
import org.psw_isa.psw_isa_backend.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MedicalRecordService {

	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	
	@Autowired
	PatientService patientService;
	
	public MedicalRecord save(MedicalRecord medicalRecord) {
		return medicalRecordRepository.save(medicalRecord);
	}
	
	
	public List<MedicalRecord> findAll() {
		return medicalRecordRepository.findAll();
	}
	
	public MedicalRecord findOneBypatient_id(Long id) {
		return medicalRecordRepository.findOneBypatient_id(id);
	}
	
	
	public MedicalRecord findOneByid(Long id) {
		return medicalRecordRepository.findOneByid(id);
	}
	
	public int updateMedicalRecord(MedicalRecordDTO medicalRecordDTO) {
		return medicalRecordRepository.updateMedicalRecord(medicalRecordDTO.getHeight(),medicalRecordDTO.getWidth(), medicalRecordDTO.getBloodType(), medicalRecordDTO.getDiopter(), medicalRecordDTO.getId());
	}
	
	public MedicalRecordDTO findOneMedicalById(@PathVariable("id") Long id){
		 
		List<MedicalRecord> listaKartona=medicalRecordRepository.findAll();
		MedicalRecordDTO pacijentovKarton=null;
		
		
		
		if(!listaKartona.isEmpty()) {
		
		for(MedicalRecord karton : listaKartona) {
			
			if(karton.getPatient().getId()==id) {
				pacijentovKarton=new MedicalRecordDTO(karton);
			}
		}
		
	    
			if(pacijentovKarton==null) {
			
			MedicalRecord novi=new MedicalRecord(patientService.findOneByid(id));
			
			medicalRecordRepository.save(novi);
			
			MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO(medicalRecordRepository.findOneBypatient_id(id));
			return medicalRecordDTO;
			
			
		}
			
			else {
				
				return pacijentovKarton;
			}
		
		}
		
		else {
			
			
			MedicalRecord novi=new MedicalRecord(patientService.findOneByid(id));
			
			medicalRecordRepository.save(novi);
			
			MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO(medicalRecordRepository.findOneBypatient_id(id));
			return medicalRecordDTO;
		}
		
	 }
}
