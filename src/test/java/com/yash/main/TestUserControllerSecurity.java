package com.yash.main;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Matchers.anyInt;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.nio.charset.Charset;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.Spy;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mock.web.MockServletContext;
//import org.springframework.security.crypto.codec.Base64;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
//import org.springframework.security.web.FilterChainProxy;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.validation.Errors;
//import org.springframework.web.client.RestTemplate;
//
//import com.yash.controller.EmployeeController;
//import com.yash.dao.JDBCEmployeeDAOImpl;
//import com.yash.integrate.ConnectionManager;
//import com.yash.integrate.DataSource;
//import com.yash.model.EmployeeResponse;
//import com.yash.service.EmployeeServiceImpl;
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@ContextConfiguration(classes= {SpringRestApplication.class,MockServletContext.class})
//class TestUserControllerSecurity {
//
//	private MockMvc mockMvc;
//	@Autowired
//	private FilterChainProxy springSecurityFilterChain;
//	
//	@Spy
//	@Autowired
//	private EmployeeServiceImpl employeeServiceImpl;
//	@Spy
//	@Autowired
//	private JDBCEmployeeDAOImpl jDBCEmployeeDAOImpl;
//	@Spy
//	@Autowired
//	private ConnectionManager connectionManager;
//	@Spy
//	@Autowired
//	private DataSource dataSource;
//	
//	
//	 private RestTemplate template;
//	
//	@InjectMocks
//	 private EmployeeController employeeController;
//	
//	   @BeforeEach
//	    public void init(){
//	        MockitoAnnotations.initMocks(this);
//	        template=new RestTemplate();
//	        mockMvc = MockMvcBuilders
//	                .standaloneSetup(employeeController)
//	                .apply(SecurityMockMvcConfigurers.springSecurity(springSecurityFilterChain))
//	                .build();
//	    }
//
//	   @WithMockUser(username = "jjjjj",password = "user123",roles = {"userrole"})
//		@Test
//		public void test_auth_positive() throws Exception {			
//			        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8082/api/employees")
//		            .accept(MediaType.ALL))
//		            .andExpect(status().isOk());
//		}
//	   @Test
//		public void integerationTestRestTemplateWithAuthentication() {
//			RestTemplate template=new RestTemplate();		     
//			String auth="amit"+":"+"amit123";			
//			HttpHeaders headers=new HttpHeaders();
//			  byte[] encodedAuth = Base64.encode( 
//			          auth.getBytes(Charset.forName("US-ASCII")) );
//			       String authHeader = "Basic " + new String( encodedAuth );
//			   headers.add("Authorization", authHeader);
//			String url="http://localhost:8082/api/employees/{empId}";
//			headers.setContentType(MediaType.APPLICATION_JSON);
//			HttpEntity<String> requestEntity=new HttpEntity<String>(headers);
//			ResponseEntity<EmployeeResponse> response=
//					template.exchange(url, HttpMethod.GET, requestEntity, EmployeeResponse.class,1002);
//			EmployeeResponse employeeResponse=response.getBody();
//			assertEquals(1002,employeeResponse.getEmpId());
//		}
	
//}
