package Backend;

/**
 * This class contains the functionality for the financial calculator
 * feature, in particular displaying the finance menu and performing
 * the four features of the financial calculator.
 */

public class FinanceApp implements MainApp{
	
	// Instance variable of the user's financial calculator
	// used to perform the four features of the FinanceApp
	private FinancialCalculator CalcOfPerson;
	
	/** FinanceApp(FinancePerson)
	 * FinanceApp Constructor
	 * 
	 * @param p1 - The object of type FinancePerson (the user), whom the FinancialCalculator
	 * is created for
	 * */
	
	public FinanceApp(FinancePerson p1) 
	{
		CalcOfPerson = new FinancialCalculator(p1);
	}
	
	/** displayMenu()
	 * Implements the displayMenu() method from the MainApp interface.
	 * This method displays the main menu for FinanceApp
	 * */
	
	public void displayMenu() 
	{
		System.out.println("");
		System.out.println("Please enter an option below: ");
		System.out.println("1: Display weekly expenditure");
		System.out.println("2: Display weekly savings");
		System.out.println("3: Display weekly budget progress");
		System.out.println("4: Display long term goal");
		System.out.println("5: exit");
	}
	
	
	/** performAction(int)
	 * Implements the performAction(int action) method from MainApp interface
	 * The method takes in an integer and based on the integer, performs either:
	 * 1. Displaying the user's weekly expenditure
	 * 2. Displaying the user's weekly savings
	 * 3. Displaying the user's success at maintaining their weekly budget
	 * 4. Displaying the user's long term goal information
	 * 5. Exits the program
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
			System.out.println(CalcOfPerson.displayWeeklyExpenditure());
			break;
		case 2:
			System.out.println(CalcOfPerson.displayWeeklySavings());
			break;
		case 3:
			System.out.println(CalcOfPerson.displayWeeklyBudgetDiff());
			break;
		case 4:
			System.out.println(CalcOfPerson.displayLongTermGoalInfo());
			break;
		case 5:
			return false;
		}
		
		return true;
	}
}
