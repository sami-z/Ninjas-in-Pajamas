import java.util.ArrayList;
import java.util.Scanner;
//random stuff
public class Main {

	private static MainApp app;
	private static ReadFile reader;

	public static void main(String[] args) 
	{
		
		Scanner input = new Scanner(System.in);
		MasterPerson p1 = getInitialMasterPerson(input);
		app = new MainApp("data.txt",p1);
		boolean Condition;

		do {
			app.displayMenu();
			int action = input.nextInt();
			Condition = app.performAction(action);
		}while(Condition);

	}

	public static void displayInterestMapping() 
	{
		reader = new ReadFile("map.txt");
		reader.displayMap();
	}

	public static MasterPerson getInitialMasterPerson(Scanner input)
	{
		System.out.println("Enter name: ");
		String name = input.nextLine();

		System.out.println("Enter year of study: ");
		String YOSString = input.nextLine();
		int YOS = Integer.parseInt(YOSString);

		System.out.println("Enter Major: ");
		String Major = input.nextLine();
		System.out.println("Enter Minor: ");
		String Minor = input.nextLine();
		
		MasterPerson p1 = new MasterPerson(name, YOS, Major, Minor);
		
		return p1;
	}
	
	public static ClubPerson getInitialClubPerson(Scanner input, MasterPerson p1) 
	{
		ArrayList<String> interests = new ArrayList<String>();
		ArrayList<String> fac = new ArrayList<String>();
		String currFac;
		String currInt;

		displayInterestMapping();
		do 
		{
			System.out.println("Enter interest(s) based on the above mapping");
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

			System.out.println("Enter faculty(ies) based on the above mapping");
			currFac = input.nextLine();
			fac.add(currFac);
		}while(!currFac.equals(""));

		ClubPerson p2 = new ClubPerson(p1.getName(),p1.getYOS(),p1.getMajor(),p1.getMinor(),interests,fac);

		return p2;
	}
	
	public static FinancePerson getInitialFinancePerson(Scanner input, MasterPerson p1)
	{
		
		ArrayList<Double> allWeeklyExpenses = new ArrayList<Double>();
		ArrayList<Double> allMonthlyExpenses = new ArrayList<Double>();
		double currWeeklyExpense;
		double currMonthlyExpense;
		System.out.println("Enter your yearly tuition: ");
		double tuition = input.nextDouble();

		System.out.println("Enter the amount in your savings account: ");
		double savings = input.nextDouble();
		
		String expense;
		String monthExpense;
		
		do 
		{
			System.out.println("Enter all weekly expenses: ");
			expense = input.nextLine();
			if(!expense.equals("")) {
				currWeeklyExpense = Double.parseDouble(expense);
				allWeeklyExpenses.add(currWeeklyExpense);
			}
		}while(!expense.equals(""));
		
		do 
		{
			System.out.println("Enter all monthly expenses: ");
			monthExpense = input.nextLine();
			if(!monthExpense.equals("")) {
				currMonthlyExpense = Double.parseDouble(monthExpense);
				allMonthlyExpenses.add(currMonthlyExpense);
			}
		}while(!monthExpense.equals(""));
		
		System.out.println("Enter your long-term goal amount: ");
		double longTermGoal = input.nextDouble();
		
		System.out.println("Enter your long-term goal period in months: ");
		int longTermGoalMonthBased = input.nextInt();
		
		System.out.println("Enter your weekly income: ");
		double weeklyIncome = input.nextDouble();
		
		System.out.println("Enter your weekly budget: ");
		double weeklyBudget = input.nextDouble();
		
		FinancePerson p3 = new FinancePerson(p1.getName(),p1.getYOS(),p1.getMajor(),p1.getMinor(), tuition, savings, allWeeklyExpenses, allMonthlyExpenses, longTermGoal, longTermGoalMonthBased, weeklyIncome, weeklyBudget);
		return p3;
	} 

}