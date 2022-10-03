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
import com.yash.model.QuizRequest;
import com.yash.model.QuizResponse;
import com.yash.service.QuizServiceImpl;
@RestController
@RequestMapping("quizapi")
@CrossOrigin(origins = "*")
public class QuizController {

	private final Logger LOGGER = LoggerFactory.getLogger(QuizController.class);
	
	@Autowired
	QuizServiceImpl quizService;

	@GetMapping("quizs")
	public ResponseEntity<List<QuizResponse>> handleGetAllQuizJSON() {

		List<QuizResponse> QuizResponseList = quizService.getQuizModel();
		ResponseEntity<List<QuizResponse>> response = null;
		if (!QuizResponseList.isEmpty()) {
			response = new ResponseEntity<List<QuizResponse>>(QuizResponseList, HttpStatus.OK);
			LOGGER.info("Successful : "+response);
		} else {
			response = new ResponseEntity<List<QuizResponse>>(QuizResponseList, HttpStatus.EXPECTATION_FAILED);
			LOGGER.error("Failed Due to : "+response);
		}
		return response;
	}

	@GetMapping("quizs/{quizId}")
	public ResponseEntity<QuizResponse> handleGetQuizByIdJSON(@PathVariable("quizId") int quizId) {
		ResponseEntity<QuizResponse> response = null;
		QuizRequest quizRequest = new QuizRequest();
		quizRequest.setQuizId(quizId);
		quizRequest.setQuizId(quizId);
		{
			QuizResponse quizResponse = quizService.getQuizModelByQuizId(quizId);

			if (quizResponse.getQuizId() != 0) {
				response = new ResponseEntity<QuizResponse>(quizResponse, HttpStatus.FOUND);
				LOGGER.info("Successful : "+response);
			} else {
				response = new ResponseEntity<QuizResponse>(quizResponse, HttpStatus.NOT_FOUND);
				LOGGER.error("Failed Due to : "+response);
			}
		}
		return response;
	}

	@PostMapping("quiz")
	public ResponseEntity<QuizResponse> saveQuiz(@RequestBody QuizRequest quizRequest) {
		ResponseEntity<QuizResponse> response = null;

		boolean quiz = quizService.storeQuizModel(quizRequest);
		if (quiz) {
			QuizResponse quizResponse = new QuizResponse();
			// quizResponse.setUserId(quizRequest.getUserId());
			quizResponse.setQuizName(quizRequest.getQuizName());
			quizResponse.setQuizLevel(quizRequest.getQuizLevel());
			
			response = new ResponseEntity<QuizResponse>(quizResponse, HttpStatus.CREATED);
			LOGGER.info("Successful : "+response);
			
		} else {
			response = new ResponseEntity<QuizResponse>(HttpStatus.CONFLICT);
			LOGGER.error("Failed Due to : "+response);

		}
		return response;

	}
}
