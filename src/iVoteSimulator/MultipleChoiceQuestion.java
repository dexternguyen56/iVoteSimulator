package iVoteSimulator;

import java.util.ArrayList;

public class MultipleChoiceQuestion implements Question {
	
	private String[] answers;
	private String question;
	
	public MultipleChoiceQuestion(int key) {
		// TODO Auto-generated constructor stub
		answers = m_answers[key];
		question = m_question[key];
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
