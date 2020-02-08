package org.psw_isa.psw_isa_backend_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.psw_isa.psw_isa_backend.service.CareService;
import org.psw_isa.psw_isa_backend.service.CheckRoleService;
import org.psw_isa.psw_isa_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes=BackendApplication.class)
public class CareServiceTest {

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {
  
        @Bean
        public CareService careService() {
            return new CareService();
        }
    }

    @Autowired
    private CareService careService;
   
    @Autowired
    @MockBean
    private CheckRoleService checkRoleService;
    
    @Autowired
    @MockBean
    private CareRepository careRepository;
    
    @Autowired
    @MockBean
    private UserRepository userRepository;

  
    private ArrayList<Care> cares=new ArrayList<Care>();

    private Clinic clinic;
	 
    private Doctor doctor;
    
    private Care care;

    private Patient patient;


    private ArrayList<User> data;
    @BeforeEach
    public void setUp() {
    	data = new ArrayList<User>();
	data.add(new User());
	when(userRepository.findOneByemail(any(String.class))).thenReturn((User) data.get(0));
    }

    @AfterEach
    public void tearDown() {
    }
   /* 
    @Test 
    public void testFindAll() {
    	assertEquals(userService.findOneByemail("").getEmail(), data.get(0).getEmail());
    }
    */
    
  


@Test
    public void findAllUnassignedAndUpcomingForClinicTest(){
    	care = new Care();
        doctor = new Doctor();
        clinic = new Clinic();
        clinic.setId(1L);
        doctor.setId(1L);
        doctor.setClinic(clinic);
        care.setDoctor(doctor);

        String str = "2020-04-08 12:30:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        care.setStartTime(dateTime);
        cares.add(care);
        when(careRepository.findAll()).thenReturn(cares);

        assertEquals(1, careService.findAllUnassignedAndUpcomingForClinic(1L).size());
    	
    }

	public void updateTest(Long careID) {

	
	}

    public void saveTest(Long careID) {

	
	}

    public void saveWithPatientTest(Long careID) {

	
	}

}
