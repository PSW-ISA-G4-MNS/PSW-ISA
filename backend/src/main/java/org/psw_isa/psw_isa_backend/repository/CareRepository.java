package org.psw_isa.psw_isa_backend.repository;

import org.psw_isa.psw_isa_backend.models.Care;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareRepository extends JpaRepository<Care, Long> {

	public Care findOneByid(Long id);
	
	
	
}
