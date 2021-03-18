import java.util.Scanner;
import javax.swing.JOptionPane;

public class ETestOne {
	/*
	 * 19/10/2018.
	 * Write a program which computes and prints out the factors of a 
	 * user supplied number.
	 * Also indicate whether entered number is a prime number.
	 */

	public static void main(String[] args) {
		
		boolean finished = false;
		boolean prime = true;
		
		do
		{
		   String input = JOptionPane.showInputDialog("Enter an integer number and its factors will be returned"
				  + " , or enter 'exit' or 'quit' to leave the program.");
		   Scanner inputScanner = new Scanner( input );

		   if(inputScanner.hasNextInt())
		   {
		      int number = inputScanner.nextInt(); //should have done something to account for if user enters a neg. number
		      System.out.println("A factor pair of " + number + " is: " + number + "x" + 1);
		      for( int divisor = 2; (divisor <= (number/divisor)); divisor ++) //Need to divide by 
		    	  //divisor so not to return same factor pair in reverse.
		      {
			      if(number % divisor == 0) 
			      {
				     int factorPair = number / divisor;
				     System.out.println("Another factor pair of " + number + " is: " + factorPair + "x"
				          + divisor);
				     prime = false;
			      }
		      } 
		      finished = true;
		      if(!prime)
			  {
				  System.out.println("" + number + " is not a prime number.");
			  }
		      else
		      {
			      System.out.println("" + number + " is a prime number.");
		      }
		   }
		   if(inputScanner.hasNext("exit") || inputScanner.hasNext("quit"))
		   {
			  finished = true;
			  JOptionPane.showMessageDialog(null, "Goodbye.");
		   }
		   else if(inputScanner.hasNext())
		   {
			  JOptionPane.showMessageDialog(null, "You have not entered in a number correctly.",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		   }
		   inputScanner.close();
		}while(!finished);

	}

}
