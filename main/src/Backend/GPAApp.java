package Backend;

import java.util.*;

public class GPAApp implements MainApp{
	
	private MasterPerson person;
	
	/**
	 * GPAApp constructor
	 * 
	 * @param person - The person object that is using the GPAAapp
	 */
	public GPAApp(MasterPerson person) 
	{
		this.person = person;
	}

	/**
	 * Implements the displayMenu() method from the mainApp interface
	 * the method displays the main menu for GPAApp 
	 */
	public void displayMenu() {
		System.out.println("Which function would you like to use?");
		System.out.println("Enter 1, to calculate what grade you need on a grade category to achieve a certain grade.");
		System.out.println("Enter 2, to calculate what grade you need in a course to maintain a certain GPA.");
	}
	
	
	/**
	 * Implements the performAction(int action) method from mainApp interface
	 * The method takes in an integer and based on the integer performs either 
	 * 1. Calculates the grade needed in a class to maintain a certain GPA in that class
	 * 2. Checks the grades need to maintain a certain GPA
	 * 
	 * @param action - the integer value which decides what action to perform
	 * @return A boolean value is returned to signal whether the program should continue
	 * taking input or terminate execute of the program
	 */
	public boolean performAction(int action) 
	{
		switch(action) 
		{
		case 1:
			// If the users input is 1 the GPAApp w
			maintainCurrGPA();
			break;
		case 2:
			maintainGPA();
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
		
		return true;
	}

	/** maintainCurrGPA()
	 * 
	 * Displays the percentage needed to maintain the desired course grade of the user based on user input
	 * Utilizes the GPACalculator.java class for calculations by creating a GPACalculator object
	 */
	public void maintainCurrGPA()
	{

<<<<<<< HEAD
		GPACalculator calc1 = new GPACalculator();
		
		Scanner input = new Scanner(System.in);
		
		String num0;
		
		// Takes input from the user for the number of grade categories
		System.out.println("How many grade categories are in your course thus far?");
		num0 = input.nextLine();
		int numCate = Integer.parseInt(num0);
=======
	GPACalculator calc1 = new GPACalculator();
	
	Scanner input = new Scanner(System.in);
	
	String num0;
	
	System.out.println("How many grade categories are in your course thus far?");
	int numCate = -1;
	
	while(numCate==-1)
	try {
		num0 = input.nextLine();
		numCate = Integer.parseInt(num0);
		if(numCate<1)
			throw new NumberFormatException();
	}catch(NumberFormatException nfe)
	{
		System.out.println("Invalid input");
		numCate = -1;
	}
	
	String num1;
	String num2;
	String num3;
	
	
	for (int i = 0 ; i < numCate ; i++) {
		
		System.out.println("Enter one of the " + numCate + " grade categories weight: ");
		num1 = input.nextLine();
		
		double currNum1 = Double.parseDouble(num1);
		calc1.categoryWeights.add(currNum1);
>>>>>>> b35ead4cf7ae6714cefc17ba5ddb343d65ee3a98
		
		String num1;
		String num2;
		String num3;
		
		// Loops for the number of grade categories
		for (int i = 0 ; i < numCate ; i++) {
			
			// Takes input from the user for the weight of the grade category
			// and adds the weight to the calc1 object
			System.out.println("Enter one of the " + numCate + " grade categories weight: ");
			num1 = input.nextLine();
			double currNum1 = Double.parseDouble(num1);
			calc1.categoryWeights.add(currNum1);
			
			// Takes input from the user for the number of components in the grade category 
			// and adds the number of components to the calc1 object
			System.out.println("Enter the number of components in this grade category: ");
			num2 = input.nextLine();
			int currNum2 = Integer.parseInt(num2);
			calc1.numCategoryComponents.add(currNum2);
			
			// Loops for the number of components in the grade category
			for (int k = 0 ; k < calc1.numCategoryComponents.get(i) ; k++) {
				
				// Takes input from the user for the grades in each component 
				// and adds the grades to the calc1 object
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
		String num6;
		
		// Takes input from the user for the type of assessment to by calculated
		// and adds the name of the assessment to the calc1 object
		System.out.println("What type of assessment would you like to use for the calculations?");
		num6 = input.nextLine();
		calc1.nameOfAssessment = num6;
	
<<<<<<< HEAD
	String info = calc1.calculatePercentNeeded();

	System.out.println(info);

	input.close();
}

=======
		// Takes input from the user for the weight of the assessment to by calculated
		// and adds the weight of the assessment to the calc1 object
		System.out.println("What is the weight of the " + calc1.nameOfAssessment + "you would like to calculate?");
		num4 = input.nextLine();
		double currNum4 = Double.parseDouble(num4);
		calc1.neededCategoryWeight = currNum4;
		
		// Takes input from the user for the desired course grade
		// and adds the desired course grade to the calc1 object
		System.out.println("What percentage would you like to achieve in this class?");
		num5 = input.nextLine();
		double currNum5 = Double.parseDouble(num5);
		calc1.desiredCourseGrade = currNum5;
		
		
		// Calculates and prints percentage needed for the desired grade of the user
		
		String info = calc1.calculatePercentNeeded();
	
		System.out.println(info);
	}
>>>>>>> a5ca6f5f566e541fc70c4ac8c3b6741348976e97


<<<<<<< HEAD
	/** maintainGPA()
	 * 
	 * Displays the GPA needed in a course to maintain the desired GPA of the user based on user input
	 * Utilizes the GPACalculator.java class for calculations by creating a GPACalculator object
	 */
	public void maintainGPA()  
	{
		Scanner input = new Scanner(System.in);
	
		int numOfClasses = 0;
		double desiredGPA = 0;
		double gradeNeeded;
=======
	int numOfClasses = -1;
	double desiredGPA = -1;
	double gradeNeeded;
	
	System.out.println("Please enter the number of courses you are currently enrolled in: ");
	
	
	while(numOfClasses==-1)
	try {
		String numbOfClassString = input.nextLine();
		numOfClasses = Integer.parseInt(numbOfClassString);
		if(numOfClasses<1)
			throw new NumberFormatException();
	}catch(NumberFormatException nfe)
	{
		System.out.println("Invalid input - Please type a positive integer");
		numOfClasses = -1;
	}
	
	
	GPACalculator calc = new GPACalculator();
	
	System.out.println("Please enter your desired GPA: ");
	
	while(desiredGPA<0) {
		try 
		{
			String desiredString = input.nextLine();
			desiredGPA = Double.parseDouble(desiredString);
			if(!(desiredGPA<=4.0&&desiredGPA>=0))
				throw new NumberFormatException();
		}
		catch(NumberFormatException nfe) 
		{
			System.out.println("Invalid input - Please type a positive  number between 0 and 4.0");
		}
	}
	
<<<<<<< HEAD
	input.close();
=======
	for (int i = 0; i < numOfClasses - 1; i++) {
	
		System.out.println("Please enter the final GPA achieved in a course: ");
		double classGradeInt = -1;
		
		while(classGradeInt<0) 
		{
			try 
			{
				String classGradeStr = input.nextLine();
				classGradeInt = Double.parseDouble(classGradeStr);
				if(!(desiredGPA<=4.0&&desiredGPA>=0))
				{
					throw new NumberFormatException();
				}
				calc.addGrade(Double.parseDouble(classGradeStr));
			}
			catch(NumberFormatException nfe){
				System.out.println("Invalid input - Please type a positive  number between 0 and 4.0");
			}
		}
>>>>>>> b35ead4cf7ae6714cefc17ba5ddb343d65ee3a98
		
		// Takes input from the user for the number of courses the user is currently enrolled in 
		System.out.println("Please enter the number of courses you are currently enrolled in: ");
		String numbOfClassString = input.nextLine();
		numOfClasses = Integer.parseInt(numbOfClassString);
		
		
		GPACalculator calc = new GPACalculator();
		
		// Takes input from the user for the desired GPA of the user 
		System.out.println("Please enter your desired GPA: ");
		String desiredString = input.nextLine();
		desiredGPA = Double.parseDouble(desiredString);
		
		// Loops for the number of classes the user is currently enrolled in
		for (int i = 0; i < numOfClasses - 1; i++) {
		
			// Takes input from the user for the final GPA achieved by the user in a course 
			// and adds the grade to the calc object
			System.out.println("Please enter the final GPA achieved in a course: ");
			String classGrade = input.nextLine();
			calc.addGrade(Double.parseDouble(classGrade));
			
			// calculates the grade needed to maintain the user's desired GPA
			// if the grade needed is not possible then a message will be displayed saying such
			// else, displays the GPA required to maintain the user's desired GPA
			gradeNeeded = calc.gradeNeededToMaintain(numOfClasses,desiredGPA);
			if(gradeNeeded == -1) 
			{
				System.out.println("You cannot get that grade from " + (numOfClasses-i-1) + " classes");
			}
			else 
			{
				System.out.println("The GPA in your course required to maintain a " + desiredGPA + " is " +gradeNeeded  + " in " + (numOfClasses-i-1) + " classes");
			}
		}
>>>>>>> a5ca6f5f566e541fc70c4ac8c3b6741348976e97
	}
}
