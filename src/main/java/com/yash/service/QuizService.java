package com.yash.service;

import java.util.List;

import com.yash.model.QuizRequest;
import com.yash.model.QuizResponse;

public interface QuizService {

	public List<QuizResponse> getQuizModel();

	public QuizResponse getQuizModelByQuizId(int quizId);

	public QuizResponse getQuizModelByQuizName(String quizName);

	public boolean storeQuizModel(QuizRequest quiz);

}
