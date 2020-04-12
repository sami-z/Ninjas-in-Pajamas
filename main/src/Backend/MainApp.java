package Backend;
import java.util.Scanner;

/**
 * This interface is implemented by FinanceApp, GPAApp, and ClubApp. 
 * It consists of two methods: displayMenu() and performAction(int), 
 * which are implemented by the other classes. 
 */

public interface MainApp {
	
	public void displayMenu();
	
	public boolean performAction(int action);

} 