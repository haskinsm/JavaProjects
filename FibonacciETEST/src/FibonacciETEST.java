import java.util.Scanner;

public class FibonacciETEST {

	public static void main(String[] args) {
		
		System.out.println("What number would you like closest Fibonacci number for: ");
		Scanner numberInput = new Scanner(System.in);
		int fibonacciNumberOne = 0;
		int fibonacciNumberTwo = 1;
		int fibonacciNumbersAdded = 1;
		if(numberInput.hasNextInt())
		{	
			int numberEntered = numberInput.nextInt();;
			if(numberEntered == 0)
			{
				System.out.println("The closest Fibonacci number to 0 is 0");
			}
			else if(numberEntered == 1)
			{
				System.out.println("The closest Fibonacci number to 1 is 1");
			}
			else if(numberEntered < 0)
			{
				System.out.println("Invalid input. Please input a positive whole number eg: 24");
			}
			else
			{
				while(fibonacciNumbersAdded < numberEntered)
				{
					fibonacciNumberTwo = fibonacciNumbersAdded;
					fibonacciNumbersAdded = fibonacciNumberOne + fibonacciNumberTwo;
					fibonacciNumberOne = fibonacciNumberTwo;
				}
				if((fibonacciNumbersAdded - numberEntered) < (numberEntered - fibonacciNumberTwo))
				{
					System.out.println("The closest Fibonacci number to " + numberEntered + " is " + fibonacciNumbersAdded);
				}
				else if((fibonacciNumbersAdded - numberEntered) > (numberEntered - fibonacciNumberTwo))
				{
					System.out.println("The closest Fibonacci number to " + numberEntered + " is " + fibonacciNumberTwo);
				}
				else if((fibonacciNumbersAdded - numberEntered) == (numberEntered - fibonacciNumberTwo))
				{
					System.out.println("The closest Fibonacci numbers to " + numberEntered + " are " + fibonacciNumberTwo + " and " + fibonacciNumbersAdded);
				}
			}
		}
		else
		{
			System.out.println("Invalid input. Please input a positive whole number eg: 24");
		}
		numberInput.close();


	}
	//Fibonacci Program with recursion functions.
/*
 * 
 * Write a program to compute a particular term in the Fibonacci sequence.  
 *
 *  Fibonacci( 1 ) = 0
 *  Fibonacci( 2 ) = 1
 *  Fibonacci( n ) = Fibonacci( n-1 ) + Fibonacci( n-2 )    where n > 2
 
public class Fibonacci {

	public static final int FIBONACCI_NUMBER_1 = 0;
	public static final int FIBONACCI_NUMBER_2 = 1;
	
	public static void main(String[] args) {

		String input = JOptionPane.showInputDialog("Enter the index of the required Fibonacci number:");
		Scanner scanner = new Scanner( input );
		int index = scanner.nextInt();
		
		int fibonacciNumber = ComputeFibonacciNumber( index );

		JOptionPane.showMessageDialog(null, "Fibonacci_number( " + index +
				" ) is " + fibonacciNumber );

	}
	
	public static int ComputeFibonacciNumber( int index )
	{
		int result;
		switch (index)
		{
		case 1:
			result = FIBONACCI_NUMBER_1;
			break;
		case 2:
			result = FIBONACCI_NUMBER_2;
			break;
		default:
			result = ComputeFibonacciNumber( index-1 ) + ComputeFibonacciNumber( index-2 );
			break;
		}
		return result;
	}
}
 */
}
