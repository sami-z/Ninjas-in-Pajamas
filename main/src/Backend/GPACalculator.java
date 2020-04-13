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
	public ArrayList<Double> allGrade;
	
	// Number of grade categories for a course of the person
	public int numGradeCategories;
	
	// List of how many components are in a grade category
	public ArrayList<Integer> numCategoryComponents = new ArrayList<Integer>();
	
	// List containing the user's current grades in course assessments
	public ArrayList<Double> allGrades = new ArrayList<Double>();
	
	// List of the weights of all the categories
	public ArrayList<Double> categoryWeights = new ArrayList<Double>();
	
	// The weight of the category to be calculated
	public double neededCategoryWeight;
	
	// The desired course grade of the person
	public double desiredCourseGrade;
	
	// The name of the assessment to be calculated
	public String nameOfAssessment;
	
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

	private double calculateCGPA() 
	{
		double average = 0;
		for(int i = 0; i<allGrade.size();i++) 
		{
			average+=allGrade.get(i);
		}
			
		return average/allGrade.size();
	}
	
	/** gradeNeededToMaintain(int,double) 
	 * This method calculates the mark the user needs in a specific course
	 * to maintain a certain overall GPA.
	 * @param enrolledCourses - number of courses that the user is enrolled in
	 * @param GPAwanted - the desired GPA of the user
	 * 
	 * @return gradeNeeded - a double which represents the grade needed to maintain the user's desired GPA
	 */

	public double gradeNeededToMaintain(int enrolledCourses,double GPAwanted) 
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
			allGrade.add(grade);
	}
	
	/** calculatePercentNeeded()
	 * Returns a string message with the percentage needed to maintain the desired course grade of the user
	 * @return infoMessage - a string message containing the percentage needed to maintain the desired course grade of the user
	 */
	public String calculatePercentNeeded()
	{
		// Calculate the sum of all the weights the user has entered so far
		double totalGrade = 0;
		double totalWeight = 0;
		
		for (int d = 0; d < categoryWeights.size(); d++) {
			
			totalWeight = totalWeight + categoryWeights.get(d);
		}
		
		double finalWeight = totalWeight + neededCategoryWeight;
		double multiplyWeight = 1 / finalWeight;

		// Calculate the user's total current grade based on the assessment
		// categories and weightings
		
		for (int i = 0 ; i < categoryWeights.size() ; i++) {
			
			double currentWeight = categoryWeights.get(i) * multiplyWeight;
			int currentNumCategoryComponents = numCategoryComponents.get(i);
			double eachWeight = currentWeight / currentNumCategoryComponents;
			
			for (int j = 0 ; j < currentNumCategoryComponents ; j++) {
				
				double currentGrade = allGrades.get(j);
				totalGrade = totalGrade + (currentGrade * eachWeight);
			}
		}
		
		double desiredWeight = neededCategoryWeight * multiplyWeight;
		double minusWeight = desiredCourseGrade - totalGrade;
		double neededGrade = minusWeight / desiredWeight;
		double dob = neededGrade * 100;
		long newLong = Math.round(dob);
		double dob2 = newLong / 100;

		// return a string describing the above information
		
		String infoMessage = "You need to get " + dob2 + "% on the next " + nameOfAssessment + " to get " + desiredCourseGrade + "% in the course.";
		
		return infoMessage;
	}



}
