package Backend;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

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
	 * 
	 * @param masterList
	 */
	public void InitializeRecommended(ClubList masterList) 
	{
		recommendedClubs = new ClubList();
		for(int i = 0;i<masterList.getSize();i++) 
		{
			int counter = 0;
			ArrayList<String> clubInterest = masterList.getClub(i).getCategory();
			for(int j = 0;j<interests.size();j++) 
			{
				if(clubInterest.contains(interests.get(j)))
					counter++;
			}
			if(counter!=0)
				recommendedClubs.addClub(new Club(masterList.getClub(i),counter));
				
		}
		
		recommendedClubs.sortClubsByNumbInterest();
		
		
	}
	
	
	// Getters and setters for the private variables
	
	public ClubList getRecommended() 
	{
		return new ClubList(recommendedClubs);
	}
	
	public ArrayList<String> getInterests() {
		ArrayList<String> nInterests = new ArrayList<String>();
		for (String d : interests) {
			nInterests.add(new String(d));
		}
		return nInterests;
		
	}
	
	public ArrayList<String> getFaculties() {
		ArrayList<String> nFaculties = new ArrayList<String>();
		for (String s : faculties) {
			nFaculties.add(new String(s));
		}
		return nFaculties;
		
	}
	
	public void addInterest(String newInterest) {
		if(mapOfInterest.containsKey(newInterest))
			interests.add(new String(newInterest));
		else {
			System.out.println("Invalid interest");
		}
		
	}
	
	public void addFaculty(String newFaculty) {
		faculties.add(new String(newFaculty));
		
	}
	
	public void removeInterest(String unwanted) {
		interests.remove(new String(unwanted));
		
	}
	
	public void removeFaculty(String unwanted) {
		faculties.remove(new String(unwanted));
		
	}
	
	private void  displayInterests() 
	{
		for(int i = 0;i<interests.size();i++) 
		{
			System.out.println(interests.get(i) + ": " + mapOfInterest.get(interests.get(i)));
		}
		
	}
	
	public void displayInfo() 
	{
		super.displayInfo();
		System.out.println("Interests: ");
		displayInterests();
		
		
	}
	
}