import java.io.BufferedReader; //works like Scanner class, will read from file
import java.io.FileReader; // how to access file in Windows
import java.util.*;

public class ReadFile {	
	private String dataFile;
	public ReadFile(String dataFile) 
	{
		this.dataFile = dataFile;
	}

	public void setDataFile(String dataFile) 
	{
		this.dataFile=dataFile;
	}

	private BufferedReader getFileReader() 
	{
		FileReader fileR;
		try {
			fileR = new FileReader(dataFile); 
		}
		catch(Exception e) 
		{
			System.out.println("Unable to open " + dataFile);
			return null;
		}
		BufferedReader readB = new BufferedReader(fileR);

		return readB;
	}

	public ClubList readClubData()
	{

		BufferedReader readB = getFileReader();

		ClubList ret = new ClubList();
		String line;
		try {
		line = readB.readLine(); //like readLine in python
		do 
		{
			String[] arr = line.split("\\|");
			String Name  = arr[0];
			String Description = arr[1];
			String website = arr[2];
			String[] Categories = arr[3].split("\\;");

			Club tempClub = new Club(Name,Description,website,Categories);
			ret.addClub(tempClub);
			line = readB.readLine();
		}while(line!=null);
		}
		catch(Exception e) 
		{
			System.out.println("Unable to read" + dataFile);
			return null;
		}

		return ret;
	}

	public HashMap<String,String> readMap()
	{
		HashMap<String,String> newMap = new HashMap<String,String>();

		BufferedReader readB = getFileReader();

		String line;
		try {
		line = readB.readLine(); //like readLine in python
		do 
		{
			String key  = line.split("\\|")[0];
			String value = line.split("\\|")[1];
			newMap.put(key, value);

			line = readB.readLine();
		}while(line!=null);

		}
		catch(Exception e) 
		{
			System.out.println("Unable to read" + dataFile);
			return null;
		}

		return newMap;


	}

	public void displayMap() 
	{
		BufferedReader readB = getFileReader();

		String line;

		try {
		line = readB.readLine(); //like readLine in python
		do 
		{
			System.out.println(line);

			line = readB.readLine();
		}while(line!=null);

		}
		catch(Exception e) 
		{
			System.out.println("Unable to read" + dataFile);
			return;
		}

	}


}