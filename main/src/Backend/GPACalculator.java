package Backend;
import java.util.ArrayList;
import java.lang.*;

/**
 * This class calculates GPA-related information based on the user input. Its two main
 * functions are to calculate the grade needed on an assessment to maintain a certain grade
 * in the course, and to calculate the grade needed in a course to maintain a certain
 * overall GPA.
 */


public class GPACalculator {

	// List of each course's grade, inputted by the user
	private ArrayList<Double> allGrade;
	
	// Number of grade categories for a course of the person
	private int numGradeCategories;
	
	// List of how many components are in a grade category
	private ArrayList<Integer> numCategoryComponents = new ArrayList<Integer>();
	
	// List containing the user's current grades in course assessments
	private ArrayList<Double> allGrades = new ArrayList<Double>();
	
	// List of the weights of all the categories
	private ArrayList<Double> categoryWeights = new ArrayList<Double>();
	
	// The weight of the category to be calculated
	private double neededCategoryWeight;
	
	// The desired course grade of the person
	private double desiredCourseGrade;
	
	// The name of the assessment to be calculated
	private String nameOfAssessment;
	
	/**
	 * GPACalculator constructor
	 * This constructor creates an instance of GPACalculator and initializes the allGrade 
	 * variable as an ArrayList containing doubles.
	 */

	public GPACalculator() 
	{
		allGrade = new ArrayList<Double>();
	}

	/** calculateCGPA() 
	 * Returns the current total GPA of the user
	 * @return average/allGrade.size() - a double which represents the calculated GPA of the user
	 */

	public int getSize()
	{
		return allGrade.size();
	}
	
	public double calculateCGPA() 
	{
		double average = 0;
		for(int i = 0; i < getSize(); i++) 
		{
			average += allGrade.get(i);
		}
			
		return average / getSize();
	}
	
	/** gradeNeededToMaintain(int,double) 
	 * This method calculates the mark the user needs in a specific course
	 * to maintain a certain overall GPA.
	 * @param enrolledCourses - number of courses that the user is enrolled in
	 * @param GPAwanted - the desired GPA of the user
	 * 
	 * @return gradeNeeded - a double which represents the grade needed to maintain the user's desired GPA
	 */

	public double gradeNeededToMaintain(int enrolledCourses, double GPAwanted) 
	{
		double currentGPA = calculateCGPA();
		double gradeNeeded = ((GPAwanted * (enrolledCourses))-(currentGPA*allGrade.size()))/(enrolledCourses-allGrade.size());
		if(gradeNeeded>4.0)
			return -1;
		else if(gradeNeeded<0)
			return 0.0;
		else
			return gradeNeeded;
	}
	
	/** addGrade(double grade)
	 * Adds a grade to the ArrayList allGrade
	 * @param grade - a double which represents the grade to add to allGrade
	 */

	public void addGrade(double grade) {
		if(grade>=0.0 && grade<=4.0)
			allGrade.add(new Double(grade));
	}
	
	/** calculatePercentNeeded()
	 * Returns a string message with the percentage needed to maintain the desired course grade of the user
	 * @return infoMessage - a string message containing the percentage needed to maintain the desired course grade of the user
	 */

	
	public double getNeededCategoryWeight()
	{
		return this.neededCategoryWeight;
	}
	
	public void setNeededCategoryWeight(double cateWeight)
	{
		this.neededCategoryWeight = cateWeight;
	}
	
	public double getDesiredCourseGrade()
	{
		return this.desiredCourseGrade;
	}
	
	public void setDesiredCourseGrade(double desiredCourseGrade)
	{
		this.desiredCourseGrade = desiredCourseGrade;
	}
	
	public String getNameOfAssessment()
	{
		return new String(this.nameOfAssessment);
	}
	
	public void setNameOfAssessment(String noa)
	{
		this.nameOfAssessment = new String(noa);
	}
	
	public int getCategoryWeightsSize()
	{
		return categoryWeights.size();
	}
	
	public ArrayList<Double> getCategoryWeights() 
	{
		ArrayList<Double> copy = new ArrayList<Double> ();
		for(int i = 0; i< getCategoryWeightsSize(); i++) 
		{
			copy.add(new Double(categoryWeights.get(i)));
		}
		return copy;
	}
	
	public void addCategoryWeights(Double newCategoryWeight)
	{
		categoryWeights.add(new Double(newCategoryWeight));
	}
	
	public int getAllGradesSize()
	{
		return allGrades.size();
	}
	
	public ArrayList<Double> getAllGrades() 
	{
		ArrayList<Double> copy = new ArrayList<Double> ();
		for(int i = 0; i< getAllGradesSize(); i++) 
		{
			copy.add(new Double(allGrades.get(i)));
		}
		return copy;
	}
	
	public void addAllGrades(Double newAllGrades)
	{
		allGrades.add(new Double(newAllGrades));
	}
	
	public int getNumCategoryComponentsSize()
	{
		return numCategoryComponents.size();
	}
	
	public ArrayList<Integer> getNumCategoryComponents() 
	{
		ArrayList<Integer> copy = new ArrayList<Integer> ();
		for(int i = 0; i< getNumCategoryComponentsSize(); i++) 
		{
			copy.add(new Integer(numCategoryComponents.get(i)));
		}
		return copy;
	}
	
	public void addNumCategoryComponents(Integer newNumCategoryComponents)
	{
		numCategoryComponents.add(new Integer(newNumCategoryComponents));
	}
	
	public void removeAllGrades(int unwantedGrade)
	{
		allGrades.remove(unwantedGrade);
	}
	
	public String calculatePercentNeeded()
	{
		// Calculate the sum of all the weights the user has entered so far
		double totalGrade = 0;
		double totalWeight = 0;
		
		for (int d = 0; d < getCategoryWeightsSize(); d++) {
			
			totalWeight = totalWeight + getCategoryWeights().get(d);
		}
		
		double finalWeight = totalWeight + getNeededCategoryWeight();
		double multiplyWeight = 100 / finalWeight;

		// Calculate the user's total current grade based on the assessment
		// categories and weightings
		
		for (int i = 0 ; i < getCategoryWeightsSize() ; i++) {
			
			double currentWeight = getCategoryWeights().get(i) * multiplyWeight;
			int currentNumCategoryComponents = getNumCategoryComponents().get(i);
			double eachWeight = currentWeight / currentNumCategoryComponents;
			
			for (int j = 0 ; j < currentNumCategoryComponents ; j++) {
				
				double currentGrade = getAllGrades().get(j);
				removeAllGrades(j);
				totalGrade = totalGrade + (currentGrade * (eachWeight / 100));
			}
		}
		
		double desiredWeight = getNeededCategoryWeight() * multiplyWeight / 100;
		double minusWeight = getDesiredCourseGrade() - totalGrade;
		double neededGrade = minusWeight / desiredWeight;
		double dob = neededGrade * 100;
		long newLong = Math.round(dob);
		double dob2 = newLong / 100;

		// return a string describing the above information
		
		String infoMessage = "You need to get " + dob2 + "% on the next " + getNameOfAssessment() + " to get " + getDesiredCourseGrade() + "% in the course.";
		
		return new String (infoMessage);
	}



}
