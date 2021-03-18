import javax.swing.JOptionPane;
public class Assignment2UmbrellaMHaskins {
/* Write a program which determines if the user should
 * bring an umbrella when they go out
 */
	/* SELF ASSESSMENT 
	   1. Did I use easy-to-understand meaningful variable names? 
	       Mark out of 10: 10
	       Comment:
	   2. Did I format the variable names properly (in lowerCamelCase)? 
	       Mark out of 10: 10
	       Comment: 
	   3. Did I indent the code appropriately? 
	       Mark out of 10: 10
	       Comment: 
	   4. Did I read the input correctly from the user using appropriate questions? 
	       Mark out of 20: 20
	       Comment: 
	   5. Did I use an appropriate (i.e. not more than necessary) series of if statements? 
	       Mark out of 30: 30
	       Comment: 
	   6. Did I output the correct answer for each possibility in an easy to read format? 
	       Mark out of 15: 15
	       Comment: 
	   7. How well did I complete this self-assessment? 
	       Mark out of 5: 5
	       Comment: 
	   Total Mark out of 100 (Add all the previous marks): 100 
	*/

 
	public static void main(String[] args) {
		
   int answer = JOptionPane.showConfirmDialog(null, "Is it raining?");
   boolean raining = (answer == JOptionPane.YES_OPTION);
   if (raining)
   {
	   JOptionPane.showMessageDialog(null, "You should bring an umbrella, and put it up.");
   }
   
   if (!raining)
   {
	   int answer2 = JOptionPane.showConfirmDialog(null, "Does it look "
	   		+ "like it might rain?");
	   boolean rainLikely = (answer2 == JOptionPane.YES_OPTION);
	   if (rainLikely)
	   {
		   JOptionPane.showMessageDialog(null, "Bring an umbrella as is it looks as if it will rain.");
	   }
	   else 
	   {
		   JOptionPane.showMessageDialog(null, "There is no need to bring an umbrella as it does not look like it will rain.");
	   }
   }
   
  }
   
 }

	


