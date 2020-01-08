package org.psw_isa.psw_isa_backend_test;

import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.psw_isa.psw_isa_backend.service.UserService;
import org.psw_isa.psw_isa_backend.models.User;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.beans.factory.annotation.*;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.mock.mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.ArgumentMatchers.*;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.*;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.TestPropertySource;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.psw_isa.psw_isa_backend.BackendApplication;

@SpringBootTest(
  //SpringBootTest.WebEnvironment.MOCK,
  classes = BackendApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application-integrationtest.properties")
public class UserControllerTest {
 
    @Autowired
    private MockMvc mvc;
 
    @Autowired
    private UserRepository repository;
 
    // write test cases here
}
