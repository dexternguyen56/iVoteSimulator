package iVoteSimulator;

/**
 * 
 * @author Tran Nguyen
 * 
 * Class MultipleChoiceQuestion will have the length of answers for each question
 * as max number of allowed answers
 *
 */

public class MultipleChoiceQuestion extends Question {
	
	//Set the answers' length as the max number of allowed answers
	public MultipleChoiceQuestion(int key) {
		super(m_question[key], m_answers[key], m_answers[key].length);
		
	}


}
