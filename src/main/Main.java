package main;
import java.util.Scanner;

import model.Student;
import model.Subject;
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
		int failedIndex = 0;
		
		Scanner inputNumberOfSubject = new Scanner(System.in);
		System.out.println(" Enter the total number of subjects ");
		byte totalSubject = inputNumberOfSubject.nextByte();
		
		
		Scanner inputCreditHour = new Scanner(System.in);
		Scanner inputSubjectName = new Scanner(System.in);
		
		Subject[] subjectArray = new Subject[totalSubject];
		for(byte i = 0 ; i <  totalSubject ; i++) {
			
			Subject subject = new Subject();
			System.out.println(" Enter subject name " + (i + 1));
			subject.setName(inputSubjectName.nextLine());
			
			System.out.println(" Enter credit hour for the subject " + subject.getName());
			subject.setCreditHour(inputCreditHour.nextByte());
			
			subjectArray[i] = subject;
			totalCreditHour += subjectArray[i].getCreditHour();
			
		}

		
		Scanner inputNumberOfStudents = new Scanner(System.in);
		System.out.println(" How many students you want to add ");
		int totalStudent = inputNumberOfStudents.nextInt();
		
		
		Scanner inputStudentName = new Scanner(System.in);
		Student[] studentNameArray = new Student[totalStudent];
		for(int i = 0 ; i < totalStudent ; i++) {
			
			Student student = new Student();
			System.out.println(" Enter student name " + (i + 1));
			student.setName(inputStudentName.nextLine());
			studentNameArray[i] = student; 

		}
				
		
		Scanner inputStudentMarks = new Scanner(System.in);
		Result[][] marksArray = new Result[totalStudent][totalSubject];
		Result[] failedSubject = new Result[totalSubject];
		
		
		for(int i = 0; i < totalStudent ; i++) {
			
			Result resultFailed = new Result();
		    totalMarks = 0;
		    percentage = 0;
		    isFailed = false;
		    failedSubjectCreditHour = 0;
		    failedIndex = 0;
		    
		    Result[] failedSubjectsArray = new Result[totalSubject];
		    
		    
			for(int j = 0 ; j < totalSubject ; j++) {
				
				Subject subject = new Subject();
				Student student = new Student();
				Result result = new Result();
				System.out.println("Enter marks for the student " + studentNameArray[i]+ " for the subject " + subjectArray[j]);
				
				result.setStudentMarks(inputStudentMarks.nextInt());
				marksArray[i][j] = result;
				
				
				if(marksArray[i][j].getStudentMarks() < 55 ) {
					isFailed = true;
					failedSubjectCreditHour += subjectArray[i].getCreditHour();
					result.setFailedSubject(subjectArray[j].getName());
					failedSubjectsArray[failedIndex] = result;
					failedIndex++;
				}
				
				totalMarks += marksArray[i][j].getStudentMarks() * subjectArray[j].getCreditHour();
				percentage = (totalMarks/totalCreditHour) ;
			}
			
			resultFailed.setTotalMarks(totalMarks);
			
		    if (isFailed) {	
		        
		        if (failedSubjectCreditHour < (totalCreditHour / 2)) {
		            System.out.print(studentNameArray[i] + " has failed the subjects: ");
		            for (int k = 0; k < failedIndex; k++) {
		                System.out.print(failedSubjectsArray[k]);
		                if (k < failedIndex - 1) {
		                    System.out.print(", ");
		                }
		            }
		            System.out.println(); 
		        } 
		    } else {
		        System.out.println(studentNameArray[i] + " has passed all subjects.");
		    }
		    resultFailed.setFailedSubject((failedIndex > 0) ? failedSubjectsArray[0].getFailedSubject() : "Passed all subjects");
		    failedSubject[i] = resultFailed;
		}
		
		
		
		for(Subject subject: subjectArray) {
			System.out.println(subject);
		}
		
		
		for(Student student: studentNameArray) {
			System.out.println(student);
		}
		
		
		System.out.println();
		System.out.print("Name" + "\t");
		for (byte i = 0; i < totalSubject; i++) {
		    System.out.print(subjectArray[i] + "\t");
		}
		System.out.print("Total Marks\tPercentage\tFailed Subjects\n");

		for (int i = 0; i < totalStudent; i++) {
		    System.out.print(studentNameArray[i] + "\t");
		    for (int j = 0; j < totalSubject; j++) {
		        System.out.print(marksArray[i][j] + "\t");
		    }
		    
		    int totalMarksForStudent = 0;
		    for (int j = 0; j < totalSubject; j++) {
		        totalMarksForStudent += marksArray[i][j].getStudentMarks() * subjectArray[j].getCreditHour();
		    }
		 
		    double percentageForStudent = (double) totalMarksForStudent / totalCreditHour;

		    System.out.print(totalMarksForStudent + "\t" );
		    System.out.print(percentageForStudent + "\t");
		    if (failedSubject[i].equals("Passed all subjects")) {
		        System.out.print(failedSubject[i]);
		    } else {
		        System.out.print(failedSubject[i]);
		    }
		    
		    System.out.println();
		    
		    inputCreditHour.close();
		    inputNumberOfSubject.close();
		    inputSubjectName.close();
		    inputNumberOfStudents.close();
		    inputStudentName.close();
		    inputStudentMarks.close();
		}
	}
}