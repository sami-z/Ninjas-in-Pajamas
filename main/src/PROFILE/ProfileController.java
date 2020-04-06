package PROFILE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Backend.ClubList;
import Backend.ClubPerson;
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

public class ProfileController {
	
	ObservableList<String> YOSlist = FXCollections.observableArrayList("1", "2", "3", "4", "5+");
	Stage CurrentStage;
	
	Scene ClubInfoScene;
	
	ClubInfoProfileController ClubController;
	
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
	void enterName() {
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
	
		
	
}