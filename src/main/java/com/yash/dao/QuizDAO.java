package com.yash.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yash.entities.Quiz;
import com.yash.entities.Result;



@Repository("hibernateQuizDAOImpl")
public interface QuizDAO {

	public List<Quiz> getAllQuizs();
	public Quiz getQuizByQuizId(int quizId);
	public Quiz getQuizByQuizName(String quizName);
	public boolean storeQuizDetails(Quiz quiz);

	
}
