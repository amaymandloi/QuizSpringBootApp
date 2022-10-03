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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
import com.yash.controller.ResultController;
import com.yash.controller.ResultController;
import com.yash.main.QuizSpringBootAppApplication;
import com.yash.model.ResultResponse;
import com.yash.model.ResultRequest;
import com.yash.model.ResultResponse;
import com.yash.model.ResultResponse;
import com.yash.service.ResultServiceImpl;
import com.yash.service.ResultServiceImpl;
@AutoConfigureMockMvc
@WebMvcTest
@ContextConfiguration(classes = QuizSpringBootAppApplication.class)
@ExtendWith(MockitoExtension.class)
class ResultControllerTest {
	
	private MockMvc mockMvc;
	@Mock
	private ResultServiceImpl resultService;

	@InjectMocks
	private ResultController resultController;

	private RestTemplate template;
	@Mock
	private RestTemplate mockTemplate;

	@BeforeEach
	public void setUp() {

		// MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(resultController).build();
		template = new RestTemplate();

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testhandleGetAllResultJSON_positive() {
		try {
			List<ResultResponse> resultResponseList = new ArrayList<ResultResponse>();

			ResultResponse resultResponse = new ResultResponse();
			
			resultResponse.setResultId(101);
			resultResponse.setMarks(90);
			resultResponse.setStatus(1);
			resultResponse.setPercentage(90);
			
			
			System.out.println("resultResponse: " + resultResponse);
			resultResponseList.add(resultResponse);
			
			when(resultService.getResultModel()).thenReturn(resultResponseList);
			System.out.println("testhandleGetAllResultsJSON_positive() : AfterWhen : line 82 : ");

			ResponseEntity<List<ResultResponse>> responseEntity = resultController.handleGetAllResultJSON();
			System.out.println("testhandleGetAllResultsJSON_positive() : resultController : line 90 : "
					+ resultController.handleGetAllResultJSON());
			System.out.println(
					"testhandleGetAllResultsJSON_positive() : resultcontroller:" + resultController.handleGetAllResultJSON());
			List<ResultResponse> responseBody = responseEntity.getBody();
			System.out.println("responseBody:" + responseBody + responseBody.size());
			assertTrue(responseBody.size() > 0);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	void retrieveResultById_positive() {
		System.out.println("retrieveResultById_positive()  : line  " + resultService.getResultModelByResultId(1));

		when(resultService.getResultModelByResultId(5)).thenAnswer(

				new Answer<ResultResponse>() {

					public ResultResponse answer(InvocationOnMock invocation) throws Exception {
						System.out.print("USerREsponse INside when : retrieveResultById_positive() ");
						ResultResponse resultResponse = new ResultResponse();

						resultResponse.setResultId(1);
						resultResponse.setMarks(89);
						resultResponse.setStatus(1);
						resultResponse.setPercentage(89);
						
						System.out
								.println("retrieveResultById_positive() : answer() : insideWhen and Answer: line 115 : ");

						System.out.println("resultResponse+" + resultResponse);
						return resultResponse;
					}
				});

		ResponseEntity<ResultResponse> responseEntity = resultController.handleGetResultByIdJSON(5);
		System.err.println(" retrieveResultById_positive() : responseEntity : line 129 " + responseEntity
				+ resultController.handleGetResultByIdJSON(5));
		ResultResponse resultResponse = responseEntity.getBody();
		System.err.println(" retrieveResultById_positive() : USerREsponse : line 131 " + resultResponse);
		assertEquals(1, resultResponse.getResultId());
	
	}

	void retrieveResultByIdRequestURINegative() {
		ResultResponse resultResponse = new ResultResponse();
		resultResponse.setResultId(1);
		resultResponse.setMarks(89);
		resultResponse.setStatus(1);
		resultResponse.setPercentage(89);

		System.out.println("retrieveResultByIdRequestURINegative()  : resultResponse : line 161 : " + resultResponse);

		when(resultService.getResultModelByResultId(anyInt())).thenReturn(resultResponse);

		System.out.println("retrieveResultByIdRequestURINegative()  : insideWhen : line 165 : ");

		try {
			MvcResult result = mockMvc.perform(get("http://localhost:8082/quizApp/resultapi/results/1"))
					.andExpect(status().isNotFound()).andReturn();
		} catch (Exception e) {

			assertTrue(false);
		}
	}	

	@Test
	void retrieveResultById_restTemplate() {
		ResultResponse resultResponse = new ResultResponse();
		resultResponse.setResultId(1);
		resultResponse.setMarks(89);
		resultResponse.setStatus(1);
		resultResponse.setPercentage(89);

		when(mockTemplate.getForEntity("http://localhost:8082/quizApp/resultapi/results/1", ResultResponse.class))
				.thenReturn(new ResponseEntity<ResultResponse>(resultResponse, HttpStatus.OK));

		ResponseEntity<ResultResponse> responseEntity = mockTemplate.getForEntity("http://localhost:8082/quizApp/resultapi/results/1",
				ResultResponse.class);
		
		ResultResponse response = responseEntity.getBody();
		System.out.println("retrieveResultById_restTemplate() : line 265 : REsponse "+response);
		assertEquals(resultResponse.getResultId(), response.getResultId());

	}
  @Test
  public void retrieveResultByIdActualCallRestTemplate() {
	  ResponseEntity<ResultResponse> responseEntity=
			  template.getForEntity("http://localhost:8082/quizApp/resultapi/results/1", 
					  ResultResponse.class);
	  ResultResponse resultResponse=responseEntity.getBody();
	  assertEquals(1,resultResponse.getResultId());
  }
  @Test
  public void testJSONData() throws ClientProtocolException, IOException {
	  HttpUriRequest request=new HttpGet("http://localhost:8082/quizApp/resultapi/results/1");
	  
	  HttpResponse response=HttpClientBuilder.create().build().execute(request);
	  ObjectMapper mapper=new ObjectMapper()
			  .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
	  
	  String stringOfResponse=EntityUtils.toString(response.getEntity());
	  ResultResponse resultResponse=mapper.readValue(stringOfResponse, ResultResponse.class);
	  assertEquals(1,resultResponse.getResultId());
	  assertEquals(89,resultResponse.getMarks());
	  
  }
 

}
