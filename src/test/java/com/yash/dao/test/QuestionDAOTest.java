package com.yash.dao.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.yash.dao.QuestionsDAOJdbcImplementation;
import com.yash.dao.ResultDAOImpl;
import com.yash.entities.Questions;
import com.yash.entities.Result;
import com.yash.helper.DateHelper;
@ExtendWith(SpringExtension.class)
class QuestionDAOTest {

	@Mock
	private QuestionsDAOJdbcImplementation questionDAO;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@AfterEach
	public void tearDown() {

	}

	@Test
	public void myTest() throws Exception {

	}

	@Test
	void getByIDTestPositive() {

		List<Questions> questions = questionDAO.getQuestionByQuestionId(1);

		System.out.println("Questions" + questions);

		verify(questionDAO).getQuestionByQuestionId(1);
	}
	
	@Test
	void getAllQuestionsTestPositive() {

		List<Questions> quetions = questionDAO.getAllQuestions();

		System.out.println("Questions" + quetions);

		verify(questionDAO).getAllQuestions();
	}

}
