import javax.swing.JOptionPane;
import java.util.Scanner;

public class TutorialWeek11Etest2Sample {
	
	public static final int  NUMBER_OF_NUMBERS= 10;
 
	public static void main(String[] args) {
		
		int number = 0;
		int[] digitFrequency = new int[NUMBER_OF_NUMBERS];
		boolean finished = false;
		do
		{
			Scanner inputScanner = new Scanner (System.in);
			System.out.println("Please enter a number:");
			if(inputScanner.hasNextInt())
			{
				number = inputScanner.nextInt();
				countDigitFrequencies( number, digitFrequency);
				printDigitFrequencies( digitFrequency);
		
			}
			else if(inputScanner.hasNext("exit"))
			{
				finished = true;
				System.out.println("Goodbye.");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "You have not entered an integer value, please try again. " + "\n" +
			             "Sample input = 355333.", "ERROR", JOptionPane.ERROR_MESSAGE); //I'm not sure if u can interchange between
				//System.out.... and JOptionPane;
			}
		}while(!finished);

		

	}
	
	public static void countDigitFrequencies(int number, int[] frequencies)
	{
		int remainingNumber = Math.abs(number);  //Math.abs acts as a modulus.
	    while(remainingNumber> 0)
	    {
	    	int lastRemainingDigit = remainingNumber % 10; //lastRemainingDigit can only be between 0 and 9
	    	//Therefore can use it as index for my frequencies array as that has an index between 0 and 9.
	    	frequencies[ lastRemainingDigit ] += 1;
	    	remainingNumber = remainingNumber/10; //Be careful in arranging the % and / lines.
	    }
	}
	public static final void printDigitFrequencies( int[] frequencies)
	{
		String outputString = "Digit frequencies: ";
		int count = 0;
		for(int index = 0; (index < frequencies.length); index ++)
		{
			if( frequencies[index] > 0)
			{ 
				outputString += ((count == 0) ? " ":", ") + index + "(" + frequencies[index] + ")";
				count ++;
			}
		}
		System.out.println( outputString);
	}

}
