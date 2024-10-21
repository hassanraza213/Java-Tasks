package main;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the total number of subjects ");
		byte totalSubject = sc.nextByte();
		String[] subject = new String[totalSubject];
		for(byte i = 0 ; i <  totalSubject ; i++) {
			System.out.println(" Enter subject name " + (i + 1));
			subject[i] = sc.next();
		}
		
		System.out.println(" How many students you want to add ");
		int totalStudent = sc.nextInt();
		
		
		String[] stdName = new String[totalStudent];
		for(int i = 0 ; i < totalStudent ; i++) {
			System.out.println(" Enter student name " + (i + 1));
			stdName[i] = sc.next();

		}
		int[][] marks = new int[totalStudent][totalSubject];
		for(int i = 0; i < totalStudent ; i++) {
			
			for(int j = 0 ; j < totalSubject ; j++) {
				System.out.println(" Enter the subject marks ");
				marks[i][j] = sc.nextInt();
			}
			sc.nextLine();
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
	
		sc.close();
}
}
