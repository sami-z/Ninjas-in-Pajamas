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

public class ClubInfoProfileController {
	private ArrayList<String> interests = new ArrayList<String>();
	private ArrayList<String> fac = new ArrayList<String>();
	
	Scene PreviousScene;
	
	@FXML
	private VBox listOfInterests = new VBox();
	
	private Stage currentStage;
	
    @FXML
    private Button BackButtonOnClick;

    @FXML
    void BackButtonOnClick(ActionEvent event)throws Exception {
    	currentStage.setScene(PreviousScene);
    	currentStage.show();
    }
	
	public ArrayList<String> getInterests() 
	{
		return new ArrayList<String>(interests);
	}
	
	public ArrayList<String>getFaculties()
	{
		return new ArrayList<String>(fac);
	}
	
	public void createInterest(String mapping, String text) 
	{
		HBox root = new HBox();
		root.setPadding(new Insets(10, 10, 10, 10));
		listOfInterests.getChildren().add(root);
		
    	Label c = new Label(text);
        root.setPadding(new Insets(10, 10, 10, 10));
        
        final Pane spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(10, 1);
        final Button add = new Button("Add");
        final Button del = new Button("Remove");
        del.setDisable(true);
        add.setOnAction(new EventHandler<ActionEvent>() 
        {
        	@Override
        	public void handle(ActionEvent event)
        	{
        		
        		addInterest(mapping);
        		add.setDisable(true);
        		del.setDisable(false);
        		
        	}
        });
        add.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);

        del.setOnAction(new EventHandler<ActionEvent>() 
        {
        	@Override
        	public void handle(ActionEvent event)
        	{
        		removeInterest(mapping);
        		add.setDisable(false);
        		del.setDisable(true);
        	}
        });
        del.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);
        
        root.getChildren().addAll(c, spacer, add,del);
	}
	
	public void addInterest(String key) 
	{
		if(!interests.contains(key))
			interests.add(new String(key));
		System.out.println(interests.toString());
	}
	
	public void removeInterest(String toRemove) 
	{
		interests.remove(toRemove);
	}
	
	public void setStage(Stage c) 
	{
		currentStage = c;
	}
	
	public void setPreviousScene(Scene c) 
	{
		PreviousScene = c;
	}
	
}
