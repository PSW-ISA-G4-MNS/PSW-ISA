package org.psw_isa.psw_isa_backend.repository;

import java.time.LocalDate;

import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.ClinicAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<ClinicAdministrator,Long > {

	@Modifying
	@Query(value = "UPDATE ClinicAdministrator admin SET admin.clinic = :clinic WHERE admin.id = :id", nativeQuery = true)
	public String updateAdminClinic(@Param("clinic") Long clinic, @Param("id") Long id);

	
}
