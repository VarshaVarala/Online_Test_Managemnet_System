package com.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.dao.QuestionDaoImpl;
import com.service.QuestionService;
import com.service.QuestionServiceI;
import com.beans.Question;

public class uiLayer {

	public static void main(String[] args) {
		System.out.println("Welcome admin!");
		welcome();
	}
	@SuppressWarnings("resource")
		     private static void welcome() {
			boolean run = true;
	           while (run) {
	               showMenu();
	               Scanner scanner = new Scanner(System.in);
	               int option = getOption(scanner);
	               if (option == -1)
	               {
	                   run = false;
	               }
	               Scanner sc=new Scanner(System.in);
			switch(option){
			
			case 1:{
				Scanner scan=new Scanner(System.in).useDelimiter("\n");
				System.out.println("Enter a Question Id to insert a new question");
				 Integer questionId=sc.nextInt();
				System.out.println("Enter the question");
		    	String questionTitle=scan.next();
		    	System.out.println("Enter the options");
		    		ArrayList<String> options=new ArrayList<String>();
		    		for(int i=0;i<4;i++){
		    	        System.out.println("enter the "+(i+1)+" option :");
		    	        options.add(sc.next());
		    	    }
		    	System.out.println("Enter answer option");
		    	Scanner s=new Scanner(System.in);
		    	 Integer answer=s.nextInt();
		    	 QuestionServiceI service = getQuestionService();
				 Question question = service.addQuestion(questionId,questionTitle,answer,options);
				options.toString();
				System.out.println("Question successfully inserted as: ");
				 System.out.println(question.toString());
				
			break;}
			case 2:{
				System.out.println("Enter the question id to delete");
			    Integer qId=sc.nextInt();
			    QuestionServiceI service = getQuestionService();
				 service.deleteQuestion(qId);
			    System.out.println("Question has been deleted");
			    break;}
			    
			case 3:{
				System.out.println("Enter the question id to be updated");
				 Integer qId=sc.nextInt();
			    System.out.println("Enter the updated answer");
			    Integer answer=sc.nextInt();
			    QuestionServiceI service = getQuestionService();
				 service.updateQuestion(qId,answer);
			    
			    
			    System.out.println("The answer has been rectified and updated");
			    break;}
			    
			case 4:{
				System.out.println("Enter question ID ");
				Integer qId=sc.nextInt();
				 QuestionServiceI service = getQuestionService();
				 Question question = service.getQuestionDetails(qId);
				  System.out.println("Question: " +qId+"."+ question.getQuestionTitle());
                  System.out.println("Options :" + question.getQuestionOptions());
                  System.out.println("Answer=" + question.getQuestionAnswer());
				break;}
			case 5:{
				System.out.println("All questions are: ");
				QuestionServiceI service=getQuestionService();
				Question ques=service.getAllQuestions();
				
				break;}
			case 6:
				System.out.println("Thank you for using the Online Test Managemnet System");
				System.out.close();
				break;
				
			}
			
		       }


	}

	private static int getOption(Scanner scanner) {
		try {
            int option = scanner.nextInt();
            return option;
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid option number");
            welcome();
            return -1;
        } catch(Exception  ex){
        	System.out.println("Sorry enter valid option");
        	return -1;
 
        }
	}

	private static void showMenu() {
		System.out.println("\n *********************************");
		System.out.println("Choose an option \n");
		System.out.println("1. Add a question");
		System.out.println("2. Delete a question");
		System.out.println("3. Update a question");
		System.out.println("4. View  question");
		System.out.println("5.View all questions");
		System.out.println("6. exit");
		
		
	}

	private static QuestionServiceI questionService = new QuestionService(new QuestionDaoImpl());
	public static QuestionServiceI getQuestionService() {
	    return questionService;
	}}
