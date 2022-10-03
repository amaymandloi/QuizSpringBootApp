package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.dao.QuestionDAO;
import com.yash.entities.Questions;
import com.yash.helper.QuestionsDBQuery;
import com.yash.integrate.ConnectionManager;

@Repository("jdbcQuestionDAOImplementation")
public class QuestionsDAOJdbcImplementation implements QuestionDAO{
	@Autowired
	private ConnectionManager connectionManager;
	
	@Autowired
	private QuestionsDBQuery questionsDBQuery;
	

	@Override
	public List<Questions> getAllQuestions()  {
		List<Questions> listOfQuestions=new ArrayList<Questions>();

		try {
			Connection connection=connectionManager.openConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(questionsDBQuery.getSelectAllQuestionQuery());
			
			while(resultSet.next()) {
				Questions question = new Questions();
				
				question.setQuestionId(resultSet.getInt("questions_id"));
				question.setQuestion(resultSet.getString("questions"));
				question.setOption1(resultSet.getString("option1"));
				question.setOption2(resultSet.getString("option2"));
				question.setOption3(resultSet.getString("option3"));
				question.setOption4(resultSet.getString("option4"));
				question.setCorrectAnswer(resultSet.getString("correct_answer"));
				question.setQuizId(resultSet.getInt("quiz_id"));
				
				listOfQuestions.add(question);
			}
			connectionManager.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		for(Questions questions:listOfQuestions) {
			System.out.println(questions);
		}
		return listOfQuestions;
	}
	
	
	
	
	String ans;
	int count;
	int i = 1;
	
	@Override
	public List<Questions> getQuestionByQuestionId(int questionId)  {
		Questions question = new Questions();
		   
		try {
			Connection connection=connectionManager.openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(questionsDBQuery.getSelectQuestionByIdQuery());		
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				question.setQuestionId(resultSet.getInt("question_id"));
				question.setQuestion(resultSet.getString("question"));
				question.setOption1(resultSet.getString("option1"));
				question.setOption2(resultSet.getString("option2"));
				question.setOption3(resultSet.getString("option3"));
				question.setOption4(resultSet.getString("option4"));	
				question.setCorrectAnswer(resultSet.getString("correct_answer"));	
					
			}
				
				connectionManager.closeConnection();
		}
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return (List<Questions>) question;
	
	}
	
	@Override
	public boolean storeQuestionDetails(Questions question)  {
		int rows=0;
		try {
			Connection connection=connectionManager.openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(questionsDBQuery.getInsertQuestionQuery());
			ResultSet resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				preparedStatement.setInt(1, question.getQuestionId());
				preparedStatement.setString(2, question.getQuestion());
				preparedStatement.setString(3, question.getOption1());
				preparedStatement.setString(4, question.getOption2());
				preparedStatement.setString(5, question.getOption4());
				preparedStatement.setString(6, question.getCorrectAnswer());
				preparedStatement.setInt(5, question.getQuizId());
		
				rows=preparedStatement.executeUpdate();
				connectionManager.closeConnection();
				} 	
			}catch ( SQLException e) {
				e.printStackTrace();
			} 
			if (rows>0)
				return true;
			else
				return false;
		}

	
	@Override
	public boolean updateQuestion(int questionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteQuestion(Questions question){
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<Questions> getSpringQuestions() {
		List<Questions> listOfQuestions=new ArrayList<Questions>();

		try {
			Connection connection=connectionManager.openConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(questionsDBQuery.getSelectSpringQuestionsQuery());
			
			while(resultSet.next()) {
				Questions question = new Questions();
				
				question.setQuestionId(resultSet.getInt("questions_id"));
				question.setQuestion(resultSet.getString("questions"));
				question.setOption1(resultSet.getString("option1"));
				question.setOption2(resultSet.getString("option2"));
				question.setOption3(resultSet.getString("option3"));
				question.setOption4(resultSet.getString("option4"));
				question.setCorrectAnswer(resultSet.getString("correct_answer"));
				question.setQuizId(resultSet.getInt("quiz_id"));
				
				listOfQuestions.add(question);
			}
			connectionManager.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		for(Questions questions:listOfQuestions) {
			System.out.println(questions);
		}
		return listOfQuestions;
	}
	}

