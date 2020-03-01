import java.util.*;

public class FinancePerson extends MasterPerson{
	
	private double tuition;
	private ArrayList<Double> allExpenses = new ArrayList<Double>();
	private double longTermGoal;
	private double weeklyIncome;
	private double weeklyBudget;
	
	public FinancePerson(String name, int yos, String major, String minor, double tuition, ArrayList<Double> allExpenses, double longTermGoal, double weeklyIncome, double weeklyBudget)
	{
		super(name, yos, major, minor);
		setTuition(tuition);
		for (double d : allExpenses) {
			addExpense(new Double(d));
		}
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
	
	public ArrayList<Double> getAllExpenses()
	{
		ArrayList<Double> newAllExpenses = new ArrayList<Double>();
		for (Double d : allExpenses) {
			newAllExpenses.add(new Double(d));
		}
		return newAllExpenses;
	}
	
	public void addExpense(Double newExpense)
	{
		allExpenses.add(new Double(newExpense));
	}
	
	public void removeExpense(Double unwantedExpense)
	{
		allExpenses.remove(new Double(unwantedExpense));
	}
}
