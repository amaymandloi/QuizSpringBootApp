package com.yash.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class QuestionsResponses {
	
	List<QuestionsResponse> questionResponse;

	public List<QuestionsResponse> getQuestionResponse() {
		return questionResponse;
	}

	public void setQuestionResponse(List<QuestionsResponse> questionResponse) {
		this.questionResponse = questionResponse;
	}
	
}
