import java.util.*;

public class GPAApp implements MainApp{
	
	MasterPerson p1;
	
	public GPAApp(MasterPerson p1) 
	{
		this.p1 = p1;
	}

	public void displayMenu() {
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
			maintainGPA();
			break;
		}
		
		return true;
	}

public void maintainCurrGPA(){

	Scanner input = new Scanner(System.in);
	ArrayList<Double> previousAssignmentGrades = new ArrayList<Double>();
	ArrayList<Double> previousAssignmentWeights = new ArrayList<Double>();
	double assignmentWeight = 0;
	double desiredClassGrade = 0;
	
	double gradeNeeded = 0;
	
	System.out.println("How many assignments/tests have you completed so far? ");
	int numOfAssignments = input.nextInt();
	
	Double previousAssignmentGrade = 0.0;
	
	for (int i = 0; i < numOfAssignments; i++) {
	
	System.out.println("Please enter a previous assignment grade: ");
	previousAssignmentGrade = input.nextDouble();
	previousAssignmentGrades.add(previousAssignmentGrade);
	
	System.out.println("Please enter the weight of that assignment/test (as a decimal value between 0.0 and 1.0): ");
	Double previousAssignmentWeight = input.nextDouble();
	previousAssignmentWeights.add(previousAssignmentWeight);
	
	}
	
	System.out.println("Please enter the weight of your upcoming assignment/test: (as a decimal value between 0.0 and 1.0)");
	assignmentWeight = input.nextDouble();
	
	System.out.println("Please enter your desired class grade: ");
	desiredClassGrade = input.nextDouble();
	
	
	System.out.println("The grade on this assignment/test required to maintain a " + desiredClassGrade + " in this class is " + gradeNeeded);

}////////////////////////////////////



public void maintainGPA()  {
	
	Scanner input = new Scanner(System.in);

	int numOfClasses = 0;
	double desiredGPA = 0;
	double gradeNeeded;
	
	System.out.println("Please enter the number of courses you are currently enrolled in: ");
	String numbOfClassString = input.nextLine();
	numOfClasses = Integer.parseInt(numbOfClassString);
	
	
	GPACalculator calc = new GPACalculator();
	
	for (int i = 0; i < numOfClasses - 1; i++) {
	
	System.out.println("Please enter the final grade achieved in a course: ");
	String classGrade = input.nextLine();
	calc.addGrade(Double.parseDouble(classGrade));
	
	}
	
	System.out.println("Please enter your desired GPA: ");
	String desiredString = input.nextLine();
	desiredGPA = Double.parseDouble(desiredString);
	
	gradeNeeded =calc.gradeNeededToMaintain(desiredGPA);
	if(gradeNeeded == -1) 
	{
		System.out.println("You cannot get that grade from one class");
	}else {
	
	System.out.println("The grade in your course required to maintain a " + desiredGPA + " is " +gradeNeeded );
	}
	}


}
