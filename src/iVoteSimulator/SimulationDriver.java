package iVoteSimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class SimulationDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		SingleChoiceQuestion test1 = new SingleChoiceQuestion(0);
		MultipleChoiceQuestion test2 = new MultipleChoiceQuestion(0);
		
		VotingService center = new VotingService(test1);
		int numberOfStudents = 0;
		int max = 0;
		int temp = 0;
	
		//Generate the number of students
		max = 100;
		numberOfStudents = (int)Math.floor(Math.random()*(max + 1));
		System.out.println("The total number of students: "+ numberOfStudents);
		
		
		System.out.println(test2.getQuestion());
		printAnswers(test2.getAnswers());
		
		ArrayList<String> possibleAns = possibleAnswers(test2.getAnswers());
		max = possibleAns.size() - 1;
		
		//Create student submission and submit to the voting center
		for(int i = 0; i < numberOfStudents; i++) {
			
			temp = (int)Math.floor(Math.random()*(max + 1));
			
			Student tempStudent = new Student(i, possibleAns.get(temp));
			students.add(tempStudent);
			center.submitAnswers(tempStudent);
		}
		
		

		
//		for (int i = 0; i < students.size();i++) {
//			center.submitAnswers(students.get(i));
//			center.submitAnswers(students.get(i));
//		}



		
//		for(int i = 0; i < possibleAns .size(); i++) {
//			System.out.println(possibleAns.get(i));
//		}
//		
		center.displayResult();
		
		
		
		

	}
	
	public static ArrayList<String> possibleAnswers(String [] answers) {
		
		int size = answers.length;
		char firstChar = answers[0].charAt(0);
		
		ArrayList<String> res = new ArrayList<String>();
		for(int i= 0; i < size;i++) {
			res.add( Character.toString( (char) ((int) firstChar + i)) );
		
		}
		
		
		return res;
	}
	
	public static void printAnswers(String [] ans) {
		for(int i = 0; i < ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
}
