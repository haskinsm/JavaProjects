import java.util.Scanner;
import javax.swing.JOptionPane;
import java.math.*;
import java.util.Random;
    //***Student Number 18323076****    ETest2 30/11/2018
//Mistakes in ETest:
//1. With error string never actually printed it. i.e. did not use System.out.println()
//2. Closed my inputScanner in the do while loop and this caused 'please enter...' to
//   be printed out endlessly.
//3. Slight mistake in my getFormattingString() function, when 2 pounds is entered it will 
//   include the comma: '2 Pounds, is equal to 0.90718464kg'.
//4. Program does not handle negatives or when say the user enters only two values.
//****Every mistake has been fixed now****
public class ETest2 {

	public static final int OUNCES_IN_A_POUND = 16;
	public static final int POUNDS_IN_A_STONE = 14;
	public static final double ONE_OUNCE_TO_KILOS = 0.02834952;
	
	public static void main(String[] args) {
		
		boolean finished = false;
		Scanner inputScanner = new Scanner( System.in );//When using loops better to open + close scanner outside loop
		do
		{
			double stones = 0;
	        double pounds = 0;
		    double ounces = 0;
			System.out.println("Please enter the number of stones, pounds and ounces separated by spaces(or enter quit):");
			if(inputScanner.hasNextDouble())
			{
				stones = inputScanner.nextDouble();
				if(inputScanner.hasNextDouble())
				{
					pounds = inputScanner.nextDouble();
				}
				else 
				{
					System.out.println(errorString());
			    }
				if(inputScanner.hasNextDouble())
				{
				    ounces = inputScanner.nextDouble();
				    if(stones >= 0 && pounds >= 0 && ounces >= 0) //This handles if they enter negative numbers
				    {
					System.out.println( getFormattedString( stones, pounds, ounces) + "is equal to " +
					             convertToKilograms(stones, pounds, ounces) + "kg");
				    }
				    else
				    {
				    	System.out.println(errorString() + "\n" + "*** You must enter POSITIVE real numbers *** ");    	
				    }
				}
				else 
				{
					System.out.println(errorString());
			
			    }
			}
			else if( inputScanner.hasNext("quit"))
			{
				finished = true;
				System.out.println("Goodbye!");
			}
			else if(inputScanner.hasNext())
			{
				System.out.println(errorString());
			}
			
		}while(!finished);
		inputScanner.close();
		
		
		

	}
	//Functions below
	public static final String getFormattedString( double stones, double pounds, double ounces)
	{
		String formattedString = "";
		if(stones == 0 && pounds == 0 && ounces == 0 )
		{
			formattedString += "0 ounces ";
		}
		else 
		{
            formattedString += ((stones > 0) ? (stones + " Stone" + ((stones == 1)? "": "s")):"") + ((stones > 0 && (pounds > 0 || ounces > 0) )? ", ": "") 
            		 + ((pounds > 0) ? (pounds + " Pound" + ((pounds == 1)? "": "s")): "" ) + ((pounds > 0 && (ounces > 0))? ", ":"") + ((ounces > 0 ) ?
            				(ounces + " Ounce" + ((ounces == 1)? " ": "s " )) : "");
		}
		return(formattedString);
	}
	public static final double convertToKilograms( double stones, double pounds, double ounces)
	{ 
		double kilogramsTotal = 0.0;
		double totalInOunces = 0.0;
		totalInOunces = ((stones * POUNDS_IN_A_STONE) + pounds)* OUNCES_IN_A_POUND + ounces;
		kilogramsTotal = totalInOunces * ONE_OUNCE_TO_KILOS  ;
		return (kilogramsTotal);
	}
	public static final String errorString( )
	{
		String errorString = "You have not entered your chosen amount of stones, pounds and ounces " + "\n"
	             + "correctly, please try again." + "\n" + "Sample input : 2 1 5 ";
		return errorString;
	}

}
