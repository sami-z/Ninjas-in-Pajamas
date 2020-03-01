import java.util.ArrayList;
import java.util.Scanner;
//random stuff
public class Main {

	private static MainApp app;
	private static ReadFile reader;

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		ClubPerson p1 = getInitiaClublPerson(input);
		app = new MainApp("data.txt",p1);
		boolean Condition;

		do {
			app.displayMenu();
			int action = input.nextInt();
			Condition = app.performAction(action);
		}while(Condition);

	}

	public static void displayInterestMapping() 
	{
		reader = new ReadFile("map.txt");
		reader.displayMap();
	}
// another test
	public static ClubPerson getInitiaClublPerson(Scanner input) 
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
			System.out.println("Enter interest(s) based on the above mapping");
			currInt = input.nextLine();
			if(!currInt.equals(""))
			interests.add(currInt);
		}while(!currInt.equals(""));

		do 
		{
			System.out.println("1.1|Faculty of Science");
			System.out.println("1.2|Faculty of Arts");
			System.out.println("1.3|Faculty of Social Work");
			System.out.println("1.4|Faculty of Kinesiology");
			System.out.println("1.5|Faculty of Health Science");
			System.out.println("1.6|Faculty of Nursing");
			System.out.println("1.7|Schulich School of Engineering");
			System.out.println("1.8|Haskayne School of Business");
			System.out.println("1.9|Werklund School of Education");
			System.out.println("1.10|Pre-Graduate Societies");
			System.out.println("1.11|Graduate Societies");

			System.out.println("Enter faculty(ies) based on the above mapping");
			currFac = input.nextLine();
			fac.add(currFac);
		}while(!currFac.equals(""));

		ClubPerson p1 = new ClubPerson(name,YOS,Major,Minor,interests,fac);

		return p1;
	}

}