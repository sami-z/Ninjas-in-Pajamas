import java.util.*;

public class FinancePerson extends MasterPerson{
	
	private double tuition;
	private ArrayList<Double> allWeeklyExpenses = new ArrayList<Double>();
	private ArrayList<Double> allMonthlyExpenses = new ArrayList<Double>();
	private double longTermGoal;
	private double weeklyIncome;
	private double weeklyBudget;
	
	public FinancePerson(String name, int yos, String major, String minor, double tuition, ArrayList<Double> allWeeklyExpenses, ArrayList<Double> allMonthlyExpenses, double longTermGoal, double weeklyIncome, double weeklyBudget)
	{
		super(name, yos, major, minor);
		setTuition(tuition);
		for (double d : allWeeklyExpenses) {
			addWeeklyExpense(new Double(d));
		}
		for (double d : allMonthlyExpenses) {
			addMonthlyExpense(new Double(d));
		}
		setLongTermGoal(longTermGoal);
		setWeeklyIncome(weeklyIncome);
		setWeeklyBudget(weeklyBudget);
	}
	
	public double getTuition()
	{
		return this.tuition;
	}
	
	public void setTuition(double tuition)
	{
		this.tuition = tuition;
	}
	
	public double getLongTermGoal()
	{
		return this.longTermGoal;
	}
	
	public void setLongTermGoal(double longTermGoal)
	{
		this.longTermGoal = longTermGoal;
	}
	
	public double getWeeklyIncome()
	{
		return this.weeklyIncome;
	}
	
	public void setWeeklyIncome(double weeklyIncome)
	{
		this.weeklyIncome = weeklyIncome;
	}
	
	public double getWeeklyBudget()
	{
		return this.weeklyBudget;
	}
	
	public void setWeeklyBudget(double weeklyBudget)
	{
		this.weeklyBudget = weeklyBudget;
	}
	
	public ArrayList<Double> getAllWeeklyExpenses()
	{
		ArrayList<Double> newAllWeeklyExpenses = new ArrayList<Double>();
		for (Double d : allWeeklyExpenses) {
			newAllWeeklyExpenses.add(new Double(d));
		}
		return newAllWeeklyExpenses;
	}
	
	public void addWeeklyExpense(Double newExpense)
	{
		allWeeklyExpenses.add(new Double(newExpense));
	}
	
	public void removeWeeklyExpense(Double unwantedExpense)
	{
		allWeeklyExpenses.remove(new Double(unwantedExpense));
	}
	
	public ArrayList<Double> getAllMonthlyExpenses()
	{
		ArrayList<Double> newAllMonthlyExpenses = new ArrayList<Double>();
		for (Double d : allMonthlyExpenses) {
			newAllMonthlyExpenses.add(new Double(d));
		}
		return newAllMonthlyExpenses;
	}
	
	public void addMonthlyExpense(Double newExpense)
	{
		allMonthlyExpenses.add(new Double(newExpense));
	}
	
	public void removeMonthlyExpense(Double unwantedExpense)
	{
		allMonthlyExpenses.remove(new Double(unwantedExpense));
	}
}
