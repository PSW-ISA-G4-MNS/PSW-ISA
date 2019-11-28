package org.psw_isa.psw_isa_backend.service;

import org.psw_isa.psw_isa_backend.models.Medicine;
import org.psw_isa.psw_isa_backend.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

	@Autowired
	MedicineRepository medicineRepository;
	
	public Medicine save(Medicine medicine) {
		return medicineRepository.save(medicine);
	}
}
