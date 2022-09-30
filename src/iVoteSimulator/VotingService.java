package iVoteSimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VotingService {
	private HashMap<Integer,ArrayList<String>> submision;
	
	private HashMap<String,Integer> results;
	
	private Question question;
	
	
	public VotingService(Question ques) {
		submision = new HashMap<Integer,ArrayList<String>>();
		results = new HashMap<String,Integer>();
		question = ques;


	}
	
	public ArrayList<String> possibleAnswers() {
		int size = question.getAnswers().length;
		char firstChar = question.getAnswers()[0].charAt(0);
		
		ArrayList<String> res = new ArrayList<String>();
		for(int i= 0; i < size;i++) {
			res.add( Character.toString( (char) ((int) firstChar + i)) );
		}
		return res;
		//ArrayList of possible answer for the question
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
		    System.out.println("["+entry.getKey()+"] : "+entry.getValue());
		}
		
		System.out.println();

	}
		
	
	public void printSubmision() {
		
		System.out.println("\nFinal submission to show that only the last submission of each student is recored: ");
		for (Map.Entry<Integer, ArrayList<String>> entry : submision.entrySet()) {
	
			System.out.println("Student [" + entry.getKey()+"] : "+entry.getValue());
		}
	

	}

	
	
	

}
