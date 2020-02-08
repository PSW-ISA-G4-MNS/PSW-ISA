package org.psw_isa.psw_isa_backend_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.models.CareType;
import org.psw_isa.psw_isa_backend.models.Operation;
import org.psw_isa.psw_isa_backend.repository.CareTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes=BackendApplication.class)
public class CareTypeRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	private Long id = Long.valueOf(1);

	private CareTypeRepository careTypeRepository;

	@BeforeEach
	public void setUp() {
		CareType careType= new CareType();
		entityManager.merge(careType);
		entityManager.flush();
	}

	@AfterEach
	public void tearDown() {
		entityManager.clear();
	}

	@Test
	public void testFindAll() {

		assertEquals(1, careTypeRepository.findAll().size());

	}
	/*
	@Test
	public void testFindOneById() {
		
		assertEquals(id,careTypeRepository.findOneByid(id).getId() );
		
	}
	*/
}
