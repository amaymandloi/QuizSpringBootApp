package com.yash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yash.convertor.QuizViewToEntityConvertor;
import com.yash.dao.QuizDAO;
import com.yash.dao.UserDAO;
import com.yash.entities.Quiz;
import com.yash.entities.Quiz;
import com.yash.model.QuizRequest;
import com.yash.model.QuizResponse;
@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizDAO quizDAO;
	
	@Autowired@Qualifier("hibernateUserDAOImpl")
	private UserDAO userDAO;
	
	@Autowired
	QuizViewToEntityConvertor quizViewToEntityConvertor;
	
	@Override
	public List<QuizResponse> getQuizModel() {
		List<Quiz> listOfQuizs = quizDAO.getAllQuizs();
		List<QuizResponse> quizModelList = new ArrayList<QuizResponse>();

		for (Quiz quiz : listOfQuizs) {
			QuizResponse quizModel = new QuizResponse();
			quizModel.setQuizId(quiz.getQuizId());
			quizModel.setQuizName(quiz.getQuizName());
			quizModel.setQuizLevel(quiz.getQuizLevel());
			
			
			quizModelList.add(quizModel);
		}
		return quizModelList;
	}

	@Override
	public QuizResponse getQuizModelByQuizId(int quizId) {
		Quiz quiz=quizDAO.getQuizByQuizId(quizId);
		QuizResponse quizResponse=new QuizResponse();
		quizResponse.setQuizId(quiz.getQuizId());
		quizResponse.setQuizName(quiz.getQuizName());
		quizResponse.setQuizLevel(quiz.getQuizLevel());
		
        return quizResponse;
        }

	
	public QuizResponse getQuizModelByQuizName(String quizName) {
		Quiz quiz=quizDAO.getQuizByQuizName(quizName);
		QuizResponse quizResponse=new QuizResponse();
		quizResponse.setQuizId(quiz.getQuizId());
		quizResponse.setQuizName(quiz.getQuizName());
		quizResponse.setQuizLevel(quiz.getQuizLevel());
		
        return quizResponse;
        }

	@Override
	public boolean storeQuizModel(QuizRequest quizRequest) {
		boolean flag = false;
		Quiz quiz = quizViewToEntityConvertor.saveQuizConvertor(quizRequest);
		
		boolean savedQuiz = quizDAO.storeQuizDetails(quiz);
		
		if(savedQuiz)
			flag=true;
		
		return flag;
	}

}
