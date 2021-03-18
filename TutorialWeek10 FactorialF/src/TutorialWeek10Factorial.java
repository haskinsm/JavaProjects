import java.util.Scanner;

import javax.swing.JOptionPane;

public class TutorialWeek10Factorial {

	/*
	 * Write a program which determines if a user supplied number is a factorian.
	 * An example of a factorian is 145 where 145 = 1! + 4! + 5!
	 * i.e. the first digits factorial + .... = nummber supplied.
	 */
	public static void main(String[] args) {
		
		boolean finished = false;
		do 
		{
			String input = JOptionPane.showInputDialog("Please enter an integer number to determine if it is"
					+ " a Factorian number or enter 'quit' to leave the program.");
			Scanner inputScanner = new Scanner( input );
			int factorianNumber;
			String output = "";
			int factorialValueSum = 0;
			if(inputScanner.hasNextInt())
			{
			    factorianNumber = inputScanner.nextInt();
			    int usersEnteredNumber = factorianNumber;
			    while( factorianNumber > 0)
			    {
			    	int lastDigit = factorianNumber % 10;
			    	factorianNumber = factorianNumber / 10;
			    	int factorialValue = factorialCalculator( lastDigit);
			    	factorialValueSum += factorialValue;
			    	output += lastDigit + "!";
			    	if( factorianNumber > 0)
			    	{
			    		output += " + "; //This is to ensure no plus sign at end of line.
			    	}
			    } //At the end of this loop factorianNumber is equal to zero so 
			    //therefore another variable name needs to be declared which is usersEnteredNumber.
			    if( factorialValueSum == usersEnteredNumber)
			    {
			    	System.out.println("" + usersEnteredNumber + " is a Factorian because " + usersEnteredNumber
			    			+ " = " + output);
			    }
			    else
			    {
			    	System.out.println("" + usersEnteredNumber + " is not a Factorian number because " 
			                + usersEnteredNumber + " != " + output);
			    }
			}
			else if(inputScanner.hasNext("quit"))
			{
				finished = true;
				System.out.println("Goodbye.");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "You have not entered a valid integer number",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
			inputScanner.close();
		}while(!finished);
     }
	
	//Functions Below Outside of main.
	//Could have used another boolean function e.g. isFactorian()
public static final int factorialCalculator( int number1)
{
	int factorialResult;
	switch (number1)
	{
	case 0:
		    factorialResult = 1;
		    break;
	case 1:
		    factorialResult = 1;
		    break;
	default:
		    factorialResult = number1 * factorialCalculator( number1 -1);
		    break;
	}	    
    return factorialResult;
}

}
