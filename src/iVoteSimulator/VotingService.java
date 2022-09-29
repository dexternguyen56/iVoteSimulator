package iVoteSimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VotingService {
	private HashMap<Integer,ArrayList<String>> submision;
	
	private HashMap<String,Integer> results;
	
	private int max_student;
	private int current_student;
	
	private Question question;
	private boolean mult_choice;
	
	public VotingService(Question question) {
		submision = new HashMap<Integer,ArrayList<String>>();
		results = new HashMap<String,Integer>();
		
		mult_choice = question instanceof MultipleChoiceQuestion ? true : false;

	}
	
	
	public void submitAnswers(Student student) {
		if (submision.containsKey(student.getID())) {
				submision.replace(student.getID(),student.getAnswer());
			}
		else {
				submision.put(student.getID(), student.getAnswer());
			}
			
		}
	
	
	public void countResult() {
		
		
		for (Map.Entry<Integer, ArrayList<String>> entry : submision.entrySet()) {
		    //System.out.println(entry.getKey()+" : "+entry.getValue());
			
			ArrayList<String> temp = entry.getValue();
		    
		    for(int i = 0; i < temp.size();i++) {
		    	
		    	if( results.containsKey(temp.get(i))) {
		    		results.replace(temp.get(i), results.get(temp.get(i)) + 1);
		    		
		    	}
		    	else {
		    		results.put(temp.get(i), 1);
		    	}
		    	//System.out.println(results.containsKey(Integer.toString(i)));
		    }
		}
		

		
		
		
	}
	
	public void displayResult(ArrayList<String> ans) {
		
		for(int i = 0; i < ans.size();i++) {
			results.put(ans.get(i), 0);
		}
		
		countResult();
		
		System.out.println("Final Resuls: ");
		for (Map.Entry<String, Integer> entry : results.entrySet()) {
		    System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		System.out.println();
	}
		
	
	public void printSubmision() {
		
		System.out.println("\nFinal submission recorded: ");
		for (Map.Entry<Integer, ArrayList<String>> entry : submision.entrySet()) {
	
			System.out.println("Student [" + entry.getKey()+"] : "+entry.getValue());
		}
		
		System.out.println();
	}

	
	
	

}
