/*
 * Name: Abel P. 
 * Class: CMSC 203 
 * Instructor: Ahmed Tarek
 * Description: An introductory program to Java GUIs. This simple program outputs the buttons that are clicked by the users.
 * 
 */

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
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	Button b1,b2,b3,b4,b5,extraButton;

	Label label = new Label();
	TextField textField = new TextField();
	HBox hbox1 = new HBox(), hbox2 = new HBox();
	
	
	
	
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		b1= new Button("Hello");
		HBox.setMargin(b1,new Insets(10));
	   
		b2 = new Button("Howdy");
		HBox.setMargin(b2,new Insets(10));
	    
		b3 = new Button("Chinese");
		HBox.setMargin(b3,new Insets(10));
	   
		b4 = new Button("Clear");
		HBox.setMargin(b4,new Insets(10));
		
		b5 = new Button("Exit");
		HBox.setMargin(b5,new Insets(10)); 
		
		extraButton = new Button("Hindi");
		HBox.setMargin(extraButton,new Insets(10)); 
	    
		label.setText("Feedback: ");
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		dataManager = new DataManager();
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		hbox2.getChildren().addAll(label,textField);
		hbox1.getChildren().addAll(b1,b2,b3,extraButton,b4,b5);
		
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		
	    getChildren().addAll(hbox1,hbox2);
	    setAlignment(Pos.CENTER);
	    
	    ButtonHandler ButtonListner = new ButtonHandler();
	    b1.setOnAction(ButtonListner);
	    b2.setOnAction(ButtonListner);
	    b3.setOnAction(ButtonListner);
	    extraButton.setOnAction(ButtonListner);
	    b4.setOnAction(ButtonListner);
	    b5.setOnAction(ButtonListner);
	    
		
	}
		
	
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event) {
			Object source = event.getTarget();
			if (source == b1)
			{
				textField.setText(dataManager.getHello());
			}
			else if(source == b2)
			{
				textField.setText(dataManager.getHowdy());
			}
			else if (source==b3) {
				textField.setText(dataManager.getChinese());
			}
			else if (source == extraButton) {
				textField.setText("Namaste");
			}
			else if (source==b4) {
				textField.setText("");
			}
			else if (source==b5) {
				Platform.exit();
				System.exit(0);
			}
			
		}
	}//end of private class
	
	
}//end
	
