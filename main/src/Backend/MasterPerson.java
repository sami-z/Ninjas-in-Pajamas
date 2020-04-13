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
	
	public MasterPerson(String name, int yos, String major, String minor) 
	{
		this.name = new String(name);
		this.yos = yos;
		this.major = new String(major);
		this.minor = new String(minor);
	}
	
	public MasterPerson(MasterPerson copy) 
	{
		this.name = copy.getName();
		this.yos = copy.getYOS();
		this.major = copy.getMajor();
		this.minor = copy.getMinor();
	}
	
	public String getName() {
		return new String(name);
		
	}
	
	public int getYOS() {
		return yos;
	
	}
	
	public String getMajor() {
		return new String(major);
		
	}
	
	public String getMinor() {
		return new String(minor);
		
	}
	
	
	public void setName(String newName) {
		name = new String(newName);
		
	}

	public void setYOS(int yos) {
		this.yos = yos;
		
	}
	
	public void setMajor(String newMajor) {
		major = new String(newMajor);
		
	}
	
	public void setMinor(String newMinor) {
		minor = new String(newMinor);
	}
	
	public void displayInfo() 
	{
		System.out.println("Name: " + getName());
		System.out.println("Year of Study: " + getYOS());
		System.out.println("Major: " + getMajor());
		System.out.println("Minor: " + getMinor());
	}
	
	
}
