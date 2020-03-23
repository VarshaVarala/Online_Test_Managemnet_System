package com.dao;

import com.service.QuestionServiceI;
import com.ui.uiLayer;

public class QuestionNotFound extends RuntimeException {
	
	  public QuestionNotFound(String msg) {
		  super(msg);  
		  System.out.println("\n"+msg+ "\n");
		  
		  uiLayer.main(null);
	}
}
