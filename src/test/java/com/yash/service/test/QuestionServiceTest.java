package com.yash.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.yash.dao.QuestionDAO;
import com.yash.dao.QuestionsDAOJdbcImplementation;
import com.yash.dao.ResultDAOImpl;
import com.yash.service.QuestionsServiceImplementation;
import com.yash.service.ResultServiceImpl;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {
	
	@Mock
	private QuestionDAO questionDAO;
	
	@Mock
	private QuestionsServiceImplementation questionService;
	
	@Mock
	private QuestionsDAOJdbcImplementation questionDAOImpl;
	
	private RestTemplate template;
	@Mock
	private RestTemplate mockTemplate;

	@BeforeEach
	void setUp() throws Exception {
		this.questionService = new QuestionsServiceImplementation(this.questionDAO);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void getAllQuestionsTest() {
		questionService.getQuestionsModel();
		verify(questionDAO).getAllQuestions();
	}

}
