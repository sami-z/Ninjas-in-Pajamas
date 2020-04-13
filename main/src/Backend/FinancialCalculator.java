package Backend;
import java.util.*;
import java.lang.Math.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 * This class calculates financial information based on the user input, in particular 
 * displaying messages, such as the user's weekly expenditure, weekly savings, weekly budget
 * progress, and long-term goal progress and predictions 
 */
public class FinancialCalculator extends FinancePerson {
	
	/** FinancialCalculator constructor
	 * This constructor takes in all information related to the user and their financial profile 
	 * and creates an instance of FinancePerson
	 * 
	 * @param name - Name of the person
	 * @param year of study - The user's current year of study
	 * @param major - The major of the person
	 * @param minor - The minor of the person
	 * @param tuition - The user's yearly tuition
	 * @param savings - The amount in the user's savings account
	 * @param allWeeklyExpenses - The Double ArrayList which contains all weekly expenses of the user
	 * @param allMonthlyExpenses - The Double ArrayList which contains all monthly expenses of the user
	 * @param longTermGoal - The amount the user wants to save over a period of time
	 * @param longTermGoalMonthBased - The amount of time the user wants to achieve long-term goal by
	 * @param weeklyIncome - The user's weekly income
	 * @param weeklyBudget - The user's weekly budget
	 * 
	 * 
	 * */
	public FinancialCalculator(String name, int yos, String major, String minor, double tuition, double savings, ArrayList<Double> allWeeklyExpenses, ArrayList<Double> allMonthlyExpenses, double longTermGoal, int longTermGoalMonthBased, double weeklyIncome, double weeklyBudget)
	{
		// Call to the parent constructor
		super(name, yos, major, minor, tuition, savings, allWeeklyExpenses, allMonthlyExpenses, longTermGoal, longTermGoalMonthBased, weeklyIncome, weeklyBudget);
	}
	
	/** FinancialCalculator copy constructor
	 * This copy constructor takes in a copy of FinancePerson  
	 * and creates an instance of FinancePerson
	 * 
	 * @param name - Name of the person
	 * @param year of study - The user's current year of study
	 * @param major - The major of the person
	 * @param minor - The minor of the person
	 * @param tuition - The user's yearly tuition
	 * @param savings - The amount in the user's savings account
	 * @param allWeeklyExpenses - The Double ArrayList which contains all weekly expenses of the user
	 * @param allMonthlyExpenses - The Double ArrayList which contains all monthly expenses of the user
	 * @param longTermGoal - The amount the user wants to save over a period of time
	 * @param longTermGoalMonthBased - The amount of time the user wants to achieve long-term goal by
	 * @param weeklyIncome - The user's weekly income
	 * @param weeklyBudget - The user's weekly budget
	 * 
	 * 
	 * */
	public FinancialCalculator(FinancePerson p) 
	{
		// Call to the parent constructor
		super(p.getName(), p.getYOS(), p.getMajor(), p.getMinor(), p.getTuition(), p.getSavings(), p.getAllWeeklyExpenses(), p.getAllMonthlyExpenses(), p.getLongTermGoal(), p.getLongTermGoalMonthBased(), p.getWeeklyIncome(), p.getWeeklyBudget());
	}
	
	/** double calculateWeeklyExpenditure()
	 * This method calculates the user's weekly expenditure based on their input about 
	 * their weekly expenses and monthly expenses
	 * @return weeklyExpenditure - A double which represents the total amount the user spent in a week
	 */
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
	
	/** String displayWeeklyExpenditure()
	 * This method calls calculateWeeklyExpenditure() method, then stores the return value with a  
	 * message regarding the user's weekly expenditure in a String and returns it
	 * @return infoWeeklyExpenditure - A String which is an informative message
	 * regarding the total amount the user spent in a week
	 */
	public String displayWeeklyExpenditure()
	{
		String infoWeeklyExpenditure = "\n" + getName() + ", your weekly expenditure is $" + String.format("%.2f", calculateWeeklyExpenditure()); 
		return new String(infoWeeklyExpenditure);
	}
	
	/** double calculateWeeklySavings()
	 * This method calculates the user's weekly savings based on the user's weekly income
	 * and the return value of calculateWeeklyExpenditure() method
	 * @return weeklySavings - A double which represents the amount the user is saving each week
	 */
	public double calculateWeeklySavings()
	{
		double weeklySavings = getWeeklyIncome() - calculateWeeklyExpenditure();
		return weeklySavings;
	}
	
	/** String displayWeeklySavings()
	 * This method calls calculateWeeklySavings() method, then stores the return value with a  
	 * message regarding the user's weekly savings in a String and returns it
	 * @return infoWeeklySavings - A String which is an informative message
	 * regarding the total amount the user saves each week
	 */
	public String displayWeeklySavings()
	{
		String infoWeeklySavings = "";
		
		if (calculateWeeklySavings() >= 0) {
			infoWeeklySavings = "\n" + "Terrific, " + getName() + "! Your weekly savings is $" + String.format("%.2f", calculateWeeklySavings());
		} else {
			double positiveValue = calculateWeeklySavings() * (-1);
			infoWeeklySavings = "\n" + "Uh oh, " + getName() + " :( Your weekly savings is -$" + String.format("%.2f", positiveValue);
		}
		return new String(infoWeeklySavings);
	}
	
	/** double calculateDailySavings()
	 * This method calculates the user's daily savings based on the return value of 
	 * calculateWeeklySavings() method
	 * @return dailySavings - A double which represents the amount the user is saving each day
	 */
	public double calculateDailySavings()
	{
		double dailySavings = calculateWeeklySavings() / 7;
		return dailySavings;
	}
	
	/** double calculateBudgetDiff()
	 * This method calculates the difference of the user's weekly budget and their weekly
	 * expenditure based on the return value of calculateWeeklyExpenditure() method
	 * @return weeklyBudgetDiff - A double which represents the difference of the user's weekly budget
	 * and their weekly expenditure
	 */
	public double calculateBudgetDiff()
	{
		double weeklyBudgetDiff = getWeeklyBudget() - calculateWeeklyExpenditure();
		return weeklyBudgetDiff;
	}
	
	/** String displayWeeklyBudgetDiff()
	 * This method calls calculateWeeklyBudgetDiff() method, then stores the return value with a  
	 * message regarding the user's weekly budget difference in a String and returns it
	 * @return infoWeeklyBudgetDiff - A String which is an informative message
	 * regarding the difference between the user's weekly budget and their weekly expenditure
	 */
	public String displayWeeklyBudgetDiff()
	{
		String infoWeeklyBudgetDiff = "";
		
		if (calculateBudgetDiff() >= 0) {
			infoWeeklyBudgetDiff = "\n" + "Yay, " + getName() + "! You are spending $" + String.format("%.2f", calculateBudgetDiff()) + " less than your weekly budget";
		} else {
			double positiveValue = calculateBudgetDiff() * (-1);
			infoWeeklyBudgetDiff = "\n" + "Crap, " + getName() + " :( You are spending $" + String.format("%.2f", positiveValue) + " more than your weekly budget";
		}
		return new String(infoWeeklyBudgetDiff);
	}
	
	/** String displayLongTermGoalInfo()
	 * This method calculates the progress for the user's long term goal based on their financial 
	 * profile. There are 3 different scenarios. 1: The user is saving more than they are spending each
	 * week and they will meet their long-term goal by their desired long-term goal period. 2: The user is 
	 * saving more than they are spending each week, but they won't be able to meet their goal by the desired
	 * period they provided. So the method suggests that the user saves more each week to be able to meet their
	 * goal. 3: They are spending more than they are saving each week, and it is not possible for them to meet 
	 * their goal at all. The method suggests that the user saves more each week to be able to meet their goal.
	 * When calculating the date of their expected long-term goal period, the method creates a current local
	 * date time instance and adds the amount of days needed to reach the goal and displays the calculated
	 * date in the infoLongTermGoal String.
	 * @return infoLongTermGoal - A String which is an informative message
	 * regarding the expected long-term goal period based on the calculations done above.
	 */
	public String displayLongTermGoalInfo()
	{
		int totalDays = getLongTermGoalMonthBased() * 30;
		LocalDateTime currentDateTime = LocalDateTime.now();
		String DATE_FORMAT = "yyyy/MM/dd";
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern(DATE_FORMAT);
		String infoLongTermGoal = "";
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		
		if (calculateDailySavings() > 0) {
			double totalSavings = calculateDailySavings() * totalDays;
			double daysNeeded = getLongTermGoal() / calculateDailySavings();
			long daysNeededRounded = Math.round(daysNeeded);
			double diff = totalSavings - getLongTermGoal();
			
			LocalDateTime expectedDateTime = currentDateTime.plusDays(daysNeededRounded);
			
			if (diff >= 0) {
				infoLongTermGoal = "\n" + "Incredible, " + getName() + "! At the rate of your income and expenditure, you will reach your long-term goal approximately by " + myFormat.format(expectedDateTime) + ", and you will have saved an additional amount of $" + String.format("%.2f", diff) + " by your desired long-term goal period";
			} else {
			
				double suggestedDailySavings = getLongTermGoal() / totalDays;
				double suggestedWeeklySavings = suggestedDailySavings * 7;
				double weeklySavingsDiff = suggestedWeeklySavings - calculateWeeklySavings();
				
				infoLongTermGoal = "\n" + "Bad news, " + getName() + " :( At the rate of your income and expenditure, you will reach your long-term goal approximately by " + myFormat.format(expectedDateTime) + ", so you will need to up your weekly savings game by $" + String.format("%.2f", weeklySavingsDiff) + " to achieve that goal by your desired long-term goal period";
			}
		} else {
			LocalDateTime periodDateTime = currentDateTime.plusDays(totalDays);
			double suggestedDailySavings2 = getLongTermGoal() / totalDays;
			double positiveValue = calculateWeeklySavings() * (-1);
			double suggestedWeeklySavings2 = (suggestedDailySavings2 * 7) + positiveValue;
			
			infoLongTermGoal = "\n" + "Very bad news, " + getName() + " :( At the rate of your income and expenditure, it seems like you are spending more than you are earning. In order to reach your long-term goal by your desired long-term goal period, which is " + myFormat.format(periodDateTime) + ". You will need to up your weekly savings game by $" + String.format("%.2f",  suggestedWeeklySavings2);
		}
	
		return new String(infoLongTermGoal);
	}
}
