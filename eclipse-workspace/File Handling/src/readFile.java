import java.io.BufferedReader; //works like Scanner class, will read from file
import java.io.FileReader; // how to access file in Windows


public class readFile {
	
	public static void main (String[] args) throws Exception{
		FileReader fileR = new FileReader("C:/Users/Sami/Desktop/newFile.txt"); 
		BufferedReader readB = new BufferedReader(fileR);
		
		
		String tempEmpty = "";
		String line = readB.readLine(); //like readLine in python
		
		while (line!=null)
		{
			tempEmpty += line;
			line = readB.readLine();
			System.out.println(line);
		}
		
		readB.close();
		//System.out.println(tempEmpty);
		
	}

}
