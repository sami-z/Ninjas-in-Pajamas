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


public class MainController {

    @FXML
    public Button gpaClick; //private?????????
    
    @FXML
    public Button profileClick;
    
    @FXML
    public Button ClubButton;
    
    
    ProfileController getInfoController;
    
    Scene profileScene = null;
/*
    @FXML
    private AnchorPane topBar;

    @FXML
    void a12525(ActionEvent event) {

    }

   // @FXML
   // void 070707(ActionEvent event) {

  //  }
*/
    
   @FXML
   public void displayGPA(ActionEvent event) throws IOException {	
            Parent root = FXMLLoader.load(getClass().getResource("/GPACALC/GPA.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("GPA CALCULATOR");
            stage.setScene(scene);
            stage.show();
            
        }
    	
    @FXML
    public void displayProfile(ActionEvent event) throws IOException {	
    	if(profileScene == null) {
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
    	else 
    	{
            Stage stage = new Stage();
            getInfoController.setStage(stage);
             
            stage.setTitle("PROFILE");
            stage.setScene(profileScene);
            stage.show();
    	}
             
      }
    
    @FXML
    void displayFinance(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FNCECALC/FNCE.fxml"));
        Parent root = loader.load();
        FinanceCalculatorController controller1 = loader.<FinanceCalculatorController>getController();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        controller1.setStage(stage);
        if(getInfoController == null) {
        	
        }else if(getInfoController.getFinancePerson() == null)
        {
        	
        }
        else
        {
        controller1.setFinancePerson(getInfoController.getFinancePerson());
        controller1.createFinancialCalculator();
        stage.setTitle("Finance Calculator");
        stage.setScene(scene);
        stage.show();
        }

    }
    
    @FXML
    public void displayClub(ActionEvent event) throws IOException {	
        //Parent root = FXMLLoader.load(getClass().getResource("/ClubFinder/Club.fxml"));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClubFinder/Club.fxml"));
        Parent root = loader.load();
        ClubMainInterfaceController controller = loader.<ClubMainInterfaceController>getController();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        controller.setStage(stage);
        if(getInfoController == null) {
        	displayProfile(new ActionEvent());
        }else
        {
	        controller.setPerson(getInfoController.getClubPerson());
	        stage.setTitle("Club Finder");
	        stage.setScene(scene);
	        stage.show();
        }
        
    }
     	
    
    
    }

