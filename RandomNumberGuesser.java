/*
 * Class: CMSC203-46519
 * Instructor: Professor Eivazi
 * Assignment #2
 * Description: This application will receive a guess from the user and will report
 * if his/her guess is the random number that was generated. It will prompts the user
 * again and again to enter a number until he/she guesses the correct number
 * Due: 06/30/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Fakhreya Mohammadi
*/

import java.util.Scanner; // The Scanner class is imported 

public class RandomNumberGuesser { // The class RandomNumberGuesser starts here 

        public static void main(String[] args) { // Main method starts here
        	// The attributes(Variables) are declared
        	int randNum;
        	int nextGuess;
        	int highGuess;
        	int lowGuess;
            String result;
            // The variable response is declared and initialized to 0
            char answer = 0;
        	// Prints the header 
            System.out.println("This application will receive a guess from the user and will report if his/her guess is the random number that was generated.");
            System.out.println(""); // Prints a space line
            // The scanner object named input is created from class Scanner
            Scanner input = new Scanner (System.in);
            // The RNG object named R is created from the class RNG
            RNG R = new RNG();
                
                
                do { // Start of do while loop. It first executes the statements and then will test the conditions
                lowGuess = 1; // The lowGuess variable is initialized to 1
                highGuess = 100; // The highGuess variable is initialized to 100
                randNum = RNG.rand(); // The method rand is called and the memory address of the object of RNG class is assigned to the variable randNum
                RNG.resetCount(); // calls the resetCount method to reset the count
                System.out.println("Enter your first guess "); // Prompts the user to enter the first guess
                nextGuess = input.nextInt();// Reads the input of user and stores it in the variable nextGuess
                
                                
                do { // the do while loop will first execute the statement and then will test the condition
                if (nextGuess > randNum) // The if statement will be executed if the condition inside the parenthesis be true 
                {
                		// calls the inputValidation and sends the arguments for validation
                        if(RNG.inputValidation(nextGuess, lowGuess, highGuess))
                   {
                      // The if statement will be executed if the condition inside the parenthesis be true	
                       if(nextGuess <= randNum && (randNum - nextGuess) < (randNum - lowGuess))
                       {
                           lowGuess = nextGuess; // assigns the nextGuess value to the lowGuess variable
                       }
                       // The if statement will be executed if the condition inside the parenthesis be true
                       if(nextGuess >= randNum && (nextGuess - randNum) < (highGuess - randNum))
                       {
                           highGuess = nextGuess; // assigns the nextGuess value to the highGuess variable
                       }
                   } // Ends the validation if statement 
                        
                // The method getCount is called and is inside the print statement 
                // The method will store the number guesses the user did after each iteration 
                System.out.println("Number of guesses is " + R.getCount());     
                // Displays the statement inside parenthesis       
                System.out.println("Your guess is too high"); // Displays the statement inside the parenthesis 
                highGuess = nextGuess; // nextGuess is assigned to the highGuess variable
                
                
                // Prompts the user to enter another guess between the range of lowGuess and highGuess of previous guess 
                System.out.println("Enter your next guess between "+lowGuess+" and " + highGuess);
                nextGuess = input.nextInt(); // Reads the input and stores it in the variable nextGuess
                
                } // Ends the if decision structure statement 
                
                else if (nextGuess < randNum) // The if statement will be executed if the condition inside the parenthesis be true 
                { 
                		// calls the inputValidation and sends the arguments for validation
                        if(RNG.inputValidation(nextGuess, lowGuess, highGuess))
                   {
                        // The if statement will be executed if the condition inside the parenthesis be true
                       if(nextGuess <= randNum && (randNum - nextGuess) < (randNum - lowGuess))
                       {
                           lowGuess = nextGuess; // assigns the nextGuess value to the lowGuess variable
                       }
                       // The if statement will be executed if the condition inside the parenthesis be true	
                       if(nextGuess >= randNum && (nextGuess - randNum) < (highGuess - randNum))
                       {
                           highGuess = nextGuess; // assigns the nextGuess value to the highGuess variable
                       }
                   }// ends the if validation decision structure statement 
                        
                        
                 // The method getCount is called and is inside the print statement 
                 // The method will store the number guesses the user did after each iteration      
                System.out.println("Number of guesses is " + R.getCount());     
                // Displays the statement inside parenthesis      
                System.out.println("Your guess is too low");
                        
                lowGuess = nextGuess; // Assigns the nextGuess value to the variable lowGuess
                // Prompts the user to enter another guess between the range of lowGuess and highGuess of previous guess        
                System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
                nextGuess= input.nextInt(); // Reads the input and stores it in the variable nextGuess
                } // ends the else if statement 
                
                } // ends the second do while loop
                while (nextGuess != (randNum)); // This while loop will be executed if the nextGuess is not equal the random number generated 
                // calls the inputValidation and sends the arguments for validation
                if(RNG.inputValidation(nextGuess, lowGuess, highGuess))
        {
             // The if statement will be executed if the condition inside the parenthesis be true 
            if(nextGuess <= randNum && (randNum - nextGuess) < (randNum - lowGuess))
            {
                lowGuess = nextGuess; // Assigns the value of nextGuess to the variable lowGuess
            }
            // The if statement will be executed if the condition inside the parenthesis be true
            if(nextGuess >= randNum && (nextGuess - randNum) < (highGuess - randNum))
            {
                highGuess = nextGuess; // Assigns the value of the nextGuess to the highGuess
            }
        } // ends the if validation condition structure
                
                // The method getCount is called and is inside the print statement 
                // The method will store the number guesses the user did after each iteration
                System.out.println("Number of guesses is " + R.getCount());
                //  Displays the statement inside the parenthesis 
                System.out.println("Congradulations, you guessed correctly \n Try again (y or n)");
                result = input.next(); // Reads the input of the user and stores it in variable input
                answer = result.charAt(0); // The method CharAt() is called and the answer to play again will be stored in variable answer
                
                
                // The while loop will be executed if the entered character is not equal to y or n
                while (answer != 'y' && answer != 'n')
                {       
                	System.out.print("Please enter Yes or No: "); // Prompts the user does he wants to play again enter y or n
                    result = input.nextLine(); // The input will be read by nextLine method and will be assigned to variable result
                    answer = result.charAt(0);// The method CharAt() is called and the answer to play again will be stored in variable answer
                    } // Ends while loop
                
                } // Ends the first do while loop 
                
                while (answer == 'y');
                System.out.println("Thank you for playing..."); // Prints the statement inside the parenthesis
                System.out.println(""); // Displays the space line
                System.out.println("Programmer: Fakhreya Mohammadi"); // Displays the programmer name
                
                input.close(); // Closes the scanner
                
        } // Ends main method

} // Ends the class RandomNumberGuesser
