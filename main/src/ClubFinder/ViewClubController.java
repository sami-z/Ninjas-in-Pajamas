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

public class ViewClubController {
	
	private Stage currentStage;
	
	private Scene previousScene;

	@FXML
	private VBox VBoxLayout;
	
	@FXML
	private ScrollPane ScollPaneC;
	
    @FXML
    private Button BackButton;
	
	private VBox VboxOfClubs = new VBox();
    
    public void createClub(Club toCreate)
    {
    	Label c = new Label(toCreate.getName());
        HBox root = new HBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        
        final Pane spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(10, 1);
        final Button right = new Button("View");
        right.setOnAction(new EventHandler<ActionEvent>() 
        {
        	@Override
        	public void handle(ActionEvent event)
        	{
        		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClubFinder/SingleClubView.fxml"));
                Parent root = null;
				try {
					root = loader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                SingleClubController ha = loader.<SingleClubController>getController();
                
                ha.InitClubValues(new Club(toCreate));
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle(toCreate.getName());
                stage.setScene(scene);
                stage.show();
        		
        		
        	}
        });
        right.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);

        root.getChildren().addAll(c, spacer, right);
    	
    	
    	VboxOfClubs.getChildren().add(root);
    }
    
    public void addToScroll() 
    {
    	VBoxLayout.getChildren().add(VboxOfClubs);
    }
    
    public void setStage(Stage c) 
    {
    	currentStage = c;
    }
    
    public void setPreviousScene(Scene c) 
    {
    	previousScene = c;
    }
    
    @FXML
    public void OnButtonClick(ActionEvent event) throws IOException {
        currentStage.setTitle("Club Finder");
        currentStage.setScene(previousScene);
        currentStage.show();
    }

}
