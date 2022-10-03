package com.yash.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yash.dao.QuestionDAO;
import com.yash.entities.Questions;
import com.yash.model.QuestionsRequest;
import com.yash.model.QuestionsResponse;
import com.yash.model.QuestionsResponses;

@Service
public class QuestionsServiceImplementation implements QuestionService{

	@Autowired@Qualifier("jdbcQuestionDAOImplementation")
	private QuestionDAO questionDAO;
	
	public QuestionsServiceImplementation(QuestionDAO questionDAO) {
		 this.questionDAO = questionDAO;
	};
	
	public List<QuestionsResponse> getQuestionsModel() {
		List<Questions> listOfQuestions=questionDAO.getAllQuestions();
		List<QuestionsResponse> questionModelList = new ArrayList<>();
			
			for(Questions questions:listOfQuestions) {
	
				QuestionsResponse questionModel = new QuestionsResponse();
				
				questionModel.setQuestionId(questions.getQuestionId());
				questionModel.setQuestion(questions.getQuestion());
				questionModel.setOption1(questions.getOption1());
				questionModel.setOption2(questions.getOption2());
				questionModel.setOption3(questions.getOption3());
				questionModel.setOption4(questions.getOption4());
				questionModel.setCorrectAnswer(questions.getCorrectAnswer());
				questionModel.setQuizId(questions.getQuizId());
				questionModelList.add(questionModel);
			}
				
		return questionModelList;
	}

	
	public List<QuestionsResponse> getQuestionModelByQuestionId(int questionId) {
	
		List<Questions> questionsList = questionDAO.getQuestionByQuestionId(questionId);
		List<QuestionsResponse> questionModelList = new ArrayList<>();
				
				
			for(Questions questions: questionsList) {
				QuestionsResponse questionModel = new QuestionsResponse();
				questionModel.setQuestionId(questions.getQuestionId());
				questionModel.setQuestion(questions.getQuestion());
				questionModel.setOption1(questions.getOption1());
				questionModel.setOption2(questions.getOption2());
				questionModel.setOption3(questions.getOption3());
				questionModel.setOption4(questions.getOption4());	
				questionModel.setCorrectAnswer(questions.getCorrectAnswer());	
				questionModel.setQuizId(questions.getQuizId());
				questionModelList.add(questionModel);
				
			}
			return questionModelList;
				
		}
		
		
	public String storeQuestionModel(QuestionsRequest questionModel) {
	
		
				Questions questions  = new Questions();
				questions.setQuestionId(questionModel.getQuestionId());
				questions.setQuestion(questionModel.getQuestion());
				questions.setOption1(questionModel.getOption1());
				questions.setOption2(questionModel.getOption2());
				questions.setOption3(questionModel.getOption3());
				questions.setOption4(questionModel.getOption4());
				questions.setCorrectAnswer(questionModel.getCorrectAnswer());
				questions.setQuizId(questionModel.getQuizId());
			
				boolean result= questionDAO.storeQuestionDetails(questions);
				
				
			if (result)
				return "Done";
			else
				return "Failed";
	}

	
	public boolean updateQuestionModel(int questionId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean deleteQuestionModel(QuestionsResponse question) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<QuestionsResponse> getAnswers() {
 
		List<Questions> listOfAnswers=questionDAO.getAllQuestions();
		List<QuestionsResponse> questionModelList = new ArrayList<>();
			
			for(Questions answers:listOfAnswers) {
	
				QuestionsResponse questionModel = new QuestionsResponse();
				
				questionModel.setCorrectAnswer(answers.getCorrectAnswer());
				
				questionModelList.add(questionModel);
			}
			System.out.println(questionModelList);
		return questionModelList;
		
	}

	@Override
	public int getQuizId() {
		int quizId=0;
		List<Questions> listOfAnswers=questionDAO.getAllQuestions();

			for(Questions qId:listOfAnswers) {
				quizId=(qId.getQuizId());
			}
		return quizId;
		
	}

	@Override
	public List<QuestionsResponse> getSpringQuestions() {
		List<Questions> listOfQuestions=questionDAO.getSpringQuestions();
		List<QuestionsResponse> listOfSpringQuestion = new ArrayList<>();
			
			for(Questions questions:listOfQuestions) {
	
				QuestionsResponse questionModel = new QuestionsResponse();
				
				questionModel.setQuestionId(questions.getQuestionId());
				questionModel.setQuestion(questions.getQuestion());
				questionModel.setOption1(questions.getOption1());
				questionModel.setOption2(questions.getOption2());
				questionModel.setOption3(questions.getOption3());
				questionModel.setOption4(questions.getOption4());
				questionModel.setCorrectAnswer(questions.getCorrectAnswer());
				questionModel.setQuizId(questions.getQuizId());
				listOfSpringQuestion.add(questionModel);
			}
				
		return listOfSpringQuestion;
	}
	
	@Override
	public List<QuestionsResponse> getSpringAnswers() {
 
		List<Questions> listOfAnswers=questionDAO.getSpringQuestions();
		List<QuestionsResponse> questionModelList = new ArrayList<>();
			
			for(Questions answers:listOfAnswers) {
	
				QuestionsResponse questionModel = new QuestionsResponse();
				
				questionModel.setCorrectAnswer(answers.getCorrectAnswer());
				
				questionModelList.add(questionModel);
			}
			System.out.println(questionModelList);
		return questionModelList;
		
	}

	public int getSpringQuizId() {
		int quizId=0;
		List<Questions> listOfAnswers=questionDAO.getSpringQuestions();

			for(Questions qId:listOfAnswers) {
				quizId=(qId.getQuizId());
			}
		return quizId;
		
	}

}
