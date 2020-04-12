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
	
    @FXML
    private Button ClubButton;

    @FXML
    private Button AllButton;

    @FXML
    private Button ExitButton;

    
    /**
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    public void ClubOnClick(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClubFinder/ViewClubs.fxml"));
        Parent root = loader.load();
        ViewClubController controller = loader.<ViewClubController>getController();
        
        ReadFile reader = new ReadFile("data.txt");
        ClubList AllClubs  = reader.readClubData();
        person.InitializeRecommended(AllClubs);
        
        ClubList recommendedClubs = person.getRecommended();
        System.out.println(recommendedClubs.getSize());
        for(int i = 0;i<recommendedClubs.getSize();i++) 
        {
        	controller.createClub(recommendedClubs.getClub(i));
        }
        
        controller.addToScroll();
        controller.setStage(main);
        controller.setPreviousScene(ClubButton.getScene());
        
        Scene scene = new Scene(root);
        main.setScene(scene);
        main.show();
    }

    @FXML
    public void AllOnClick(ActionEvent event) throws IOException {
    	
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClubFinder/ViewClubs.fxml"));
        Parent root = loader.load();
        ViewClubController controller = loader.<ViewClubController>getController();
        
        ReadFile reader = new ReadFile("data.txt");
        ClubList AllClubs  = reader.readClubData();
        AllClubs.sortClubsByAlphabet();
        for(int i = 0;i<AllClubs.getSize();i++) 
        {
        	controller.createClub(AllClubs.getClub(i));
        }
        
        controller.addToScroll();
        controller.setStage(main);
        controller.setPreviousScene(ClubButton.getScene());
        
        Scene scene = new Scene(root);
        main.setScene(scene);
        main.show();
    }

    /**
     * This method handle the onClick event for the ExitButton
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
     * 
     * */
    public void setPerson(ClubPerson person) 
    {
    	System.out.println(person.getInterests().toString());
    	this.person = new ClubPerson(person);
    }

}
