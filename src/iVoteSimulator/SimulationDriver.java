package iVoteSimulator;

import java.util.ArrayList;

/**
 * @author Tran Nguyen
 *
 * The main driver class for iVote Simulator
 * 
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class SimulationDriver {
	

	public static void main(String[] args) {

		int numberOfStudents; //Number of students
		int max;			  //Max for each random generator
		int typeOfQuestion;	  //Type of questions: 0-Single and 1-Multiple
		int indexOfQuestion;  //Index of question from the questions bank
		int id;				  //Student ID
		final int MAX_STUDENT = 100;            //Max possible students
		final int MAX_NUMBER_OF_QUESTIONS = 2; //Max possible number of questions
		String questionType;
		
		ArrayList<Student> students = new ArrayList<Student>(); // A list of students
		Question question;										// Question 
		ArrayList<String> tempAns;								// Temporary answer for each student 			
		VotingService votingCenter;								// iVote center
		// Array of possible answers based on the question type and the first character of the first answer
		ArrayList<String> possibleAns ;	
	
		
		//Generate the question type and the index from the question bank
		max = 1;
		typeOfQuestion = (int)Math.floor(Math.random()*(max + 1));
		
		max = MAX_NUMBER_OF_QUESTIONS - 1;
		indexOfQuestion = (int)Math.floor(Math.random()*(max + 1));
		
		//Instantiate a question
		if(typeOfQuestion == 0) {
			
			question = new SingleChoiceQuestion(indexOfQuestion);
			questionType = "Single Choice";
		}
		else {
			question = new MultipleChoiceQuestion(indexOfQuestion);
			questionType = "Multiple Choice";
		}
		
		//Send the question to the voting center
		votingCenter = new VotingService(question);
		
		//Get possible answers from the voting center
		possibleAns = votingCenter.possibleAnswers();
		
	
		//Generate the number of students from the max possible number of students
		max = MAX_STUDENT;
		numberOfStudents = (int)Math.floor(Math.random()*(max)) + 1;
		printStars();
		System.out.println("The total number of students: "+ numberOfStudents);
		
		//Instantiate students and add them to a list
		for(int i = 0; i < numberOfStudents; i++) {
			Student tempStudent = new Student(i);
			students.add(tempStudent);
		}
		
		//Print question and answers
		printStars();
		System.out.println("Question type: "+questionType+"\n");
		System.out.println(question.getQuestion());
		question.printAnswers();


		

		//Generate submission
		printStars();
		System.out.println("Voting Center is accepting submission!");
		System.out.println();
		long endTime = System.currentTimeMillis() + 5;
		while (System.currentTimeMillis() < endTime) {
			
			//Get a random student and random answers
			id = (int)Math.floor(Math.random()*(numberOfStudents));
			tempAns = generateAns(question, possibleAns);
			
			//Set the answer to that student
			students.get(id).setAnswer(tempAns);
			
			//Print the current submission
			System.out.print("Student ["+id+"] submitted: ");
			for (String ans : tempAns) {
				System.out.print(ans +" ");
			}
			System.out.println();
			
			//Submit the student vote to the iVote center
			votingCenter.submitAnswers(students.get(id));
	
		}
		printStars();
		
		/* Print the current result stored in the voting center to show that only the last submission of
		each students is captured
		*/
		votingCenter.printSubmision();

		//Display the final results
		printStars();
		votingCenter.displayResult(possibleAns);
		printStars();
		

	}
	
	//Helper function to generate the answer for each student based on the question type
	public static ArrayList<String> generateAns(Question question, ArrayList<String> ans){
		
		//Get the number of answers Single-1 and Multiple-(>1)
		int numOfAns= (int)Math.floor(Math.random()*(question.getMaxAnswer())) + 1;
		
		ArrayList<String> result = new ArrayList<>();	//Final answer to return
		HashSet<String> tempAns = new HashSet<String>(); //Temporary hash set to remove duplicated answers 
		int temp;

		//Get random answer from the possible answers set
		for(int i = 0; i < numOfAns;i++) {
			temp = (int)Math.floor(Math.random()*(ans.size()));
			tempAns.add(ans.get(temp));
		}
		result.addAll(tempAns);
		
		return result;
	}
	
	
	public static void printStars() {
		System.out.println("***************************************");
	}
 	

}
