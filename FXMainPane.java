


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox 
{

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button hello, howdy, chinese, clear, exit;
	Label feedback;
	TextField textField;
	
	//  declare two HBoxes
	HBox hboxFirst;
	HBox hboxSecond;
	VBox vbox;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;

	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() 
	{
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		hello= new Button("Hello");
		howdy = new Button("Howdy");
		chinese = new Button("Chinese");
		clear = new Button("Clear");
		exit = new Button("Exit");

		feedback = new Label("Feedback");
		textField = new TextField();
		
	//  instantiate the HBoxes
			hboxFirst = new HBox();
			hboxSecond = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager 		
		dataManager = new DataManager();
		
		//set margins and set alignment of the components
		HBox.setMargin(hello, new Insets(10));
		HBox.setMargin(howdy, new Insets(10));
		HBox.setMargin(chinese, new Insets(10));
		HBox.setMargin(clear, new Insets(10));
		HBox.setMargin(exit, new Insets(10));
		hboxFirst.setAlignment(Pos.CENTER);
		hboxSecond.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		hboxFirst.getChildren().addAll(hello, howdy, chinese, clear, exit);
		hboxSecond.getChildren().addAll(feedback, textField);
		getChildren().addAll(hboxFirst,hboxSecond);
		
		// task #4 set
		hello.setOnAction(new ButtonHandler());
		howdy.setOnAction(new ButtonHandler());
		chinese.setOnAction(new ButtonHandler());
		clear.setOnAction(new ButtonHandler());
		exit.setOnAction(new ButtonHandler());


		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent>
	{

		public void handle(ActionEvent h) 
		{
			if (h.getTarget( )== hello) 
			{
				textField.setText(dataManager.getHello());
			}
			else if (h.getTarget() == howdy) 
			{
				textField.setText(dataManager.getHowdy());
			}
			else if (h.getTarget() == chinese) 
			{
				textField.setText(dataManager.getChinese());
			}
			else if (h.getTarget() == clear) 
			{
				textField.setText("");
			}
			else if (h.getTarget() == exit) 
			{
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
