package org.psw_isa.psw_isa_backend.repository;

import org.psw_isa.psw_isa_backend.models.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {

}
