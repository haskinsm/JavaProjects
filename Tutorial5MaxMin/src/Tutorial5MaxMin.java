import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * Write a program to compute the maximum and minimum numbers in a
 * list of numbers entered by the user (on a single line).
 */
public class Tutorial5MaxMin {

	public static void main(String[] args) {
		
		int minNumber = 0;
		int maxNumber = 0;
		int currentNumber = 0;
		
		String input = JOptionPane.showInputDialog("Enter a list of numbers one at a time, enter 'exit' or 'quit' to exit the program"
				+ "(seperate numbers by spaces).");
		Scanner inputScanner = new Scanner( input );
		if(inputScanner.hasNextInt())
		{
			minNumber = inputScanner.nextInt();
		    maxNumber = minNumber;
		    while(inputScanner.hasNextInt())
		    {
			   currentNumber = inputScanner.nextInt();
				if(currentNumber < minNumber)
				{
					minNumber = currentNumber;
				}
				else if(currentNumber > maxNumber)
				{
					maxNumber = currentNumber;
				}
		    }
		    JOptionPane.showMessageDialog(null, "From the entered list of numbers,"
					+ " \n the max number is: " + maxNumber 
					+ " the min number is: " + minNumber );
		}
		else if(inputScanner.hasNext("exit") || inputScanner.hasNext("quit"))
		{
			JOptionPane.showMessageDialog(null, "Goodbye.");
		}	
		else
		{
			JOptionPane.showMessageDialog(null, "Numbers have not been provided correctly.",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		inputScanner.close();
	}

}
