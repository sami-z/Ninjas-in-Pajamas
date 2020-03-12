package PROFILE;

import java.io.IOException;

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
	
	
	@FXML
	public TextField nameField;
		
	@FXML
	public ChoiceBox YOSchoiceBox;
			
	@FXML
	void enterName() {
	}
		
	@FXML
	private void initialize() {
		YOSchoiceBox.setValue("Select");
		YOSchoiceBox.getItems().removeAll(YOSchoiceBox.getItems());
		YOSchoiceBox.getItems().addAll("1", "2", "3", "4", "5+");

	}
		
		
	
}