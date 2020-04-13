package GUI_PACKAGE;

import java.io.IOException;

import ClubFinder.ClubMainInterfaceController;
import GUI_PACKAGE.Main;
import PROFILE.ProfileController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import FNCECALC.FinanceCalculatorController;

/**
 * The MainController class is the controller for the GUI.fxml file.
 * This class allows the user to pick what feature they would like to use, and loads the appropriate 
 * scene
 */
public class MainController {

	//gpaClick, is the button in the GUI.fxml file that the user presses to display GPA.fxml
    @FXML
    private Button gpaClick; 
    
    //profileClick, is the button in the GUI.fxml file that the user presses to display Profile.fxml
    @FXML
    private Button profileClick;
    
    //ClubButton, is the button in the GUI.fxml file that the user presses to display Club.fxml
    @FXML
    private Button ClubButton;
    
    //Controller to access ProfileController
    private ProfileController getInfoController;
    
    //Initialized profileScene to null
    private Scene profileScene = null;

   
    /**
     * This method loads the scene GPA.fxml 
     * 
     * @param event - An action event that is triggered when the button gpaClick is pressed
     */
   @FXML
   public void displayGPA(ActionEvent event) throws IOException {	
	   		//Load scene
            Parent root = FXMLLoader.load(getClass().getResource("/GPACALC/GPA.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("GPA CALCULATOR");
            stage.setScene(scene);
            stage.show();
            
        }
   
   /**
    * This method loads the scene Profile.fxml 
    * 
    * @param event - An action event that is triggered when the button profleClick is pressed
    */	
    @FXML
    public void displayProfile(ActionEvent event) throws IOException {	
    	//Check if scene is initialized yet
    	if(profileScene == null) {
    		//Load scene
    	 	FXMLLoader loader = new FXMLLoader(getClass().getResource("/PROFILE/Profile.fxml"));
    	 	Parent root = loader.load();
    	 	getInfoController = loader.<ProfileController>getController();
            Scene scene = new Scene(root);
            profileScene = scene;
            Stage stage = new Stage();
            getInfoController.setStage(stage);
             
            stage.setTitle("PROFILE");
            stage.setScene(scene);
            stage.show();
    	}
    	// If the scene has already been initialized the program loads the previous scene
    	else 
    	{
    		//creates new stage and loads previous scene
            Stage stage = new Stage();
            getInfoController.setStage(stage);
             
            stage.setTitle("PROFILE");
            stage.setScene(profileScene);
            stage.show();
    	}
             
      }
    
    /**
     * This method loads the scene FNCE.fxml 
     * 
     * @param event - An action event that is triggered when the finance button is pressed
     */
    @FXML
    void displayFinance(ActionEvent event) throws IOException {
    	//Load Scene 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FNCECALC/FNCE.fxml"));
        Parent root = loader.load();
        //Get controller for finance scene
        FinanceCalculatorController controller1 = loader.<FinanceCalculatorController>getController();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        controller1.setStage(stage);
        //Checks if profile has been opened
        if(getInfoController == null) {
        	displayProfile(new ActionEvent());
       
        //Checks is finance person has been created
        }else if(getInfoController.getFinancePerson() == null)
        {
        	displayProfile(new ActionEvent());
        }
        //sets scene to finance scene
        else
        {
        controller1.setFinancePerson(getInfoController.getFinancePerson());
        controller1.createFinancialCalculator();
        stage.setTitle("Finance Calculator");
        stage.setScene(scene);
        stage.show();
        }

    }
    
    /**
     * This method loads the scene Club.fxml 
     * 
     * @param event - An action event that is triggered when the button ClubButtonis pressed
     */
    @FXML
    public void displayClub(ActionEvent event) throws IOException {	
        //Load Scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClubFinder/Club.fxml"));
        Parent root = loader.load();
        ClubMainInterfaceController controller = loader.<ClubMainInterfaceController>getController();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        controller.setStage(stage);
        
        //Checks if profile has been opened
        if(getInfoController == null) {
        	displayProfile(new ActionEvent());
        }else
        {
        	// Opens and displays clubs scene
	        controller.setPerson(getInfoController.getClubPerson());
	        stage.setTitle("Club Finder");
	        stage.setScene(scene);
	        stage.show();
        }
        
    }
     	
    
    
    }

