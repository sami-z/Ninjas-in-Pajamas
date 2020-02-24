import java.util.*;
public class mainApp {

	//Two instance variables needed to run the application
	ClubList masterClubList;
	Person currentPerson;
	
	//Constructor used to initializes the app
	public mainApp(String data,Person currentPerson) 
	{
		try {
		masterClubList = ReadData(data);
		masterClubList.sortClubsByAlphabet();
		}
		catch(Exception e)
		{
			System.out.println("Unable to read data");
		}
		
		this.currentPerson = currentPerson;
	}
	
	//Reads the data and returns a ClubList
	private ClubList ReadData(String data) throws Exception
	{
		readFile reader = new readFile(data);
		return reader.readClubData();
	}
	
	// Displays main menu
	public void displayMenu() 
	{
		System.out.println("Please enter an option below: ");
		System.out.println("1: Get recommended clubs");
		System.out.println("2: View all clubs");
		System.out.println("3: Update current information");
		System.out.println("4: Exit");
	}
	
	private void displayRecommended() 
	{
		currentPerson.InitializeRecommended(masterClubList);
		ClubList currClubList = currentPerson.getRecommended();
		currClubList.displayClubList();
		displayClub(currClubList);
	}
	
	private void displayMasterClub() 
	{
		masterClubList.displayClubList();
		displayClub(masterClubList);
	}
	
	private void displayUpdateUserPrompt() 
	{
		currentPerson.displayInfo();
		
		System.out.println();
	}
	
	private void UpdateUser() 
	{
		displayUpdateUserPrompt();
		
	}
	
	private void displayClub(ClubList list) 
	{
		Scanner input = new Scanner(System.in);
		String responseStr;
		int response;
		
		do 
		{
			System.out.println("Enter -1 to get back to menu");
			System.out.println("Enter the number of the club to see info");
			System.out.println();
			responseStr = input.nextLine();
			response = Integer.parseInt(responseStr);
			
			Club returnedClub = list.getClub(response-1);
			if(returnedClub==null)
				System.out.println("Invalid club number");
			else
				returnedClub.displayInfo();
		}while(response!=-1);
		
		
	}
	
	public boolean performAction(int action) 
	{
		switch(action) 
		{
		case 1:
			displayRecommended();
			break;
		case 2:
			displayMasterClub();
			break;
		case 3:
			UpdateUser();
			break;
		case 4:
			return false;
		default:
			System.out.println("Invalid input");
		}
		
		return true;
	}
	
	
}
