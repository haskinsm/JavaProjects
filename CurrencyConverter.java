import java.util.Scanner;

import javax.swing.JOptionPane;

public class CurrencyConverter {
/* Write a program which takes in amounts of old 
 * Sterling pounds, shillings and pennies
 *  and converts it to modern pounds and pennies.
 */
	/*  SELF ASSESSMENT
	   1. Did I use appropriate CONSTANTS instead of numbers within the code?
	       Mark out of 10: 10  
	   2. Did I use easy-to-understand, meaningful CONSTANT names?
	       Mark out of 5:  5
	    3. Did I format the CONSTANT names properly (in UPPERCASE)?
	       Mark out of 5:  5
	   4. Did I use easy-to-understand meaningful variable names?
	       Mark out of 10: 10 
	   5. Did I format the variable names properly (in lowerCamelCase)?
	       Mark out of 10: 10
	   6. Did I indent the code appropriately?
	       Mark out of 10: 10
	   7. Did I read the input correctly from the user using (an) appropriate question(s)?
	       Mark out of 10:  10
	   8. Did I compute the answer correctly for all cases?
	       Mark out of 20:  20
	   9. Did I output the correct answer in the correct format (as shown in the examples)?
	       Mark out of 10:  10
	   10. How well did I complete this self-assessment?
	       Mark out of 10:  10
	   Total Mark out of 100 (Add all the previous marks): 100 
	*/
	
	public static final int NEWPENNIES_PER_NEWPOUND = 100 ;
	public static final int NEWPENNIES_PER_OLDPENNY = 67 ;
	public static final int NEWPENNIES_PER_OLDSHILLING = 804 ;
	public static final int NEWPENNIES_PER_OLDPOUND = 16080 ;
	
	
	public static void main(String[] args) {
	
		String input = JOptionPane.showInputDialog("Enter old pounds, shillings and pennies, seperated by spaces, "
				    + "to be converted into modern pounds and pennies. " );
		Scanner inputScanner = new Scanner ( input );
		int oldPounds = inputScanner.nextInt();
		int oldShillings = inputScanner.nextInt();
		int oldPennies = inputScanner.nextInt();
		inputScanner.close();
		
		double totalNewPennies = ((oldPounds * NEWPENNIES_PER_OLDPOUND ) + (oldShillings * NEWPENNIES_PER_OLDSHILLING ) + (oldPennies * NEWPENNIES_PER_OLDPENNY));
		double totalNewPounds = (totalNewPennies / NEWPENNIES_PER_NEWPOUND );
		
		JOptionPane.showMessageDialog(null, " If " + oldPounds + " old pounds, " + oldShillings + " old shillings and " 
		            + oldPennies + " old pennies are exchanged you will receive \n £" + totalNewPounds) ;    
		
		
	}

}
