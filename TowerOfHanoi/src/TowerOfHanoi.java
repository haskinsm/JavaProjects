import java.util.Scanner;
/*
 * Update the BankCustomer class creating an array storing data of type bankCustomerArray and add your BankCustomer to this array.

Part2:

The Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. 
The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:

1. Only one disk can be moved at a time
2. Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack 
      i.e. a disk can only be moved if it is the uppermost disk on a stack
3. No disk may be placed on top of a smaller disk

  Write a Java program that asks the user to input the number of disks and 
  implements a recursive function to implement your solution.


 */
public class TowerOfHanoi {

	//private int size;
	//private int stack;
	
	public void makeRod1 ( int numberOfDiscs )
	{
		int[] rod1 = new int[ numberOfDiscs ];
		for(int index = 0; index < (rod1.length - 1) ; index++)
		{
			rod1[ index ] = index;
		}
	}
	public void makeRod2 ( int numberOfDiscs )
	{
		int[] rod2 = new int[ numberOfDiscs ];
		for(int index = 0; index < (rod2.length - 1) ; index++)
		{
			rod2[ index ] = 0;
		}
	}
	public void makeRod3 ( int numberOfDiscs )
	{
		int[] rod3 = new int[ numberOfDiscs ];
		for(int index = 0; index < (rod3.length - 1) ; index++)
		{
			rod3[ index ] = 0;
		}
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner inputScanner = new Scanner( System.in );
		System.out.println( "Please enter a positive integer number of disc's for your game.");
		if( inputScanner.hasNextInt() )
		{
             int numberOfDiscs = inputScanner.nextInt();
		}
        inputScanner.close();
	}

}
