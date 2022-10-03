package com.yash.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import com.yash.controller.UserController;
import com.yash.dao.ResultDAOImpl;
import com.yash.entities.Result;
import com.yash.main.QuizSpringBootAppApplication;
import com.yash.service.ResultServiceImpl;


@ExtendWith(MockitoExtension.class)
class ResultServiceTest {

	private MockMvc mockMvc;
	
	@Mock
	private ResultDAOImpl resultDAO;
	
	@Mock
	private ResultServiceImpl resultService;
	
	@Mock
	private ResultDAOImpl resultDAOImpl;

	@InjectMocks
	private UserController userController;

	private RestTemplate template;
	@Mock
	private RestTemplate mockTemplate;

	@BeforeEach
	void setUp() throws Exception {
		this.resultService = new ResultServiceImpl(this.resultDAO);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void getAllResultsTestPositive() {
	resultService.getResultModel();
	verify(resultDAO).getAllResults();
	}

}
