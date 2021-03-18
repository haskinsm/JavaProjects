import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.Math;

public class Tuorial6MinusBFormula2016ETEST {
/*
 * Write a program which finds the roots of a polynomial
 * which has been entered by the user using the minus
 * B formula,
 */
	public static void main(String[] args) {
		
		boolean finished = false;
		double coeA = 0.0;
		double coeB = 0.0;
		double coeC = 0.0;
		
		do
		{
		   String input = JOptionPane.showInputDialog("Enter the coefficients of your chosen polynomial"
				+ "(which should be in the form ax^2 + bx + c and this should be entered as, a b c) "
				+ "or enter 'quit' or 'exit' to exit the program ");
		   Scanner inputScanner = new Scanner( input );
		   if(inputScanner.hasNextDouble())
		   {
		     coeA = inputScanner.nextDouble();
	       }
		   if(inputScanner.hasNextDouble())
		   {
	         coeB = inputScanner.nextDouble();
		   }
		   if(inputScanner.hasNextDouble())
	   	   {
		     coeC = inputScanner.nextDouble();
		     double discriminant = coeB*coeB - 4*(coeA)*(coeB);
		     if(discriminant >= 0) //TO ACCOUNT FOR IMAGINARY ROOTS, I.E. WHEN DICRIMANT IS NEGATIVE//
		     {
		        double root1 = ( - coeB + (Math.pow(discriminant, 0.5)))/ 2*(coeA);
		        double root2 = ( - coeB - (Math.pow(discriminant, 0.5)))/ 2*(coeA);
                JOptionPane.showMessageDialog(null, "Having entered the polynomial " + (coeA) + "x^2 and " + coeB + "x and " + coeC +
				", the roots of this equation are " + root1 + " and " + root2);
		     }
		     else
		     {
		    	 JOptionPane.showMessageDialog(null, "Roots of equation provided are imaginary.",
		    			 "ERROR", JOptionPane.ERROR_MESSAGE);
		     }
		   }
		   else if(inputScanner.hasNext( "exit") || inputScanner.hasNext( "quit"))
		   {
			  finished = true;
			  JOptionPane.showMessageDialog(null, "Goodbye.");
		   }
		   else
		   {
			  JOptionPane.showMessageDialog(null, "Numbers have not been provided correctly.",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		   }
		   inputScanner.close();
		
		}while(!finished);
	} 

}
