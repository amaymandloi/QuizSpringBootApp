package com.yash.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yash.entities.Result;
@Repository
public interface ResultDAO {
	
	public List<Result> getAllResults();
	public Result getResultByResultId(int resultId);
	public boolean storeResultDetails(Result result);

}
