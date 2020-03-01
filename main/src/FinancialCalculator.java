import java.util.*;

public class FinancialCalculator extends FinancePerson {
	
	public FinancialCalculator(String name, int yos, String major, String minor, double tuition, ArrayList<Double> allWeeklyExpenses, ArrayList<Double> allMonthlyExpenses, double longTermGoal, int longTermGoalMonthBased, double weeklyIncome, double weeklyBudget)
	{
		super(name, yos, major, minor, tuition, allWeeklyExpenses, allMonthlyExpenses, longTermGoal, longTermGoalMonthBased, weeklyIncome, weeklyBudget);
	}
	
	public double calculateWeeklyExpenditure()
	{
		double weeklyExpenditure = 0;
		for (Double x : getAllWeeklyExpenses()) {
			double eachWeek = x.doubleValue();
			weeklyExpenditure = weeklyExpenditure + eachWeek;
		}
		for (Double y : getAllMonthlyExpenses()) {
			double eachMonth = y.doubleValue();
			double eachWeek = eachMonth / 4;
			weeklyExpenditure = weeklyExpenditure + eachWeek;
		}
		return weeklyExpenditure;
	}
	
	public String displayWeeklyExpenditure()
	{
		String infoWeeklyExpenditure = getName() + " , your weekly expenditure is $ " + calculateWeeklyExpenditure(); 
		return infoWeeklyExpenditure;
	}
	
	public double calculateWeeklySavings()
	{
		double weeklySavings = getWeeklyIncome() - calculateWeeklyExpenditure();
		return weeklySavings;
	}
	
	public String displayWeeklySavings()
	{
		String infoWeeklySavings = "";
		
		if (calculateWeeklySavings() >= 0) {
			infoWeeklySavings = "Terrific, " + getName() + "! Your weekly savings is $ " + calculateWeeklySavings();
		} else {
			double positiveValue = calculateWeeklySavings() * (-1);
			infoWeeklySavings = "Uh oh, " + getName() + ":( Your weekly savings is -$ " + positiveValue;
		}
		return infoWeeklySavings;
	}
	
	public double calculateDailySavings()
	{
		double dailySavings = calculateWeeklySavings() / 7;
		return dailySavings;
	}
	
	public double calculateBudgetDiff()
	{
		double weeklyBudgetDiff = getWeeklyBudget() - calculateWeeklyExpenditure();
		return weeklyBudgetDiff;
	}
	
	public String displayWeeklyBudgetDiff()
	{
		String infoWeeklyBudgetDiff = "";
		
		if (calculateBudgetDiff() >= 0) {
			infoWeeklyBudgetDiff = "Yay, " + getName() + "! You are spending $ " + calculateBudgetDiff() + " less than your weekly budget";
		} else {
			double positiveValue = calculateBudgetDiff() * (-1);
			infoWeeklyBudgetDiff = "Crap, " + getName() + ":( You are spending $ " + positiveValue + " more than your weekly budget";
		}
		return infoWeeklyBudgetDiff;
	}
	
	public String displayLongTermGoalInfo()
	{
		int totalDays = getLongTermGoalMonthBased() * 30;
		double totalSavings = calculateDailySavings() * totalDays;
		return null;
	}
}
