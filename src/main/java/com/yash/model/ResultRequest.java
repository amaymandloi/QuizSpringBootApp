package com.yash.model;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ResultRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resultId;
	private int status;
	private int marks;
	private int percentage;
	private int isDelete;
	private int userId;
	private int quizId;
	private String email;
	private LocalDate createDateTime;
	private LocalDate updateDateTime;
	
	public ResultRequest() {}

	

	public int getQuizId() {
		return quizId;
	}



	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public ResultRequest(int resultId, int status, int marks, int percentage, int isDelete, int userId, int quizId,
			String email, LocalDate createDateTime, LocalDate updateDateTime) {
		super();
		this.resultId = resultId;
		this.status = status;
		this.marks = marks;
		this.percentage = percentage;
		this.isDelete = isDelete;
		this.userId = userId;
		this.quizId = quizId;
		this.email = email;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
	}



	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDate getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDate createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDate getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDate updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDateTime == null) ? 0 : createDateTime.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + isDelete;
		result = prime * result + marks;
		result = prime * result + percentage;
		result = prime * result + quizId;
		result = prime * result + resultId;
		result = prime * result + status;
		result = prime * result + ((updateDateTime == null) ? 0 : updateDateTime.hashCode());
		result = prime * result + userId;
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
		ResultRequest other = (ResultRequest) obj;
		if (createDateTime == null) {
			if (other.createDateTime != null)
				return false;
		} else if (!createDateTime.equals(other.createDateTime))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (isDelete != other.isDelete)
			return false;
		if (marks != other.marks)
			return false;
		if (percentage != other.percentage)
			return false;
		if (quizId != other.quizId)
			return false;
		if (resultId != other.resultId)
			return false;
		if (status != other.status)
			return false;
		if (updateDateTime == null) {
			if (other.updateDateTime != null)
				return false;
		} else if (!updateDateTime.equals(other.updateDateTime))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResultRequest [resultId=" + resultId + ", status=" + status + ", marks=" + marks + ", percentage="
				+ percentage + ", isDelete=" + isDelete + ", userId=" + userId + ", quizId=" + quizId + ", email="
				+ email + ", createDateTime=" + createDateTime + ", updateDateTime=" + updateDateTime + "]";
	};
	
	
}
