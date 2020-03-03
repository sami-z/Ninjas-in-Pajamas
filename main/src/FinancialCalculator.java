import java.util.*;
import java.lang.Math.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class FinancialCalculator extends FinancePerson {
	
	public FinancialCalculator(String name, int yos, String major, String minor, double tuition, double savings, ArrayList<Double> allWeeklyExpenses, ArrayList<Double> allMonthlyExpenses, double longTermGoal, int longTermGoalMonthBased, double weeklyIncome, double weeklyBudget)
	{
		super(name, yos, major, minor, tuition, savings, allWeeklyExpenses, allMonthlyExpenses, longTermGoal, longTermGoalMonthBased, weeklyIncome, weeklyBudget);
	}
	
	public FinancialCalculator(FinancePerson p) 
	{
		super(p.getName(), p.getYOS(), p.getMajor(), p.getMinor(), p.getTuition(), p.getSavings(), p.getAllWeeklyExpenses(), p.getAllMonthlyExpenses(), p.getLongTermGoal(), p.getLongTermGoalMonthBased(), p.getWeeklyIncome(), p.getWeeklyBudget());
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
		String infoWeeklyExpenditure = "\n" + getName() + ", your weekly expenditure is $ " + String.format("%.2f", calculateWeeklyExpenditure()); 
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
			infoWeeklySavings = "\n" + "Terrific, " + getName() + "! Your weekly savings is $ " + String.format("%.2f", calculateWeeklySavings());
		} else {
			double positiveValue = calculateWeeklySavings() * (-1);
			infoWeeklySavings = "\n" + "Uh oh, " + getName() + " :( Your weekly savings is -$ " + String.format("%.2f", positiveValue);
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
			infoWeeklyBudgetDiff = "\n" + "Yay, " + getName() + "! You are spending $ " + String.format("%.2f", calculateBudgetDiff()) + " less than your weekly budget";
		} else {
			double positiveValue = calculateBudgetDiff() * (-1);
			infoWeeklyBudgetDiff = "\n" + "Crap, " + getName() + " :( You are spending $ " + String.format("%.2f", positiveValue) + " more than your weekly budget";
		}
		return infoWeeklyBudgetDiff;
	}
	
	public String displayLongTermGoalInfo()
	{
		int totalDays = getLongTermGoalMonthBased() * 30;
		double totalSavings = calculateDailySavings() * totalDays;
		double daysNeeded = getLongTermGoal() / calculateDailySavings();
		long daysNeededRounded = Math.round(daysNeeded);
		double diff = totalSavings - getLongTermGoal();
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		LocalDateTime expectedDateTime = currentDateTime.plusDays(daysNeededRounded);
		String DATE_FORMAT = "yyyy/MM/dd";
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern(DATE_FORMAT);
		
		String infoLongTermGoal = "";
		if (diff >= 0) {
			infoLongTermGoal = "\n" + "Incredible, " + getName() + "! At the rate of your income and expenditure, you will reach your long-term goal approximately by " + myFormat.format(expectedDateTime) + ", and you will have saved an additional amount of $" + String.format("%.2f", diff) + " by your desired long-term goal period";
		} else {
		
			double suggestedDailySavings = getLongTermGoal() / totalDays;
			double suggestedWeeklySavings = suggestedDailySavings * 7;
			double weeklySavingsDiff = suggestedWeeklySavings - calculateWeeklySavings();
			
			infoLongTermGoal = "\n" + "Bad news, " + getName() + " :( At the rate of your income and expenditure, you will reach your long-term goal approximately by " + myFormat.format(expectedDateTime) + ", so you will have to up your weekly savings game by $" + String.format("%.2f", weeklySavingsDiff) + " to achieve that goal by your desired long-term goal period";
		}
		return infoLongTermGoal;
	}
}
