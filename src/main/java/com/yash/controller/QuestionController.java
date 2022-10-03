package com.yash.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.QuestionsResponse;
import com.yash.service.QuestionsServiceImplementation;

@RestController
@RequestMapping("questionapi")
@CrossOrigin(origins = "*")
public class QuestionController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	private QuestionsServiceImplementation questionServiceObj;
	
	@GetMapping("questions")
	public ResponseEntity<List<QuestionsResponse>> handleGetAllQuestionJSON(){
		List<QuestionsResponse> questionResponseList=questionServiceObj.getQuestionsModel();
		ResponseEntity<List<QuestionsResponse>> response=null;
		if(!questionResponseList.isEmpty()) {
		 response=new ResponseEntity<List<QuestionsResponse>>(questionResponseList,HttpStatus.OK);
		 LOGGER.info("Fetching Data Successfully : "+response);
		}else {
			response=new ResponseEntity<List<QuestionsResponse>>(questionResponseList,HttpStatus.EXPECTATION_FAILED);
			LOGGER.error("Fetching Data Failed "+response+response.getStatusCode()+response.getBody());
		}
		return response;
	}
	
	@GetMapping("answers")
	public ResponseEntity<List<String>> handleGetAllAnswers()
	{
	
		List<QuestionsResponse>  answersResponseList = questionServiceObj.getAnswers();
		ResponseEntity<List<String>> response=null;
		List<String> answerList=new ArrayList<String>();
		for(QuestionsResponse questionResponse:answersResponseList) {
			
			String answer=questionResponse.getCorrectAnswer();
			answerList.add(answer);
		}
			 response=new ResponseEntity<List<String>>(answerList,HttpStatus.OK);		
			LOGGER.info("Data Fetch Succesfully : "+response);
			return response;
		}
	
	@GetMapping("quizId")
	public int handleGetQuizId()
	{
	
		int  quizId = questionServiceObj.getQuizId();
		System.out.println("quiz:"+quizId);
			
			return quizId;
	}
	
	@GetMapping("springQuestions")
	public ResponseEntity<List<QuestionsResponse>> handleGetSpringQuestionJSON(){
		List<QuestionsResponse> springQuestionsResponseList=questionServiceObj.getSpringQuestions();
		ResponseEntity<List<QuestionsResponse>> response=null;
		if(!springQuestionsResponseList.isEmpty()) {
		 response=new ResponseEntity<List<QuestionsResponse>>(springQuestionsResponseList,HttpStatus.OK);
		 LOGGER.info("Data Fetch Succesfully : "+response);
		}else {
			response=new ResponseEntity<List<QuestionsResponse>>(springQuestionsResponseList,HttpStatus.EXPECTATION_FAILED);
			LOGGER.error("Failed Due to : "+response);
		}
		return response;
	}
	@GetMapping("springAnswers")
	public ResponseEntity<List<String>> handleGetSpringAnswers()
	{
	
		List<QuestionsResponse>  answersResponseList = questionServiceObj.getSpringAnswers();
		ResponseEntity<List<String>> response=null;
		List<String> answerList=new ArrayList<String>();
		for(QuestionsResponse questionResponse:answersResponseList) {
			
			String answer=questionResponse.getCorrectAnswer();
			answerList.add(answer);
		}
			 response=new ResponseEntity<List<String>>(answerList,HttpStatus.OK);		
			 LOGGER.info("Data Fetch Succesfully : "+response);
			return response;

}
	@GetMapping("springQuizId")
	public int handleGetSpringQuizId()
	{
	
		int  quizId = questionServiceObj.getSpringQuizId();
		System.out.println("quiz:"+quizId);
			
			return quizId;
	}
}
