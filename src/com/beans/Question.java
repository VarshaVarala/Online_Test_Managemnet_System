package com.beans;

import java.math.BigInteger;
import java.util.ArrayList;

public class Question {
	private String questionTitle;
	private Integer questionAnswer;
	private Object questionOptions;
	

	public Question(String questionTitle, Integer questionAnswer, Object object) {
		super();
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionOptions = object;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	@Override
	public String toString() {
		return " "+questionTitle+ "\n Options=" + questionOptions+"\nAnswer=" + questionAnswer  ;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public Integer getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(Integer questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public Object getQuestionOptions() {
		return questionOptions;
	}
	public void setQuestionOptions(Object questionOptions) {
		this.questionOptions = questionOptions;
	}
	
	

}
