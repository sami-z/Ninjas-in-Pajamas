package Backend;

import java.util.*;

/**
 * This class makes use of GPACalculator to implement the functionality for the GPA 
 * Calculator feature, which consists of two main parts: calculating the grade needed
 * on an assessment to maintain a course grade, and calculating the grade needed in a 
 * course to maintain a certain GPA.
 */


public class GPAApp implements MainApp{
	
	private MasterPerson person;
	
	/**
	 * GPAApp constructor
	 * 
	 * @param person - The person object that is using the GPAAapp
	 */
	public GPAApp(MasterPerson person) 
	{
		this.person = new MasterPerson(person);
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
	public void maintainCurrGPA(){
	
		GPACalculator calc1 = new GPACalculator();
		
		Scanner input = new Scanner(System.in);
		
		String num0;
		
		System.out.println("How many grade categories are in your course thus far?");
		int numCate = -1;
		
		while(numCate==-1)
		try {
			num0 = new String(input.nextLine());
			numCate = Integer.parseInt(num0);
			if(numCate<1)
				throw new NumberFormatException();
		}catch(NumberFormatException nfe)
		{
			System.out.println("Invalid input");
			numCate = -1;
		}
		
		String num1;
		String num2 = null;
		String num3;
		
		// Loops for the number of grade categories
		for (int i = 0 ; i < numCate ; i++) {
			double currNum1 = -1;
			int currNum2 = -1;
			
			// Takes input from the user for the weight of the grade category
			// and adds the weight to the calc1 object
			System.out.println("Enter one of the " + numCate + " grade categories weight(1-99): ");
			
			while(currNum1<0) {
				try {
					num1 = new String(input.nextLine());
					currNum1 = Double.parseDouble(num1);
					if(!(currNum1>=1&&currNum1<=99)) {
						throw new NumberFormatException();
					}
					calc1.addCategoryWeights(new Double(currNum1));
				}
				catch(NumberFormatException nfe) 
				{
					System.out.println("Please enter a weight between 1 and 99 (inclusive)");
				}
			}
			
			// Takes input from the user for the number of components in the grade category 
			// and adds the number of components to the calc1 object
			System.out.println("Enter the number of components in this grade category: ");
			
			
			while(currNum2==-1)
				try {
					num2 = new String(input.nextLine());
					currNum2 = Integer.parseInt(num2);
					if(currNum2<1) {
						throw new NumberFormatException();
						}
					calc1.addNumCategoryComponents(new Integer(currNum2));
				}catch(NumberFormatException nfe)
				{
					System.out.println("Invalid input");
					currNum2 = -1;
				}
			
			// Loops for the number of components in the grade category
			for (int k = 0 ; k < calc1.getNumCategoryComponents().get(i) ; k++) {
				
				// Takes input from the user for the grades in each component 
				// and adds the grades to the calc1 object
				System.out.println("Enter each of the " + num2 + " components grade: ");
				double currNum3 = -1;
				while(currNum3<0) {
					try {
						num3 = new String(input.nextLine());
						currNum3 = Double.parseDouble(num3);
						if(!(currNum3>=0&&currNum3<=100)) {
							throw new NumberFormatException();
						}
						calc1.addAllGrades(new Double(currNum3));
					}
					catch(NumberFormatException nfe) 
					{
						System.out.println("Please enter a weight between 0 and 100 (inclusive)");
					}
				}
			}
		}
		
		String num4;
		String num5;
		String num6;
		double currNum4 = -1;
		double currNum5 = -1;
		
		
		// Takes input from the user for the type of assessment to by calculated
		// and adds the name of the assessment to the calc1 object
		System.out.println("What type of assessment would you like to use for the calculations?");
		num6 = new String (input.nextLine());
		calc1.setNameOfAssessment(new String(num6));
		
	
		System.out.println("What is the weight of the " + calc1.getNameOfAssessment() + "you would like to calculate?");
		
		// Takes input from the user for the weight of the assessment to by calculated
		// and adds the weight of the assessment to the calc1 object
		while(currNum4 <0) {
			try {
				num4 = new String(input.nextLine());
				currNum4 = Double.parseDouble(num4);
				if(!(currNum4>=1&&currNum4<=99)) {
					throw new NumberFormatException();
				}
				calc1.setNeededCategoryWeight(new Double(currNum4));
				
			}
			catch(NumberFormatException nfe) 
			{
				System.out.println("Please enter a weight between 0 and 99 (inclusive)");
			}
		}
		
		System.out.println("What percentage would you like to achieve in this class?");
		
		// Takes input from the user for the desired course grade
		// and adds the desired course grade to the calc1 object
		while(currNum5 <0) {
			try {
				num5 = input.nextLine();
				currNum5 = Double.parseDouble(num5);
				if(!(currNum5>=0&&currNum5<=100)) {
					throw new NumberFormatException();
				}
				calc1.setDesiredCourseGrade(new Double(currNum5));
				
			}
			catch(NumberFormatException nfe) 
			{
				System.out.println("Please enter a weight between 0 and 100 (inclusive)");
			}
		}
		
		String info = calc1.calculatePercentNeeded();
	
		System.out.println(new String(info));
	
		
	}
	
	
	/** maintainGPA()
	 * 
	 * Displays the GPA needed in a course to maintain the desired GPA of the user based on user input
	 * Utilizes the GPACalculator.java class for calculations by creating a GPACalculator object
	 */
	public void maintainGPA()  {
		
		Scanner input = new Scanner(System.in);
	
		int numOfClasses = -1;
		double desiredGPA = -1;
		double gradeNeeded;
		
		System.out.println("Please enter the number of courses you are currently enrolled in: ");
		
		// Takes input from the user for the number of courses the user is currently enrolled in 
		while(numOfClasses==-1)
		try {
			String numbOfClassString = new String(input.nextLine());
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
		
		// Takes input from the user for the desired GPA of the user 
		while(desiredGPA<0) {
			try 
			{
				String desiredString = new String(input.nextLine());
				desiredGPA = Double.parseDouble(desiredString);
				if(!(desiredGPA<=4.0&&desiredGPA>=0))
					throw new NumberFormatException();
			}
			catch(NumberFormatException nfe) 
			{
				System.out.println("Invalid input - Please type a positive  number between 0 and 4.0");
			}
		}
		
		// Loops for the number of classes the user is currently enrolled in
		for (int i = 0; i < numOfClasses - 1; i++) {
		
			System.out.println("Please enter the final GPA achieved in a course: ");
			double classGradeInt = -1;
			
			// Takes input from the user for the final GPA achieved by the user in a course 
			// and adds the grade to the calc object
			while(classGradeInt<0) 
			{
				try 
				{
					String classGradeStr = new String(input.nextLine());
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
	
	
	}
}
