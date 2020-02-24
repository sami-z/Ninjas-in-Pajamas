import java.util.*;
public class main {
	
	private static mainApp app;
	private static readFile reader;
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		Person p1 = getInitialPerson(input);
		app = new mainApp("data.txt",p1);
		boolean Condition;
		
		do {
			app.displayMenu();
			int action = input.nextInt();
			Condition = app.performAction(action);
		}while(Condition);
		
	}
	
	public static void displayInterestMapping() 
	{
		reader = new readFile("map.txt");
		reader.displayMap();
	}
	
	public static Person getInitialPerson(Scanner input) 
	{
		ArrayList<String> interests = new ArrayList<String>();
		ArrayList<String> fac = new ArrayList<String>();
		
		System.out.println("Enter name: ");
		String name = input.nextLine();
		
		System.out.println("Enter year of study: ");
		String YOSString = input.nextLine();
		int YOS = Integer.parseInt(YOSString);
		
		System.out.println("Enter Major: ");
		String Major = input.nextLine();
		System.out.println("Enter Minor: ");
		String Minor = input.nextLine();
		String currFac;
		String currInt;
		
		displayInterestMapping();
		do 
		{
			System.out.println("Enter numbers based on the above mapping");
			currInt = input.nextLine();
			if(!currInt.equals(""))
			interests.add(currInt);
		}while(!currInt.equals(""));
		
		do 
		{
			System.out.println("Enter faculty");
			currFac = input.nextLine();
			fac.add(currFac);
		}while(!currFac.equals(""));
		
		Person p1 = new Person(name,YOS,Major,Minor,interests,fac);
		
		return p1;
	}
	
}
