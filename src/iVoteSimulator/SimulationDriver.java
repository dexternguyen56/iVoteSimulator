package iVoteSimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class SimulationDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		for(int i = 0; i < 10; i++) {
			Student temp = new Student(i, Integer.toString(i + 1));
			students.add(temp);
		}
		
//		for (int i = 0; i < students.size();i++) 
//	      { 		      
//	          System.out.println(students.get(i).getID() + " " + students.get(i).getAnswer()); 		
//	      }   
		
		SingleChoiceQuestion test1 = new SingleChoiceQuestion(1);
		MultipleChoiceQuestion test2 = new MultipleChoiceQuestion(1);
		
		VotingService center = new VotingService(test1);
		
		for (int i = 0; i < students.size();i++) {
			center.submitAnswers(students.get(i));
			center.submitAnswers(students.get(i));
		}
		
		//center.printSubmision();
		
	
		System.out.println(test2.getQuestion());
		
		center.displayResult();
		//center.countResult();
		
		

}
}
