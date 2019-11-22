package org.psw_isa.psw_isa_backend.controller;

import javax.servlet.http.HttpSession;

import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.service.PatientService;
import org.psw_isa.psw_isa_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@RequestMapping(value = "patients")
public class PatientController {


    @Autowired
    PatientService patientService;
    
    @Autowired
    UserService userService;
    
    @GetMapping(value = "")
    public ResponseEntity<Patient> getData(){
        return new ResponseEntity<>(patientService.getBySession(), HttpStatus.OK);
    }


}
