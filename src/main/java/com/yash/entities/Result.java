package com.yash.entities;

import java.time.LocalDate;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="result")
@NamedQueries(
		{   
			@NamedQuery(name = "FindResults", query = "select o from Result o"),
			@NamedQuery(name = "FindResultByResultId", query = "select o from Result o where o.resultId=:id")
			
		}
		)
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="result_id")
	private int resultId;
	@Column(name="status")
	private int status;
	@Column(name="marks")
	private int marks;
	@Column(name="percentage")
	private int percentage;
	
	@Column(name="quiz_id")
	private int quizId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="is_delete")
	private int isDelete;
	
//	@OneToMany
//	@Column(name="user_id")
//	private User userId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date_time")
	private Date createDateTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date_time")
	private Date updateDateTime;
	
	
	public Result() {}

	public Result(int resultId, int status, int marks, int percentage, int quizId, String email, int isDelete,
			Date createDateTime, Date updateDateTime) {
		super();
		this.resultId = resultId;
		this.status = status;
		this.marks = marks;
		this.percentage = percentage;
		this.quizId = quizId;
		this.email = email;
		this.isDelete = isDelete;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
	}








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



	public Date getCreateDateTime() {
		return createDateTime;
	}


	public void setCreateDateTime(Date date) {
		this.createDateTime = date;
	}


	public Date getUpdateDateTime() {
		return updateDateTime;
	}


	public void setUpdateDateTime(Date updateDateTime) {
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
		Result other = (Result) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "Result [resultId=" + resultId + ", status=" + status + ", marks=" + marks + ", percentage=" + percentage
				+ ", quizId=" + quizId + ", email=" + email + ", isDelete=" + isDelete + ", createDateTime="
				+ createDateTime + ", updateDateTime=" + updateDateTime + "]";
	}

	

	
	
	

}
