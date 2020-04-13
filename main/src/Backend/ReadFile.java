package Backend;
import java.io.BufferedReader; //works like Scanner class, will read from file
import java.io.FileReader; // how to access file in Windows
import java.util.*;

public class ReadFile {	
	
	// The file to be read
	private String dataFile;
	
	/** Read File constructor
	 * 
	 * @param dataFile - The file to be read
	 */
	public ReadFile(String dataFile) 
	{
		this.dataFile = dataFile;
	}

	/** setDataFile(String dataFile)
	 * Sets the file to be read
	 * @param dataFile - The file to be read
	 */
	public void setDataFile(String dataFile) 
	{
		this.dataFile = dataFile;
	}

	/** getFileReader()
	 * Returns a BufferedReader which will be used to read the file
	 * @return readB - a BufferedReader object
	 */
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

	/** readClubData()
	 * Returns a ClubList object with all of the clubs read from the file
	 * @return ret - a ClubList object that contains all of the clubs read from the file
	 */
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

	/** readMap()
	 * Returns a Hash Map containing the mapping of club categories/interests to their respective numbers
	 * @return newMap - a Hashmap<String,String> object containing the mapping 
	 */
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
	
	/** getKeys()
	 * Returns an Array List containing the numbers (keys) which represent each club category/interest
	 * @return keys - an ArrayList<String> object that contains the numbers (keys)
	 */
	public ArrayList<String> getKeys()
	{
		ArrayList<String> keys = new ArrayList<String>();

		BufferedReader readB = getFileReader();

		String line;
		try {
		line = readB.readLine(); //like readLine in python
		do 
		{
			String key  = line.split("\\|")[0];
			keys.add(key);

			line = readB.readLine();
		}while(line!=null);

		}
		catch(Exception e) 
		{
			System.out.println("Unable to read" + dataFile);
			return null;
		}

		return keys;
	}

	/** displayMap()
	 * Displays the information contianed in the file using the BufferedReader, line by line
	 */
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