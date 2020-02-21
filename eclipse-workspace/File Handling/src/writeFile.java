import java.io.BufferedWriter; //works like Scanner class, will write to file
import java.io.File;
import java.io.FileWriter; //how we will actually write to new file
import java.util.Scanner;


///ISSUES
		//FORMAT (classes/subclasses)
		//readFile is straight from youtube vid

/* How to use this program: The writeFile program creates a data.txt file in the directory where it is launched.
 * The user can input data relating to the different clubs around campus, the program takes this data in a writes
 * the data into one line of data.txt.
 * */

public class writeFile {
			
	public static void main (String [] args) 
	{
		
		File newFile = new File("data.txt"); 
		
		if (newFile.exists())
		{
			//System.out.println("File exists, make new file");
				writeToFile(newFile);			
		}
		
		else
		{ 
			try {
				newFile.createNewFile();
				writeToFile(newFile);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void writeToFile(File newFile) 
	{
		try 
		{
			FileWriter fileW = new FileWriter(newFile, true);
			BufferedWriter buffW = new BufferedWriter(fileW);
			String response;
			String yes = "y";
			
			Scanner keyboard = new Scanner (System.in);
			System.out.println("Do you want to add data? (y/n): ");
			response = keyboard.nextLine();
			
			while(response.equals("y")) 
			{
				//FileWriter fileW = new FileWriter(newFile);
				//BufferedWriter buffW = new BufferedWriter(fileW);
						
				// get club name, store as cN
				 String cN;
				 System.out.println("Enter the club name: ");
				 cN = keyboard.nextLine();	
				 
				 //get club description, store as cD
				 String cD;
				 System.out.println("Enter the club description: ");
				 cD = keyboard.nextLine();
				 
				 // get club link, store as link
				 String link;
				 System.out.println("Enter the club link: ");
				 link = keyboard.nextLine();
				 
				// get club main Class, store as mainClass
				 String categories;
				 
				 String output = cN.replace(' ', '_') + "|" + cD + "|" + link + "|";
				 
				 do 
				 {
					 System.out.println("Enter the club categorie(s): ");
					 System.out.println("Enter nothing to end list");
					 categories = keyboard.nextLine();
					 if(!categories.equalsIgnoreCase(""))
						 output+= categories+';';
				 } while(! categories.equalsIgnoreCase("") );
				 
				 buffW.write(output);		//WRITE EVERYTHING ON SAME LINE
				 buffW.newLine();		//NEW LINE FOR NEXT ITERATION
				 
				 System.out.println("Do you want to add data? (y/n): ");
				 response = keyboard.nextLine();
				 
				 //clubN.close();
				// buffW.close();
			//buffW.write("this is a test");
			}
			
		
			buffW.close();
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}


