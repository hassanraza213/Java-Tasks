package main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Student;
import model.Subject;
import service.InvalidMarksException;
import service.Result;

public class Main {

	public static void main(String[] args) {
		
				
		
//		Subject subject = new Subject();
//		subject.setName(""); 
//		subject.setCreditHour(0);
		
		int totalCreditHour = 0;
		int totalMarks;
		double percentage;
		boolean isFailed = false;
		int failedSubjectCreditHour;
		//int failedIndex = 0;
		
		Scanner inputNumberOfSubject = new Scanner(System.in);
		System.out.println(" Enter the total number of subjects ");
		byte totalSubject = inputNumberOfSubject.nextByte();
		
		
		Scanner inputCreditHour = new Scanner(System.in);
		Scanner inputSubjectName = new Scanner(System.in);
		
		ArrayList<Subject> subjectArrayList = new ArrayList<>();
		//Subject[] subjectArray = new Subject[totalSubject];
		for(byte i = 0 ; i <  totalSubject ; i++) {
			
			Subject subject = new Subject();
			System.out.println(" Enter subject name " + (i + 1));
			subject.setName(inputSubjectName.nextLine());
			
			System.out.println(" Enter credit hour for the subject " + subject.getName());
			subject.setCreditHour(inputCreditHour.nextByte());
			
			subjectArrayList.add(subject);
			//subjectArray[i] = subject;
			totalCreditHour += subjectArrayList.get(i).getCreditHour();
			
		}
		
		Scanner inputNumberOfStudents = new Scanner(System.in);
		System.out.println(" How many students you want to add ");
		int totalStudent = inputNumberOfStudents.nextInt();
		
		
		Scanner inputStudentName = new Scanner(System.in);
		ArrayList<Student> studentNameArrayList = new ArrayList<>();
		//Student[] studentNameArray = new Student[totalStudent];
		for(int i = 0 ; i < totalStudent ; i++) {
			
			Student student = new Student();
			System.out.println(" Enter student name " + (i + 1));
			student.setName(inputStudentName.nextLine());
			studentNameArrayList.add(student);
			//studentNameArray[i] = student; 

		}
				
		
		Scanner inputStudentMarks = new Scanner(System.in);
		
		ArrayList<ArrayList<Result>> marksArrayList = new ArrayList<ArrayList<Result>>();
		ArrayList<Result> failedSubject = new ArrayList<>();
		//Result[][] marksArray = new Result[totalStudent][totalSubject];
		//Result[] failedSubject = new Result[totalSubject];
		
		
		for(int i = 0; i < totalStudent ; i++) {
			
			Result resultFailed = new Result();
		    totalMarks = 0;
		    percentage = 0;
		    isFailed = false;
		    failedSubjectCreditHour = 0;
		    //failedIndex = 0;
		    
		    ArrayList<Result> failedSubjectsArray = new ArrayList<Result>();
		    marksArrayList.add(new ArrayList<Result>());

		    //Result[] failedSubjectsArray = new Result[totalSubject];
		    
		    
		    for (int j = 0; j < totalSubject; j++) {
		        Subject subject = new Subject();
		        Student student = new Student();
		        Result result = new Result();
		        boolean validInput = false; // Flag for valid input

		        while (!validInput) { // Loop until valid input is received
		            System.out.println("Enter marks for the student " + studentNameArrayList.get(i) + " for the subject " + subjectArrayList.get(j));

		            try {
		                int marks = inputStudentMarks.nextInt(); // Read input

		                // Validate marks
		                if (marks < 0 || marks > 100) {
		                    throw new InvalidMarksException(); // Throw custom exception for invalid marks
		                }
		                result.setStudentMarks(marks); // Set valid marks
		                validInput = true; // Exit loop on valid input
		            } catch (InvalidMarksException e) {
		                System.out.println(e.getMessage()); // Print error message for invalid marks
		                System.out.println("Please enter marks between 0 and 100."); // Prompt for valid input
		            } catch (InputMismatchException e) {
		                System.out.println("Invalid input. Please enter an integer value."); // Handle non-integer inputs
		                inputStudentMarks.next(); // Clear the invalid input
		            }
		        }

		        // After successfully getting the marks, proceed with your existing logic
		        marksArrayList.get(i).add(result); // Add result to the list

		        // Check failing conditions
		        if (result.getStudentMarks() < 55 && subjectArrayList.get(j).getCreditHour() < (totalCreditHour / 2)) {
		            isFailed = true;
		            failedSubjectCreditHour += subjectArrayList.get(j).getCreditHour();
		            result.setFailedSubject(subjectArrayList.get(j).getName());
		            failedSubjectsArray.add(result);
		        }

		        totalMarks += result.getStudentMarks() * subjectArrayList.get(j).getCreditHour(); // Calculate total marks
		        percentage = (double) totalMarks / totalCreditHour; // Calculate percentage
		    }

		    // After processing all subjects, check and display results
		    resultFailed.setTotalMarks(totalMarks);

		    if (isFailed && !failedSubjectsArray.isEmpty() && failedSubjectCreditHour < (totalCreditHour / 2)) {
		        System.out.print(studentNameArrayList.get(i) + " has failed the subjects: ");
		        for (int k = 0; k < failedSubjectsArray.size(); k++) {
		            System.out.print(failedSubjectsArray.get(k).getFailedSubject());
		            if (k < failedSubjectsArray.size() - 1) {
		                System.out.print(", ");
		            }
		        }
		        System.out.println();
		    } else {
		        System.out.println(studentNameArrayList.get(i) + " has passed all subjects.");
		    }

		    resultFailed.setFailedSubject((failedSubjectsArray.size() > 0) ? failedSubjectsArray.get(0).getFailedSubject() : "Passed all subjects");
		    failedSubject.add(resultFailed); // Add result to failed subjects list

		}
		
		
//		
//		for(Subject subject: subjectArrayList) {
//			System.out.println(subject);
//		}
//		
//		
//		for(Student student: studentNameArrayList) {
//			System.out.println(student);
//		}
		
		
		System.out.println();
		System.out.print("Name\t");
		for (Subject subject : subjectArrayList) {
		    System.out.print(subject.getName() + "\t"); // Print each subject name
		}
		System.out.print("Total Marks\tPercentage\tFailed Subjects\n");

		// Loop through each student to print their data
		for (int i = 0; i < totalStudent; i++) {
		    System.out.print(studentNameArrayList.get(i) + "\t"); // Print student name

		    // Print marks for each subject dynamically
		    for (int j = 0; j < totalSubject; j++) {
		        System.out.print(marksArrayList.get(i).get(j).getStudentMarks() + "\t"); // Print marks for the subject
		    }

		    // Calculate and print total marks and percentage
		    int totalMarksForStudent = 0;
		    for (int j = 0; j < totalSubject; j++) {
		        totalMarksForStudent += marksArrayList.get(i).get(j).getStudentMarks() * subjectArrayList.get(j).getCreditHour();
		    }

		    double percentageForStudent = (double) totalMarksForStudent / totalCreditHour;
		    System.out.print(totalMarksForStudent + "\t"); // Print total marks
		    System.out.print(String.format("%.2f", percentageForStudent) + "%\t");  

		    // Print failed subjects
		    System.out.print(failedSubject.get(i)); // Ensure this holds all failed subjects

		    System.out.println(); // Move to the next line for the next student
		    
		    inputCreditHour.close();
		    inputNumberOfSubject.close();
		    inputSubjectName.close();
		    inputNumberOfStudents.close();
		    inputStudentName.close();
		    inputStudentMarks.close();
		}
	}
}