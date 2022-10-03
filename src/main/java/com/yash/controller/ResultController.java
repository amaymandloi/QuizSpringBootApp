package com.yash.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.helper.DateHelper;
import com.yash.model.ResultRequest;
import com.yash.model.ResultResponse;
import com.yash.service.ResultServiceImpl;

@RestController
@RequestMapping("resultapi")
@CrossOrigin(origins = "*")
public class ResultController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ResultController.class);

	@Autowired
	ResultServiceImpl resultService;

	@GetMapping("results")
	public ResponseEntity<List<ResultResponse>> handleGetAllResultJSON() {

		List<ResultResponse> ResultResponseList = resultService.getResultModel();
		ResponseEntity<List<ResultResponse>> response = null;
		if (!ResultResponseList.isEmpty()) {
			response = new ResponseEntity<List<ResultResponse>>(ResultResponseList, HttpStatus.OK);
			LOGGER.info("Successful : "+response);
		} else {
			response = new ResponseEntity<List<ResultResponse>>(ResultResponseList, HttpStatus.EXPECTATION_FAILED);
			LOGGER.error("Failed Due to : "+response);
		}
		return response;
	}

	@GetMapping("results/{resultId}")
	public ResponseEntity<ResultResponse> handleGetResultByIdJSON(@PathVariable("resultId") int resultId) {
		ResponseEntity<ResultResponse> response = null;
		ResultRequest resultRequest = new ResultRequest();
		resultRequest.setResultId(resultId);
		resultRequest.setResultId(resultId);
		{
			ResultResponse resultResponse = resultService.getResultModelByResultId(resultId);

			if (resultResponse.getResultId() != 0) {
				response = new ResponseEntity<ResultResponse>(resultResponse, HttpStatus.FOUND);
				LOGGER.info("Successful : "+response);
			} else {
				response = new ResponseEntity<ResultResponse>(resultResponse, HttpStatus.NOT_FOUND);
				LOGGER.error("Failed Due to : "+response);
			}
		}
		return response;
	}

	@PostMapping("result")
	public ResponseEntity<ResultResponse> saveResult(@RequestBody ResultRequest resultRequest) {
		ResponseEntity<ResultResponse> response = null;

		boolean result = resultService.storeResultModel(resultRequest);
		if (result) {
			ResultResponse resultResponse = new ResultResponse();
	
			resultResponse.setStatus(resultRequest.getStatus());
			resultResponse.setMarks(resultRequest.getMarks());
			resultResponse.setPercentage(resultRequest.getPercentage());

			//resultResponse.setUserId(resultRequest.getUserId());

			resultResponse.setCreateDateTime(DateHelper.getCurrentDate());

			response = new ResponseEntity<ResultResponse>(resultResponse, HttpStatus.CREATED);
			LOGGER.info("Successful : "+response);
		} else {
			response = new ResponseEntity<ResultResponse>(HttpStatus.CONFLICT);
			
			LOGGER.error("Failed Due to : "+response);

		}
		return response;

	}
}
