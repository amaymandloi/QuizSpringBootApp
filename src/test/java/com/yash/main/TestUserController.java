package com.yash.main;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.controller.UserController;
import com.yash.model.UserRequest;
import com.yash.model.UserResponse;
import com.yash.service.UserService;
import com.yash.validation.UserCustomValidator;
import com.yash.validation.UserIdCustomValidator;
@AutoConfigureMockMvc
@WebMvcTest
@ContextConfiguration(classes=QuizSpringBootAppApplication.class)
class TestUserController {
	
	private MockMvc mockMvc;
	@Mock
	private UserService userService;
	@InjectMocks
	private UserController userController;
	@InjectMocks
	@Spy
	private UserCustomValidator userCustomValidator;
	@InjectMocks
	@Spy
	private UserIdCustomValidator empIdCustomValidator;
	
	private RestTemplate template;
	@Mock
	private RestTemplate mockTemplate;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(userController).build();
		template=new RestTemplate();
		
	}
//	@Test
//	void testhandleGetAllUsersJSON_positive() {
//		try {
//		List<UserResponse> userResponseList=new ArrayList<UserResponse>();
//		
//		UserResponse userResponse=new UserResponse();
//		userResponse.setUserId(5);
//		userResponse.setFirstName("Himanshu");
//		userResponse.setEmail("himanshu@gmail.com");
//
//		userResponseList.add(userResponse);
//		
//		when(userService.usersRetrievalServicesJSON()).thenReturn(userResponseList);
//		
//		ResponseEntity<List<UserResponse>> responseEntity=userController.handleGetAllUsersJSON();
//		List<UserResponse> responseBody=responseEntity.getBody();
//		assertTrue(responseBody.size()>0);
//		}catch(Exception e) {
//			assertTrue(false);
//		}
	
		
		
//}
//	@Test
//	void retrieveUserById_positive() {
//		
//		when(userService.getUser(anyInt())).thenAnswer(
//				new Answer<UserResponse>() {
//					
//					public UserResponse answer(InvocationOnMock invocation) throws Exception {
//						UserResponse userResponse=new UserResponse();
//						userResponse.setEmpId(1001);
//						userResponse.setEmpName("Sabbir");
//						userResponse.setEmpSalary(34000);
//						userResponse.setEmpDesignation("Manager");
//						return userResponse;
//					}});
//		
//
//		ResponseEntity<UserResponse> responseEntity=userController.retrieveUserByIdRequest(1001);
//		UserResponse userResponse=responseEntity.getBody();
//		assertEquals(1001,userResponse.getEmpId());
//	}
//	
//	@Test
//	void retrieveUserByIdRequestURIPositive() 
// {
//		UserResponse userResponse=new UserResponse();
//		userResponse.setEmpId(1002);
//		userResponse.setEmpName("Sabbir");
//		userResponse.setEmpSalary(34000);
//		userResponse.setEmpDesignation("Manager");
//		
//		when(userService.getUser(anyInt())).thenReturn(userResponse);
//		
//		try {
//			MvcResult result=
//					mockMvc.perform(get("http://localhost:8082/api/usersreq?empId=1002"))
//			.andExpect(status().isFound()).andReturn();
//		} catch (Exception e) {
//
//       assertTrue(false);
//		}
//	}
//	
//	void retrieveUserByIdRequestURINegative() 
//	 {
//			UserResponse userResponse=new UserResponse();
//			userResponse.setEmpId(1001);
//			userResponse.setEmpName("Sabbir");
//			userResponse.setEmpSalary(34000);
//			userResponse.setEmpDesignation("Manager");
//			
//			when(userService.getUser(anyInt())).thenReturn(userResponse);
//			
//			try {
//				MvcResult result=
//						mockMvc.perform(get("http://localhost:8082/api/usersreq?empId=1002"))
//				.andExpect(status().isNotFound()).andReturn();
//			} catch (Exception e) {
//
//	       assertTrue(false);
//			}
//		}
//
//	@Test
//	void retrieveUserByIdPathURIPositive() 
// {
//		UserResponse userResponse=new UserResponse();
//		userResponse.setEmpId(1002);
//		userResponse.setEmpName("Sabbir");
//		userResponse.setEmpSalary(34000);
//		userResponse.setEmpDesignation("Manager");
//		  when(userService.checkEmpId(anyInt())).thenReturn(true);
//		Errors errorsMock=Mockito.mock(Errors.class);
//		  when(errorsMock.hasErrors()).thenReturn(false);
//		when(userService.getUser(anyInt())).thenReturn(userResponse);
//		
//		try {
//			MvcResult result=
//					mockMvc.perform(get("http://localhost:8082/api/users/{empId}",1002))
//			.andExpect(status().isFound()).andReturn();
//		} catch (Exception e) {
//
//       assertTrue(false);
//		}
//	}
//	
//	
//  @Test
//  void persistUserPositive() {
//	  UserRequest userRequest=new UserRequest();
//	 
//	  userRequest.setEmpId(1001);
//	  userRequest.setEmpName("Sabbir");
//	  userRequest.setEmpSalary(34000);
//	  userRequest.setEmpDesignation("Manager");
//	  when(userService.checkEmpId(anyInt())).thenReturn(true);
//
//	  Errors errorsMock=Mockito.mock(Errors.class);
//	  when(errorsMock.hasErrors()).thenReturn(false);
//	  when(userService.persistUser(userRequest)).thenReturn(true);
//	  ResponseEntity<UserResponse> responseEntity=userController.persistUser(userRequest, errorsMock);
//	  UserResponse userResponse=responseEntity.getBody();
//	  assertEquals(userResponse.getEmpId(),userRequest.getEmpId());
//  }
//  @Test
//  void updateUserSalary() {
//	  when(userService.updateUser(anyInt(), anyDouble())).thenReturn(true);
//	  try {
//		MvcResult result=mockMvc.perform(patch("http://localhost:8082/api/users/{empId}/{empSalary}",1001,32000))
//		  .andExpect(status().isAccepted()).andReturn();
//	} catch (Exception e) {
//		assertTrue(false);
//	}
//  }
//  
//  @Test
//  void retrieveUserById_restTemplate() {
//	  UserResponse userResponse=new UserResponse();
//		userResponse.setEmpId(1002);
//		userResponse.setEmpName("Sabbir");
//		userResponse.setEmpSalary(34000);
//		userResponse.setEmpDesignation("Manager");
//		
//		when(mockTemplate
//				.getForEntity("http://localhost:8082/api/users/1002",UserResponse.class))
//		.thenReturn(new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK));
//		
//		ResponseEntity<UserResponse> responseEntity=
//				mockTemplate.getForEntity("http://localhost:8082/api/users/1002", UserResponse.class);
//		  when(userService.checkEmpId(anyInt())).thenReturn(true);
//			Errors errorsMock=Mockito.mock(Errors.class);
//			  when(errorsMock.hasErrors()).thenReturn(false);
//		UserResponse response=responseEntity.getBody();
//		assertEquals(userResponse.getEmpId(),response.getEmpId());
//		
//  
//  }
//  @Test
//  public void retrieveUserByIdActualCallRestTemplate() {
//	  ResponseEntity<UserResponse> responseEntity=
//			  template.getForEntity("http://localhost:8082/api/users/1002", 
//					  UserResponse.class);
//	  UserResponse userResponse=responseEntity.getBody();
//	  assertEquals(1002,userResponse.getEmpId());
//  }
//  @Test
//  public void testJSONData() throws ClientProtocolException, IOException {
//	  HttpUriRequest request=new HttpGet("http://localhost:8082/api/users/1002");
//	  
//	  HttpResponse response=HttpClientBuilder.create().build().execute(request);
//	  ObjectMapper mapper=new ObjectMapper()
//			  .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
//	  
//	  String stringOfResponse=EntityUtils.toString(response.getEntity());
//	  UserResponse userResponse=mapper.readValue(stringOfResponse, UserResponse.class);
//	  assertEquals(1002,userResponse.getEmpId());
//	  assertEquals("amit",userResponse.getEmpName());
//	  
//  }
//  @Test
//  public void testJSONMockData() throws Exception {
//		UserResponse userResponse=new UserResponse();
//		userResponse.setEmpId(1002);
//		userResponse.setEmpName("Sabbir");
//		userResponse.setEmpSalary(34000);
//		userResponse.setEmpDesignation("Manager");
//		  when(userService.checkEmpId(anyInt())).thenReturn(true);
//		Errors errorsMock=Mockito.mock(Errors.class);
//		  when(errorsMock.hasErrors()).thenReturn(false);
//		when(userService.getUser(anyInt())).thenReturn(userResponse);
//		
//		mockMvc.perform(get("http://localhost:8082/api/usersjson/{empId}",1002))
//		.andExpect(status().isOk())
//		.andExpect(jsonPath("$.empId").value(1002))
//		.andExpect(jsonPath("$.empName").value("Sabbir"))
//		.andExpect(jsonPath("$.empSalary").value(34000))
//		.andExpect(jsonPath("$.empDesignation").value("Manager")).andReturn();
//
//  }
}
