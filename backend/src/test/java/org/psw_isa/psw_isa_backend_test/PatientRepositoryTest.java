package org.psw_isa.psw_isa_backend_test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.research.ws.wadl.Application;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes=BackendApplication.class)
public class PatientRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
	
	 @Autowired
	 private PatientRepository patientRepository;
	 
	 private Long id=Long.valueOf(1);
	 
	 @BeforeEach
	    public void setUp() {
		// given
		Patient patient = new Patient();
		patient.setInsuranceID("1234567891234");
		entityManager.merge(patient);
		entityManager.flush();
	    }

	    @AfterEach
	    public void tearDown() {
	    	entityManager.clear();
	    }
	    
	    @Test 
	    public void testFindAll() {

		assertEquals( 1,patientRepository.findAll().size());
	
	    }
	    
	    @Test
	    public void testfindOneByIdNotNull() {
	    	
	    	assertNotNull(patientRepository.findOneByid(id));
	    }
	    
	    
	    /*
	    @Test
	    public void testfindOneById() {
	    	
	    	assertEquals(1,patientRepository.findOneByid(id).getId());
	    }
	    */
	    
	    @Test
	    public void testsave() {
	    	patientRepository.save(new Patient());
	    	assertEquals( 2,patientRepository.findAll().size());
	    }
	    
	    @Test
	    public void testDelete() {
	    	patientRepository.deleteAll();
	    	assertEquals( 0,patientRepository.findAll().size());
	    }
	   
	    
	    
	    
}
