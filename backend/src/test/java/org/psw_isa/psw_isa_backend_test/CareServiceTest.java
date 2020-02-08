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
import org.psw_isa.psw_isa_backend.dtos.CareDTO;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.Diagnosis;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.Room;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.DiagnosisRepository;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.psw_isa.psw_isa_backend.service.CareService;
import org.psw_isa.psw_isa_backend.service.CheckRoleService;
import org.psw_isa.psw_isa_backend.service.RoomService;
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

    @Autowired
    @MockBean
    private CareService careService2;

    @Autowired
    @MockBean
    private DoctorRepository doctorRepository;

    @Autowired
    @MockBean
    private RoomService roomService;

    @Autowired
    @MockBean
    private DiagnosisRepository diagnosisRepository;
  
    private ArrayList<Care> cares=new ArrayList<Care>();

    private Clinic clinic;
	 
    private Doctor doctor;

    private Room room;
    
    private Care care;

    private Diagnosis diagnosis;

    private Patient patient;

    private CareDTO careDTO;


    private ArrayList<User> data;
    @BeforeEach
    public void setUp() {
    
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
        care.setId(1L);
        care.setDoctor(doctor);

        String str = "2021-08-08 19:30:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        care.setStartTime(dateTime);
        care.setPatient(null);
        cares.add(care);
        when(careRepository.findAll()).thenReturn(cares);

        assertEquals(1, careService.findAllUnassignedAndUpcomingForClinic(1L).size());
    	
    }

    @Test
	public void updateTest(Long careID) {

	
	}

    @Test
    public void saveTest(Long careID) {
       
        
        when(careRepository.save(care)).thenReturn(care);
        assertEquals(care, careService.save(careDTO));
	
	}

    @Test
    public void saveWithPatientTest(Long careID) {

	
	}

}
