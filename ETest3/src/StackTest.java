import java.util.*;

import javax.swing.JOptionPane;
public class StackTest {

	//E-Test 3  other class is Stack.
	public static void main(String[] args) {
		
		boolean finished = false;
		boolean userInputRecieved = false;
		Stack userStack = new Stack();
		do
		{
			String input = JOptionPane.showInputDialog( "Please enter in one integer number between 1 and 10 at a time. " + "\n" + 
					"Sample input: '3'" + "\n" + "Enter 'finished' to move on from this loop in the program.");
			Scanner inputScanner = new Scanner( input );
			if( inputScanner.hasNextInt())
			{
				int numberEntered = inputScanner.nextInt();
				if( numberEntered >= 1 && numberEntered <= 10)
				{
					userStack.push( numberEntered ); 
					userInputRecieved = true;
				}
			}
			else if( inputScanner.hasNext( "finished") )
			{
				finished = true;
			}
			else
			{
				JOptionPane.showMessageDialog( null, "You have not entered valid input. Please enter a positive Integer number between 1 and 10.", 
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}while( !finished );
		if( userInputRecieved )
		{
			userStack.pop(); //remove top of stack. ie. last entered number
			int lastItem = userStack.peek();
			if( lastItem == -1)
			{
				JOptionPane.showMessageDialog( null, "Your stack is now empty!", 
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Last Integer in your stack is: " + lastItem);
			}
			int toMove = 6;
			int toSearch = 5;
			userStack.search( toSearch );
			userStack.move( toMove );
			//System.out.println( userStack.toString() );
		}
	}

}
