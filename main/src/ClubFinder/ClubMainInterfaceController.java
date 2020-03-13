package ClubFinder;

import java.io.IOException;

import Backend.Club;
import Backend.ClubList;
import Backend.ReadFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ClubMainInterfaceController {
	
	public Stage main;

    @FXML
    private Button ClubButton;

    @FXML
    private Button AllButton;

    @FXML
    private Button ExitButton;

    @FXML
    void ClubOnClick(ActionEvent event) {

    }

    @FXML
    void AllOnClick(ActionEvent event) throws IOException {
    	
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClubFinder/ViewClubs.fxml"));
        Parent root = loader.load();
        ViewClubController controller = loader.<ViewClubController>getController();
        
        ReadFile reader = new ReadFile("data.txt");
        ClubList AllClubs  = reader.readClubData();
        AllClubs.sortClubsByAlphabet();
        for(int i = 0;i<AllClubs.getSize();i++) 
        {
        	controller.createClub(AllClubs.getClub(i));
        }
        
        controller.addToScroll();
        controller.setStage(main);
        
        Scene scene = new Scene(root);
        main.setScene(scene);
        main.show();
    }

    @FXML
    void ExitOnClick(ActionEvent event) {
    	main.close();
    }
    
    public void setStage(Stage or) {
    	main = or;
    }

}
