package com.yash.service;

import java.util.List;

import com.yash.model.ResultRequest;
import com.yash.model.ResultResponse;
import com.yash.model.UserResponse;

public interface ResultService {
	
	public List<ResultResponse> getResultModel();
	public ResultResponse getResultModelByResultId(int resultId);
	public boolean storeResultModel(ResultRequest result);
}
