import java.util.Scanner;
import javax.swing.JOptionPane;

/* SELF ASSESSMENT  
1.  createSequence:
Did I use the correct method definition?
Mark out of 5: 5
Comment: Yes
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5: 5
Comment: Yes, array of size n was created & it worked.
Did I return the correct item?
Mark out of 5: 5
Comment: Yes, when n=30, created an int array from 2,3....30.
2.  crossOutMultiples
Did I use the correct method definition?
Mark out of 5: 5
Comment: Yes
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2: 2
Comment: Yes
Did I loop through the array using the correct multiple?
Mark out of 5: 5
Comment: Yes, all multiples were eliminated.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3: 3
Comment: Yes, they items to be crossed out were changed to zero and then this was fixed when I changed it to a String
3.  sieve   
Did I have the correct function definition?
Mark out of 5: 5
Comment: Yes
Did I make calls to other methods?
Mark out of 5: 5
Comment: Yes   
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2: 0
Comment: No, i returned a string instead that was then outputted.
4.  sequenceTostring  
Did I have the correct function definition?
Mark out of 5: 5
Comment: Yes.
Did I ensure the parameter to be used is not null?
Mark out of 3: 3
Comment: Yes
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10: 10
Comment: Yes
5.  nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5: 5
Comment:  Yes      
Did I ensure the parameter to be used is not null?  
Mark out of 3: 3
Comment: Yes
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5: 5
Comment: Yes
6.  main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5: 5
Comments: Yes
Did I make calls to other methods (at least one)?
Mark out of 5: 5
Comment:  Yes
Did I print the output as shown in the question?  
Mark out of 5: 5
Comment:  Yes, but I used JOptionPane instead of system.out....
7.  Overall
Is my code indented correctly?
Mark out of 4: 4
Comments: Yes
Do my variable names make sense?
Mark out of 4: 4
Comments: i.e. multiplier.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4: 4
Comments: Yes
   Total Mark out of 100 (Add all the previous marks):  98
*/

public class SieveOfEratosthenes {

	public static final int CROSSED_OUT_NUMBER = 0;
	public static final int FIRST_PRIME = 2;
	
	//Functions below
	public static int[] createSequence (int numberLimit)
	{
		int [] sequence = new int[ numberLimit ];
		int count = FIRST_PRIME;
		for( int index = 0; index < (sequence.length - 1) ; index++)
		{
			sequence[ index ] = count;
			count ++;
		}
		return sequence;
	}
	
	public static final int[] crossOutHigherMultiples ( int [] sequence, int prime)
	{
		for( int index = 0; index < sequence.length ; index++ )
		{
			if( sequence[ index ] % prime == 0 && sequence[ index ] != prime)
			{
				sequence[ index ] = CROSSED_OUT_NUMBER;
			}
			//multiplier ++;
		    //sequence [ (multiplier * prime) - 2 ] = CROSSED_OUT_NUMBER; 
		    // Need to include - 2 in my 'index' as array starts from 2.  i.e. 4th term = 6.
		}
		
		return sequence;
	}
	
	public static String sieve ( int [] sequence, int [] initialSequence)
	{
		String output = "";
		for( int index = 0; index < sequence.length -1; index++)
		{
			if( sequence[ index ] == 0)
			{
				output += initialSequence[ index ] + ", ";
			}
		}
		output = cutCommaEndings( output );
		return output;
	}
	
	public static String sequenceToString ( int[] sequence, int[] initialSequence )
	{
		String output = "";
		for( int index = 0; index < sequence.length - 1; index++ )
		{
			if( sequence[ index ] == CROSSED_OUT_NUMBER)
			{
				output += "[" + initialSequence[ index ] + "], ";
			}
			else
			{
				output += sequence[ index ] + ", ";
			}			
		}
		output = cutCommaEndings( output );
		return output;
	}
	
	public static String nonCrossedOutSubseqToString ( int[] sequence )
	{
		String output = "";
		for( int index = 0; index < sequence.length -1; index++ )
		{
			if( sequence[index] != 0)
			{
				output += sequence[ index ] + ", ";
			}
		}
		output = cutCommaEndings( output );
		return output;
	}
	
	public static void errorOutput( )
	{
		JOptionPane.showMessageDialog(null, "You have not entered an integer number greater than 5." + "\n"
				+ "Sample input: 30.", "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public static final String cutCommaEndings( String output) 
	{
		char[] tempCharArray = output.toCharArray();
		char temp = ' '; 
		tempCharArray[ tempCharArray.length - 2] = temp; 
		output = new String ( tempCharArray );
		return output;
	}
	
	//Main
	public static void main(String[] args) {
		
            String input = JOptionPane.showInputDialog( "Please enter a positive integer number greater than 5 to "
            		+ "be the limit of your sequence.");
            Scanner inputScanner = new Scanner( input );
            if( inputScanner.hasNextInt())
            {
            	int sequenceLimit = inputScanner.nextInt(); 
            	if( sequenceLimit > 4)
            	{
		        	int [] sequence = createSequence( sequenceLimit );
		        	int [] initialSequence = sequence.clone();
		        	for( int index2 = FIRST_PRIME; index2 < sequence.length; index2++) 
		        	{
		        		if( sequence[ index2 - 2] != 0 && 
		        				sequence[ index2 - 2] < Math.pow( sequence.length, 0.5) )
		        		{
		        			sequence = crossOutHigherMultiples( sequence, index2);
		        			JOptionPane.showMessageDialog(null, 
		        					(index2 == FIRST_PRIME ? "E" : "Now also e") + 
		        					"liminating multiples of the prime " + index2 + ":"
		        					+ "\n" + sequenceToString( sequence, initialSequence) 
		        					+ "\n");
		        		}
		        	}
		             JOptionPane.showMessageDialog(null, "This is your sequence with prime and"
		            		+ " non-prime numbers in square brackets: " +
			        	    "\n" + sequenceToString( sequence, initialSequence ) + "\n" + 
		            		"This is your sequence with prime numbers only:" + "\n" +
			        		nonCrossedOutSubseqToString( sequence ) + "\n" + 
		            		"This is your sequence with non-prime numbers only:" + 
			        	    "\n" + sieve( sequence, initialSequence ) );
            	}
            	else
            	{
            		errorOutput();
            	}
            }
            else
            {
            	errorOutput();
            }
            inputScanner.close();
	}

}
