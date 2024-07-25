package mypack;

public class Contact 
{
	private int contactid;
	private String name;
	private String email;
	
	
	public Contact(String name, String email) {
		
		this.name = name;
		this.email = email;
	}
	
	public int getContactid() {
		return contactid;
	}
	public void setContactid(int contactid) {
		this.contactid = contactid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
