import javax.swing.JOptionPane;
import java.util.Scanner;
/*
 * Write a program which takes keeps taking in numbers from a user on the command line until the user enters "quit" or "exit". 
 *  The user should be allowed to enter only one number each time and the system should compute the average and variance of all numbers entered so far each time.  To do this WITHOUT storing all the numbers we must use formulas which allow to compute the average and variance based only on the previous values (of the average and variance) together with the latest number entered.

 *AVERAGEN = AVERAGEN-1 + (NUMBERN - AVERAGEN-1) / N

 *VARIANCEN = ((VARIANCEN-1 * (N-1)) + (NUMBERN - AVERAGEN-1) * (NUMBERN - AVERAGEN)) / N
 */
/* SELF ASSESSMENT 
 *1. Did I use easy-to-understand meaningful variable names? 
    Mark out of 10: 10
    Comment: Yes, average and prevAverage are self explanatory.
 *2. Did I format the variable names properly (in lowerCamelCase)? 
    Mark out of 5: 5
    Comment: Yes, prevAverage for example.
 *3. Did I indent the code appropriately? 
    Mark out of 10: 10
    Comment: Yes, code is indented where appropriate, for iterations etc.
 *4. Did I input the numbers one at a time from the command line?
    Mark out of 10:  10
    Comment: Yes, runs and works as its suppose to.
 *5. Did I check the input to ensure that invalid input was handled appropriately?
    Mark out of 10:  10
    Comment: Yes, program ends when exit is entered and reruns when user enters something that is not a number or the word exit.
 *6. Did I use an appropriate while or do-while loop to allow the user to enter numbers until they entered exit/quit?
    Mark out of 20:  20
    Comment: Yes, do-while loop works well and exits when its suppose to.
 *7. Did I implement the loop body correctly so that the average and variance were updated and output appropriately?
    Mark out of 30:  30
    Comment: Yes this was done by setting prevAverage = average as it was needed to calculate variance two lines down so had to be done separately where as
    variance did not need to be stored, like it could just be done by setting variance = variance as variance only appears in that line. 
 *8. How well did I complete this self-assessment? 
    Mark out of 5: 5
    Comment: Program works and can handle errors and exits loop when user enters exit or quit.
 *Total Mark out of 100 (Add all the previous marks): 100
 */

public class Assignment4AVandSD {

	public static void main(String[] args) {

		double total = 0;
		double numberCount = 0;
		double prevAverage = 0;
		double average = 0;
		double variance = 0;
		boolean finished = false;
		
          do
          {
		   
			   String input = JOptionPane.showInputDialog("Enter a number(or type 'exit' or 'quit')");
			   Scanner inputScanner = new Scanner( input );
			      if(inputScanner.hasNextDouble() )
			      {
			      numberCount ++;
			      double number = inputScanner.nextDouble();
			      total += number;
			      prevAverage = average;
		          average = average + (( number - average )/numberCount);
		          variance =  ((variance*(numberCount-1)) + ((number - prevAverage )*( number - average ))) 
		        		  / numberCount;
			      JOptionPane.showMessageDialog(null, "So far the sum of the numbers entered is: " + total + 
			    		  ".\n" + "The average of this total is: " + average + 
			    		  ".\n The variance is: " + variance + ".");
			      } 
			      else if(inputScanner.hasNext("exit") || inputScanner.hasNext("quit"))
			      {
			           finished = true;
				       JOptionPane.showMessageDialog(null, "Goodbye");	
			      }
			      else
			      {
						JOptionPane.showMessageDialog(null,"No numbers have been provided.",
								"ERROR",JOptionPane.ERROR_MESSAGE);
				  }
			      inputScanner.close();
		   }while(!finished);
	}
}
