import javax.swing.JOptionPane;
import java.util.Scanner;

/* SELF ASSESSMENT 

Class Rational 
I declared two member variables: numerator and denominator (marks out of 4: 4).
Comment: Yes two private variables in the Rational class

Constructor 1 
My program takes take two integers as parameters (for numerator and denominator) and initializes the member variables with the corresponding values . If the denominator is equal to 0 I throw an exception (marks out of 5: 5).
Comment: Yes it works well for this and will throw an error message if the user enters 0 for the numerator.

Constructor 2 
My program takes only one integer as parameter (numerator), and set the numerator to this value . I set the denominator to 1 in this case, as the resulting rational number in this case is an integer (marks out of 3: 3 ).
Comment: Yes the user can enter in only one number for each rational number or two and I used this constructor for the sake of it, as it wasn't really necessary in my code.

Add Method 
My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator which the addition of the two objects - this and the parameter. My program does not overwrite any of the other two rational numbers (marks out of 8: 8).
Comment: Yes neither Rational number is overwritten and one Rational number is taken as a parameter and a new rational number is returned and outputted immediately.

Subtract Method 
I have implemented this the same as add method, except it implements subtraction (marks out of 8: 8 ).
Comment: Yes works perfect.

Multiply Method 
I have implemented this the same as add method, except it implements multiplication (marks out of 8: 8 ).
Comment: Yes works well and result is simplified.

Divide Method 
I have implemented this the same as add method, except it implements divide (marks out of 8: 8 ).
Comment: Yes works well and avoids dividing by zero if user enters a numerator with value of zero for b an error message is thrown and the user is asked to re-enter both rational numbers.

Equals Method 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication between numerators/denominators for the purpose of comparison, as integer division will lead to incorrect results. I return a boolean value ((marks out of 8: 8).
Comment: Yes this worked well.

isLessThan 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication as integer division will lead to incorrect results. I return a boolean value (marks out of 8: 8).
Comment: Yes worked perfectly.

Simplify Method 
My program returns a rational number but not a new rational number, instead it returns the current reference which is this. It doesn't take any parameters as it works only with the reference object. I first find the greatest common divisor (GCD) between the numerator and denominator, and then obtain the new numerator and denominator by dividing to the GCD (marks out of 8: 8).
Comment: Yes my program does this exactly using a public void method.

gcd function 
My program returns the greatest common divider of two integers: the numerator and the denominator (marks out of 6: 6 ).
Comment: Yes I have a method for this that works fine.

toString Method 
My program returns a string showing the fraction representation of the number, eg. "1/2". It takes no parameters (marks out of 4: 4 ).
Comment: Yes I returned a string and my method had no parameters.

Test Client Class 
My program asks the user for two rational numbers, creates two rational objects using the constructor and passing in the provided values, calls addition, subtraction, multiplication, division, comparison and simplification and prints out the results (marks out of 22: 22 ).
Comment: Yes it does all of this, I could have used one String for outputting everything but I found that to be messy.

Total marks: 100/100
*/


public class TestClient {

	public static void main(String[] args) {
		
		boolean correctInput = false;
		do
		{
			int numeratorA = 0;
			int numeratorB = 0;
			int denominatorA = 1;
			int denominatorB = 1;
			String input = JOptionPane.showInputDialog( "Please enter in Rational Number A in the form:" + "\n"
					+ "numerator of rational number a, space, denominator a" + "\n" + "i.e: '1 3' (This is 1/3)");
			Scanner inputScanner = new Scanner( input );
			if( inputScanner.hasNextInt() )
			{
				numeratorA = inputScanner.nextInt(); 
			}
			if( inputScanner.hasNextInt() )
			{
				denominatorA = inputScanner.nextInt();
			}
			String inputTwo = JOptionPane.showInputDialog( "Please enter in Rational Number B in the form: " + "\n" +
					"numerator of rational number b, space, denominator b");
			Scanner inputScannerTwo = new Scanner( inputTwo );
			if( inputScannerTwo.hasNextInt() )
			{
				numeratorB = inputScannerTwo.nextInt();
			}
			if( inputScannerTwo.hasNextInt() )
			{
				denominatorB = inputScannerTwo.nextInt();
			}
			if( denominatorA != 0 && denominatorB !=0 && numeratorB != 0 )
			{
				correctInput = true;
				Rational a;
				if( denominatorA == 1 ) //I know there isn't much point in this because of the way I've written the program
				{
					a = new Rational( numeratorA );
				}
				else
				{
					a = new Rational( numeratorA, denominatorA);
				}
				Rational b;
				if( denominatorB == 1)
				{
					b = new Rational( numeratorB );
				}
				else
				{
		    		b = new Rational( numeratorB, denominatorB); //This is indented in line with the other IF's on my laptop but not on blackboard
				}
				System.out.println( "You have entered in Rational a: " + a.toString() + "\n"
						+ "You have entered in Rational b: " + b.toString() );
				System.out.println( "Rational a plus Rational b: " + a.add( b ).toString() );
				System.out.println( "Rational a minus Rational b: " + a.subtract( b ).toString() );
				System.out.println( "Rational a multiplied by Rational b: " + a.multiply( b ).toString() );
				System.out.println( "Rational a divided by Rational b: " + a.divide( b ).toString() );
				System.out.println( "Rational a is " + ( (a.isLessThan( b ) == true) ? "less than" : "greater than" ) + " b.");
				System.out.println( "Rational a" + ( a.equals( b ) == true ? " is " : " is not ") + "equal to Rational b.");
				System.out.print( "Rational a in its simplest form: " + a.toString() + " --> " );
				a.simplify();
				System.out.print( a.toString() + "\n");
				System.out.print( "Rational b in its simplest form: " + b.toString() + " --> " );
				b.simplify();
				System.out.print( b.toString() );
			}
			else if( numeratorB == 0 )
			{
				JOptionPane.showMessageDialog(null, "You have not entered in Rational Number B correcrly."
						+ "\n" + "Please note that numerator of rational B cannot be zero as it will be "
						+ "dividing rational A later in the program."
						+ "\n" + "Please note that the numerator of a rational number also cannot be zero." + "\n"
						+ "Please try again. Sample input: 1/2 = '1 2' ", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "You have not entered in the two Rational Numbers correctly."
						+ "\n" + "Please note that the denominator of a rational number cannot be zero" + "\n"
						+ "Please try again. Sample input: 1/2 = '1 2' ", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
			
		}while( !correctInput );
		
	}

}
