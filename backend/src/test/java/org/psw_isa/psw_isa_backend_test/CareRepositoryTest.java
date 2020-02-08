package org.psw_isa.psw_isa_backend_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes=BackendApplication.class)
public class CareRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CareRepository careRepository;

	private Long id =Long.valueOf(1);
	
	@BeforeEach
	public void setUp() {
		
		Care care = new Care();
		Patient patient=new Patient();
		entityManager.merge(care);
		entityManager.merge(patient);
		entityManager.flush();
	}

	@AfterEach
	public void tearDown() {
		entityManager.clear();
	}
	
	/*
	@Test
	public void testfindOneById() {
		
		assertEquals(id,careRepository.findOneByid(id).getId());
	}
	*/
	@Test
	public void testCarePatientUpdate() {
		
		careRepository.carePatientUpdate(id, id);
		
		assertEquals( id,careRepository.findOneByid(id).getPatient().getId());
		
	}

}
