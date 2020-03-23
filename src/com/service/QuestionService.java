package com.service;

import java.math.BigInteger;
import java.util.ArrayList;

import com.dao.*;

import com.beans.Question;


public class QuestionService implements QuestionServiceI {
	  private QuestionDao questionDao;//has-a
	    public QuestionDao getQuestionDao(){
	        return questionDao;
	    }
	    public void setQuestionDao(final QuestionDao questionDao){
	        this.questionDao=questionDao;
	    }
	    public QuestionService(){
	    }
	    public QuestionService(final QuestionDao questionDao){
	        this.questionDao=questionDao;
	    }
	@Override
	public Question getQuestionDetails(final Integer qId) {
		// TODO Auto-generated method stub
		  Question question= getQuestionDao().getQuestionDetails(qId);
		  return question;
	}
	@Override
	public Question getAllQuestions() {
		// TODO Auto-generated method stub
		Question question=getQuestionDao().getAllQuestions();
		return question;
	}
	@Override
	public Question deleteQuestion(final Integer qId) {
		Question question= getQuestionDao().deleteQuestion(qId);
		  return question;
	}
	@Override
	public Question updateQuestion(Integer qId, Integer answer) {
		Question question= getQuestionDao().updateQuestion(qId,answer);
		return question;
	}
	@Override
	public Question addQuestion(Integer questionId, String questionTitle, Integer answer, ArrayList options) {
		Question question= getQuestionDao().addQuestion(questionId,questionTitle,answer,options);
		return question;
	}

}
