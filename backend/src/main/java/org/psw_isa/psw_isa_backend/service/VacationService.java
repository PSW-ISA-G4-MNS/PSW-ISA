package org.psw_isa.psw_isa_backend.service;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Vacation;
import org.psw_isa.psw_isa_backend.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationService {

	
	@Autowired
	VacationRepository vacationRepository;
	
	
	public Vacation findOneByid(Long id) {
		return vacationRepository.findOneByid(id);
	}
	
	public List<Vacation> findAll() {
		return vacationRepository.findAll();
	}

	public Long save(Vacation vacation) 
	{
		vacation.setId(null);
		Vacation v = vacationRepository.save(vacation);
		return v.getId();
	}
	public Long update(Long id, Vacation vacation) 
	{
		vacation.setId(id);
		Vacation v = vacationRepository.save(vacation);
		return v.getId();
	}
}
