package iVoteSimulator;


/**
 * 
 * @author Tran Nguyen
 * 
 * Class SingleChoiceQuestion will have the 1 as max number of allowed answers
 */
public class SingleChoiceQuestion extends Question {
	
	private static final int MAX = 1;
	// Set 1 as max number of allowed answers
	public SingleChoiceQuestion(int key) {

		super(s_question[key],s_answers[key],MAX);
		
	}

}
