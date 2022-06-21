/*
 * Class: CMSC203-46519
 * Instructor: Professor Eivazi
 * Assignment #1
 * Description: This program will guide the user to some step by step solution ways to diagnoses a WiFi malfunction.
 * Due: 06/21/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Fakhreya Mohammadi
*/

import java.util.Scanner; // The scanner class is imported

public class WiFiDiagnosis { // The public class starts here

	public static void main(String[] args) { // The main class starts here
		
		// Creates a new Scanner instance  in order to read the input and store it in the associated variable
		Scanner keyboard = new Scanner (System.in);
		
		String answer = "yes"; // A string variable named "answer" is declared and initialized to "yes"
		
		// Displays the message inside the parentheses
		System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work.");
		System.out.println(" "); // Displays a space line
		System.out.println("First step: reboot your computer"); // Displays the message inside the parentheses 
		System.out.println("Are you able to connect with the internet? (yes or no)"); // Displays the message inside the parentheses 
		answer = keyboard.nextLine(); // Reads the input and stores it in the variable named answer
				
		if(answer.equals("yes")) // This if statement will be executed if the entered input equals yes 
			System.out.println("Rebooting your computer seemed to work"); // Displays the message inside the parentheses
		else // It will be executed if the above boolean expression is not true
		{
			System.out.println("Second step: reboot your router"); // Displays the message inside the parentheses
			System.out.println("Now are you able to connect with the internet? (yes or no)"); // Displays the message inside the parentheses
			answer = keyboard.nextLine(); // Reads the input and stores it in the variable named answer
				
			if (answer.equals("yes")) // This if statement will be executed if the entered input equals yes 
				System.out.println("Rebooting your router seemed to work"); // Displays the message inside the parentheses
			else // It will be executed if the above boolean expression is not true
			{
				// Displays the message inside the parentheses
				System.out.println("Third step: make sure the cables to your router are plugged in firmly and your router is getting power");
				System.out.println("Now are you able to connect with the internet? (yes or no)"); // Displays the message inside the parentheses
				answer = keyboard.nextLine(); // Reads the input and stores it in the variable named answer
				
				if (answer.equals("yes"))  // This if statement will be executed if the entered input equals yes 
					System.out.println("Checking the router's cables seemed to work"); // Displays the message inside the parentheses
				else // It will be executed if the above boolean expression is not true
				{
					System.out.println("Fourth step: move your computer closer to your router"); // Displays the message inside the parentheses
					System.out.println("Now are you able to connect with the internet? (yes or no)"); // Displays the message inside the parentheses
					answer = keyboard.nextLine(); // Reads the input and stores it in the variable named answer
					
					if (answer.equals("yes")) // This if statement will be executed if the entered input equals yes 
						System.out.println("Moving your computer closer to your router seemed to work"); // Displays the message inside the parentheses
					else // It will be executed if the above boolean expression is not true
					{
						System.out.println("Fifth step: contact your ISP"); // Displays the message inside the parentheses
						System.out.println("Make sure your ISP is hooked up to your router."); // Displays the message inside the parentheses
					}
				}
			}
		}
		keyboard.close(); // closes the scanner
		System.out.println("Fakhreya Mohammadi");
	} // Closes main
} // Closes public class WiFiDiagnosis