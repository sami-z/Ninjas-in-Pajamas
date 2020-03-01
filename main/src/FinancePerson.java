import java.util.*;

public class FinancePerson extends MasterPerson{
	
	private double tuition;
	private ArrayList<Double> allExpenses;
	private double longTermGoal;
	private double weeklyIncome;
	private double weeklyBudget;
	
	public FinancePerson(String name, int yos, String major, String minor, double tuition, ArrayList<Double> allExpenses, double longTermGoal, double weeklyIncome, double weeklyBudget)
	{
		super(name, yos, major, minor);
		
	}
	
	
}
