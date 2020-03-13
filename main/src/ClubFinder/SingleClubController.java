package ClubFinder;

import Backend.Club;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class SingleClubController {
    @FXML
    private Text linkText;

    @FXML
    private Text nameText;

    @FXML
    private Text descriptionText;
    
    @FXML
    private Text interestsText;

    
	public void InitClubValues(Club c) 
	{
		linkText.setText(c.getLink());
		nameText.setText(c.getName());
		descriptionText.setText(c.getDescription());
		interestsText.setText(""+c.getNumbOfInterest());
	}
}
