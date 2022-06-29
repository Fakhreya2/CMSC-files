/*
 * Class: CMSC203-46519
 * Instructor: Professor Eivazi
 * Assignment: Lab #1
 * Description: This program will take the input for the name, rating, and tickets sold for a movie and will display the entered input
 * Due: 06/29/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming lab independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Fakhreya Mohammadi
*/
import java.util.Scanner; // The scanner class is imported

// The class MovieDriver starts here
public class MovieDriver {

	public static void main(String[] args) 
	{ // The main method starts here
		
		// A scanner object is created from the Scanner class
		Scanner keyboard = new Scanner(System.in);
		
		
		// Variable character is declared and initialized to y
		char character = 'y';
		// Variable numberOfTickets is declared
		int numberOfTickets;
		// The title variable is declared
		String title;
		// The rating variable is declared
		String rating;
		
		// The while loop is used for repeat of entering another movie while input equals y
		while(character == 'y')
		{
			Movie input = new Movie(); // An object of Movie class is created
			
			System.out.println("Enter the name of the movie "); // prompts the user to enter the name of the movie
			title = keyboard.nextLine(); // Reads the input and stores it in variable title
			input.setTitle(title);// The method is called and the argument title is passed to the called method
			
			
			System.out.println("Enter the rating of the movie "); // prompts the user to enter the rating of the movie
			rating = keyboard.next();// Reads the input and stores it in variable rating
			input.setRating(rating);// The method is called and the argument rating is passed to the called method
			
			
			System.out.println("Enter the number of tickets sold for this movie "); // prompts the user to enter number of tickets sold for this movie
			numberOfTickets =keyboard.nextInt(); // Reads the input and stores it in variable numberOfTickets
			input.setSoldTickets(numberOfTickets);// The method is called and the argument numberOfTickets is passed to the called method
			
			
			System.out.println(input.toString()); // The method toString is called and it si inside the print statement. It will return a string
			System.out.println("Do you want to enter another ?(y or n)"); // The user is asked does he wants to enter another movie
			character=keyboard.next().charAt(0); // Reads the input and stores it in variable character
			keyboard.nextLine();// This is for line feed
			} // End of while loop
		
		System.out.println("Goodbye!"); // Displays the statement inside parenthesis
		keyboard.close(); // Closes the scanner 
		


	} // End of main method

} // End of MovieDriver class