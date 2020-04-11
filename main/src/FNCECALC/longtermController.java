package FNCECALC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class longtermController {

	private Scene previousScene;
	
	private Stage currentStage;
		
	@FXML
    private Text LongTermResult;

    public void setText(String s)
    {
    	LongTermResult.setText(s);
    }
    
	public void setStage(Stage currStage) 
	{
		currentStage = currStage;
	}
	
	public void setPreviousScene(Scene scene) 
	{
		previousScene = scene;
	}

    @FXML
    void buttonOnClick(ActionEvent event) {
    	currentStage.setScene(previousScene);
    	currentStage.show();
    }
    
    
}
