package Backend;
import java.util.Scanner;

/**
 * This class implements the functionality of the Club Finder feature, particularly sorting 
 * and displaying clubs based on the user's inputted preferences.
 */

public class ClubApp implements MainApp{
	
	//ClubList containing all clubs
	ClubList masterClubList;
	
	//ClubPerson representing the user's club-related profile
	ClubPerson currentPerson;
	
	//File reader for navigating the file containing clubs
	ReadFile reader;
	
	/** ClubApp(String, ClubPerson)
	 * ClubApp Constructor
	 *  
	 * @param data - Name of the file containing club information
	 * @param currentPerson - The instance of the user's club-related profile
	 * */
	
	public ClubApp(String data,ClubPerson currentPerson) 
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
	
	
	/** ClubList(String)
	 * Reads the data in the club information file
	 * 
	 * @param data - Name of the file containing club information
	 * @return A ClubList object containing information about all the clubs in the given file
	 * */

	private ClubList ReadData(String data) throws Exception
	{
		reader = new ReadFile(data);
		return reader.readClubData();
	}
	
	
	/** displayMenu()
	 * Prints the main menu of the club app to the console
	 * */

	public void displayMenu() 
	{
		System.out.println("Please enter an option below: ");
		System.out.println("1: Get recommended clubs");
		System.out.println("2: View all clubs");
		System.out.println("3: Update current information");
		System.out.println("4: Exit");
	}
	
	
	/** displayRecommended()
	 * Prints a list of recommended clubs to the console
	 * */

	private void displayRecommended() 
	{
		currentPerson.InitializeRecommended(masterClubList);
		ClubList currClubList = currentPerson.getRecommended();
		System.out.println(currClubList.toString());
		displayClub(currClubList);
	}
	
	/** displayMasterClub()
	 * Prints a list of all the clubs to the console
	 * */

	private void displayMasterClub() 
	{
		System.out.println(masterClubList.toString());
		displayClub(masterClubList);
	}
	
	/** displayUpdateUserPrompt()
	 * Prints the current information of the user's main and club-related profiles
	 * */

	private void displayUpdateUserPrompt() 
	{
		currentPerson.displayInfo();

		System.out.println();
	}
	
	
	/** UpdateUser()
	 * Allows the user to change the values stored in their profile
	 * */

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
		int option = scan.nextInt();

		switch (option) {
		case 1:
			Scanner name = new Scanner(System.in);
			System.out.println("Enter Name: ");
			String newName = name.nextLine();
			currentPerson.setName(newName);
		break;

		case 2:
			Scanner YOS = new Scanner(System.in);
			System.out.println("Enter Year of Study: ");
			int newYOS = YOS.nextInt();
			currentPerson.setYOS(newYOS);

			break;

		case 3: 
			Scanner major = new Scanner(System.in);
			System.out.println("Enter Major: ");
			String newMajor = major.nextLine();
			currentPerson.setMajor(newMajor);
			break;

		case 4:
			Scanner minor = new Scanner(System.in);
			System.out.println("Enter Minor: ");
			String newMinor = minor.nextLine();
			currentPerson.setMinor(newMinor);
			break;


		case 5:
			Scanner interests = new Scanner(System.in);
			System.out.println("Do you want to add or remove interests? (add/rem): ");
			String response = interests.nextLine();
			String newInterest;
			String remInterest;
			if (response.equals("add")) {
				do {
				System.out.println("Enter interest(s) to add: ");
				newInterest = interests.nextLine();	
				if(!newInterest.equals(""))
					currentPerson.addInterest(newInterest);
				}
				while(!newInterest.contentEquals("")); 

			}

			if (response.equals("rem")) {
				do {
					System.out.println("Enter interest(s) to remove: ");
					remInterest = interests.nextLine();
					currentPerson.removeInterest(remInterest);

				}while(!remInterest.contentEquals(""));

			}



			break;


		case 6:
			Scanner fac = new Scanner(System.in);
			System.out.println("Do you want to add or remove a faculty? (add/rem): ");
			String response2 = fac.nextLine();
			String newFac;
			String remFac;
			if (response2.equals("add")) {
				do {
				System.out.println("Enter faculty to add: ");
				newFac = fac.nextLine();	
				currentPerson.addFaculty(newFac);
				}
				while(!newFac.contentEquals("")); 

			}

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
	
	/** displayClub(ClubList)
	 * Prints information about a specific, user-chosen club to the console
	 * 
	 * @param list - ClubList containing information about the possible clubs the 
	 * user could choose to view
	 * */

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
			
			if(response==-1)
				break;

			Club returnedClub = list.getClub(response-1);
			
			
			if(returnedClub==null)
				System.out.println("Invalid club number");
			else
				System.out.println(returnedClub.toString());
		}while(response!=-1);


	}
	
	
	/** performAction(int)
	 * Implements MainApp's method. Allows user to utilize the Club Finder's features
	 * 
	 *  
	 * @param action - Integer (between 1 and 4) indicating which feature in the Club Finder
	 * the user would like to use
	 * @return A boolean determining whether or not the input integer was 4
	 * */

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
