package com.yash.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class QuizResponses {
	
	List<QuizResponse> quizResponse;

	public List<QuizResponse> getQuizResponse() {
		return quizResponse;
	}

	public void setQuizResponse(List<QuizResponse> quizResponse) {
		this.quizResponse = quizResponse;
	}

}
