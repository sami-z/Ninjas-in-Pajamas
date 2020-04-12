package ClubFinder;

import Backend.Club;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
/**
 * The SingleClubController class is the controller for the SingleClubView.fxml file.
 * This class sets the information in the fxml file to the information pertaining to a single club
 */
public class SingleClubController {
	
	// linkText, is the text in the SingleClubView.fxml file which contains the text for the website of the club
    @FXML
    private Text linkText;

    //nameText, is the text in the SingleClubView.fxml file which contains the text for the name of the club
    @FXML
    private Text nameText;

    //nameText, is the text in the SingleClubView.fxml file which contains the text for the description of the club
    @FXML
    private Text descriptionText;
    
    //nameText, is the text in the SingleClubView.fxml file which contains the text for the number of interests in common
    //of the club
    @FXML
    private Text interestsText;

    /**
     * This method takes in a Club as a parameter and initializes the screen for the specific club
     * that is chosen
     * 
     * @param club - The club which you are getting the information you want to display
     */
	public void InitClubValues(Club club) 
	{
		linkText.setText(club.getLink());
		nameText.setText(club.getName());
		descriptionText.setText(club.getDescription());
		interestsText.setText(""+club.getNumbOfInterest());
	}
}
