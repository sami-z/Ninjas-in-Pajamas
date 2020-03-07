import java.util.*;
public class GPAApp implements MainApp{
	
	MasterPerson p1;
	
	public GPAApp(MasterPerson p1) 
	{
		this.p1 = p1;
	}
	
	public void displayMenu() 
	{
		System.out.println("Which function would you like to use:");
		System.out.println("Enter 1, to calculate what grade you need on an assignment/test in order to maintain a certain grade.");
		System.out.println("Enter 2, to calculate what grade you need in a course to maintain a certain GPA.");
	}
	
	public boolean performAction(int action) 
	{
		switch(action) 
		{
		case 1:
			maintainCurrGPA();
			break;
		case 2:
			break;
		}
		
		return true;
	}
	
	public void maintainCurrGPA()
	{
		Scanner input = new Scanner(System.in);
		ArrayList<Double> previousAssignmentGrades = new ArrayList<Double>();
		ArrayList<Double> previousAssignmentWeights = new ArrayList<Double>();
		double assignmentWeight = 0;
		double desiredClassGrade = 0;
		
		double gradeNeeded = 0;
		
		System.out.print("Please enter a previous assignment/test grade: (Leave blank if you have no more assignments to input)");
		Double previousAssignmentGrade = input.nextDouble();
		
		while (previousAssignmentGrade.toString() != "") {
			
			previousAssignmentGrades.add(previousAssignmentGrade);
			
			System.out.print("Please enter the weight of that assignment/test (as a decimal value between 0.0 and 1.0): ");
			Double previousAssignmentWeight = input.nextDouble();
			previousAssignmentWeights.add(assignmentWeight);
			
			System.out.print("Please enter a previous assignment grade: (Leave blank if you have no more assignments to input)");
			previousAssignmentGrade = input.nextDouble();
		}
		
		System.out.print("Please enter the weight of your upcoming assignment/test: (as a decimal value between 0.0 and 1.0)");
		assignmentWeight = input.nextDouble();
		
		System.out.print("Please enter your desired class grade: ");
		desiredClassGrade = input.nextDouble();
		
		GPACalculator calc = new GPACalculator(p1.getName(),p1.getYOS(),p1.getMajor(),p1.getMinor(),previousAssignmentGrades, previousAssignmentWeights, assignmentWeight, desiredClassGrade);
		
		gradeNeeded = calc.CalculateAssignmentGradeNeeded();
		
		System.out.println("The grade on this assignment/test required to maintain a " + desiredClassGrade + " in this class is " + gradeNeeded);
	}
	public void maintainGPA() 
	{
		Scanner input = new Scanner(System.in);
		int numOfClasses = 0;
		ArrayList<Double> finalClassGrades = new ArrayList<Double>();
		double desiredGPA = 0;
		
		double gradeNeeded = 0;
		
		System.out.println("Please enter the number of courses you are currently enrolled in: ");
		numOfClasses = input.nextInt();
		
		System.out.print("Please enter the final grade achieved in a course: (Leave blank if you have no more courses to input)");
		Double finalClassGrade = input.nextDouble();
		
		while (finalClassGrade.toString() != "") {
			
			finalClassGrades.add(finalClassGrade);
			
			System.out.print("Please enter the final grade achieved in a course: (Leave blank if you have no more courses to input)");
			finalClassGrade = input.nextDouble();
		}
		
		System.out.println("Please enter your desired GPA: ");
		desiredGPA = input.nextDouble();
		
		GPACalculator calc = new GPACalculator(p1.getName(),p1.getYOS(),p1.getMajor(),p1.getMinor(),numOfClasses, finalClassGrades, desiredGPA);
		
		gradeNeeded = calc.CalculateGPA();
		
		System.out.println("The grade in this course required to maintain a " + desiredGPA + " is " + gradeNeeded);
	}
	
}
