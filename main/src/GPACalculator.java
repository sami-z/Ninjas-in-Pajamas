import java.util.ArrayList;

public class GPACalculator {

	ArrayList<Double> allGrade;
	int numGradeCategories;
	ArrayList<Integer> numCategoryComponents = new ArrayList<Integer>();
	ArrayList<Double> allGrades = new ArrayList<Double>();
	ArrayList<Double> categoryWeights = new ArrayList<Double>();
	double neededCategoryWeight;
	double desiredCourseGrade;
	String nameOfAssessment;
	
	public GPACalculator() 
	{
		allGrade = new ArrayList<Double>();
	}
	
	private double calculateCGPA() 
	{
		double average = 0;
		for(int i = 0; i<allGrade.size();i++) 
		{
			average+=allGrade.get(i);
		}
			
		return average/allGrade.size();
	}
	
	public double gradeNeededToMaintain(double GPAwanted) 
	{
		double currentGPA = calculateCGPA();
		double gradeNeeded = (GPAwanted * (allGrade.size()+1))-(currentGPA*allGrade.size());
		if(gradeNeeded>4.0)
			return -1;
		else
			return gradeNeeded;
	}
	
	public void addGrade(double grade) {
		if(grade>=0.0 && grade<=4.0)
			allGrade.add(grade);
	}
	
	public String calculatePercentNeeded()
	{
		
		double totalGrade = 0;
		double totalWeight = 0;
		
		for (int d = 0; d < categoryWeights.size(); d++) {
			
			totalWeight = totalWeight + categoryWeights.get(d);
		}
		
		double finalWeight = totalWeight + neededCategoryWeight;
		double multiplyWeight = 1 / finalWeight;
		
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
		
		String infoMessage = "You need to get " + String.format("%.2f", neededGrade) + "% on the next " + nameOfAssessment + " to get " + desiredCourseGrade + "% in the course.";
		
		return infoMessage;
	}



}
