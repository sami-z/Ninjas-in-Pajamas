import java.util.*;
public class ClubList {
	
	// The ArrayList that stores all of the Club is the ClubList
	private ArrayList<Club> listOfClubs;
	
	//Constructor which initializes and empty ClubList 
	public ClubList() 
	{
		listOfClubs = new ArrayList<Club> ();
	}
	
	/* Copy constructor for ClubList
	 * 
	 * Parameters:
	 * copy: The ClubList that you want to copy from
	 * */
	public ClubList(ClubList copy) 
	{
		this();
		ArrayList<Club> copyArray = copy.getClubs();
		for(int i = 0;i<copyArray.size();i++) 
		{
			listOfClubs.add(new Club(copyArray.get(i)));
		}
	}
	
	// Returns the size of the listOfClubs ArrayList
	public int getSize() 
	{
		return listOfClubs.size();
	}
	
	// Adds a club to the listOfClubs ArrayList
	public void addClub(Club newClub) 
	{
		listOfClubs.add(new Club(newClub));
	}
	
	//Sorts the Clubs in listOfClubs by alphabetical order order
	public void sortClubsByAlphabet() 
	{
		Collections.sort(listOfClubs, new Comparator<Club>() {
		    public int compare(Club v1, Club v2) {
		        return v1.getName().compareTo(v2.getName());
		    }
		});
	}
	
	//Sorts the Clubs in listOfClubs by the numbOfInterest in the Club class
	public void sortClubsByNumbInterest() 
	{
		Collections.sort(listOfClubs, Collections.reverseOrder(new Comparator<Club>() {
		    public int compare(Club i1, Club i2) {
		        return i1.getNumbOfInterest() - i2.getNumbOfInterest();
		    }
		}));

	}
	
	// Returns a copy of listOfClubs
	public ArrayList<Club> getClubs() 
	{
		ArrayList<Club> copy = new ArrayList<Club> ();
		for(int i = 0;i<listOfClubs.size();i++) 
		{
			copy.add(new Club(listOfClubs.get(i)));
		}
		return copy;
	}
	
	// Displays all of the clubs in listOfClubs
	public void displayClubList() 
	{
		for(int i = 0;i<listOfClubs.size();i++) 
		{
			System.out.println((i+1) + ": " + listOfClubs.get(i).getName());
		}
	}
	
	/* Returns a club from listOfClubs based on interests
	 * 
	 * Parameters:
	 * index: the index of the Club that is the be returned
	 * */
	public Club getClub(int index) 
	{
		if(index>=0 && index<=listOfClubs.size()-1)
			return new Club (listOfClubs.get(index));
		else return null;
	}
}
