<<<<<<< HEAD:GPACalculator.java
import java.util.ArrayList;

public class GPACalculator {

	private ArrayList<Double> previousAssignmentGrades;
	private ArrayList<Double> previousAssignemntWeights;
	private double assignmentWeight;
	private double desiredClassGrade;
	
	private int numOfClasses;
	private ArrayList<Double> finalClassGrades;
	private double desiredGPA;
	
	public GPACalculator(ArrayList<Double> previousAssignmentGrades, ArrayList<Double> previousAssignemntWeights, double assignmentWeight, double desiredClassGrade) {
		
		this.previousAssignmentGrades = new ArrayList<Double>();
		
		for (double num : previousAssignmentGrades) {
			this.previousAssignmentGrades.add(num);
		}
		
		this.previousAssignemntWeights = new ArrayList<Double>();
		
		for (double num : previousAssignemntWeights) {
			this.previousAssignemntWeights.add(num);
		}
		
		this.assignmentWeight = assignmentWeight;
		this.desiredClassGrade = desiredClassGrade;
	}
	
	public GPACalculator(int numOfClasses, ArrayList<Double> finalClassGrades, double desiredGPA) {
		
		this.numOfClasses = numOfClasses;
		this.finalClassGrades = new ArrayList<Double>();
		
		for (double grade : finalClassGrades) {
			this.finalClassGrades.add(grade);
		}
		
		this.desiredGPA = desiredGPA;
	}
	
	public double CalculateAssignmentGradeNeeded() {
		
		double currentAverage = 0;
		double weightedGradeSum = 0;
		double sumOfWeights = 0;
		double gradeNeeded = 0;
		
		for (double grade : this.previousAssignmentGrades) {
			for (double weight : this.previousAssignemntWeights) {
				double weightedGrade = grade * weight;
				weightedGradeSum += weightedGrade;
				sumOfWeights += weight;
			}
		}
		
		currentAverage = (weightedGradeSum / (sumOfWeights * 100)) * 100;
		currentAverage = Math.round(currentAverage * 100.0) / 100.0;
		
		gradeNeeded = (this.desiredClassGrade - ((1.0 - this.assignmentWeight) * currentAverage)) / this.assignmentWeight;
		gradeNeeded = Math.round(gradeNeeded * 100.0) / 100.0;
		
		return gradeNeeded;
	}
	
	public double CalculateGPA() {
		
		double numOfClasses = this.numOfClasses;
		ArrayList<Double> finalClassGrades = this.finalClassGrades;
		double desiredGPA = this.desiredGPA;
		
		double currentGPA = 0;
		double classGradesSum = 0;
		double weightOfClass = 0;
		double gradeNeeded = 0;
		
		
		for (double grade : finalClassGrades) {
			classGradesSum += grade;
		}
		
		currentGPA = classGradesSum / (numOfClasses - 1);
		currentGPA = Math.round(currentGPA * 100.0) / 100.0;
		
		weightOfClass = (100 / numOfClasses) / 100;
		weightOfClass = Math.round(weightOfClass * 100.0) / 100.0;
		
		gradeNeeded = (desiredGPA - ((1.0 - weightOfClass) * currentGPA)) / weightOfClass;
		gradeNeeded = Math.round(gradeNeeded * 100.0) / 100.0;
		
		return gradeNeeded;
	}
	
}
=======
import java.util.*;

public class GPACalculator extends MasterPerson {
	private ArrayList<Double> previousAssignmentGrades;
	private ArrayList<Double> previousAssignemntWeights;
	private double assignmentWeight;
	private double desiredClassGrade;
	
	private int numOfClasses;
	private ArrayList<Double> finalClassGrades;
	private double desiredGPA;
	
	public GPACalculator(String name, int YOS, String Major, String Minor,ArrayList<Double> previousAssignmentGrades, ArrayList<Double> previousAssignemntWeights, double assignmentWeight, double desiredClassGrade) {
		super(name,YOS,Major,Minor);
		this.previousAssignmentGrades = new ArrayList<Double>();
		
		for (double num : previousAssignmentGrades) {
			this.previousAssignmentGrades.add(num);
		}
		
		this.previousAssignemntWeights = new ArrayList<Double>();
		
		for (double num : previousAssignemntWeights) {
			this.previousAssignemntWeights.add(num);
		}
		
		this.assignmentWeight = assignmentWeight;
		this.desiredClassGrade = desiredClassGrade;
	}
	
	public GPACalculator(String name, int YOS, String Major, String Minor,int numOfClasses, ArrayList<Double> finalClassGrades, double desiredGPA) {
		super(name,YOS,Major,Minor);
		this.numOfClasses = numOfClasses;
		this.finalClassGrades = new ArrayList<Double>();
		
		for (double grade : finalClassGrades) {
			this.finalClassGrades.add(grade);
		}
		
		this.desiredGPA = desiredGPA;
	}
	
	public double CalculateAssignmentGradeNeeded() {
		
		double currentAverage = 0;
		double weightedGradeSum = 0;
		double gradeNeeded = 0;
		
		for (double grade : this.previousAssignmentGrades) {
			for (double weight : this.previousAssignemntWeights) {
				double weightedGrade = grade * weight;
				weightedGradeSum += weightedGrade;
			}
		}
		
		currentAverage = weightedGradeSum / this.previousAssignmentGrades.size();
		
		gradeNeeded = (this.desiredClassGrade - ((1.0 - this.assignmentWeight) * currentAverage)) / this.assignmentWeight;
		
		return gradeNeeded;
	}
	
	public double CalculateGPA() {
		
		double currentGPA = 0;
		double classGradesSum = 0;
		double weightOfClass = 0;
		double gradeNeeded = 0;
		
		for (double grade : this.finalClassGrades) {
			classGradesSum += grade;
		}
		
		currentGPA = classGradesSum / this.numOfClasses;
		
		weightOfClass = (100 / (this.numOfClasses +1)) / 100;
		
		gradeNeeded = (this.desiredGPA - ((1.0 - weightOfClass) * currentGPA)) / weightOfClass;
		
		return gradeNeeded;
	}
}
>>>>>>> master:main/src/GPACalculator.java
