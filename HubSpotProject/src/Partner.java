import com.fasterxml.jackson.annotation.JsonIgnore;

public class Partner {
	private String firstName;
	private String lastName;
	private String email;
	private String country;
	public String [] availableDates;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String[] getAvailableDates() {
		return availableDates;
	}
	public void setAvailableDates(String[] availableDates) {
		this.availableDates = availableDates;
	}
		
	
}
