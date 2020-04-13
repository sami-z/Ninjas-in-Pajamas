package ClubFinder;


import java.io.IOException;

import javax.swing.ScrollPaneConstants;

import Backend.Club;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class is a controller for the ViewClubs.fxml scene. It populates the scene with a list of clubs 
 * and allows the user to click on any club to see details about that club
 */
public class ViewClubController {
	
	// Instance variable of the current Stage that is being displayed
	private Stage currentStage;
	
	// The instance variable of contains the previous scene
	private Scene previousScene;

	// The VBox which contains the list of all of the Clubs
	@FXML
	private VBox VBoxLayout;
	
	// The Button Object that allows the user to go back to the previous scene
    @FXML
    private Button BackButton;
	
	private VBox VboxOfClubs = new VBox();
    
	/**
	 * This method takes a Club as a parameter and adds the clubs to the VboxOfClubs which allows the users
	 * to see the clubs in a ordered format
	 * @param toCreate - The Club that you are adding
	 */
    public void createClub(Club toCreate)
    {
    	// Label which contains the name of the club
    	Label c = new Label(toCreate.getName());
    	
    	// HBox which will display the information about the Club horizontally
        HBox root = new HBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        
        // Spacer used to format how the "View" button and the Club name are spaced
        final Pane spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(10, 1);
        
        // Button that allows the user to view the information about the Club
        final Button right = new Button("View");
        right.setOnAction(new EventHandler<ActionEvent>() 
        {
        	// This method handles the event when the "View" button is clicked
        	@Override
        	public void handle(ActionEvent event)
        	{
        		// Loads the SingleClubView Scene
        		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClubFinder/SingleClubView.fxml"));
                Parent root = null;
				try {
					root = loader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				//Creates an instance of the controller for the SingleClubView file
                SingleClubController SingleClubC = loader.<SingleClubController>getController();
                
                //Send the toCreate club into the singleClubController to add the information to the scene
                SingleClubC.InitClubValues(new Club(toCreate));
                
                //Creates and displays the scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle(toCreate.getName());
                stage.setScene(scene);
                stage.show();
        		
        		
        	}
        });
        right.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);

        // Adds the label space and the button to the HBox
        root.getChildren().addAll(c, spacer, right);
    	
    	// Adds the HBox to VboxOfClubs
    	VboxOfClubs.getChildren().add(root);
    }
    
    
    /**
     * This method updates the VBoxLayout which allows the the list of the clubs to be shown
     */
    public void addToScroll() 
    {
    	VBoxLayout.getChildren().add(VboxOfClubs);
    }
    
    
    /**
     * Setter method that is used to pass in the previous stage
     * 
     * @param currentStage - The stage that the caller is passing in to the controller
     */
    
    public void setStage(Stage currentStage) 
    {
    	// We do not create a new currentStage because we need the reference of the currentStage from the caller
    	this.currentStage = currentStage;
    }
    
    /**
     * Setter method that is used to set the previousScene instance variable
     * 
     * @param previousScene - The previous scene that you want to go back to
     */
    public void setPreviousScene(Scene previousScene) 
    {
    	// Note we do not create a new previous scene, because we want to save the state of the previous scene
    	this.previousScene = previousScene;
    }
    
    
    /**
     * This method handles the event when the BackButton is clicked
     * 
     * @param event - An ActionEvent object that is passed into the method when the BackButton is clicked
     */
    @FXML
    public void OnButtonClick(ActionEvent event){
    	
    	// Changes the title of the Scene
        currentStage.setTitle("Club Finder");
        
        // Changes to the previousScene
        currentStage.setScene(previousScene);
        currentStage.show();
    }

}
