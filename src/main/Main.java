package main;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int totalCreditHour = 0;
		int totalMarks;
		double percentage;
		boolean isFailed = false;
		int failedSubjectCreditHour;
		int failedIndex = 0;
		Scanner inputSubject = new Scanner(System.in);
		System.out.println(" Enter the total number of subjects ");
		byte totalSubject = inputSubject.nextByte();
		
		Scanner subjectName = new Scanner(System.in);
		String[] subject = new String[totalSubject];
		byte[] creditHour = new byte[totalSubject];
		for(byte i = 0 ; i <  totalSubject ; i++) {
			System.out.println(" Enter subject name " + (i + 1));
			subject[i] = subjectName.nextLine();
			System.out.println(" Enter credit hour for the subject " + subject[i]);
			creditHour[i] = subjectName.nextByte();
			totalCreditHour += creditHour[i];
			subjectName.nextLine();
		}
	
		
		Scanner inputStudent = new Scanner(System.in);
		System.out.println(" How many students you want to add ");
		int totalStudent = inputStudent.nextInt();
		
		
		Scanner studentName = new Scanner(System.in);
		String[] stdName = new String[totalStudent];
		for(int i = 0 ; i < totalStudent ; i++) {
			System.out.println(" Enter student name " + (i + 1));
			stdName[i] = studentName.nextLine();

		}
		
		Scanner inputMarks = new Scanner(System.in);
		int[][] marks = new int[totalStudent][totalSubject];
		String[] failedSubject = new String[totalSubject];
		for(int i = 0; i < totalStudent ; i++) {
			
		    totalMarks = 0;
		    percentage = 0;
		    isFailed = false;
		    failedSubjectCreditHour = 0;
		    failedIndex = 0;
		    String[] failedSubjectsForStudent = new String[totalSubject];
		    
			for(int j = 0 ; j < totalSubject ; j++) {
				System.out.println("Enter marks for the student " + stdName[i]+ " for the subject " + subject[j]);
				marks[i][j] = inputMarks.nextInt();
				if(marks[i][j] < 55 ) {
					isFailed = true;
					failedSubjectCreditHour += creditHour[j];
					failedSubjectsForStudent[failedIndex] = subject[j];;
					failedIndex++;
				}
				totalMarks += marks[i][j] * creditHour[j];
				percentage = (totalMarks/totalCreditHour) ;
			}
			
		    if (isFailed) {
		        
		        if (failedSubjectCreditHour < (totalCreditHour / 2)) {
		            System.out.print(stdName[i] + " has failed the subjects: ");
		            for (int k = 0; k < failedIndex; k++) {
		                System.out.print(failedSubjectsForStudent[k]);
		                if (k < failedIndex - 1) {
		                    System.out.print(", ");
		                }
		            }
		            System.out.println(); 
		        } 
		    } else {
		        System.out.println(stdName[i] + " has passed all subjects.");
		    }
		    failedSubject[i] = (failedIndex > 0) ? failedSubjectsForStudent[0] : "Passed all subjects";
		}
		 
		System.out.println();
		System.out.print("Name" + "\t");
		for (byte i = 0; i < totalSubject; i++) {
		    System.out.print(subject[i] + "\t");
		}
		System.out.print("Total Marks\tPercentage\tFailed Subjects\n");

		for (int i = 0; i < totalStudent; i++) {
		    System.out.print(stdName[i] + "\t");
		    for (int j = 0; j < totalSubject; j++) {
		        System.out.print(marks[i][j] + "\t");
		    }
		    
		    int totalMarksForStudent = 0;
		    for (int j = 0; j < totalSubject; j++) {
		        totalMarksForStudent += marks[i][j] * creditHour[j];
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
	
		inputSubject.close();
		subjectName.close();
		inputStudent.close();
		studentName.close();
		inputMarks.close();
}
}
}
