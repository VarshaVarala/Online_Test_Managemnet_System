/**
 * 
 */
package com.dao;
import com.beans.Question;

import java.math.BigInteger;
import java.util.ArrayList;

public interface QuestionDao {
	
	 Question getQuestionDetails(Integer qId);

	Question getAllQuestions();
	Question deleteQuestion(Integer qId);

	Question updateQuestion(Integer qId, Integer answer);

	Question addQuestion(Integer questionId, String questionTitle, Integer answer, ArrayList options);

}
