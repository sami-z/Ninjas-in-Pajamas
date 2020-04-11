package FNCECALC;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import FNCECALC.FinanceCalculatorController;

public class weeklyExpenditureController {

    @FXML
    private Text displayResult1;

    public void setText(String s)
    {
    	displayResult1.setText(s);
    }
    
}