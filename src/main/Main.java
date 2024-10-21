package main;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner inputSubject = new Scanner(System.in);
		System.out.println(" Enter the total number of subjects ");
		byte totalSubject = inputSubject.nextByte();
		
		Scanner subjectName = new Scanner(System.in);
		String[] subject = new String[totalSubject];
		for(byte i = 0 ; i <  totalSubject ; i++) {
			System.out.println(" Enter subject name " + (i + 1));
			subject[i] = subjectName.nextLine();
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
		for(int i = 0; i < totalStudent ; i++) {
			//System.out.print("Enter marks for the student " +stdName[i]);
			for(int j = 0 ; j < totalSubject ; j++) {
				System.out.println("Enter marks for the student " + stdName[i]+ " for the subject " + subject[j]);
				marks[i][j] = inputMarks.nextInt();
			}
//			sc.nextLine();
		}
			
		System.out.print("Name" + "   ");
		for(byte i = 0 ; i < totalSubject ; i++) {
		System.out.print(subject[i] + "   ");
		}
		
		
		System.out.println();
		for(int i = 0 ; i < totalStudent ; i++) {
			System.out.print(stdName[i] + "   ");
			  for (int j = 0; j < totalSubject; j++) {
	                System.out.print(marks[i][j] + "   ");
	            }
			  System.out.println();
		}
	
		inputSubject.close();
		subjectName.close();
		inputStudent.close();
		studentName.close();
		inputMarks.close();
}
}
