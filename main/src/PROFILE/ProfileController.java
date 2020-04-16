package PROFILE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import Backend.MasterPerson;
import Backend.ClubList;
import Backend.ClubPerson;
import Backend.FinancePerson;
import Backend.ReadFile;
import ClubFinder.ViewClubController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import FNCECALC.FinanceCalculatorController;

/**
 * This class handles and validates the input for the user in the profie screen.
 * This class also contains methods that allow the MainController get a FinancePerson object
 * and a ClubPerson Object
 *
 */
public class ProfileController {
	
	private ObservableList<String> YOSlist = FXCollections.observableArrayList("1", "2", "3", "4", "5+");
	
	// Stage that holds the current stage
	private Stage CurrentStage;
	
	// The club profile scene
	private Scene ClubInfoScene;
	
	// The finance profile scene
	private Scene FinanceScene;
	
	//The controller for the Finance profile scene
	private FinanceProfileController FinanceController;
	
	// The controller for the club profile scene
	private ClubInfoProfileController ClubController;
	
	// The textfield that contains the information about the users minor
    @FXML
    private TextField minorTextField;
    
    // The textfield that contains the information about the users major
    @FXML
    private TextField majorTextField;
	
    // The textfield that contains the information about the users name
	@FXML
	private TextField nameField;
	
	// Choicebox used for the YOS variable
	@FXML
	private ChoiceBox YOSchoiceBox;
	
	// The Button Object for the Club profile scene
    @FXML
    private Button ClubInfoButton;
	
    // The Button Object for the Finance profile scene
    @FXML
    private Button financeButton;
    
	
	/**
	 * This method is used to return a MasterPerson Object to the main controller
	 * 
	 * @return MasterPerson - returns a MasterPerson from the information in this scene
	 */
	public MasterPerson getMasterPerson()
	{
		return new MasterPerson(nameField.getText(), 1, majorTextField.getText(), minorTextField.getText());
	}
	
	/**
	 * This method is called when the Profile scene is created, the method initializes the values for the ChoiceBox,
	 * and loads the scenes for the FinanceProfile and ClubProle
	 * @throws IOException - Potential IOException that may occur when loading the scene
	 */
	@FXML
	private void initialize() throws IOException{
		
		//Initializes the Choice by setting the text and values
		YOSchoiceBox.setValue("Select");
		YOSchoiceBox.getItems().removeAll(YOSchoiceBox.getItems());
		YOSchoiceBox.getItems().addAll("1", "2", "3", "4", "5+");
		
		//Loads the ClubInfoProfile scene and creates the ClubController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/PROFILE/ClubInfoProfile.fxml"));
        Parent root = loader.load();
        ClubController = loader.<ClubInfoProfileController>getController();
        
        // Reads the interest mapping using ReadFile, this mapping is used in the ClubInfo Scene
        ReadFile reader = new ReadFile("map.txt");
        HashMap<String,String> map = reader.readMap();
        ArrayList<String> keys = reader.getKeys();
        
        // Loops through the interest mapping and adds the interest into the ClubInfo Scene
        for(String key : keys) 
        {
        	ClubController.createInterest(key, map.get(key));
        }
        ClubInfoScene = new Scene(root);
        
        //Creates the FinanceScene and the FinanceController
        FXMLLoader FinanceLoader = new FXMLLoader(getClass().getResource("/PROFILE/FinanceProfile.fxml"));
        Parent FinanceRoot = FinanceLoader.load();
        FinanceController = FinanceLoader.<FinanceProfileController>getController();
        FinanceScene = new Scene(FinanceRoot);

	}
	
    /**
     * Setter method that is used to pass in the previous stage
     * 
     * @param c - The stage that the caller is passing in to the controller
     */
	public void setStage(Stage c) 
	{
		CurrentStage = c;
	}
	
	/**
	 * This method handles the event when the ClubInfoButton is clicked, the method changes the scene to the
	 * ClubInfoProfile scene
	 * 
	 * @param event - ActionEvent that is passed in as a parameter when the financeButton is pressed
	 */
	
	@FXML
	public void ClubInfoButtonOnClick(ActionEvent event)throws Exception {
        //controller.setStage(CurrentStage);
		ClubController.setStage(CurrentStage);
		ClubController.setPreviousScene(nameField.getScene());
        CurrentStage.setScene(ClubInfoScene);
        CurrentStage.show();
	}
	
	/**
	 * This method is used to return a ClubPerson Object to the main controller so that it can be used
	 * in the Club Finder 
	 * 
	 * @return ClubPerson - returns an instance ClubPerson from the ClubInforProfile scene
	 */
	
	public ClubPerson getClubPerson() 
	{
		return new ClubPerson(nameField.getText(), 1, majorTextField.getText(), minorTextField.getText(), ClubController.getInterests(),  ClubController.getFaculties());
	}
	
	/**
	 * This method handles the event when the financeButton is clicked, the method changes the scene to the
	 * FinanceProfile scene
	 * 
	 * @param event - ActionEvent that is passed in as a parameter when the financeButton is pressed
	 */
	@FXML
    private void financeButtonOnClick(ActionEvent event) {
		
		//Changes the scene
		CurrentStage.setScene(FinanceScene);
		
		//initializes values for the scene via the FinanceController
		FinanceController.setMasterPerson(new MasterPerson(nameField.getText(), 1, majorTextField.getText(), minorTextField.getText()));
		FinanceController.setPreviousScene(nameField.getScene());
		FinanceController.setStage(CurrentStage);
		CurrentStage.show();
    }
	
	/**
	 * This method is used to return a FinancePerson Object to the main controller
	 * 
	 * @return FinancePerson - returns a FinanacePerson from the FinanceProfile scene
	 */
	public FinancePerson getFinancePerson() 
	{
		FinanceController.setMasterPerson(new MasterPerson(nameField.getText(), 1, majorTextField.getText(), minorTextField.getText()));
		return FinanceController.getFinancePerson();
	}
}