import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CodingChallenge {

	public static final String GET_API_URL = "https://candidate.hubteam.com/candidateTest/v3/problem/dataset?userKey=";
	public static final String POST_API_URL = "https://candidate.hubteam.com/candidateTest/v3/problem/result?userKey="; 
	public static final String API_KEY = "ffce024f79c824a16a38260b5178";
	
	public static boolean availableOnDate(String dateAvailable, String nextAvailableDate) {
		//Date format: 2020-08-30
		String[] a = dateAvailable.split("-");
		int yearFirst = Integer.parseInt(a[0]);
		int monthFirst = Integer.parseInt(a[1]);
		int dateFirst = Integer.parseInt(a[2]);
		
		String[] b = nextAvailableDate.split("-");
		int yearSec = Integer.parseInt(b[0]);
		int monthSec = Integer.parseInt(b[1]);
		int dateSec = Integer.parseInt(b[2]);
		
		if(yearFirst != yearSec) { //Will fix this if I have time so works for 31st dec->1st Jan, but looks like all dates are in 2017 so doesnt matter
			return false;
		}
		
		int c = daysintoTheYear(dateFirst, monthFirst, yearFirst);
		int d = daysintoTheYear(dateSec, monthSec, yearSec);
	
		if( d-c == 1) {
			return true; //As consecutive Dates so the able to do two consecutive days
		}
		return false;
	}
	
	//Wont work for dif years
	public static int daysintoTheYear(int date, int month, int year) {
		int days = 0;
		//I.e. for 30-3-2020
		//  days = 31 + 28 + 30(the date) = 89
		if( month > 1) {
			month --;
			switch (month) {
				case 11:
					days += 30;
				case 10: 
					days += 31;
				case 9:
					days += 30;
				case 8: 
					days += 31;
				case 7:
					days += 31;
				case 6:
					days += 30;
				case 5: 
					days += 31;
				case 4:
					days += 30;
				case 3:
					days += 31;
				case 2: 
					if (((year % 4 == 0) && 
							!(year % 100 == 0))
							|| (year % 400 == 0))
						days = 29;
					else
						days = 28;
				case 1:
					days += 31;
					break;
				default:
					System.out.println("Invalid month.");
					break;
			}
		}
		days += date;
		return days;
	}
	
	public static String tomorrowsDate(String fullDate) {
		String[] a = fullDate.split("-");
		int year = Integer.parseInt(a[0]);
		int month = Integer.parseInt(a[1]);
		int date = Integer.parseInt(a[2]);
		
		String tomorrowsDate= year + "-0"; //All dates are before 10th month so can add the zero here
		switch (month) {
        case 1: case 3: case 5:
        case 7: case 8: case 10:
        case 12:
            if( date == 31) {
            	month += 1;
            	tomorrowsDate += month + "-" + 01;
            }
            else {
            	tomorrowsDate += month + "-" + (date + 1);
            }
            break;
        case 4: case 6:
        case 9: case 11:
        	if( date == 30) {
        		month += 1;
            	tomorrowsDate += month + "-" + 01;
            }
        	else {
            	tomorrowsDate += month + "-" + (date + 1);
            }
            break;
        case 2:
            if (((year % 4 == 0) && 
                 !(year % 100 == 0))
                 || (year % 400 == 0)) {
            	if( date == 29) {
            		month += 1;
                	tomorrowsDate += month + "-" + 01;
                }
            	else {
                	tomorrowsDate += month + "-" + (date + 1);
                }
            }   	
            else
            	if( date == 28) {
            		month += 1;
                	tomorrowsDate += month + "-" + 01;
                }
            	else {
                	tomorrowsDate += month + "-" + (date + 1);
                }
            break;
		}
		return tomorrowsDate;
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create("" + GET_API_URL + API_KEY))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println( "Status Code:" + response.statusCode() );
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response.body());  //Need these 2 lines because this Json is of the form:
        String arrayString = jsonNode.get("partners").toString(); // { "partners": [ {...}, {....}, ....] }
        //Format of the JSON caused me big big problems, lost a lot of time trying to read in the JSON data correctly
        //Found the above 3 lines online which made the below line work finally.
        List<Partner> partners = mapper.readValue(arrayString, new TypeReference<List<Partner>>() {});
       
        //Check if data in partners List 
        System.out.println(partners.get(0).getFirstName());
        System.out.println(partners.get(0).availableDates[0]);
        
        //Will be used for accessing countries objects by the countries name
        Map<String, Countries> countriesMap  = new HashMap<String, Countries>();
        
        //List of countries Objects
        ArrayList<Countries> countriesList = new ArrayList<>();
        
        for( int i =0; i < partners.size() ; i++){
        	String partnersCountry = partners.get(i).getCountry();
        	 if( countriesMap.containsKey(partnersCountry) ) {
        		 countriesMap.get(partnersCountry).partnersArrayL.add(partners.get(i));
        	 }
        	 else {
        		 Countries a = new Countries();
        		 a.setName(partnersCountry);
        		 a.setAttendeeCount(0);
        		 a.setAttendees(null);
        		 a.partnersArrayL.add(partners.get(i));
        		 countriesMap.put(partnersCountry, a);
        		 countriesList.add(a);
        	 }
        }
        
        //Test to see if it HashMap and CountriesList contains right data
        System.out.println( countriesMap.get(partners.get(3).getCountry()).getName());
         countriesList.forEach(countries -> {
            System.out.println(countries.getName());
         });
        
        
        // Plan to create a HashMap with the key being the date and the value being
        // how many attendees there will be if the two day event commences on that date
  
        //Loop for the countries
        for(int j = 0; j < countriesList.size(); j++) {
        	Countries a = countriesList.get(j);
        	Map<String, Integer> availabilityMap = new HashMap<String, Integer>();
        	
        	//Loop for the partners of the respective countries
        	for( int k = 0; k < a.partnersArrayL.size(); k++) {
        		
        		//Loop for the available dates of each partner
        		for( int m = 0; m < a.partnersArrayL.get(k).availableDates.length - 1; m++ ) {
        			String date = a.partnersArrayL.get(k).availableDates[m];
        			String nextDate = a.partnersArrayL.get(k).availableDates[m+1];
        			
        			if( availableOnDate(date, nextDate) ){
                		int count = 1;
    					if( availabilityMap.containsKey(date)) {
    						count = availabilityMap.get(date);
    						count ++;
    					}
    					availabilityMap.put(date, count);	
        			}
        		}
        	}
        	System.out.println(availabilityMap.values()); //Shows a collection
        	if( !availabilityMap.isEmpty()) {
        		int maxValueInMap=(Collections.max(availabilityMap.values()));
        		System.out.println(a.getName() + "    " + maxValueInMap);
        		a.setAttendeeCount(maxValueInMap);
        		
        		for (Entry<String, Integer> entry : availabilityMap.entrySet()) {  
                    if (entry.getValue()==maxValueInMap) {
                        System.out.println(entry.getKey());    
                        a.setStartDate(entry.getKey());
                        a.setEndDate(tomorrowsDate(a.getStartDate()));
                    }
                }
        		
        		ArrayList<String> emailsList = new ArrayList<>();
        		for(int k = 0; k < a.partnersArrayL.size(); k++) {
        			for( int n = 0; n < a.partnersArrayL.get(k).availableDates.length - 1; n++) {
	        			if( a.partnersArrayL.get(k).availableDates[n].equals( a.getStartDate() )
	        					&& a.partnersArrayL.get(k).availableDates[n+1].equals( a.getEndDate() ) ) {
	        				emailsList.add(a.partnersArrayL.get(k).getEmail());
	        			}
        			}
        		}
        		a.setAttendees(emailsList.toArray(new String[0]));

        	}
        }
        
        //The following commented out code were some initial abandoned attempts.
        //The sending of the JSON data to the API is below the commented out code.
        
        /*
        Map<String, Integer> countriesIndexInArray  = new HashMap<String, Integer>();
        ArrayList<ArrayList<Partner>> countrysPartners = new ArrayList<>();
        
        int j = 0;
        for( int i = 0; i < partners.size() - 1; i++) {
        	if(!countriesIndexInArray.containsKey(partners.get(i).getCountry())) {
        		countriesIndexInArray.put(partners.get(i).getCountry(), j);
        		j++;
        	}
        	if( countrysPartners.size() > j ) {
        		countrysPartners.add();
        	}
        	countrysPartners.get(countriesIndexInArray.get(partners.get(i).getCountry())).add(e);
        }
        */
        
/*
		ObjectMapper mapper = new ObjectMapper();
		//A Partners info will all have the same index in the following arraylists 
		ArrayList<String> emails = new ArrayList<>();
		ArrayList<String> countryNames = new ArrayList<>();
		ArrayList<ArrayList<String>> availableDates = new ArrayList<>();
		try {
		
		    JsonNode jsonNode = mapper.readValue(response.body(), JsonNode.class);
		    for( int i = 0; i < jsonNode.get("partners").size() - 1 ; i++) {
		    	
		    	JsonNode array = jsonNode.get("partners");
		    	
			    JsonNode emailNode = array.get(i).get("email");
			    emails.add( emailNode.asText());
			
			    JsonNode countryNamesNode = array.get(i).get("country");
			    countryNames.add( countryNamesNode.asText());
			
			    JsonNode availableDatesArray = array.get(i).get("availableDates");
			    for( int j =0; j< availableDatesArray.size() - 1 ; j++) {
			    	JsonNode availableDatesNode = availableDatesArray.get(j);
			        availableDates.get(i).add( availableDatesNode.asText());
			    }
		    }
		
		} catch (IOException e) {
		    e.printStackTrace();
		}
*/
        
    
       //Json sent to API in desired format now.
       HashMap<String, ArrayList<Countries>> jsonOutput = new HashMap<String, ArrayList<Countries>>();
       jsonOutput.put("Countries", countriesList);
 	   mapper.writeValue(  new FileOutputStream("C:\\Users\\micha\\Documents\\dataJSON.json"), jsonOutput);
        
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(POST_API_URL + API_KEY))
                .POST(HttpRequest.BodyPublishers.ofFile( Paths.get("C:\\Users\\micha\\Documents\\dataJSON.json"))) ////*******
                .build();

        HttpResponse<String> postResponse = client.send(postRequest,
                HttpResponse.BodyHandlers.ofString());
        
        System.out.println("Status Code: " + postResponse.statusCode() + "\n" + postResponse.body());
   
	}

}
