package com.yash.dao;


import java.util.List;

import com.yash.entities.Questions;

public interface QuestionDAO {
	
	public List<Questions> getAllQuestions();
	public List<Questions> getQuestionByQuestionId(int questionId);
	public boolean storeQuestionDetails(Questions question);
	public boolean updateQuestion(int questionId);
	public boolean deleteQuestion(Questions question);
	public List<Questions> getSpringQuestions();

}
