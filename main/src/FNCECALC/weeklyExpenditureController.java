package FNCECALC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import FNCECALC.FinanceCalculatorController;

public class weeklyExpenditureController {

	private Scene previousScene;
	
	private Stage currentStage;
		
	@FXML
    private Text WeeklExpResult;

    public void setText(String s)
    {
    	WeeklExpResult.setText(s);
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