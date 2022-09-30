package iVoteSimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Tran Nguyen
 * 
 * VotingService will accept submission from students and display the final results
 *
 */
public class VotingService {
	private HashMap<Integer,ArrayList<String>> submision;
	private HashMap<String,Integer> results;
	private Question question;
	
	
	// Instantiate the submission and result and construct the question
	public VotingService(Question ques) {
		submision = new HashMap<Integer,ArrayList<String>>();
		results = new HashMap<String,Integer>();
		question = ques;
	}
	
	//Get possible answers based from the first character of the answer i.e (A,B,C,..) or (1,2..)
	public ArrayList<String> possibleAnswers() {
		int size = question.getAnswers().length;
		char firstChar = question.getAnswers()[0].charAt(0);
		
		ArrayList<String> res = new ArrayList<String>();
		for(int i= 0; i < size;i++) {
			res.add( Character.toString( (char) ((int) firstChar + i)) );
			// Convert the ascii to char
		}
		return res;

	}
	

	// Accept the student answers and store them in the submission hashMap
	public void submitAnswers(Student student) {
		if (submision.containsKey(student.getID())) {
				submision.replace(student.getID(),student.getAnswer());
			}
		else {
				submision.put(student.getID(), student.getAnswer());
			}
		}
	
	
	// Count the result from the submission hashMap
	private void countResult() {
		
		for (Map.Entry<Integer, ArrayList<String>> entry : submision.entrySet()) {

			ArrayList<String> temp = entry.getValue();
		    
		    for(int i = 0; i < temp.size();i++) {
		    	
		    	if( results.containsKey(temp.get(i))) {
		    		results.replace(temp.get(i), results.get(temp.get(i)) + 1);
		    	}
		    	else {
		    		results.put(temp.get(i), 1);
		    	}

		    }
		}
		
	}
	
	// Call the countResult() and display the result from the result hashMap
	public void displayResult(ArrayList<String> ans) {
		
		//Initialize the result with 
		for(int i = 0; i < ans.size();i++) {
			results.put(ans.get(i), 0);
		}
		
		countResult();
		
		System.out.println("Final Results: \n");
		
		System.out.println("Number of participated students: "+ submision.size() +"\n");
		for (Map.Entry<String, Integer> entry : results.entrySet()) {
		    System.out.println("["+entry.getKey()+"] : "+entry.getValue());
		}
		
		System.out.println();

	}
		
	
	// Display submission to show only the last submission of each student is recored:
	public void printSubmision() {
		
		System.out.println("Final submission to show only the last submission of each student is recored: \n");
		for (Map.Entry<Integer, ArrayList<String>> entry : submision.entrySet()) {
			System.out.println("Student [" + entry.getKey()+"] : "+entry.getValue());
		}
	
	}

	
	
	

}
