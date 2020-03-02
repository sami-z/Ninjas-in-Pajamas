
public class FinanceApp extends MainApp{
	
	FinancialCalculator CalcOfPerson;
	
	public FinanceApp(FinancePerson p1) 
	{
		CalcOfPerson = new FinancialCalculator(p1);
	}
	
	public void displayMenu() 
	{
		System.out.println("Please enter an option below: ");
		System.out.println("1: Display weekly expenditure");
		System.out.println("2: Display weekly savings");
		System.out.println("3: Display weekly budget progress");
		System.out.println("4: Display long term goal");
		System.out.println("5: exit");
	}
	
	public boolean performAction(int action) 
	{
		switch(action) 
		{
		case 1:
			CalcOfPerson.displayWeeklyExpenditure();
			break;
		case 2:
			CalcOfPerson.displayWeeklySavings();
			break;
		case 3:
			CalcOfPerson.displayWeeklyBudgetDiff();
			break;
		case 4:
			CalcOfPerson.displayLongTermGoalInfo();
			break;
		case 5:
			return false;
		}
		
		return true;
	}
}
