
package com.yash.service;

import java.util.List;

import com.yash.model.QuestionsRequest;
import com.yash.model.QuestionsResponse;
import com.yash.model.QuestionsResponses;

public interface QuestionService {
	
	public List<QuestionsResponse> getQuestionsModel();
	public List<QuestionsResponse> getQuestionModelByQuestionId(int questionId);
	public String storeQuestionModel(QuestionsRequest question);
	public boolean updateQuestionModel(int questionId);
	public boolean deleteQuestionModel(QuestionsResponse question);
	List<QuestionsResponse> getAnswers();
	public int getQuizId();
	public List<QuestionsResponse> getSpringQuestions();
	public List<QuestionsResponse> getSpringAnswers();

}
