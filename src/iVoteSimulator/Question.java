package iVoteSimulator;

import java.util.ArrayList;

public interface Question {
	
	public static final String[] s_question = {"Do you like dynamic backtracking problems?", "Do you like apple?"};
	public static final String[][] s_answers = {{"1. Yes","2. No","3. Maybe"},{"1. Yes","2. No"}};
	
	public static final String[] m_question = {"Which are your favorite tree traversals?", 
			"Do you prefer Top-down (memoization) or Bottom-up (tabulation)?"};
	public static final String[][] m_answers = {{"A. Pre-order","B. In-order","C. Post-order"},
			{"A. Top-down","B. Bottom-up", "C. I hate DP problems"}};
	
	
	String[] getAnswers();
	String[] getCorrect();
	String getQuestion();
	
	
}
