package com.dao;

import com.ui.uiLayer;

public class QuestionExistsException extends RuntimeException{
	
	 public QuestionExistsException(final String msg){
	        super(msg);
	        uiLayer.main(null);
	    }

	    public QuestionExistsException(final String msg,final Throwable e){
	        super(msg,e);
	        uiLayer.main(null);
	    }

}
