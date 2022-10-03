package com.yash.convertor;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.yash.dao.QuizDAO;
import com.yash.dao.UserDAO;
import com.yash.entities.Quiz;
import com.yash.entities.User;
import com.yash.helper.DateHelper;
import com.yash.model.QuizRequest;
@Component
public class QuizViewToEntityConvertor {

	@Autowired
	private QuizDAO quizDAO;
	
	@Autowired@Qualifier("hibernateUserDAOImpl")
	private UserDAO userDAO;
	
	public Quiz saveQuizConvertor(QuizRequest quizRequest) {

		Quiz destinationQuiz = new Quiz();
//		User user = userDAO.getUserByUserId(quizRequest.getUserId());
//		if(user==null) {
//			System.err.print("User Not found : "+quizRequest.getUserId());
//		}
		
		destinationQuiz.setQuizId(quizRequest.getQuizId());
		destinationQuiz.setQuizName(quizRequest.getQuizName());
		destinationQuiz.setQuizLevel(quizRequest.getQuizLevel());
		
		
		return destinationQuiz;
		
	}
	
}
