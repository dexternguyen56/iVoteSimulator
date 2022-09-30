package iVoteSimulator;

import java.util.ArrayList;

public class Question {

	protected static final String[] s_question = {"Do you like dynamic backtracking problems?", "Do you like apple?"};
	protected  static final String[][] s_answers = {{"1. Yes","2. No","3. Maybe"},{"1. Yes","2. No"}};
	protected  static final String[] m_question = {"Which are your favorite tree traversals?", 
			"Do you prefer Top-down (memoization) or Bottom-up (tabulation)?"};
	protected  static final String[][] m_answers = {{"A. Pre-order","B. In-order","C. Post-order", "D. All three!"},
			{"A. Top-down","B. Bottom-up", "C. I hate DP problems"}};

	
	
	private String[] answers;
	private String question;
	private int maxAnswer;
	
	public Question(String ques, String [] answer, int max) {
		// TODO Auto-generated constructor stub
		answers = answer;
		question = ques;
		maxAnswer = max;
	}



	public String[] getAnswers() {
		// TODO Auto-generated method stub
		return answers;
	}


	public String getQuestion() {
		// TODO Auto-generated method stub
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
