package org.psw_isa.psw_isa_backend.repository;

import org.psw_isa.psw_isa_backend.models.CareType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareTypeRepository extends JpaRepository<CareType, Long> {

	
	public CareType findOneByid(Long id);
	
}
