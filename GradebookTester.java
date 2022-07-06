/*
 * Class: CMSC203-46519
 * Instructor: Professor Eivazi
 * Assignment: Lab 3
 * Description: This application applies the JUnit test to a class named GradeBook
 * Due: 07/07/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Fakhreya Mohammadi
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	
	//..... Task #3
	// The two objects of class GradeBook are declared
	 GradeBook grade1;
	 GradeBook grade2;

	@BeforeEach
	
	void setUp() throws Exception {
		//..... Task #3
		// At least two objects (grade1, grade2) 
		// of GradeBook class is created to hold 5 scores.  
		 grade1 = new GradeBook(5);
		 grade2 = new GradeBook(5);
		 
		 // The addScore method for each of the GradeBook 
		 // objects are called 4 times with scores added
		 grade1.addScore(45.0);
		 grade1.addScore(32.0);
		 grade1.addScore(30.0);
		 grade1.addScore(10.0);

		 grade2.addScore(67.0);
		 grade2.addScore(50.0);
		 grade2.addScore(80.0);
		 grade2.addScore(70.0);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		//.....Task #3
		// The two objects of GradeBook class are set to null.
		grade1 = null;
		grade2 = null;
		
	}

	@Test
	void testAddScore() {
		//.....Task #4
		//The test of toString method is used to compare 
		//the contents of what is in the scores 
		// array vs. what is expected to be in the scores array.
		assertTrue((grade1.toString()).equals("45.0 32.0 30.0 10.0 "));
		assertTrue((grade2.toString()).equals("67.0 50.0 80.0 70.0 "));;
	}

	@Test
	void testSum() {
		//.....Task #4
		// The test of Sum method is used to 
		// compare what is returned by sum() to 
		//the expected sum of the scores entered.
		assertEquals(117.0, grade1.sum());
		assertEquals(267.0, grade2.sum());	
	}

	@Test
	void testMinimum() {
		//.....Task #4
		// The test of minimum method is used to
		// compare what is returned by minimum() to 
		// the expected minimum of the scores entered.
		assertEquals(10.0, grade1.minimum());
		assertEquals(50.0, grade2.minimum());
	}

	@Test
	void testFinalScore() {
		//.....Task #4
		// The test of finalScore method is used to 
		// compare what is returned by finalScore() to 
		// the expected finalScore of the scores entered.
		assertEquals(107.0, grade1.finalScore());
		assertEquals(217.0, grade2.finalScore());

	}

	@Test
	void testGetScoreSize() {
		//.....Task #4
		// The test of scoreSize method is used to 
		// compare the scoreSize to the expected number of scores entered.
		assertEquals(4, grade1.getScoreSize());
		assertEquals(4, grade2.getScoreSize());
	}

	@Test
	void testToString() {
		// The test of toString method is used to 
		// compare what is returned by toString() to 
		// the expected toString of the scores entered.
		assertEquals("45.0 32.0 30.0 10.0 ", grade1.toString());
		assertEquals("67.0 50.0 80.0 70.0 ", grade2.toString());

	}

}
