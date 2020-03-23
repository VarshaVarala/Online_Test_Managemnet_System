package com.service;


import java.util.ArrayList;

import com.beans.Question;

public interface QuestionServiceI {
	
	Question getQuestionDetails(Integer qId);

	Question getAllQuestions();

	Question deleteQuestion(Integer qId);

	Question updateQuestion(Integer qId, Integer answer);

	Question addQuestion(Integer questionId, String questionTitle, Integer answer, ArrayList options);
	

}
