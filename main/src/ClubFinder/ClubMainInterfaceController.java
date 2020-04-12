package ClubFinder;

import java.io.IOException;

import Backend.Club;
import Backend.ClubList;
import Backend.ClubPerson;
import Backend.ReadFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * This class is the controller for the Club.fxml file. This class checks whether the user has clicked one of the three buttons,
 * and depending on the button decides to display the recommended clubs, all the clubs or exit.  
 */
public class ClubMainInterfaceController {
	
	// Instance variable which contains the currentStage the scene is on
	private Stage main;
	
	// ClubPerson object used to get information about the recommended clubs
	private ClubPerson person;
	
	// Button object for the "Get your clubs" button
    @FXML
    private Button ClubButton;

    // Button object to list all of the clubs
    @FXML
    private Button AllButton;

    // Button object to exit the club finder
    @FXML
    private Button ExitButton;

    
    /**
     * This method handles the OnAction event for the ClubButton. 
     * @param event - The ActionEvent object that is passed into the method when the ClubButton is clicked
     * @throws IOException - IOException that can be caused when reading file
     */
    @FXML
    public void ClubOnClick(ActionEvent event) throws IOException{
    	
    	//Loads the FXML scene for viewClubs
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClubFinder/ViewClubs.fxml"));
        Parent root = loader.load();
        
        //Creates an instance of the controller of the ViewClubs
        ViewClubController controller = loader.<ViewClubController>getController();
        
        //Reads the data for clubs so we can get the recommended clubs
        ReadFile reader = new ReadFile("data.txt");
        ClubList AllClubs  = reader.readClubData();
        
        //Passes the data for all clubs into the person to get the recommended clubs
        person.InitializeRecommended(AllClubs);
        
        
        // For each club the we called the createClub method in ViewClubController that creates the club in the scene
        ClubList recommendedClubs = person.getRecommended();
        for(int i = 0;i<recommendedClubs.getSize();i++) 
        {
        	controller.createClub(recommendedClubs.getClub(i));
        }
        
        controller.addToScroll();
        
        // Using setter methods to set the stage and previous scene variables in ViewClubController
        controller.setStage(main);
        controller.setPreviousScene(ClubButton.getScene());
        
        // Creates the new scene and displays it
        Scene scene = new Scene(root);
        main.setScene(scene);
        main.show();
    }
    
    /**
     * This method handles the OnAction event for the AllButton. 
     * 
     * @param event - The ActionEvent object that is passed into the method when the AllButton is clicked
     * @throws IOException - IOException that can be caused when reading file
     */

    @FXML
    public void AllOnClick(ActionEvent event) throws IOException {
    	
    	//Loads the FXML scene for viewClubs
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClubFinder/ViewClubs.fxml"));
        Parent root = loader.load();
        ViewClubController controller = loader.<ViewClubController>getController();
        
        // Reads the data for all clubs and creates a ClubList
        ReadFile reader = new ReadFile("data.txt");
        ClubList AllClubs  = reader.readClubData();
        
        // Sorts all the clubs alphabetically
        AllClubs.sortClubsByAlphabet();
        
        // Loops through all the Clubs in AllClubs and creates a clubs interface in the scene
        for(int i = 0;i<AllClubs.getSize();i++) 
        {
        	controller.createClub(AllClubs.getClub(i));
        }
        
        controller.addToScroll();
        
        // Using setter methods to set the stage and previous scene variables in ViewClubController
        controller.setStage(main);
        controller.setPreviousScene(ClubButton.getScene());
        
        // Creates the new scene and displays it
        Scene scene = new Scene(root);
        main.setScene(scene);
        main.show();
    }

    /**
     * This method handles the onClick event for the ExitButton
     * @param event - The ActionEvent object that is passed into the method when the ExitButton is clicked
     */
    @FXML
    public void ExitOnClick(ActionEvent event) {
    	
    	//Closes the stage
    	main.close();
    }
    
    /**
     * Setter method that is used to pass in the previous stage
     * @param currentStage - The stage that the caller is passing in to the controller
     */
    public void setStage(Stage currentStage) {
    	
    	// We do not create a new currentStage because we need the reference of the currentStage from the caller
    	main = currentStage;
    }
    
    /**
     * Setter method that is used to pass the ClubPerson for which the application will get the recommended clubs for
     * 
     * @param person - Club person that the ClubFinder application is going to run on
     * */
    public void setPerson(ClubPerson person) 
    {
    	this.person = new ClubPerson(person);
    }

}
