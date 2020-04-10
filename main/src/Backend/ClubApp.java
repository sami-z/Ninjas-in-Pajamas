package Backend;
import java.util.Scanner;

/**
 * This class contains the functionality for the club finder feature,
 * in particular sorting and displaying information about clubs
 * based on the user's preferences.
 */

public class ClubApp implements MainApp{
	
	// Instance variable which contains all the Clubs
	private ClubList masterClubList;
	
	// Instance variable which contains the information pertaining to the currentPerson using ClubApp
	private ClubPerson currentPerson;
	
	
	/**
	 * ClubApp constructor  
	 * @param data - The filename for the file which contains the data on the Clubs
	 * @param currentPerson - The object of type ClubPerson for which the ClubApp is using to get the clubs for
	 */
	public ClubApp(String data, ClubPerson currentPerson) 
	{
		try {
		masterClubList = ReadData(new String(data));
		masterClubList.sortClubsByAlphabet();
		}
		catch(Exception e)
		{
			System.out.println("Unable to read data");
		}

		this.currentPerson = currentPerson;
	}

	/**
	 * Helper method used to read Club data from a file and return this data in the form
	 * of a ClubList
	 * 
	 * @param data - The filename for the file which contains the data on the Clubs
	 * 
	 * @return A ClubList which contains all Clubs that were stored within the file
	 * 
	 * @throws Exception
	 */
	private ClubList ReadData(String data) throws Exception
	{
		ReadFile reader = new ReadFile(new String(data));
		return reader.readClubData();
	}

	/**
	 * Implements the displayMenu() method from the mainApp interface
	 * the method displays the main menu for ClubApp 
	 */
	public void displayMenu() 
	{
		System.out.println("Please enter an option below: ");
		System.out.println("1: Get recommended clubs");
		System.out.println("2: View all clubs");
		System.out.println("3: Update current information");
		System.out.println("4: Exit");
	}

	/**
	 * Displays the list of recommended clubs for the user, then goes to displayClub() to allow user pick out
	 * individual clubs 
	 */
	private void displayRecommended() 
	{
		// Initializes the list of recommended Clubs
		currentPerson.InitializeRecommended(masterClubList);
		ClubList currClubList = currentPerson.getRecommended();
		
		// Displays the recommended clubs
		System.out.println(currClubList.toString());
		
		displayClub(currClubList);
	}

	/**
	 * Displays the list of all clubs for the user, then goes to displayClub() to allow user pick out
	 * individual clubs
	 */
	
	private void displayMasterClub() 
	{
		System.out.println(masterClubList.toString());
		displayClub(masterClubList);
	}

	
	/**
	 * Displays the current user information
	 */
	private void displayUpdateUserPrompt() 
	{
		currentPerson.displayInfo();

		System.out.println();
	}

	
	/**
	 * This method allows the user to update there Name, Year of Study, Major, Minor, Interests and faculty
	 */
	private void UpdateUser() 
	{
		displayUpdateUserPrompt();
		System.out.println("Enter an option you would like to update: ");
		System.out.println("1: Name");
		System.out.println("2: Year of Study");
		System.out.println("3: Major");
		System.out.println("4: Minor");
		System.out.println("5: Interests");
		System.out.println("6: Faculty");
		System.out.println();

		Scanner scan = new Scanner(System.in);
		String optionString = scan.nextLine();
		int option = -1;
		try {
			option = Integer.parseInt(optionString);
		}
		catch(NumberFormatException nfe) 
		{
			System.out.println("Input is not an integer");
		}

		switch (option) {
		// Takes input from the user and changes the name of the user
		case 1:
			System.out.println("Enter Name: ");
			String newName = scan.nextLine();
			currentPerson.setName(newName);
			break;

		// Takes input from the user and changes their year of study
		case 2:
			System.out.println("Enter Year of Study: ");
			String newYOSString = scan.nextLine();
			int newYOS;
			// Checks if the input entered is an integer
			try {
				newYOS = Integer.parseInt(newYOSString);
			}
			catch (NumberFormatException nfe) {
				System.out.println("Input is not a number");
				break;
		    }
			currentPerson.setYOS(newYOS);
			break;

		// Takes input from the user and changes their major
		case 3: 
			System.out.println("Enter Major: ");
			String newMajor = scan.nextLine();
			currentPerson.setMajor(newMajor);
			break;
		
		// Takes input from the user and changes their minor
		case 4:
			System.out.println("Enter Minor: ");
			String newMinor = scan.nextLine();
			currentPerson.setMinor(newMinor);
			break;


		// Takes input to add/rem interests from the users interests
		case 5:
			System.out.println("Do you want to add or remove interests? (add/rem): ");
			String response = scan.nextLine();
			String newInterest;
			String remInterest;
			
			//Adds an interest to the currentPerson object
			if (response.equals("add")) {
				do {
				System.out.println("Enter interest(s) to add: ");
				newInterest = scan.nextLine();	
				if(!newInterest.equals(""))
					currentPerson.addInterest(newInterest);
				}
				while(!newInterest.contentEquals("")); 

			}

			//removes an interest from the currentPerson object
			if (response.equals("rem")) {
				do {
					System.out.println("Enter interest(s) to remove: ");
					remInterest = scan.nextLine();
					currentPerson.removeInterest(remInterest);

				}while(!remInterest.contentEquals(""));

			}
			break;

		
		// Takes input to add/rem faculties from the faculties the user is apart of
		case 6:
			Scanner fac = new Scanner(System.in);
			System.out.println("Do you want to add or remove a faculty? (add/rem): ");
			String response2 = fac.nextLine();
			String newFac;
			String remFac;
			
			// Adds a faculty to the currentPerson object
			if (response2.equals("add")) {
				do {
				System.out.println("Enter faculty to add: ");
				newFac = fac.nextLine();	
				currentPerson.addFaculty(newFac);
				}
				while(!newFac.contentEquals("")); 

			}
			
			// Removes a a faculty from the currentPerson object
			if (response2.equals("rem")) {
				do {
					System.out.println("Enter faculty to remove: ");
					remFac = fac.nextLine();
					currentPerson.removeInterest(remFac);

				}while(!remFac.contentEquals(""));

			}



			break;
		}


	}

	/**
	 * This method takes in a ClubList and allows the user to enter input to view specific clubs
	 * from a ClubsList
	 * @param list - the ClubList that the user wants to view individual Clubs from
	 */
	private void displayClub(ClubList list) 
	{
		Scanner input = new Scanner(System.in);
		String responseStr;
		int response = -1;

		do 
		{
			System.out.println("Enter -1 to get back to menu");
			System.out.println("Enter the number of the club to see info");
			System.out.println();
			
			//Takes in user input
			responseStr = input.nextLine();
			
			// Try's to convert user input into integer. If the user does not enter an integer it will
			// throw and exception and go back to the main menu
			try {
			response = Integer.parseInt(responseStr);
			}
			catch (NumberFormatException nfe) {
				System.out.println("Input is not a number");
				response = -1;
		    }
			
			// If the users input is -1 then the program will go back to the main menu
			if(response==-1)
				break;

			//Gets the Club at the index specified
			Club returnedClub = list.getClub(response-1);
			
			//If the index is not in the range of list null is returned and the club number is invalid
			if(returnedClub==null)
				System.out.println("Invalid club number");
			else
				// Display the information of the club at the specified index
				System.out.println(returnedClub.toString());
		}while(response!=-1);


	}

	/**
	 * Implements the performAction(int action) method from mainApp interface
	 * The method takes in an integer and based on the integer performs either 
	 * 1. Displaying the recommended clubs
	 * 2. Displaying all of the clubs
	 * 3. Updating user information
	 * 4. Exits the program
	 * 
	 * @param action - the integer value which decides what action to perform
	 * @return A boolean value is returned to signal whether the program should continue
	 * taking input or terminate execute of the program
	 */
	public boolean performAction(int action) 
	{
		switch(action) 
		{
		case 1:
			// If the user inputs 1 the ClubApp will display the recommended clubs
			displayRecommended();
			break;
		case 2:
			// If the user inputs 2 the ClubApp will display all of the clubs
			displayMasterClub();
			break;
		case 3:
			// If the user inputs 4 the ClubApp will allow the user to change their information
			UpdateUser();
			break;
		case 4:
			// If the user inputs 4 the method returns false and the program execution is terminated
			return false;
		default:
			System.out.println("Invalid input");
		}

		// Allows the user to continue to enter input for the program
		return true;
	}
}
