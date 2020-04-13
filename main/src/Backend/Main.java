package Backend;
import java.util.ArrayList;
import java.util.Scanner;

/** Main class
 * Makes use of other classes in the Backend package to tie the 
 * whole program together, including profile information and
 * feature functionality.
 */

public class Main {

	// Instance variable of type MainApp for the functionality of the program
	private static MainApp app;

	// Instance variable to read the file(s) for club information
	private static ReadFile reader;

	/** main(String[] args)
	 * This method runs the program by first creating a user profile and printing out the 
	 * main menu, then calling on other classes and methods to execute the functionality
	 * of the three features.
	 * 
	 * @param args - Unused.
	 * */

	public static void main(String[] args) 
	{
		
		Scanner input = new Scanner(System.in);
		MasterPerson p1 = getInitialMasterPerson(input);
		
		System.out.println("Which of the following 3 features would you like to use?");
		System.out.println("1: Get information about clubs you're interested in!");
		System.out.println("2: Get information about your finances and budget your expenses!");
		System.out.println("3: GPA Calculator");
		
		int userChoice = -1;
		while(userChoice==-1) {
			String userChoiceString = input.nextLine();
			try {
				userChoice = Integer.parseInt(userChoiceString);
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Invalid input");
			}
			
		}
		
		if(userChoice == 1) 
		{
			ClubPerson  p2 = getInitialClubPerson(input,p1);
			app = new ClubApp("data.txt",p2);
		}
		else if(userChoice == 2) 
		{
			FinancePerson p3 = getInitialFinancePerson(input,p1);
			app = new FinanceApp(p3);
		}
		else if (userChoice==3) 
		{
			app = new GPAApp(p1);
		}
		
		boolean Condition;

		do {
			app.displayMenu();
			
			String actionString = input.nextLine();
			int action = -1;
			try {
				action = Integer.parseInt(actionString);
			}
			catch(NumberFormatException nfe) 
			{
			}
			
			Condition = app.performAction(action);
		}while(Condition);

	}


	/** displayInterestMapping()
	 * Reads the file containing the list of interest options and prints 
	 * it to the console.
	 * */


	public static void displayInterestMapping() 
	{
		reader = new ReadFile("map.txt");
		reader.displayMap();
	}

	/** getInitialMasterPerson(Scanner)
	 * Creates an instance of MasterPerson representing the current user
	 * 
	 * @param input - A Scanner object used to gather profile
	 * information from the user
	 */


	public static MasterPerson getInitialMasterPerson(Scanner input)
	{
		System.out.println("Enter your name: ");
		String name = input.nextLine();

		System.out.println("Enter year of study: ");
		String YOSString;	
		int YOS = -1;
		while(YOS==-1) {
			YOSString = input.nextLine();
			try {
				YOS = Integer.parseInt(YOSString);
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Invalid input");
			}
			
		}
		
		
		
		System.out.println("Enter your major: ");
		String Major = input.nextLine();
		System.out.println("Enter your minor: ");
		String Minor = input.nextLine();
		
		MasterPerson p1 = new MasterPerson(name, YOS, Major, Minor);
		
		return p1;
	}

	/** getInitialClubPerson(Scanner, MasterPerson)
	 * Creates an instance of ClubPerson representing the current user. 
	 * 
	 * @param input - A Scanner object used to gather profile
	 * information from the user
	 * @param p1 - The instance of MasterPerson that represents the current
	 * user. It is used to establish the non-club related aspects of the profile.
	 */
	
	public static ClubPerson getInitialClubPerson(Scanner input, MasterPerson p1) 
	{
		ArrayList<String> interests = new ArrayList<String>();
		ArrayList<String> fac = new ArrayList<String>();
		String currFac;
		String currInt;

		displayInterestMapping();
		do 
		{
			System.out.println("Enter your interest(s) based on the above mapping");
			currInt = input.nextLine();
			if(!currInt.equals(""))
			interests.add(currInt);
		}while(!currInt.equals(""));

		do 
		{
			System.out.println("1.1|Faculty of Science");
			System.out.println("1.2|Faculty of Arts");
			System.out.println("1.3|Faculty of Social Work");
			System.out.println("1.4|Faculty of Kinesiology");
			System.out.println("1.5|Faculty of Health Science");
			System.out.println("1.6|Faculty of Nursing");
			System.out.println("1.7|Schulich School of Engineering");
			System.out.println("1.8|Haskayne School of Business");
			System.out.println("1.9|Werklund School of Education");
			System.out.println("1.10|Pre-Graduate Societies");
			System.out.println("1.11|Graduate Societies");

			System.out.println("Enter faculty(ies) you belong to based on the above mapping");
			currFac = input.nextLine();
			fac.add(currFac);
		}while(!currFac.equals(""));

		ClubPerson p2 = new ClubPerson(p1.getName(),p1.getYOS(),p1.getMajor(),p1.getMinor(),interests,fac);

		return p2;
	}

	/** getInitialFinancePerson(Scanner, MasterPerson)
	 * Creates an instance of FinancePerson representing the current user
	 * 
	 * @param input - A Scanner object used to gather profile
	 * information from the user
	 * @param p1 - The instance of MasterPerson that represents the current
	 * user. It is used to establish the non-finance related aspects of the profile.
	 */
	
	public static FinancePerson getInitialFinancePerson(Scanner input, MasterPerson p1)
	{
		
		ArrayList<Double> allWeeklyExpenses = new ArrayList<Double>();
		ArrayList<Double> allMonthlyExpenses = new ArrayList<Double>();
		double currWeeklyExpense;
		double currMonthlyExpense;
		System.out.println("Enter your yearly tuition: ");
		
		double tuition = ValidateFinanceInput(input,"Invalid input: Input must be a positive double");

		System.out.println("Enter the amount in your savings account: ");
		double savings = ValidateFinanceInput(input,"Invalid input: Input must be a positive double");
		
		
		String expense;
		String monthExpense;
		
		do 
		{
			System.out.println("Enter all weekly expenses: ");
			expense = input.nextLine();
			if(!expense.equals("")) {
				try {
					currWeeklyExpense = Double.parseDouble(expense);
					if(currWeeklyExpense<0)
						throw new NumberFormatException("Negative double");
					allWeeklyExpenses.add(currWeeklyExpense);
				}
				catch(NumberFormatException nfe)
				{
					System.out.println("Invalid input: Input must be a positive double");
				}
			}
		}while(!expense.equals(""));
		
		do 
		{
			System.out.println("Enter all monthly expenses: ");
			monthExpense = input.nextLine();
			
			if(!monthExpense.equals("")) {
				try {
					currMonthlyExpense = Double.parseDouble(monthExpense);
					if(currMonthlyExpense<0)
						throw new NumberFormatException("Negative double");
					allMonthlyExpenses.add(currMonthlyExpense);
				}
				catch(NumberFormatException nfe)
				{
					System.out.println("Invalid input: Input must be a positive double");
				}
			}
		}while(!monthExpense.equals(""));
		
		System.out.println("Enter your weekly income: ");
		double weeklyIncome =  ValidateFinanceInput(input,"Invalid input: Input must be a positive double");
		
		System.out.println("Enter your weekly budget: ");
		double weeklyBudget =  ValidateFinanceInput(input,"Invalid input: Input must be a positive double");
		
		System.out.println("Enter your long-term goal amount: ");
		double longTermGoal =  ValidateFinanceInput(input,"Invalid input: Input must be a positive double");
		
		System.out.println("Enter your long-term goal period in months: ");
		
		int longTermGoalMonthBased = -1;
		while(longTermGoalMonthBased==-1) {
			String strLongTermGoalMonthBased = input.nextLine();
			try {
				longTermGoalMonthBased = Integer.parseInt(strLongTermGoalMonthBased);
				if(longTermGoalMonthBased<0)
					throw new NumberFormatException("Negative double");
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Please enter a positive integer");
			}
			
		}
		
		FinancePerson p3 = new FinancePerson(p1.getName(),p1.getYOS(),p1.getMajor(),p1.getMinor(), tuition, savings, allWeeklyExpenses, allMonthlyExpenses, longTermGoal, longTermGoalMonthBased, weeklyIncome, weeklyBudget);
		return p3;
	} 
	
	private static double ValidateFinanceInput(Scanner input,String error) 
	{
		double ret = -1;
		while(ret==-1) {
			String strRet = input.nextLine();
			try {
				ret = Double.parseDouble(strRet);
				if(ret<0)
					throw new NumberFormatException("Negative double");
			}
			catch(NumberFormatException nfe)
			{
				System.out.println(error);
			}
			
		}
		
		return ret;
	}
	
	

}