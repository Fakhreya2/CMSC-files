/*
 * Class: CMSC203-46519
 * Instructor: Professor Eivazi
 * Assignment: Lab 2
 * Description: This application constructs a simple GUI step by step
 * Due: 07/07/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Fakhreya Mohammadi
*/


import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FXDriver extends Application {
	   
	/**
	 * The main method for the GUI example program JavaFX version
	 * @param args not used
	 * @throws IOException
	 */
	public static void main(String[] args) {
		launch(args);
		 
	}
		   
	@Override
	public void start(Stage stage) throws IOException {
		//student Task #1:
		//  instantiate the FXMainPane, name it root
		//  set the scene to hold root
		FXMainPane root = new FXMainPane();
		stage.setScene(new Scene(root, 500, 350));
		//set stage title
		stage.setTitle("Hello World GUI");
		//display the stage
		stage.show();

	}
}