package result;

import java.util.*;
import result.Student;
import result.Subject;

public class StudentInput {
	
	private int numberOfStudents;
	private String[] studentName;
	private int totalNumberOfSubjects;
	private String[] subjectName;
	private int totalCreditHour = 0;
    private int totalMarks = 0;
    private double percentage;
    private boolean isFailed = false;
    private int failedSubjectCreditHour = 0;
    private int failedIndex = 0;
    private String[] failedSubject;
    private int[][] marks;
    private byte[] creditHour;
	private Student student;
	private Subject subject;
	
    public StudentInput() {
        student = new Student(0, new String[0]); 
        subject = new Subject(0, new String[0]); 
    }
	 
	public void getStudentData() {
		
		Scanner addStudents = new Scanner(System.in);
		System.out.println(" How many students you want to add ");
		numberOfStudents = addStudents.nextInt();
		
		
		Scanner addStudentName = new Scanner(System.in);
		studentName = new String[numberOfStudents];
		for(int i = 0 ; i < numberOfStudents ; i++) {
			System.out.println(" Enter student name " + (i + 1));
			studentName[i] = addStudentName.nextLine();

			}
		
			student.setTotalStudents(numberOfStudents);
			student.setStudentNames(studentName);
		}
	
	public void getSubjectData() {
		
		Scanner addSubject = new Scanner(System.in);
		System.out.println(" Enter the total number of subjects ");
		totalNumberOfSubjects = addSubject.nextByte();
		
		Scanner addSubjectName = new Scanner(System.in);
		subjectName = new String[totalNumberOfSubjects];
		creditHour = new byte[totalNumberOfSubjects];
		for(byte i = 0 ; i <  totalNumberOfSubjects ; i++) {
			System.out.println(" Enter subject name " + (i + 1));
			subjectName[i] = addSubjectName.nextLine();
			System.out.println(" Enter credit hour for the subject " + subjectName[i]);
			creditHour[i] = addSubjectName.nextByte();
			totalCreditHour += creditHour[i];
			addSubjectName.nextLine();
		}
		
			subject.setNumberOfSubject(totalNumberOfSubjects);
			subject.setSubjectName(subjectName);

	}
	
	public void result() {
		
		Scanner inputMarks = new Scanner(System.in);
		marks = new int[numberOfStudents][totalNumberOfSubjects];
		failedSubject = new String[totalNumberOfSubjects];
		for(int i = 0; i < numberOfStudents ; i++) {
			
		    totalMarks = 0;
		    percentage = 0;
		    isFailed = false;
		    failedSubjectCreditHour = 0;
		    failedIndex = 0;
		    String[] failedSubjectsForStudent = new String[totalNumberOfSubjects];
		    
			for(int j = 0 ; j < totalNumberOfSubjects ; j++) {
				System.out.println("Enter marks for the student " + studentName[i]+ " for the subject " + subjectName[j]);
				marks[i][j] = inputMarks.nextInt();
				if(marks[i][j] < 55 ) {
					isFailed = true;
					failedSubjectCreditHour += creditHour[j];
					failedSubjectsForStudent[failedIndex] = subjectName[j];;
					failedIndex++;
				}
				totalMarks += marks[i][j] * creditHour[j];
				percentage = (totalMarks/totalCreditHour) ;
			}
			
		    if (isFailed) {
		        
		        if (failedSubjectCreditHour < (totalCreditHour / 2)) {
		            System.out.print(studentName[i] + " has failed the subjects: ");
		            for (int k = 0; k < failedIndex; k++) {
		                System.out.print(failedSubjectsForStudent[k]);
		                if (k < failedIndex - 1) {
		                    System.out.print(", ");
		                }
		            }
		            System.out.println(); 
		        } 
		    } else {
		        System.out.println(studentName[i] + " has passed all subjects.");
		    }
		    failedSubject[i] = (failedIndex > 0) ? failedSubjectsForStudent[0] : "Passed all subjects";
		}
	
	}
	
	public void displayResult() {
		
		System.out.println();
		System.out.printf("%-10s", "Name");
		for (byte i = 0; i < totalNumberOfSubjects; i++) {
			System.out.printf("%-10s", subjectName[i]);
		}
		System.out.printf("%-12s%-10s%-20s\n", "Total Marks", "Percentage", "Failed Subjects");	

		for (int i = 0; i < numberOfStudents; i++) {
			System.out.printf("%-10s", studentName[i]);
		    for (int j = 0; j < totalNumberOfSubjects; j++) {
		    	System.out.printf("%-10d", marks[i][j]);
		    }
		    
		    int totalMarksForStudent = 0;
		    for (int j = 0; j < totalNumberOfSubjects; j++) {
		        totalMarksForStudent += marks[i][j] * creditHour[j];
		    }
		 
		    double percentageForStudent = (double) totalMarksForStudent / totalCreditHour;
		    System.out.printf("%-12d%-10.2f", totalMarksForStudent, percentageForStudent);
		   // System.out.print(totalMarksForStudent + "\t" );
		   // System.out.print(percentageForStudent + "\t");
		    if (failedSubject[i].equals("Passed all subjects")) {
		        System.out.print(failedSubject[i]);
		    } else {
		        System.out.print(failedSubject[i]);
		    }
		    System.out.println();
		
		}
	}
}

