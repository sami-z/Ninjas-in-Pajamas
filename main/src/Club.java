import java.util.*;
public class Club {
	
	// Name of the club
	private String name;
	
	// Description of the club
	private String description;
	
	//ArrayList of the categories that the club 
	private ArrayList<String> categories = new ArrayList<String>();
	
	// Club website
	private String link;
	
	//Number of interest that the club and person share
	private int numbOfInterest = 0;
	
	
	/*
	 * Club Constructor
	 * 
	 * Parameters: 
	 * Name: Name of the club
	 * Description: The description of the club
	 * link: The link of the club
	 * cate: The String array of categores that the club fits
	 * */
	public Club(String Name, String Description,String link, String[] cate) 
	{
		setName(Name);
		setDescription(Description);
		setLink(link);
		for(int i = 0;i<cate.length;i++) 
		{
			categories.add(cate[i]);
		}
	}
	
	
	/* 
	 * Copy constructor for Club
	 * 
	 * Parameters:
	 * copy: The club that you want to copy from
	 * */
	public Club(Club copy) 
	{
		setName(copy.name);
		setDescription(copy.description);
		setLink(copy.link);
		for(int i = 0;i<copy.categories.size();i++) 
		{
			categories.add(copy.categories.get(i));
		}
		setNumbOfInterest(copy.getNumbOfInterest());
	}
	
	
	/*
	 * Club constructor which takes a club of number of interest in common
	 * 
	 * Parameters:
	 * 
	 * copy: The club that you want to copy from
	 * numbOfInterest: The number of interest that the club and person share
	 * */
	public Club(Club copy, int numbOfInterest) 
	{
		this(copy);
		setNumbOfInterest(numbOfInterest);
	}
	
	
	// Set the number of interest
	public void setNumbOfInterest(int c) 
	{
		numbOfInterest = c;
	}
	
	// Returns the number of interest the person and club share
	public int getNumbOfInterest() 
	{
		return numbOfInterest;
	}
	
	// Sets name
	public void setName(String name) 
	{
		this.name = name;
	}
	
	// Gets name of club
	public String getName() 
	{
		return name.replace('_', ' ');
	}
	
	// Sets the description of the club
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	// Returns the description of the club
	public String getDescription() 
	{
		return description;
	}
	
	// Set the link of the club
	public void setLink(String link) 
	{
		this.link = link;
	}
	
	// Returns the link of the club
	public String getLink() 
	{
		return link;
	}
	
	// Adds a category to the club
	public void addCategory(String cate) 
	{
		categories.add(cate);
	}
	
	// Returns a copy of the categories of which the club fits
	public ArrayList<String> getCategory()
	{
		ArrayList<String> copy = new ArrayList();
		for(int i = 0;i<categories.size();i++) 
		{
			copy.add(new String(categories.get(i)));
		}
		return copy;
	}
	
	// Formats and diplays the inforamtion about the club
	public void displayInfo()
	{
		System.out.println("Name: " + name.replace('_', ' '));
		System.out.println("Description: " + description);
		System.out.println("Link: " + link);
		System.out.println("Interests: " + numbOfInterest);
		System.out.println();
	}
	
}
