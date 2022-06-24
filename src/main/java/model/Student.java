package model;

/**
 * Entity class: Student
 * 
 * @author Vladislav Altunin
 */
public class Student {
	private int id;
	private String firstname;
	private String lastname;
	private String streetaddress;
	private String postcode;
	private String postoffice;

	public Student() {
		id = -1;
		firstname = "";
		lastname = "";
		streetaddress = "";
		postcode = "";
		postoffice = "";
	}

	public Student(int id, String firstname, String lastname, String streetaddress, String postcode, String postoffice) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.streetaddress = streetaddress;
		this.postcode = postcode;
		this.postoffice = postoffice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastName() {
		return lastname;
	}
	
	public void setLastName(String lastName) {
		this.lastname = lastName;
	}
	
	public String getStreetAddress() {
		return streetaddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetaddress = streetAddress; 
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public void setPoastcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getPostOffice() {
		return postoffice;
	}
	
	public void setPostOffice(String postOffice) {
		this.postoffice = postOffice;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", first name=" + firstname + ", last name=" + lastname + ", street address=" + streetaddress + ", postcode=" + postcode + ", post office=" + postoffice + "]";
	}
}
// End
