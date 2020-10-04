import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Countries {
	private int attendeeCount = 0;
	private String [] attendees;
	private String name; //Country Name
	private String startDate;
	@JsonIgnore
	public String endDate;
	@JsonIgnore
	public ArrayList<Partner> partnersArrayL = new ArrayList<>();
	
	
	public int getAttendeeCount() {
		return attendeeCount;
	}
	public void setAttendeeCount(int attendeeCount) {
		this.attendeeCount = attendeeCount;
	}
	
	public String[] getAttendees() {
		return attendees;
	}
	public void setAttendees(String[] attendees) {
		this.attendees = attendees;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
}
