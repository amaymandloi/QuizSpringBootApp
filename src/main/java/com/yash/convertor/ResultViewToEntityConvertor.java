package com.yash.convertor;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.yash.dao.ResultDAO;
import com.yash.dao.UserDAO;
import com.yash.entities.Result;
import com.yash.entities.User;
import com.yash.helper.DateHelper;
import com.yash.model.ResultRequest;

@Component
public class ResultViewToEntityConvertor {

	@Autowired
	private ResultDAO resultDAO;
	
	@Autowired@Qualifier("hibernateUserDAOImpl")
	private UserDAO userDAO;
	
	public Result saveResultConvertor(ResultRequest resultRequest) {

		Result destinationResult = new Result();
		User user = userDAO.getUserByUserId(resultRequest.getUserId());
		if(user==null) {
			System.err.print("User Not found : "+resultRequest.getUserId());
		}
		
		
		destinationResult.setResultId(resultRequest.getResultId());
		destinationResult.setStatus(resultRequest.getStatus());
		destinationResult.setMarks(resultRequest.getMarks());
		destinationResult.setPercentage(resultRequest.getPercentage());
		destinationResult.setIsDelete(0);
		destinationResult.setEmail(resultRequest.getEmail());
		destinationResult.setQuizId(resultRequest.getQuizId());
		
	//	destinationResult.setUserId(user);
		
		destinationResult.setCreateDateTime(DateHelper.getCurrentDate());
		
		return destinationResult;
		
	}
	
}
