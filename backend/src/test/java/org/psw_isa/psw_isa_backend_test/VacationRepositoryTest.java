package org.psw_isa.psw_isa_backend_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.models.CareType;
import org.psw_isa.psw_isa_backend.models.Vacation;
import org.psw_isa.psw_isa_backend.repository.CareTypeRepository;
import org.psw_isa.psw_isa_backend.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes=BackendApplication.class)
public class VacationRepositoryTest {

	
	@Autowired
	private TestEntityManager entityManager;

	
	private Long id = Long.valueOf(1);

	private VacationRepository vacationRepository;

	@BeforeEach
	public void setUp() {
		Vacation vacation= new Vacation();
		entityManager.merge(vacation);
		entityManager.flush();
	}

	@AfterEach
	public void tearDown() {
		entityManager.clear();
	}

	@Test
	public void testFindAll() {

		assertEquals(1, vacationRepository.findAll().size());

	}
	/*
	@Test
	public void testFindOneById() {
		
		assertEquals(id,vacationRepository.findOneByid(id).getId() );
		
	}
	*/
}
