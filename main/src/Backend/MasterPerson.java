package Backend;

public class MasterPerson {
	
	//Name of the person
	private String name;
	
	//Age of the person
	private int yos;
	
	// Major program the person is in
	private String major;
	
	// Minor program the person is in
	private String minor;
	
	/** Master Person constructor
	 * 
	 * @param name - Name of the person
	 * @param yos - The person's current year of study
	 * @param major - The major of the person
	 * @param minor - The minor of the person
	 * 
	 */
	public MasterPerson(String name, int yos, String major, String minor) 
	{
		this.name = new String(name);
		this.yos = yos;
		this.major = new String(major);
		this.minor = new String(minor);
	}
	
	/** Master Person copy constructor
	 * 
	 * @param copy - An instance of MasterPerson
	 * 
	 */
	public MasterPerson(MasterPerson copy) 
	{
		this.name = copy.getName();
		this.yos = copy.getYOS();
		this.major = copy.getMajor();
		this.minor = copy.getMinor();
	}
	
	/** getName()
	 * Returns the name of the person 
	 * @return name - a String which represents the name of the person
	 */
	public String getName() {
		return new String(name);
		
	}
	
	/** getYOS()
	 * Returns the year of study of the person 
	 * @return yos - an integer which represents the year of study of the person
	 */
	public int getYOS() {
		return yos;
	
	}
	
	/** getMajor()
	 * Returns the major of the person
	 * @return major - a String which represents the major of the person
	 */
	public String getMajor() {
		return new String(major);
		
	}
	
	/** getMinor()
	 * Returns the minor of the person 
	 * @return minor - a String which represents the minor of the person
	 */
	public String getMinor() {
		return new String(minor);
		
	}
	
	/** setName(String newName) 
	 * Sets the name of the person
	 * @param newName - a String which represents the name of the person
	 */
	public void setName(String newName) {
		name = new String(newName);
		
	}

	/** setYOS(int yos) 
	 * Sets the year of study of the person
	 * @param yos - an integer which represents the year of study of the person
	 */
	public void setYOS(int yos) {
		this.yos = yos;
		
	}
	
	/** setMajor(String newMajor) 
	 * Sets the major of the person
	 * @param newMajor - a String which represents the major of the person
	 */
	public void setMajor(String newMajor) {
		major = new String(newMajor);
		
	}
	
	/** setMinor(String newMinor) 
	 * Sets the minor of the person
	 * @param newMinor - a String which represents the minor of the person
	 */
	public void setMinor(String newMinor) {
		minor = new String(newMinor);
	}
	
	/** displayInfo() 
	 * Prints the name, year of study, major, and minor of the person
	 */
	public void displayInfo() 
	{
		System.out.println("Name: " + getName());
		System.out.println("Year of Study: " + getYOS());
		System.out.println("Major: " + getMajor());
		System.out.println("Minor: " + getMinor());
	}
	
	
}
