import java.util.Scanner;
import javax.swing.JOptionPane;

public class Tutorial8ValidDateFunctions {

	public static void main(String[] args) {
		
		String input = JOptionPane.showInputDialog(" Enter a day to check if it is valid, seperate"
				+ " the day, month and year by spaces. i.e. 24 10 1999");
		Scanner inputScanner = new Scanner( input);
		int day = inputScanner.nextInt();
		int month = inputScanner.nextInt();
		int year = inputScanner.nextInt();
		if(isValidDate( day, month , year))
		{
			JOptionPane.showMessageDialog(null, "The date you have entered, " + day + "/" +
		          month + "/" + year + " is valid.");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "The date you have entered, " + day + "/" + 
		         month + "/" + year + ", is an invalid date.");
		}
		inputScanner.close();
	}
	public static boolean isValidDate( int day, int month, int year)
	{
		boolean isValidDate = true;
		int totalDaysInMonth = daysInMonth( month, year);
		if(month > 12 || day> totalDaysInMonth || year < 0)
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
	

}
