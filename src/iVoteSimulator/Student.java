package iVoteSimulator;

import java.util.ArrayList;

/**
 * 
 * @author Tran Nguyen
 * 
 * Each Student will have an ID and answers 
 *
 */

public class Student {
	private int ID;
	private ArrayList<String> Answer;
	
	
	public Student(int id) {
		ID = id;
	}
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public ArrayList<String> getAnswer() {
		return Answer;
	}
	public void setAnswer(ArrayList<String> answer) {
		Answer = answer;
	}
	

	
	
	

	

	
	



}
