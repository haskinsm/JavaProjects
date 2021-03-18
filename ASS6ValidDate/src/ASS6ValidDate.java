import java.util.Scanner;
import javax.swing.JOptionPane;

public class ASS6ValidDate {
	
	/* SELF ASSESSMENT

	 1. Did I use appropriate, easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?

	        Mark out of 5: 5
	        Comment: Didn't see any point in using any, so I didn't. Could of possibly used MAX_DAYS_IN_FEB = 28
	        but I didn't see how it would make my code any easier to understand.

	 2. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

	        Mark out of 5: 5
	        Comment:   Yes e.g. dayOfWeek.

	 3. Did I indent the code appropriately?

	        Mark out of 5:  5
	        Comment: Yes.

	 4. Did I define the required functions correctly (names, parameters & return type) and invoke them correctly?

	       Mark out of 20: 20
	        Comment:  Yes, everything worked.

	 5. Did I implement the dayOfTheWeek function correctly and in a manner that can be understood?

	       Mark out of 20: 20
	        Comment:  Yes, I think it is quite clear.

	 6. Did I implement the other functions correctly, giving credit for any code that you take from elsewhere?

	       Mark out of 20: 20
	        Comment:  This was all my own code, other than the Gaussian algorithm format.

	 7. Did I obtain (and process) the input from the user in the correct format (dd/mm/yyyy), and deal with any invalid input properly?       
	      Mark out of 10: 10
	        Comment:  Yes, exceptions were caught.

	 8. Does the program produce the output in the correct format (e.g. Monday, 25th December 2017)?

	       Mark out of 10: 10
	        Comment:  Yes.

	 9. How well did I complete this self-assessment?

	        Mark out of 5: 5
	        Comment: Well, but I felt my code was quite long but didn't see how to 
	        significantly shorten it anywhere.

	 Total Mark out of 100 (Add all the previous marks): 100.

	*/ 

	public static void main(String[] args) {
		
		try
		{
				String input = JOptionPane.showInputDialog(" Enter a date to check if it is valid, seperate"
						+ " the day, month and year by spaces. i.e. 24 10 1999");
				Scanner inputScanner = new Scanner( input);
				int date = inputScanner.nextInt();
				int month = inputScanner.nextInt();
				int year = inputScanner.nextInt();
				int lastNumberOfDate = 0;
				if( date > 10)
				{
					lastNumberOfDate = date % 10;
				}
				if( date < 10)
				{
					lastNumberOfDate = date;
				}
				String dateEnding = "";
				switch( lastNumberOfDate )
				{
				case 1:
					    dateEnding += "st";
					    break;
				case 2:
					    dateEnding += "nd";
					    break;
				case 3:
					    dateEnding += "rd";
					    break;
				default:
					    dateEnding += "th";
					    break;
				}
				if(isValidDate( date, month , year))
				{
					JOptionPane.showMessageDialog(null, "The date you have entered is " + day( date, month, year)
					     + ", " + date + dateEnding + monthInWords( month) + " " + year + " and it is a valid date.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "The date you have entered, " + date + "/" + 
				         month + "/" + year + ", is an invalid date.");
				}
				inputScanner.close();
		}catch (java.util.NoSuchElementException exception)
		{
			JOptionPane.showMessageDialog(null, "This is not a valid input.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		catch ( NullPointerException exception)
		{
			JOptionPane.showMessageDialog(null, "This is not a valid input.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//Functions must be below, outside main( String [] args) to work
	public static boolean isValidDate( int date, int month, int year)
	{
		boolean isValidDate = true;
		int totalDaysInMonth = daysInMonth( month, year);
		if(month > 12 || date> totalDaysInMonth || year < 0)
		{
			isValidDate = false; 
		}
		return(isValidDate);
	}
	
	public static final int daysInMonth( int month, int year )
	{
		boolean leapYear = isLeapYear( year );
		int daysInMonth;
		if(leapYear = true && month == 2)
		{
			daysInMonth = 29;
		}
		else
		{
			if(month == 11 || month == 4 || month == 6 || month == 9)
			{
				daysInMonth = 30;
			}
			else if( month == 2)
			{
				daysInMonth = 28;
			}
			else
			{
				daysInMonth = 31;
			}
		}
		return(daysInMonth);
	}
	
    public static boolean isLeapYear( int year )
	{
		boolean leapYear = false;
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) //% is remainder.
		{
			leapYear = true;
		}
		return(leapYear);
	}
    
	public static final String monthInWords( int month) 	
	{
		String monthWords = "";
		switch( month )
		{
		case 1:
			    monthWords = " January";
			    break;
		case 2:
			    monthWords = " February";
			    break;
		case 3:
			    monthWords = " March";
			    break;
		case 4:
			    monthWords = " April";
			    break;
		case 5:
			    monthWords = " May";
			    break;
		case 6:
			    monthWords = " June";
			    break;
		case 7:
			    monthWords = " July";
			    break;
		case 8:
			    monthWords = " August";
			    break;
		case 9:
			    monthWords = " September";
			    break;
		case 10:
			    monthWords = " October";
			    break;
		case 11:
			    monthWords = " November";
			    break;
		case 12:
			    monthWords = " December";
			    break;	    
		}
		return(monthWords);
	}
	
	//function below will work for dates between the years 1000 and 9999 AD. i.e. four digit years.
	public static final String day( int date, int month, int year) 
	//changes answer if these are doubles for some reason. 
	//e.g. Saturday 10th Nov. becomes Sunday 10th Nov. when doubles used here. To do with rounding probably.
	{
		String day = " ";
		double lastTwoDigitsYear = 0;
		double firstTwoDigitsYear = 0;
		if(month == 1 || month == 2)
		{
			lastTwoDigitsYear = (year -1) % 100;
			firstTwoDigitsYear = (year -1) / 100;
		}
		else
		{
		    lastTwoDigitsYear = year % 100;
		    firstTwoDigitsYear = year / 100;
		}
		int dayOfWeek = Math.abs((int)((date + Math.floor(2.6*(((month + 9)% 12)+1)- 0.2) + lastTwoDigitsYear 
				+ Math.floor(lastTwoDigitsYear/4) + Math.floor(firstTwoDigitsYear/4) - 2*(firstTwoDigitsYear)))% 7); 
		//floor is a function used for rounding and % 7 is a modulus. i.e. % is a modulus and remainder sign.
		switch( dayOfWeek )
		{
		case 0:
			    day = "Sunday";
			    break;
		case 1:
			    day = "Monday";
			    break;
		case 2:
			    day = "Tuesday";
			    break;
		case 3:
			    day = "Wednesday";
			    break;
		case 4:
			    day = "Thursday";
			    break;
		case 5:
			    day = "Friday";
			    break;
		case 6: 
			    day = "Saturday";
			    break;
		}
		return(day);		   
	}
	

}


	