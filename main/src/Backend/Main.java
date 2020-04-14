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
			String userChoiceString = new String(input.nextLine());
			try {
				userChoice = Integer.parseInt(userChoiceString);
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Invalid input");
			}
			
		}
		
		/** this block of code is for accessing features based on the user input for which
		 * feature they would like to use
		 */
		if(userChoice == 1) 
		{
			ClubPerson p2 = getInitialClubPerson(input,p1);
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
			
			String actionString = new String(input.nextLine());
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
		//Take input for user name
		System.out.println("Enter your name: ");
		String name = new String(input.nextLine());

		System.out.println("Enter year of study: ");
		String YOSString;	
		int YOS = -1;
		while(YOS==-1) {
			YOSString = new String(input.nextLine());
			try {
				YOS = Integer.parseInt(YOSString);
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Invalid input");
			}
			
		}
		
		
		//Take input foe user major and minor
		System.out.println("Enter your major: ");
		String Major = new String(input.nextLine());
		System.out.println("Enter your minor: ");
		String Minor = new String(input.nextLine());
		
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
			currInt = new String(input.nextLine());
			if(!currInt.equals(""))
			interests.add(new String(currInt));
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
			currFac = new String(input.nextLine());
			fac.add(new String(currFac));
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
		
		double tuition = validateFinanceInput(input,"Invalid input: Input must be a positive double");

		System.out.println("Enter the amount in your savings account: ");
		double savings = validateFinanceInput(input,"Invalid input: Input must be a positive double");
		
		
		String expense;
		String monthExpense;
		
		/** this block of code is for getting input from the user regarding their weekly
		 * expenses and also checks for invalid input
		 */
		do 
		{
			System.out.println("Enter all weekly expenses: ");
			expense = new String(input.nextLine());
			if(!expense.equals("")) {
				try {
					currWeeklyExpense = Double.parseDouble(expense);
					if(currWeeklyExpense<0)
						throw new NumberFormatException("Negative double");
					allWeeklyExpenses.add(new Double(currWeeklyExpense));
				}
				catch(NumberFormatException nfe)
				{
					System.out.println("Invalid input: Input must be a positive double");
				}
			}
		}while(!expense.equals(""));
		
		/** this block of code is for getting input from the user regarding their monthly
		 * expenses and also checks for invalid input
		 */
		do 
		{
			System.out.println("Enter all monthly expenses: ");
			monthExpense = new String(input.nextLine());
			
			if(!monthExpense.equals("")) {
				try {
					currMonthlyExpense = Double.parseDouble(monthExpense);
					if(currMonthlyExpense<0)
						throw new NumberFormatException("Negative double");
					allMonthlyExpenses.add(new Double(currMonthlyExpense));
				}
				catch(NumberFormatException nfe)
				{
					System.out.println("Invalid input: Input must be a positive double");
				}
			}
		}while(!monthExpense.equals(""));
		
		//Take input for user's finances
		System.out.println("Enter your weekly income: ");
		double weeklyIncome =  validateFinanceInput(input,"Invalid input: Input must be a positive double");
		
		System.out.println("Enter your weekly budget: ");
		double weeklyBudget =  validateFinanceInput(input,"Invalid input: Input must be a positive double");
		
		System.out.println("Enter your long-term goal amount: ");
		double longTermGoal =  validateFinanceInput(input,"Invalid input: Input must be a positive double");
		
		System.out.println("Enter your long-term goal period in months: ");
		
		/** this block of code is for getting input from the user regarding their long-term
		 * goal period and also checks for invalid input
		 */
		int longTermGoalMonthBased = -1;
		while(longTermGoalMonthBased==-1) {
			String strLongTermGoalMonthBased = new String(input.nextLine());
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
	
	/** double validateFinanceInput(Scanner input, String error)
	 * This method checks if the String input can be parsed into a Double, then checks if 
	 * the input is negative, which then throws a NumberFormatException error
	 * @return ret - A double which represents the correct input 
	 */
	private static double validateFinanceInput(Scanner input,String error) 
	{
		double ret = -1;
		while(ret==-1) {
			String strRet = new String(input.nextLine());
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