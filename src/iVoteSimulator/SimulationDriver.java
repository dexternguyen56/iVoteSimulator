package iVoteSimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class SimulationDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Student> students = new ArrayList<Student>();
		SingleChoiceQuestion test1 = new SingleChoiceQuestion(0);
		MultipleChoiceQuestion test2 = new MultipleChoiceQuestion(0);
		
		VotingService center = new VotingService(test1);
		ArrayList<String> tempAns;
		
		int numberOfStudents = 0;
		int max = 0;
		int temp = 0;
	
		//Generate the number of students
		max = 10;
		numberOfStudents = (int)Math.floor(Math.random()*(max + 1));
		System.out.println("The total number of students: "+ numberOfStudents);
		
		
		System.out.println(test1.getQuestion());
		printAnswers(test1.getAnswers());
		
		ArrayList<String> possibleAns = possibleAnswers(test1.getAnswers());
		
		
		max = possibleAns.size() - 1;
		
		//Create students
		for(int i = 0; i < numberOfStudents; i++) {
			Student tempStudent = new Student(i);
			students.add(tempStudent);
		}
		//Generate submission
		for(int i = 0 ; i < 10; i++) {
			temp = (int)Math.floor(Math.random()*(numberOfStudents));
			
			tempAns = generateAns(test1, possibleAns);	
			students.get(temp).setAnswer(tempAns);
			
			center.submitAnswers(students.get(temp));
		 	
		}
		
		
		center.printSubmision();
		center.displayResult(possibleAns);
		
		
		
		

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
	
	public static ArrayList<String> generateAns(Question question, ArrayList<String> ans){
		
		int maxRand = (int)Math.floor(Math.random()*(ans.size())) + 1;
		//System.out.println("Max random: " + maxRand);
		int numOfAns = question instanceof SingleChoiceQuestion ? 1: maxRand;
		ArrayList<String> res = new ArrayList<String>();
		int temp;
		
		for(int i = 0; i < numOfAns;i++) {
			
			temp = (int)Math.floor(Math.random()*(ans.size()));
			res.add(ans.get(temp));
		}
		
		return res;
	}
 	
	public static void printAnswers(String [] ans) {
		for(int i = 0; i < ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
}
