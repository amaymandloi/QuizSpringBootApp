package com.yash.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.yash.controller.UserController;
import com.yash.dao.ResultDAOImpl;
import com.yash.dao.UserDAO;
import com.yash.dao.UserDAOHIbernate;
import com.yash.service.ResultServiceImpl;
import com.yash.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	private MockMvc mockMvc;
	
	@Mock
	private UserDAO userDAO;
	
	@Mock
	private UserServiceImpl userService;
	
	private RestTemplate template;
	@Mock
	private RestTemplate mockTemplate;

	@BeforeEach
	void setUp() throws Exception {
		//this.userService = new UserServiceImpl(userDAO);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void getAllUsersTestPositive() {
		userService.getUserModel();
		verify(userDAO).getAllUsers();
	}

}
