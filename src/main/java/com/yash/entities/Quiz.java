package com.yash.entities;

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
@Table(name="quiz")
@NamedQueries(
		{
			@NamedQuery(name = "FindQuizs", query = "select o from Quiz o"),
			@NamedQuery(name = "FindQuizByQuizId", query = "select o from Quiz o where o.quizId=:id"),
			@NamedQuery(name = "FindQuizByQuizName", query = "select o from Quiz o where o.quizName=:name")
	
}
		)
public class Quiz {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="quiz_id")
	private int quizId;
	@Column(name="quiz_name")
	private String quizName;
	@Column(name="quiz_level")
	private String quizLevel;
	
	public Quiz() { }

	public Quiz(int quizId, String quizName, String quizLevel) {
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
		Quiz other = (Quiz) obj;
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
		return "Quiz [quizId=" + quizId + ", quizName=" + quizName + ", quizLevel=" + quizLevel + "]";
	}
	
	
	

}
