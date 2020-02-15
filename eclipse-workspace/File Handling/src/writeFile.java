import java.io.BufferedWriter; //works like Scanner class, will write to file
import java.io.File;
import java.io.FileWriter; //how we will actually write to new file
import java.util.Scanner;


///ISSUES
		///NEED TO CHANGE DIRECTORY FOR MAC
		//FORMAT (classes/subclasses)
		//readFile is straight from youtube vid

public class writeFile {
			
	public static void main (String [] args) {
		
		File newFile = new File( "C:/Users/Sami/Desktop/newFile.txt");  //FORMAT MUST BE CHANGED FOR MAC
		
		if (newFile.exists()) {
			//System.out.println("File exists, make new file");
			try {
				FileWriter fileW = new FileWriter(newFile, true);
				BufferedWriter buffW = new BufferedWriter(fileW);
				String response;
				String yes = "yes";
				while( true) {
					//FileWriter fileW = new FileWriter(newFile);
					//BufferedWriter buffW = new BufferedWriter(fileW);
					Scanner keyboard = new Scanner (System.in);
					System.out.println("Do you want to add data?: ");
					response = keyboard.nextLine();
						if (response.equalsIgnoreCase(yes) == true) { 
							
							// get club name, store as cN
							 String cN;
							 System.out.println("Enter the club name: ");
							 Scanner clubN = new Scanner(System.in);
							 cN = clubN.nextLine();	
							 
							 //get club description, store as cD
							 String cD;
							 System.out.println("Enter the club description: ");
							 Scanner clubD = new Scanner(System.in);
							 cD = clubD.nextLine();
							 
							 // get club link, store as link
							 String link;
							 System.out.println("Enter the club link: ");
							 Scanner clubL = new Scanner(System.in);
							 link = clubL.nextLine();
							 
							// get club main Class, store as mainClass
							 String mainClass;
							 //System.out.println("Enter the club mainClass: ");
							 Scanner mainC = new Scanner(System.in);
							// mainClass = mainC.nextLine();
							 
							 
							 
							 /*/get club sub Class, store as subClass
							 String subClass;
							 System.out.println("Enter the club subClass: ");
							 Scanner subC = new Scanner(System.in);
							 subClass = subC.nextLine();
							 */
							 String output = cN.replace(' ', '_') + "&" + cD + "&" + link + "&";
							 
							 do 
							 {
								 System.out.println("Enter the club categorie(s): ");
								 System.out.println("Enter nothing to end list");
								 mainClass = mainC.nextLine();
								 output+= mainClass+';';
							 } while(! mainClass.equalsIgnoreCase("") );
							 
							 buffW.write(output);		//WRITE EVERYTHING ON SAME LINE
							 buffW.newLine();		//NEW LINE FOR NEXT ITERATION
						
							 
							 
							 //clubN.close();
							// buffW.close();
						//buffW.write("this is a test");
						}else {
							break;
						}
						}
				buffW.close();
			}
					
				
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		
		
		else{ {
			
			try {
				newFile.createNewFile();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				FileWriter fileW = new FileWriter(newFile);
				BufferedWriter buffW = new BufferedWriter(fileW);
				String response;
				String yes = "yes";
				while( true) {
					//FileWriter fileW = new FileWriter(newFile);
					//BufferedWriter buffW = new BufferedWriter(fileW);
					Scanner keyboard = new Scanner (System.in);
					System.out.println("Do you want to add data?: ");
					response = keyboard.nextLine();
						if (response.equalsIgnoreCase(yes) == true) { 
							
							// get club name, store as cN
							 String cN;
							 System.out.println("Enter the club name: ");
							 Scanner clubN = new Scanner(System.in);
							 cN = clubN.nextLine();	
							 
							 //get club description, store as cD
							 String cD;
							 System.out.println("Enter the club description: ");
							 Scanner clubD = new Scanner(System.in);
							 cD = clubD.nextLine();
							 
							 // get club link, store as link
							 String link;
							 System.out.println("Enter the club link: ");
							 Scanner clubL = new Scanner(System.in);
							 link = clubL.nextLine();
							 
							// get club main Class, store as mainClass
							 String mainClass;
							 //System.out.println("Enter the club mainClass: ");
							 Scanner mainC = new Scanner(System.in);
							// mainClass = mainC.nextLine();
							 
							 
							 
							 /*/get club sub Class, store as subClass
							 String subClass;
							 System.out.println("Enter the club subClass: ");
							 Scanner subC = new Scanner(System.in);
							 subClass = subC.nextLine();
							 */
							 String output = cN.replace(' ', '_') + "&" + cD + "&" + link + "&";
							 
							 do 
							 {
								 System.out.println("Enter the club categorie(s): ");
								 System.out.println("Enter nothing to end list");
								 mainClass = mainC.nextLine();
								 output+= mainClass+';';
							 } while(! mainClass.equalsIgnoreCase("") );
							 
							 buffW.write(output);		//WRITE EVERYTHING ON SAME LINE
							 buffW.newLine();		//NEW LINE FOR NEXT ITERATION
						
							 
							 
							 //clubN.close();
							// buffW.close();
						//buffW.write("this is a test");
						}else {
							break;
						}
						}
				buffW.close();
			}
					
				
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
}


