package PROFILE;

import java.io.IOException;
import java.util.ArrayList;

import Backend.Club;
import ClubFinder.SingleClubController;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class is the controller for the ClubInfoProfile.fxml scene and handles the events
 * when the user adds or removes and interest
 */
public class ClubInfoProfileController {
	
	// The ArrayList that stores all of the interests
	private ArrayList<String> interests = new ArrayList<String>();
	
	// The ArrayList that stores all of the faculties
	private ArrayList<String> fac = new ArrayList<String>();
	
	// The Scene object which contains the previous scene
	private Scene PreviousScene;
	
	// VBox that is used to display the interests the user can pick from
	@FXML
	private VBox listOfInterests = new VBox();
	
	//The Stage object of the currentStage the scene is on
	private Stage currentStage;
	
	// The Button Object for the back button
    @FXML
    private Button BackButtonOnClick;

    
	/**
     * This method handles the event when the back button is clicked, it returns to the previous scene
     * 
     * @param event - An ActionEvent object that is passed into the method when the BackButton is clicked
     */	
    @FXML
    public void BackButtonOnClick(ActionEvent event)throws Exception {
    	currentStage.setScene(PreviousScene);
    	currentStage.show();
    }
    
    
	/** Returns the interests the user has
	 * 
	 * @return - A copy of the interests ArrayList
	 */
	public ArrayList<String> getInterests() 
	{
		return new ArrayList<String>(interests);
	}
	
	/** Returns the faculties the user is interested
	 * 
	 * @return - A copy of the faculties ArrayList
	 */
	public ArrayList<String>getFaculties()
	{
		return new ArrayList<String>(fac);
	}
	
	
	/**
	 * This method is used to create the interest and display the interest
	 * 
	 * @param mapping - The key of the interest (Ex 1.1)
	 * @param text - The raw text of the interest (Ex Faculty of Arts)
	 */
	public void createInterest(String mapping, String text) 
	{
		// Creates an HBox which will list one interest
		HBox root = new HBox();
		root.setPadding(new Insets(10, 10, 10, 10));
		
		// Adds that HBox to the VBox listOfInterests so that it will be displayed in the scene
		listOfInterests.getChildren().add(root);
		
    	Label c = new Label(text);
        root.setPadding(new Insets(10, 10, 10, 10));
        
        final Pane spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(10, 1);
        
        //Two buttons are made for adding and removing an interest
        final Button add = new Button("Add");
        final Button del = new Button("Remove");
        
        // The "Remove" button is disabled because you first need to add the interest before you remove it
        del.setDisable(true);
        
        
        add.setOnAction(new EventHandler<ActionEvent>() 
        {
        	// This method handles the event when the Add button is clicked
        	@Override
        	public void handle(ActionEvent event)
        	{
        		
        		// Add an interest and disable the add button and enable the remove button
        		addInterest(mapping);
        		add.setDisable(true);
        		del.setDisable(false);
        		
        	}
        });
        add.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);

        del.setOnAction(new EventHandler<ActionEvent>() 
        {
        	// This method handles the event when the Add button is clicked
        	@Override
        	public void handle(ActionEvent event)
        	{
        		// Remove the interest and disable the remove button and enable the add button
        		removeInterest(mapping);
        		add.setDisable(false);
        		del.setDisable(true);
        	}
        });
        del.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);
        
        // Adds the label, spacer and button to the HBox
        root.getChildren().addAll(c, spacer, add,del);
	}
	
	/**
	 * This method adds an interest to the interests ArrayList
	 * 
	 * @param key - The interest that is to be added
	 */
	public void addInterest(String key) 
	{
		// If the interest is not already in the ArrayList than add the interest
		if(!interests.contains(key))
			interests.add(new String(key));
		System.out.println(interests.toString());
	}
	
	/**
	 * This function removes an interest from the interests ArrayList
	 * 
	 * @param toRemove The interest that is to be removed
	 */
	public void removeInterest(String toRemove) 
	{
		interests.remove(toRemove);
	}
	
    /**
     * Setter method that is used to pass in the previous stage
     * 
     * @param c - The stage that the caller is passing in to the controller
     */
	public void setStage(Stage c) 
	{
		currentStage = c;
	}
	
	
    /**
     * Setter method that is used to set the previousScene instance variable
     * 
     * @param c - The previous scene that you want to go back to
     */
	public void setPreviousScene(Scene c) 
	{
		PreviousScene = c;
	}
	
}
