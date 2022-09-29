package iVoteSimulator;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleChoiceQuestion implements Question {
	
	private String[] answers;
	private String question;
	
	public SingleChoiceQuestion(int key) {
		// TODO Auto-generated constructor stub
		answers = s_answers[key];
		question = s_question[key];
	}


	@Override
	public String[] getAnswers() {
		// TODO Auto-generated method stub
		return answers;
	}

	@Override
	public String[] getCorrect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQuestion() {
		// TODO Auto-generated method stub
		return question;
	}


	



}
