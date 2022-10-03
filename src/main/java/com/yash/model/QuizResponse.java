package com.yash.model;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class QuizResponse {

	@Id
	private int quizId;
	private String quizName;
	private String quizLevel;
	
	public QuizResponse() {}

	public QuizResponse(int quizId, String quizName, String quizLevel) {
		super();
		this.quizId = quizId;
		this.quizName = quizName;
		this.quizLevel = quizLevel;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public String getQuizLevel() {
		return quizLevel;
	}

	public void setQuizLevel(String quizLevel) {
		this.quizLevel = quizLevel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quizId;
		result = prime * result + ((quizLevel == null) ? 0 : quizLevel.hashCode());
		result = prime * result + ((quizName == null) ? 0 : quizName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuizResponse other = (QuizResponse) obj;
		if (quizId != other.quizId)
			return false;
		if (quizLevel == null) {
			if (other.quizLevel != null)
				return false;
		} else if (!quizLevel.equals(other.quizLevel))
			return false;
		if (quizName == null) {
			if (other.quizName != null)
				return false;
		} else if (!quizName.equals(other.quizName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuizResponse [quizId=" + quizId + ", quizName=" + quizName + ", quizLevel=" + quizLevel + "]";
	}
	
	
	
	
}
