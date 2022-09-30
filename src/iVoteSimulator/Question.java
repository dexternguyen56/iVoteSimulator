package iVoteSimulator;

import java.util.ArrayList;

/**
 * 
 * @author Tran Nguyen
 * 
 * Class question will hold the questions bank, question, and answers
 *
 */

public class Question {

	//Proteted questions bank
	protected static final String[] s_question = {"Do you like dynamic backtracking problems?", "Do you like apple?"};
	protected  static final String[][] s_answers = {{"1. Yes","2. No","3. Maybe"},{"1. Yes","2. No"}};
	protected  static final String[] m_question = {"Which are your favorite tree traversals?", 
			"Do you prefer Top-down (memoization) or Bottom-up (tabulation)?"};
	protected  static final String[][] m_answers = {{"A. Pre-order","B. In-order","C. Post-order", "D. All three!"},
			{"A. Top-down","B. Bottom-up", "C. I hate DP problems"}};

	
	
	private String[] answers;
	private String question;
	private int maxAnswer;
	
	//Constructor for each questions
	public Question(String ques, String [] answer, int max) {
		answers = answer;
		question = ques;
		maxAnswer = max;
	}


	//Setters, getters, and display
	public String[] getAnswers() {
		return answers;
	}


	public String getQuestion() {
		return question;
	}
	
	public int getMaxAnswer() {
		return maxAnswer;
	}
	
	public void printAnswers() {
		for(int i = 0; i < answers.length;i++) {
			System.out.println(answers[i]);
		}
	}
	
	
}
