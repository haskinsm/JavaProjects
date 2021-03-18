import java.lang.reflect.Array;
import java.util.Scanner;

import javax.swing.JOptionPane;
 //NEED TO RE-DO
public class Ass8HighScoreArrays {

	/*
	 * Write a program to maintain a list of the high scores obtained in a game.  
	 * The program should first ask the user how many scores they want to maintain and then repeatedly 
	 * accept new scores from the user and should add the score to the list of high scores (in the appropriate position)
	 *  if it is higher than any of the existing high scores.  You must include the following functions:
	 *  initialiseHighScores () which sets all high scores to zero.
	 *  printHighScores() which prints the high scores in the format: “The high scores are 345, 300, 234”, for all exisiting high scores in the list (remember that sometimes it won’t be full).
	 *  higherThan() which takes the high scores and a new score and returns whether the passed score is higher than any of those in the high score list.
	 *  insertScore() which takes the current high score list  and a new score and updates it by inserting the new score at the appropriate position in the list
     */
	/* SELF ASSESSMENT

	 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

	        Mark out of 5:  5 
            Yes, E.g. index or highScoresToMaintain.
	 2. Did I indent the code appropriately?

	        Mark out of 5: 5
            Yes.
	 3. Did I write the initialiseHighScores function correctly (parameters, return type and function body) and invoke it correctly?

	       Mark out of 15:  15
           Yes used all of the functions that were asked for this time. All of them work correctly.
	 4. Did I write the printHighScores function correctly (parameters, return type and function body) and invoke it correctly?

	       Mark out of 15:  15
           Yes.
	 5. Did I write the higherThan function correctly (parameters, return type and function body) and invoke it correctly?

	       Mark out of 15:  15
           Yes.
	 6. Did I write the insertScore function correctly (parameters, return type and function body) and invoke it correctly?

	       Mark out of 20:  20
           Yes.
	 7. Did I write the main function body correctly (first asking for the number of scores to be maintained and then repeatedly asking for scores)?

	       Mark out of 20:  20
           Yes two inputs and I think my program will catch any possible errors and prompt the user to enter in a correct input.
	 8. How well did I complete this self-assessment?

	        Mark out of 5:  5
           Very well I think.
	 Total Mark out of 100 (Add all the previous marks): 100

	*/ 
	
	public static void main(String[] args) {
		
		int[] highScores = null;
		int highScoresToMaintain = 0;
		boolean correctInput = false;
		while( correctInput == false)
		{
			String input = JOptionPane.showInputDialog("How many scores do you want to maintain?" +"\n" +
			            "Please enter a positive integer Number:");
			Scanner inputScanner = new Scanner( input );
			if( (inputScanner.hasNextInt()) )
			{
				highScoresToMaintain =  inputScanner.nextInt();
				if(highScoresToMaintain > 0)
				{
					highScores = new int[highScoresToMaintain]; //This creates and sets array length
					initialiseHighScores( highScores); //refer to an array as highScores, don't need []
					correctInput = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You have not entered a POSITIVE integer number of scores "
							+ "to be mainatined, please try again." + "\n" + "Sample input: 3",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "You have not entered in a positive integer number of scores"
						+ " to be maintained correctly." + "\n" + "Sample Input: 3",
		    			"ERROR", JOptionPane.ERROR_MESSAGE);
			}
			inputScanner.close();
		}
		boolean finished = false;
		do
		{
		    String input2 = JOptionPane.showInputDialog( "Enter the positive integer scores one at a time please"
		    		+ " or enter 'quit' to exit the program." + "\n" + "Sample input: 6.");
		    Scanner inputScanner2 = new Scanner( input2 );
		    int newScore = 0;
		    if(inputScanner2.hasNextInt())
		    {
		    	newScore = inputScanner2.nextInt();
		    	boolean isEntryNewHighScore = higherThan( highScores, newScore );//***Wrong*** want to insert score if it is greater than any of the high scores in the list
		    	//Only entering score into highScore array if it is a new high score
		    	//If for example the current High Score is 6 I have considered that if the next
		    	//Entry is 6 this will be counted as a new high score and added to the highScore list(array).
		    	//This can be changed by adding >= in my higherThan() functions IF statement.
		    	if( isEntryNewHighScore == true)
		    	{
		    		highScores = insertScore( highScores, newScore );
		    		JOptionPane.showMessageDialog( null, printHighScores( highScores));
		    	}
		    	else
		    	{
		    		JOptionPane.showMessageDialog(null, newScore + " is not a new high Score");
		    	}
		    }
		    else if(inputScanner2.hasNext("quit"))
		    {
		    	finished = true;
		    	JOptionPane.showMessageDialog(null, "In conclusion," + "\n" + printHighScores( highScores) + "\n" + 
		    	        "Goodbye.");
		    }
		    else
		    {
		    	JOptionPane.showMessageDialog(null, "You have not entered in an integer number or entered 'quit' to"
		    			+ "leave the program correctly." + "\n" + "Please try again.",
		    			"ERROR", JOptionPane.ERROR_MESSAGE);
		    }
		    inputScanner2.close();
		}while( !finished );
	}

	//Functions Below.
	public static void initialiseHighScores( int[] array)
	{
		 //Use Void when have nothing to return, the array should return with every index value set to zero.
		//Index Can not be less than or equal to array.length .
		for( int index = 0 ; (index < array.length); index++)
		{
			array[index] = 0;
		}
	
	}
	public static final String printHighScores(int[] highScores)
	{
		String outputString = "The high scores are: " + "\n" + highScores[0];
		for(int index = 1 ; index < highScores.length ; index ++)
		{
			outputString += ", " + highScores[index];
		}
		return (outputString);
	}
	public static final boolean higherThan( int[] highScores, int newScore)
	{
		boolean newHighScore = false;
		for( int i = 0; i < highScores.length; i++)
		{
			if( highScores[i] < newScore) //fixed
			{                                        
				newHighScore = true;
			}
		}
		return (newHighScore);
	}
	public static final int[] insertScore( int[] highScores, int newScore)
	{ //FIXED 27/02/2019
		//****WRONG****.. since higher than function was misinterpreted. Could possibly use a for loop inside a for loop.
		//Must set index to array length minus 1 or would have an error then
		//Say array.length is 4 then by setting index to 4 this would result in errors
		//as you are trying to find/set the fifth term of an array which only has 4 terms.
		//**Remember first term in an array has an index of zero.**
		int temp = 0;
		boolean foundHigherThanPoint = false;
		for( int i = 0; i < highScores.length; i++)
		{
			if( newScore > highScores[ i ] && !foundHigherThanPoint)
			{
				foundHigherThanPoint = true;
				temp = i;
			}
		}
		for(int index = (highScores.length -1) ; index > temp ; index --)
		{
			highScores[index] = highScores[index - 1];
		}
		highScores[ temp ] = newScore;
		return (highScores);
	}
	
}
