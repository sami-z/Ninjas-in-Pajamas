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

	GPACalculator calc1 = new GPACalculator();
	
	Scanner input = new Scanner(System.in);
	
	String num0;
	
	System.out.println("How many grade categories are in your course thus far?");
	num0 = input.nextLine();
	int numCate = Integer.parseInt(num0);
	
	String num1;
	String num2;
	String num3;
	
	
	for (int i = 0 ; i < numCate ; i++) {
		
		System.out.println("Enter one of the " + numCate + " grade categories weight: ");
		num1 = input.nextLine();
		double currNum1 = Double.parseDouble(num1);
		calc1.categoryWeights.add(currNum1);
		
		System.out.println("Enter the number of components in this grade category: ");
		num2 = input.nextLine();
		int currNum2 = Integer.parseInt(num2);
		calc1.numCategoryComponents.add(currNum2);
		
		for (int k = 0 ; k < calc1.numCategoryComponents.get(i) ; k++) {
			
			System.out.println("Enter each of the " + num2 + " components grade: ");
			num3 = input.nextLine();
			if (num3.equals("")) {
				break;
			}
			double currNum3 = Double.parseDouble(num3);
			calc1.allGrades.add(currNum3);
		}
	}
	
	String num4;
	String num5;
	
	System.out.println("What is the weight of the grade category that you would like to calculate?");
	num4 = input.nextLine();
	double currNum4 = Double.parseDouble(num4);
	calc1.neededCategoryWeight = currNum4;
	
	System.out.println("What percentage would you like to achieve in this class?");
	num5 = input.nextLine();
	double currNum5 = Double.parseDouble(num5);
	calc1.desiredCourseGrade = currNum5;
	
	String info = calc1.calculatePercentNeeded();

	System.out.println(info);

	
	
	
	
	
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
