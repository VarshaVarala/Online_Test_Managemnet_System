package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.beans.Question;
import com.beans.questionOptions;

@SuppressWarnings("rawtypes")
public class QuestionDaoImpl implements QuestionDao {
	
	   private HashMap<Integer, Question> questionEntry;

	    public QuestionDaoImpl() {
	        questionEntry = new HashMap<>();
	  
	 questionOptions op1=new questionOptions("Object","long","void","int");
	   questionOptions op2=new questionOptions("Runnable","Marker","Abstract","CharSequence Interface"); 
	   questionOptions op3=new questionOptions(" release all locks","not release any locks","release half of it's locks","none"); 
	   questionOptions op4=new questionOptions("Variabl SHadowing","Serialization","Abstraction","Multi-Threading"); 
	   questionOptions op5=new questionOptions("JVM","JRE","JDB","JDK"); 
	   questionOptions op6=new questionOptions("A","B","C","D"); 
	   ArrayList<questionOptions> options=new ArrayList<questionOptions>();
	  options.add(op1);
	  options.add(op2);
	  options.add(op3);
	  options.add(op4);
	  options.add(op5);
	  options.add(op6);
	        Question question1 = new Question("What is return type of hashcode() method in object class?",4,options.get(0));
	        Question question2=new Question("An interface with no feilds or methods id known as ",2,options.get(1));
	        Question question3=new Question("If thread goes to sleep, it will _______ ",2,options.get(2));
	        Question question4=new Question("Local variable has same name as one of instance variable",1,options.get(3));
	        Question question5=new Question("_______ is used to find and fix bugs in Java programs ",3,options.get(4));
	        Question question6=new Question("Dummy Question",1,options.get(5));
	     questionEntry.put(1, question1);
	     questionEntry.put(2, question2);
	     questionEntry.put(3, question3);
	     questionEntry.put(4, question4);
	     questionEntry.put(5, question5);
	     questionEntry.put(6, question6);
	     

	    }	   
	    
	    private void validQuestionId(final Integer qId) {
			 boolean noExists = questionEntry.containsKey(qId);
		        if (!noExists) {
		            throw new QuestionNotFound("Sorry! No Question found for this question Id=" + qId);
		        }

		    }

	@Override
	public Question getQuestionDetails(Integer qId) {
		validQuestionId(qId);
	      return questionEntry.get(qId);   
	      }



	@Override
	public Question getAllQuestions() {
		Set set = questionEntry.entrySet(); // Get a set of the entries
		Iterator i = set.iterator(); // Get an iterator
		while(i.hasNext()) { // Display elements
		HashMap.Entry me = (HashMap.Entry)i.next();
		 System.out.println(me.getKey() + ": "+ me.getValue());
		}
		return null;
	}

	@Override
	public Question deleteQuestion(Integer qId) {
	validQuestionId(qId);
			questionEntry.remove(qId);

		return null;
	}

	@Override
	public Question updateQuestion(Integer qId, Integer answer) {
		validQuestionId(qId);
		Question ques=new Question(null, answer, null);
		ques.setQuestionAnswer(answer);
		questionEntry.replace(qId, ques);
		return questionEntry.get(qId);
	}

	@Override
	public Question addQuestion(Integer questionId, String questionTitle, Integer answer, ArrayList options) {
		questionExists(questionId);
		Question questionObj=new Question(questionTitle,answer,options);
		questionEntry.put(questionId, questionObj);
		return questionEntry.get(questionId);
	}

	private void questionExists(Integer questionId) {
		 boolean qExists = questionEntry.containsKey(questionId);
		 if (qExists) {
	            throw new QuestionExistsException("Sorry, Try again! Question already found for this question Id=" + questionId);
	        }
		
	}
}
