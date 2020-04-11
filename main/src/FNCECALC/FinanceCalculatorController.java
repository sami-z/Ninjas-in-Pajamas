package FNCECALC;

import Backend.FinancePerson;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.*;
import java.io.IOException;

public class FinanceCalculatorController {
	
	public Stage main;
	FinancePerson person;
	
	private Button expButton;
	
	private Button savButton;
	
	private Button budgButton;
	
	private Button longButton;
	
	private Button backButton;
	
	void expOnClick(ActionEvent event) throws Exception{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FNCECALC/WeeklyExpend.fxml"));
		Parent root = loader.load();
		
	}
	
	public void setFinancePerson(FinancePerson person) 
	{
		this.person = person;
	}
}
