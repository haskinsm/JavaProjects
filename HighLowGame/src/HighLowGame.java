import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.Random;

public class HighLowGame {

	public static final int GUESSES_ALLOWED = 5;
	public static final int MAX_NUMBER = 20;
	public static final int UNKNOWN_NUMBER = -1;

	public static void main(String[] args) {
		
		    Random  generator = new Random();
		    int numberToGuess = generator.nextInt(MAX_NUMBER+1); //Must do Max_Number+1 to get interval pool of 0 to 20
		    int numberGuessed = UNKNOWN_NUMBER;
		    int count;
		    
		    for (count = 0; (count < GUESSES_ALLOWED) &&
		             (numberGuessed != numberToGuess); count++)
		    {
		    	Scanner input = new Scanner( System.in );
	  		    System.out.print("Guess the number (between 0 and 20): ");
		        numberGuessed = input.nextInt();
		        if (numberGuessed < numberToGuess)
		        {
		          System.out.println("" + numberGuessed + " is too low.");
		        }
		        else if (numberGuessed > numberToGuess)
		        {
		        System.out.println("" + numberGuessed +
		                                               " is too high.");
		        }
		        //NOTICE: Scanner NEVER closed, as if it is loop wont function right.
		    }
		    

		    if (numberGuessed == numberToGuess)
		    {
		      System.out.println("Well done.  You got it in " + count +
		                                                 " guesses.");
		    }
		    else 
		    {
		    	System.out.println("Hard luck.  The number was " + 
		                                       numberToGuess + ".");
		    }
		    
		}

	}

