package org.psw_isa.psw_isa_backend.repository;

import java.time.LocalDate;

import org.psw_isa.psw_isa_backend.models.Care;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CareRepository extends JpaRepository<Care, Long> {

	public Care findOneByid(Long id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE care SET approved = :approved WHERE id = :id", nativeQuery = true)
	public int updateCareApprovePrescription(@Param("approved") boolean approved,@Param("id") Long id);

	
}
