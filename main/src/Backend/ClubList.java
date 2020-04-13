package Backend;
import java.util.*;

/**
 * This is a wrapper class for the data structure ArrayList<Club>. The class provides 
 * methods to sort the ArrayList, add elements to the ArrayList, and return the information
 * stored in the ArrayList
 */

public class ClubList {
	
	// The ArrayList that stores all of the Club is the ClubList
	private ArrayList<Club> listOfClubs;
	
	/**
	 * ClubList constructor which initializes an empty ArrayList of Clubs
	 */
	public ClubList() 
	{
		listOfClubs = new ArrayList<Club> ();
	}
	
	/** Copy constructor for ClubList
	 * 
	 * @param copy - The ClubList that you want to copy from
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
	
	/**
	 * Returns the number of Clubs contained within listOfClubs
	 * 
	 * @return An integer representing the size of listOfClubs
	 */
	public int getSize() 
	{
		return listOfClubs.size();
	}
	
	/**
	 * A method for adding a Club into the ClubList
	 * 
	 * @param newClub -  A club that is added to listOfClubs
	 */
	public void addClub(Club newClub) 
	{
		listOfClubs.add(new Club(newClub));
	}
	
	/**
	 * A method that sorts the Clubs in listOfClubs in alphabetical order from the 
	 * names
	 */
	public void sortClubsByAlphabet() 
	{
		Collections.sort(listOfClubs, new Comparator<Club>() {
		    public int compare(Club v1, Club v2) {
		        return v1.getName().compareTo(v2.getName());
		    }
		});
	}
	
	/**
	 * A method that sorts the Clubs in listOfClubs by the number of interests in common
	 */
	public void sortClubsByNumbInterest() 
	{
		Collections.sort(listOfClubs, Collections.reverseOrder(new Comparator<Club>() {
		    public int compare(Club i1, Club i2) {
		        return i1.getNumbOfInterest() - i2.getNumbOfInterest();
		    }
		}));

	}
	
	/**
	 * Returns a copy of listOfClubs
	 * 
	 * @return copy -  A copy of the ArrayList listOfClubs, which contains all the clubs
	 * that ClubList stores
	 */
	public ArrayList<Club> getClubs() 
	{
		ArrayList<Club> copy = new ArrayList<Club> ();
		for(int i = 0;i<listOfClubs.size();i++) 
		{
			copy.add(new Club(listOfClubs.get(i)));
		}
		return copy;
	}
	
	/**
	 * Returns the string representation of ClubList, 
	 * 
	 * @return out - A formatted String which displays the index of which the club is in
	 * in list of Clubs followed by the name of the club
	 */
	public String toString() 
	{
		String out="";
		for(int i = 0;i<listOfClubs.size();i++) 
		{
			out+= (i+1) + ": " + listOfClubs.get(i).getName() + "\n";
		}
		return new String(out);
	}
	
	/** Returns a club from listOfClubs from a given index. If the index is not 
	 * valid, the method returns null
	 * 
	 * @param index - the index of the Club that is the be returned
	 * @return The club stored at the index
	 * */
	public Club getClub(int index) 
	{
		if(index>=0 && index<=listOfClubs.size()-1)
			return new Club (listOfClubs.get(index));
		else return null;
	}
}
