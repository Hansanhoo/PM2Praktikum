package controler;

import java.util.Date;

public class Customer {
	long id;
	String firstname;
	String familyname;
	Date date;
	
	public Customer(String firstname, String familyname) {
		this.firstname =firstname;
		this.familyname = familyname;
		Date d = new Date();
		d.getDate();
		this.date = d;	
		//ich hab keine Ahnung wie ich jetzt die sequence nutze für die Id
		
	}
	
	public Customer(long id,String firstname, String familyname) {
		this.id = id;
		this.firstname = firstname;
		this.familyname = familyname;
		Date d = new Date();
		d.getDate();
		this.date = d;	
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firtsname) {
		this.firstname = firtsname;
		Connector.onUpdateFirstName(this);
	}
	public String getFamilyname() {
		return familyname;
	}
	public void setFamilyname(String familyname) {
		this.familyname = familyname;
		Connector.onUpdateFamilyName(this);
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
