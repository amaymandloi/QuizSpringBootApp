package com.yash.controller.test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Errors;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.controller.UserController;
import com.yash.entities.User;
import com.yash.main.QuizSpringBootAppApplication;
import com.yash.model.UserRequest;
import com.yash.model.UserResponse;
import com.yash.service.UserService;
import com.yash.service.UserServiceImpl;
import com.yash.validation.UserCustomValidator;
import com.yash.validation.UserIdCustomValidator;

@AutoConfigureMockMvc
@WebMvcTest
@ContextConfiguration(classes = QuizSpringBootAppApplication.class)
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	private MockMvc mockMvc;
	@Mock
	private UserServiceImpl userService;

//	@Mock
//	private UserService userServiceInterface;
	@InjectMocks
	private UserController userController;
	@InjectMocks
	@Spy
	private UserCustomValidator userCustomValidator;
	@InjectMocks
	@Spy
	private UserIdCustomValidator userIdCustomValidator;

	private RestTemplate template;
	@Mock
	private RestTemplate mockTemplate;

	@BeforeEach
	public void setUp() {

		// MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		template = new RestTemplate();

	}

	@Test
	void testhandleGetAllUsersJSON_positive() {
		try {
			List<UserResponse> userResponseList = new ArrayList<UserResponse>();

			UserResponse userResponse = new UserResponse();
//		userResponse.setUserId(1);
//		userResponse.setFirstName("Amit");
//		userResponse.setLastName("Verma");
//		userResponse.setEmail("amit@gmail.com");

			userResponse.setUserId(5);
			userResponse.setFirstName("Himanshu");
			userResponse.setLastName("Kulshrestha");
			userResponse.setEmail("himanshu@gmail.com");
			System.out.println("userResponse: " + userResponse);
			userResponseList.add(userResponse);
			// System.out.println("userService :
			// "+userService.usersRetrievalServicesJSON());
			// when(userService.usersRetrievalServicesJSON()).thenReturn(userResponseList);
			when(userService.getUserModel()).thenReturn(userResponseList);
			System.out.println("testhandleGetAllUsersJSON_positive() : AfterWhen : line 87 : ");

			ResponseEntity<List<UserResponse>> responseEntity = userController.handleGetAllUserJSON();
			System.out.println("testhandleGetAllUsersJSON_positive() : userController : line 90 : "
					+ userController.handleGetAllUserJSON());
			System.out.println(
					"testhandleGetAllUsersJSON_positive() : usercontroller:" + userController.handleGetAllUserJSON());
			List<UserResponse> responseBody = responseEntity.getBody();
			System.out.println("responseBody:" + responseBody + responseBody.size());
			assertTrue(responseBody.size() > 0);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	void retrieveUserByIdRequestURINegative() {
		UserResponse userResponse = new UserResponse();
		userResponse.setUserId(5);
		userResponse.setFirstName("Himanshu");
		userResponse.setLastName("Kulshrestha");
		userResponse.setEmail("himanshu@gmail.com");

		System.out.println("retrieveUserByIdRequestURINegative()  : userResponse : line 161 : " + userResponse);

		when(userService.getUserByUserId(anyInt())).thenReturn(userResponse);

		System.out.println("retrieveUserByIdRequestURINegative()  : insideWhen : line 165 : ");

		try {
			MvcResult result = mockMvc.perform(get("http://localhost:8082/quizApp/userapi/userById/5"))
					.andExpect(status().isNotFound()).andReturn();
		} catch (Exception e) {

			assertTrue(false);
		}
	}


	@Test
	void retrieveUserById_restTemplate() {
		UserResponse userResponse = new UserResponse();
		userResponse.setUserId(5);
		userResponse.setFirstName("Himanshu");
		userResponse.setLastName("Kulshrestha");
		userResponse.setEmail("himanshu789@gmail.com");

		when(mockTemplate.getForEntity("http://localhost:8082/quizApp/userapi/userById/5", UserResponse.class))
				.thenReturn(new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK));

		ResponseEntity<UserResponse> responseEntity = mockTemplate.getForEntity("http://localhost:8082/quizApp/userapi/userById/5",
				UserResponse.class);
		Errors errorsMock = Mockito.mock(Errors.class);
		//when(errorsMock.hasErrors()).thenReturn(false);
		UserResponse response = responseEntity.getBody();
		System.out.println("retrieveUserById_restTemplate() : line 265 : REsponse "+response);
		assertEquals(userResponse.getUserId(), response.getUserId());

	}
  @Test
  public void retrieveUserByIdActualCallRestTemplate() {
	  ResponseEntity<UserResponse> responseEntity=
			  template.getForEntity("http://localhost:8082/quizApp/userapi/userById/5", 
					  UserResponse.class);
	  UserResponse userResponse=responseEntity.getBody();
	  assertEquals(5,userResponse.getUserId());
  }
  @Test
  public void testJSONData() throws ClientProtocolException, IOException {
	  HttpUriRequest request=new HttpGet("http://localhost:8082/quizApp/userapi/userById/5");
	  
	  HttpResponse response=HttpClientBuilder.create().build().execute(request);
	  ObjectMapper mapper=new ObjectMapper()
			  .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
	  
	  String stringOfResponse=EntityUtils.toString(response.getEntity());
	  UserResponse userResponse=mapper.readValue(stringOfResponse, UserResponse.class);
	  assertEquals(5,userResponse.getUserId());
	  assertEquals("Himanshu",userResponse.getFirstName());
	  
  }
}
