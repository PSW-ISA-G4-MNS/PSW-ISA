package org.psw_isa.psw_isa_backend_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.CareType;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.ClinicRepository;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.service.ClinicService;
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
public class ClinicServiceTest {

	 @TestConfiguration
	    static class UserServiceImplTestContextConfiguration {
	  
	        @Bean
	        public ClinicService clinicService() {
	            return new ClinicService();
	        }
	    }
	 @Autowired
	 ClinicService clinicService;
	 
	 @Autowired
	 @MockBean
	 DoctorRepository doctorRepository;
	 
	 @Autowired
	 @MockBean
	 ClinicRepository clinicRepository;
	 
	 
	 private ArrayList<Doctor> doctors=new ArrayList<Doctor>();
	 
	 private ArrayList<Care> cares=new ArrayList<Care>();
	 
	 private ArrayList<Clinic> clinics=new ArrayList<Clinic>();
	 
	 private Clinic clinic=new Clinic();
	 
	 private Doctor doctor;
	 
	 private CareType careType;
	 
	
	 
	 @Test
	    public void assignPatientToCareTest(){
		 
		 assertEquals(clinicRepository.findAll(), new ArrayList<Clinic>());
		 
	   // clinicService.findClinicsWithFreeDoctors(1L, "2020-06-18 17:00:00");
	    
	  //  when(clinicService.findClinicsWithFreeDoctors(1L, "2020-06-18 17:00:00")).thenReturn(arg0)
	    
	    	
	    }
	
}
