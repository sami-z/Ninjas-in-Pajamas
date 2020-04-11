package FNCECALC;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class weeklyBudgetController {

	@FXML
    private Text displayResult3;

    public void setText(String s)
    {
    	displayResult3.setText(s);
    }
}
