import java.util.Scanner;
import javax.swing.JOptionPane;

public class Factorial {

	public static void main(String[] args) {
		
		int factorial = 1;
		
		String input = JOptionPane.showInputDialog("Enter in a number to compute its factorial"
				+ " or type 'exit' or 'quit' to exit the program.");
		Scanner inputScanner = new Scanner( input );
		if(inputScanner.hasNextInt())
		{
		  int number = inputScanner.nextInt();
		  for(int i = 1; (i <= number); i++) 
		  {
		    factorial = i * factorial;
		  }
		  JOptionPane.showMessageDialog(null, "The factorial of your chosen number is: " + factorial);
		}
		else if(inputScanner.hasNext("exit") || inputScanner.hasNext("quit"))
		{
			JOptionPane.showMessageDialog(null, "Goodbye.");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "You have not entered a number.",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		inputScanner.close();
		
	}

}
