package com.yash.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.entities.Result;
@Repository
public class ResultDAOImpl implements ResultDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Result> getAllResults() {

		Session session = sessionFactory.openSession();
		Query query = session.createNamedQuery("FindResults");
		List<Result> resultList = query.list();
		return resultList;
	}

	@Override
	public Result getResultByResultId(int resultId) {

		Session session = sessionFactory.openSession();
		Result result = (Result) session.load(Result.class, resultId);
		return result;
	}

	@Override
	public boolean storeResultDetails(Result result) {
		Session session=sessionFactory.openSession();
	       Transaction transaction=session.getTransaction();
	       transaction.begin();
	       session.persist(result);
	       transaction.commit();       
	       Result resultDB=(Result)session.load(Result.class, result.getResultId());
	       if(result.getResultId()==resultDB.getResultId()) {
	    	   return true;
	       }
	       //session.close();
	       return false;
	}

}
