package Backend;
import java.util.*;

/**
 * This class stores the data of each club and provides methods to extract the data
 * and display the information.
 */

public class Club {
	
	// Name of the club
	private String name;
	
	// Description of the club
	private String description;
	
	//ArrayList of the categories that the club 
	private ArrayList<String> categories = new ArrayList<String>();
	
	// Club website link stored as a string
	private String link;
	
	//Number of interest that the club and person share
	private int numbOfInterest = 0;
	
	
	/** Club(String, String, String, String[])
	 * Club Constructor
	 * 
	 *  
	 * @param Name - Name of the club
	 * @param Description - The description of the club
	 * @param link - The link of the club
	 * @param cate - The String array of categories that the club fits
	 * */
	public Club(String Name, String Description,String link, String[] cate) 
	{
		setName(new String(Name));
		setDescription(new String(Description));
		setLink(new String(link));
		for(int i = 0;i<cate.length;i++) 
		{
			categories.add(new String(cate[i]));
		}
	}
	
	
	/** Club(Club)
	 * Copy constructor for Club
	 * @param copy - The club that you want to copy from
	 * @return A Club object which is a deep copy of the Club passed in as an argument
	 * does not copy the number of interests in common
	 * */
	public Club(Club copy) 
	{
		setName(new String(copy.name));
		setDescription(new String(copy.description));
		setLink(new String(copy.link));
		for(int i = 0;i<copy.categories.size();i++) 
		{
			categories.add(new String(copy.categories.get(i)));
		}
		setNumbOfInterest(copy.getNumbOfInterest());
	}
	
	
	/** Club(Club, int)
	 * Club constructor which takes a club of number of interest in common
	 * 
	 * @param copy - The club that you want to copy from
	 * @param numbOfInterest - The number of interest that the club and person share
	 * @return A Club object which is a deep copy of the Club passed in as an argument
	 * copy's the number of interests in common
	 * */
	public Club(Club copy, int numbOfInterest) 
	{
		this(copy);
		setNumbOfInterest(numbOfInterest);
	}
	
	
	/** setNumbOfInterest(int)
	 * Sets the number of interests a the club and person share.
	 * @param numbOfInterest - An integer which represents the number of interests
	 * the club and person share.
	 * */
	public void setNumbOfInterest(int numbOfInterest) 
	{
		this.numbOfInterest = numbOfInterest;
	}
	
	/** getNumbOfInterest()
	 * Returns the number of interests a the club and person share.
	 * @return numbOfInterest - An integer which represents the number of interests
	 * the club and person share.
	 * */
	public int getNumbOfInterest() 
	{
		return numbOfInterest;
	}
	
	/** setName(String)
	 * Sets the clubs names.
	 * @param name - A String containing the name of the club
	 * */
	public void setName(String name) 
	{
		this.name = new String(name);
	}
	
	/** getName()
	 * Returns the name of the Club.
	 * @return name - A String containing the name of the club with all '_' replaced with
	 * ' '
	 * */
	public String getName() 
	{
		return new String(name.replace('_', ' '));
	}
	
	/** setDescription(String)
	 * Sets the description of the Club.
	 * @param description - A String containing the description of the club
	 * */
	public void setDescription(String description) 
	{
		this.description = new String(description);
	}
	
	/** getDescription()
	 * Returns the description of the Club.
	 * @return description - A String containing the description of the club
	 * */
	public String getDescription() 
	{
		return new String(description);
	}
	
	/** setLink(String)
	 * Sets the link of the club
	 * @param link - The link for the clubs website
	 * */
	public void setLink(String link) 
	{
		this.link = new String(link);
	}
	
	/** getLink()
	 * Returns the link of the club
	 * @return link - The link for the clubs website
	 * */
	public String getLink() 
	{
		return new String(link);
	}
	
	/** addCategory(String)
	 * Method that adds a category the clubs falls under to an ArrayList.
	 * @param cate - A string containing the clubs fits 
	 * */
	public void addCategory(String cate) 
	{
		categories.add(new String(cate));
	}
	
	/** getCategory()
	 * Returns an ArrayList of the categories that the club falls under
	 * @return copy - A copy of the categories the club falls under
	 * */
	public ArrayList<String> getCategory()
	{
		ArrayList<String> copy = new ArrayList();
		for(int i = 0;i<categories.size();i++) 
		{
			copy.add(new String(categories.get(i)));
		}
		return copy;
	}
	
	/** toString()
	 * Returns a formatted string representation of the information stored in the Club
	 * 
	 * @return out - A formatted string containing the Name, Description, Link and Interests 
	 * associated with the club.
	 * */
	public String toString()
	{
		String out = "";
		out += "Name: " + name.replace('_', ' ') + "\n";
		out+= "Description: " + description+"\n";
		out += "Link: " + link + "\n";
		out += "Interests: " + numbOfInterest + "\n";
		out+="\n";
		return out;
	}
	
}
