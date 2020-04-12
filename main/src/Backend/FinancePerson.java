package Backend;
import java.util.*;


/**
 * This class controls the user's financial profile. In particular, 
 * managing getters and setters for financial information and 
 * adding and removing based on their inputs.
 */
public class FinancePerson extends MasterPerson{
	
	// Yearly tuition of the person
	private double tuition;
	
	// The amount in the person's savings account
	private double savings;
	
	// List of all weekly expenses of the person
	private ArrayList<Double> allWeeklyExpenses = new ArrayList<Double>();
	
	// List of all monthly expenses of the person
	private ArrayList<Double> allMonthlyExpenses = new ArrayList<Double>();
	
	// The amount the user wants to save over a period of time
	private double longTermGoal;
	
	// The amount of time the user wants to achieve long-term goal by
	private int longTermGoalMonthBased;
	
	// the user's weekly income
	private double weeklyIncome;
	
	// the user's weekly budget
	private double weeklyBudget;
	
	/** FinancePerson constructor
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
	public FinancePerson(String name, int yos, String major, String minor, double tuition, double savings, ArrayList<Double> allWeeklyExpenses, ArrayList<Double> allMonthlyExpenses, double longTermGoal, int longTermGoalMonthBased, double weeklyIncome, double weeklyBudget)
	{
		// Call to the parent constructor
		super(name, yos, major, minor);
		setTuition(tuition);
		setSavings(savings);
		
		// Loops through each weekly expense in allWeeklyExpenses (input) and adds it to this.allWeeklyExpenses
		for (Double d : allWeeklyExpenses) {
			addWeeklyExpense(new Double(d));
		}
		for (Double d : allMonthlyExpenses) {
			addMonthlyExpense(new Double(d));
		}
		setLongTermGoal(longTermGoal);
		setLongTermGoalMonthBased(longTermGoalMonthBased);
		setWeeklyIncome(weeklyIncome);
		setWeeklyBudget(weeklyBudget);
	}
	
	/** getTuition()
	 * Returns the yearly tuition of the user
	 * @return tuition - A double which represents the yearly tuition of the user
	 */
	public double getTuition()
	{
		return this.tuition;
	}
	
	/** setTuition(double tuition)
	 * sets the yearly tuition of the user
	 * @param tuition - A double which represents the yearly tuition of the user
	 * 
	 * */
	public void setTuition(double tuition)
	{
		this.tuition = tuition;
	}
	
	/** getSavings()
	 * Returns the amount in the user's savings account
	 * @return savings - A double which represents the amount in the user's savings account
	 */
	public double getSavings()
	{
		return this.savings;
	}
	
	/** setSavings(double savings)
	 * sets the amount in the user's savings account
	 * @param savings - A double which represents the amount in the user's savings account
	 * 
	 * */
	public void setSavings(double savings)
	{
		this.savings = savings;
	}
	
	/** getLongTermGoal()
	 * Returns the amount the user wants to save over a period of time
	 * @return longTermGoal - A double which represents the amount the user wants to save over a period of time
	 */
	public double getLongTermGoal()
	{
		return this.longTermGoal;
	}
	
	/** setLongTermGoal(double longTermGoal)
	 * sets the amount the user wants to save over a period of time
	 * @param longTermGoal - A double which represents the amount the user wants to save over a period of time
	 * 
	 * */
	public void setLongTermGoal(double longTermGoal)
	{
		this.longTermGoal = longTermGoal;
	}
	
	/** getLongTermGoalMonthBased()
	 * Returns the amount of time the user wants to achieve long-term goal by
	 * @return longTermGoalMonthBased - An integer which represents the amount of time the user wants to 
	 * achieve long-term goal by
	 */
	public int getLongTermGoalMonthBased()
	{
		return this.longTermGoalMonthBased;
	}
	
	/** setLongTermGoalMonthBased(double longTermGoal)
	 * sets the amount the user wants to save over a period of time
	 * @param longTermGoal - An integer which represents the amount of time the user wants to achieve 
	 * long-term goal by
	 * 
	 * */
	public void setLongTermGoalMonthBased(int newMonthBasedGoal)
	{
		this.longTermGoalMonthBased = newMonthBasedGoal;
	}
	
	/** getWeeklyIncome()
	 * Returns the user's weekly income
	 * @return weeklyIncome - A double which represents the user's weekly income
	 */
	public double getWeeklyIncome()
	{
		return this.weeklyIncome;
	}
	
	/** setWeeklyIncome(double weeklyIncome)
	 * sets the user's weekly income
	 * @param weeklyIncome - A double which represents the user's weekly income
	 * 
	 * */
	public void setWeeklyIncome(double weeklyIncome)
	{
		this.weeklyIncome = weeklyIncome;
	}
	
	/** getWeeklyBudget()
	 * Returns the user's weekly budget
	 * @return weeklyBudget - A double which represents the user's weekly budget
	 */
	public double getWeeklyBudget()
	{
		return this.weeklyBudget;
	}
	
	/** setWeeklyBudget(double weeklyBudget)
	 * sets the user's weekly budget
	 * @param weeklyIncome - A double which represents the user's weekly budget
	 * 
	 * */
	public void setWeeklyBudget(double weeklyBudget)
	{
		this.weeklyBudget = weeklyBudget;
	}
	
	/** ArrayList<Double> getAllWeeklyExpenses() 
	 * Returns the ArrayList of the user's all weekly expenses
	 * @return newAllWeeklyExpenses - A copy of the all weekly expenses ArrayList
	 */
	public ArrayList<Double> getAllWeeklyExpenses()
	{
		ArrayList<Double> newAllWeeklyExpenses = new ArrayList<Double>();
		for (Double d : allWeeklyExpenses) {
			newAllWeeklyExpenses.add(new Double(d));
		}
		return newAllWeeklyExpenses;
	}
	
	/** addWeeklyExpense(Double newExpense)
	 * Adds a weekly expense to the allWeeklyExpenses ArrayList
	 * @param newExpense - The user's weekly expense
	 */
	public void addWeeklyExpense(Double newExpense)
	{
		allWeeklyExpenses.add(new Double(newExpense));
	}
	
	/** removeWeeklyExpense(Double unwantedExpense)
	 * The method removes a weekly expense from the allWeeklyExpenses ArrayList
	 * @param unwantedExpense - The weekly expense that is to be removed
	 */
	public void removeWeeklyExpense(Double unwantedExpense)
	{
		allWeeklyExpenses.remove(new Double(unwantedExpense));
	}
	
	/** ArrayList<Double> getAllMonthlyExpenses()
	 * Returns the ArrayList of the user's all monthly expenses
	 * @return newAllMonthlyExpenses - A copy of the all monthly expenses ArrayList
	 */
	public ArrayList<Double> getAllMonthlyExpenses()
	{
		ArrayList<Double> newAllMonthlyExpenses = new ArrayList<Double>();
		for (Double d : allMonthlyExpenses) {
			newAllMonthlyExpenses.add(new Double(d));
		}
		return newAllMonthlyExpenses;
	}
	
	/** addMonthlyExpense(Double newExpense)
	 * Adds a monthly expense to the allMonthlyExpenses ArrayList
	 * @param newExpense - The user's monthly expense
	 */
	public void addMonthlyExpense(Double newExpense)
	{
		allMonthlyExpenses.add(new Double(newExpense));
	}
	
	/** removeMonthlyExpense(Double unwantedExpense)
	 * The method removes a monthly expense from the allMonthlyExpenses ArrayList
	 * @param unwantedExpense - The monthly expense that is to be removed
	 */
	public void removeMonthlyExpense(Double unwantedExpense)
	{
		allMonthlyExpenses.remove(new Double(unwantedExpense));
	}
}
