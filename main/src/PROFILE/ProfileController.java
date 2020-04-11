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


public class ProfileController {
	
	ObservableList<String> YOSlist = FXCollections.observableArrayList("1", "2", "3", "4", "5+");
	Stage CurrentStage;
	
	Scene ClubInfoScene;
	
	Scene FinanceScene;
	
	FinanceProfileController FinanceController;
	
	ClubInfoProfileController ClubController;
	

    @FXML
    private Text tuitionText;
	
    @FXML
    private TextField minorTextField;
    

    @FXML
    private TextField majorTextField;
	
	
	@FXML
	public TextField nameField;
		
	@FXML
	public ChoiceBox YOSchoiceBox;
	
    @FXML
    private Button ClubInfoButton;
			
    @FXML
    private Button financeButton;
    
	@FXML
	void nameFieldPressed(ActionEvent event) {
		
		String strName = nameField.getText();
		
	}
	
	@FXML
    void majorPressed(ActionEvent event) {
		
		String strMajor = majorTextField.getText();
    }
	
	@FXML
    void minorPressed(ActionEvent event) {
		
		String strMinor = minorTextField.getText();
	
    }
	
	public MasterPerson getMasterPerson()
	{
		return new MasterPerson(nameField.getText(), 1, majorTextField.getText(), minorTextField.getText());
	}
	
	@FXML
	private void initialize() throws Exception{
		YOSchoiceBox.setValue("Select");
		YOSchoiceBox.getItems().removeAll(YOSchoiceBox.getItems());
		YOSchoiceBox.getItems().addAll("1", "2", "3", "4", "5+");
		
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/PROFILE/ClubInfoProfile.fxml"));
        Parent root = loader.load();
        ClubController = loader.<ClubInfoProfileController>getController();
        ReadFile reader = new ReadFile("map.txt");
        HashMap<String,String> map = reader.readMap();
        ArrayList<String> keys = reader.getKeys();
        for(String key : keys) 
        {
        	ClubController.createInterest(key, map.get(key));
        }
        ClubInfoScene = new Scene(root);
        
        FXMLLoader FinanceLoader = new FXMLLoader(getClass().getResource("/PROFILE/FinanceProfile.fxml"));
        Parent FinanceRoot = FinanceLoader.load();
        FinanceController = FinanceLoader.<FinanceProfileController>getController();
        FinanceScene = new Scene(FinanceRoot);

	}
	
	public void setStage(Stage c) 
	{
		CurrentStage = c;
	}
	
	@FXML
	void ClubInfoButtonOnClick(ActionEvent event)throws Exception {
        //controller.setStage(CurrentStage);
		ClubController.setStage(CurrentStage);
		ClubController.setPreviousScene(nameField.getScene());
        CurrentStage.setScene(ClubInfoScene);
        CurrentStage.show();
	}
	
	public ClubPerson getClubPerson() 
	{
		return new ClubPerson(nameField.getText(), 1, majorTextField.getText(), minorTextField.getText(), ClubController.getInterests(),  ClubController.getFaculties());
	}
	
	@FXML
    void financeButtonOnClick(ActionEvent event) {
		CurrentStage.setScene(FinanceScene);
		FinanceController.setMasterPerson(new MasterPerson(nameField.getText(), 1, majorTextField.getText(), minorTextField.getText()));
		FinanceController.setPreviousScene(nameField.getScene());
		FinanceController.setStage(CurrentStage);
		CurrentStage.show();
    }
	
	public FinancePerson getFinancePerson() 
	{
		FinanceController.setMasterPerson(new MasterPerson(nameField.getText(), 1, majorTextField.getText(), minorTextField.getText()));
		return FinanceController.getFinancePerson();
	}
}