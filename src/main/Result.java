package main;

import java.util.Scanner;

public class Result {

	public static void main(String[] args) {
		
	
		String checkAgain;
		do {
			
			short totalMarks = 500;

//			
			Scanner sc = new Scanner(System.in);
//			
			System.out.println("Enter your name");
			String name = sc.next();
			System.out.println(name);
			
			String[] subject = new String[5];
			short[] marks = new short[5];
			
			for(byte i = 0; i<5; i++) {
				System.out.println("Enter subject name " + ( i + 1) );
				subject[i] = sc.next();
				
				byte mark = -1;
				while(mark < 0 || mark > 100) {
					System.out.println("Enter valid marks");
					mark = sc.nextByte();
				}
				if(mark >= 0 && mark <=100) {
					marks[i] = mark;
				}else {
					System.out.println("Please enter valid marks");
				}
				
				if(marks[i] >=50) {
					System.out.println("you've passed the subject");
				}else {
					System.out.println("you've failed the subject");
				}
				
			}
			
			float obtainedMarks = 0f;
			for(byte i=0; i<5; i++) {
				System.out.println(subject[i] + " : " + marks[i]);
				obtainedMarks += marks[i];
			}
			System.out.println("Obtained marks are : " + obtainedMarks);
			System.out.println();
			
			
			float percentage =  ( obtainedMarks / totalMarks) * 100f;
			System.out.println("Your percentage is : " + percentage);
			System.out.println();
			System.out.println("Do you want to check marks again ? (Yes | No)");
			checkAgain = sc.next();
		} while(checkAgain.equals("Yes"));
//		
//		System.out.println("Enter you English marks");
//		int subOne = sc.nextInt();
//		System.out.println(subOne);
//
//		System.out.println("Enter you Physics marks");
//		int subTwo = sc.nextInt();
//		System.out.println(subTwo);
//
//		System.out.println("Enter you Chemistry marks");
//		int subThree = sc.nextInt();
//		System.out.println(subThree);
//
//		System.out.println("Enter you Maths marks");
//		int subFour = sc.nextInt();
//		System.out.println(subFour);
//
//
//		System.out.println("Enter you History marks");
//		int subFive = sc.nextInt();
//		System.out.println(subFive);
		
		
		
//		if(subOne > 100 ) {
//			System.out.println("Please enter a valid number");
//		}else if(subOne >= 50) {
//			System.out.println("you've passed the English Subject");
//		}else {
//			System.out.println("you've failed the English Subject");
//		}
//		
//		if(subTwo >= 50 ) {
//			System.out.println("you've passed the Physics Subject");
//		}else {
//			System.out.println("you've failed the Physics Subject");
//		}
//		
//		if(subThree >= 50 ) {
//			System.out.println("you've passed the Chemistry Subject");
//		}else{
//			System.out.println("you've failed the Chemistry Subject");
//		}
//		
//		if(subFour >= 50 ) {
//			System.out.println("you've passed the Maths Subject");
//		}else {
//			System.out.println("you've failed the Maths Subject");
//		}
//		
//		if(subFive >= 50 ) {
//			System.out.println("you've passed the History Subject");
//		}else {
//			System.out.println("you've failed the History Subject");
//		}
//		
//		
//		double obtainedMarks = subOne + subTwo + subThree + subFour + subFive ;
//		
//		System.out.println();
//		System.out.println("Your obtained Marks are : " + obtainedMarks);
//		
//		double percentage = (obtainedMarks / totalMarks) * 100;
//		System.out.println();
//		System.out.println("Your percentage is : " + percentage	);
		
		

	}

}
