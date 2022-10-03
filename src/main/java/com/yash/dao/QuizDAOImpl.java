package com.yash.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.entities.Quiz;
import com.yash.entities.Quiz;
@Repository
public class QuizDAOImpl implements QuizDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Quiz> getAllQuizs(){
		
		Session session = sessionFactory.openSession();
		Query query = session.createNamedQuery("FindQuizs");
		List<Quiz> quizList = query.list();
		return quizList;
	}

	@Override
	public Quiz getQuizByQuizId(int quizId) {
		Session session = sessionFactory.openSession();
		Quiz quiz = (Quiz) session.load(Quiz.class, quizId);
		return quiz;
	}

	@Override
	public Quiz getQuizByQuizName(String quizName) {
		Session session = sessionFactory.openSession();
		Quiz quiz = (Quiz) session.load(Quiz.class, quizName);
		return quiz;
	}
	
	@Override
	public boolean storeQuizDetails(Quiz quiz) {
		Session session=sessionFactory.openSession();
	       Transaction transaction=session.getTransaction();
	       transaction.begin();
	       session.persist(quiz);
	       transaction.commit();
	       
	       Quiz quizDB=(Quiz)session.load(Quiz.class, quiz.getQuizId());
	       if(quiz.getQuizId()==quizDB.getQuizId()) {
	    	   return true;
	       }
	       //session.close();
	       return false;
	}
}
