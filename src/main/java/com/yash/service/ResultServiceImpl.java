package com.yash.service;

import java.util.ArrayList;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yash.convertor.ResultViewToEntityConvertor;
import com.yash.dao.ResultDAO;
import com.yash.dao.UserDAO;
import com.yash.dao.ResultDAO;
import com.yash.entities.Result;
import com.yash.entities.User;
import com.yash.helper.DateHelper;
import com.yash.entities.Result;
import com.yash.model.ResultRequest;
import com.yash.model.ResultResponse;
import com.yash.model.UserResponse;
import com.yash.model.ResultResponse;
import com.yash.model.ResultResponse;

@Service
@Transactional
public class ResultServiceImpl implements ResultService {
	
	@Autowired
	private ResultDAO resultDAO;
	
	@Autowired@Qualifier("hibernateUserDAOImpl")
	private UserDAO userDAO;
	
	@Autowired
	ResultViewToEntityConvertor resultViewToEntityConvertor;
	
	public ResultServiceImpl(ResultDAO resultDAO){
		 this.resultDAO = resultDAO;
	};
	
	@Override
	public List<ResultResponse> getResultModel() {
		List<Result> listOfResults = resultDAO.getAllResults();
		List<ResultResponse> resultModelList = new ArrayList<ResultResponse>();

		for (Result result : listOfResults) {
			ResultResponse resultModel = new ResultResponse();
			resultModel.setResultId(result.getResultId());
			resultModel.setStatus(result.getStatus());
			resultModel.setMarks(result.getMarks());
			resultModel.setPercentage(result.getPercentage());
			resultModel.setResultId(result.getResultId());
			resultModel.setCreateDateTime(result.getCreateDateTime());		
			
			resultModelList.add(resultModel);
		}
		return resultModelList;
	}

	@Override
	public ResultResponse getResultModelByResultId(int resultId) {
		Result result=resultDAO.getResultByResultId(resultId);
		ResultResponse resultResponse=new ResultResponse();
		resultResponse.setResultId(result.getResultId());
		resultResponse.setStatus(result.getStatus());
		resultResponse.setMarks(result.getMarks());
		resultResponse.setPercentage(result.getPercentage());
		resultResponse.setResultId(result.getResultId());
		resultResponse.setCreateDateTime(result.getCreateDateTime());
        return resultResponse;
        }

	@Override
	public boolean storeResultModel(ResultRequest resultRequest){
		boolean flag = false;
		Result result = resultViewToEntityConvertor.saveResultConvertor(resultRequest);
		
		boolean savedResult = resultDAO.storeResultDetails(result);
		
		if(savedResult)
			flag=true;
		
		return flag;
	}	


}
