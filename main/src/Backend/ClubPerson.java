package Backend;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 
 *
 */
public class ClubPerson extends MasterPerson {
	
	// List of interests of the person.
	private ArrayList<String> interests = new ArrayList<String>();
	
	private HashMap<String,String> mapOfInterest;
	
	// List of faculties that the person is apart of
	private ArrayList<String> faculties = new ArrayList<String>();
	
	// The list of recommendedClubs that fit the users interests
	private ClubList recommendedClubs;
	
	
	/** ClubPerson constructor
	 * 
	 * @param name - Name of the person
	 * @param age - The age of the person as an int
	 * @param major - The major of the person
	 * @param minor - The minor of the person
	 * @param interests - The String ArrayList which contains all the interest of the person
	 * @param faculties - The String ArrayList of the faculties by which the person is apart of
	 * 
	 * */
	public ClubPerson(String name, int yos, String major, String minor, ArrayList<String> interests, ArrayList<String> faculties) {
		
		// Call to the parent constructor
		super(name,yos,major,minor);
		
		
		ReadFile reader = new ReadFile("map.txt");
		mapOfInterest = reader.readMap();
		
		// Loops through each interest in interests and adds that interest to ClubPerson
		for (String d : interests) {
			addInterest(new String(d));
		}
		
		for (String s : faculties) {
			addFaculty(new String(s));
		}
		
		recommendedClubs = new ClubList();
		
	}
	
	
	/**
	 * This method  Initialize the recommendedClubs ClubList and populates the ClubList
	 * with Clubs based on the number of interests the person and Club have in common
	 * 
	 * @param masterList - A ClubList which contains all the clubs 
	 */
	public void InitializeRecommended(ClubList masterList) 
	{
		//Creates a new instance of ClubList
		recommendedClubs = new ClubList();
		for(int i = 0;i<masterList.getSize();i++) 
		{
			// A counter is created to count the number of interests in common
			int counter = 0;
			ArrayList<String> clubInterest = masterList.getClub(i).getCategory();
			for(int j = 0;j<interests.size();j++) 
			{
				// Loops through the interests and counts the number of interests in common
				if(clubInterest.contains(interests.get(j)))
					counter++;
			}
			if(counter!=0)
				// If the clubs do share an interests in common then they are added to the recommendedClubs ClubList
				recommendedClubs.addClub(new Club(masterList.getClub(i),counter));
				
		}
		
		// Sorts the recommendedClubs ClubList by the number of interests in common
		recommendedClubs.sortClubsByNumbInterest();
		
		
	}
	
	
	
	/**
	 * Precondition: InitializeRecommended(ClubList masterList) has been called
	 * Returns the recommendedClubs ClubList
	 * 
	 * @return recommendedClubs - The ClubList which contains clubs sorted by the number of interests in common
	 * 
	 */
	public ClubList getRecommended() 
	{
		return new ClubList(recommendedClubs);
	}
	
	/** Returns the interests the person has
	 * 
	 * @return nInterests - A copy of the interests ArrayList
	 */
	public ArrayList<String> getInterests() {
		ArrayList<String> nInterests = new ArrayList<String>();
		for (String d : interests) {
			nInterests.add(new String(d));
		}
		return nInterests;
		
	}
	
	/** Returns the faculties the person is apart of
	 * 
	 * @return nFaculties - A copy of the faculties ArrayList
	 */
	public ArrayList<String> getFaculties() {
		ArrayList<String> nFaculties = new ArrayList<String>();
		for (String s : faculties) {
			nFaculties.add(new String(s));
		}
		return nFaculties;
		
	}
	
	/**
	 * Adds an interest to the interests ArrayList
	 * @param newInterest - An interest the person has
	 */
	public void addInterest(String newInterest) {
		if(mapOfInterest.containsKey(newInterest))
			interests.add(new String(newInterest));
		else {
			System.out.println("Invalid interest");
		}
		
	}
	
	/**
	 * Adds faculty to the faculties ArrayList
	 * @param newFaculty - A faculty the person is apart of
	 */
	public void addFaculty(String newFaculty) {
		faculties.add(new String(newFaculty));
		
	}
	
	/**
	 * The method removes a interest from the interests ArrayList
	 * @param unwanted - The interest that is to be removed
	 */
	public void removeInterest(String unwanted) {
		interests.remove(new String(unwanted));
		
	}
	
	/**
	 * The method removes a faculty from the interests ArrayList
	 * @param unwanted - The faculty that is to be removed
	 */
	public void removeFaculty(String unwanted) {
		faculties.remove(new String(unwanted));
		
	}
	
	/**
	 * Displays the current interests the person has
	 */
	private void  displayInterests() 
	{
		for(int i = 0;i<interests.size();i++) 
		{
			System.out.println(interests.get(i) + ": " + mapOfInterest.get(interests.get(i)));
		}
		
	}
	
	/**
	 * Displays the current information stored within ClubPerson and MasterPerson classes
	 */
	public void displayInfo() 
	{
		super.displayInfo();
		System.out.println("Interests: ");
		displayInterests();
		
		
	}
	
}