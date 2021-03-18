import java.util.Scanner;

public class BinarySampleETest2 {

	public static void main(String[] args) {
		
			boolean valid = false; 
			while( !valid )
			{
				try
				{
					boolean finished = false;
					while( !finished )
					{
						System.out.print("Enter a number (or enter 'quit')");
						Scanner input = new Scanner( System.in);
						if( input.hasNextInt())
						{
							int numberInput = input.nextInt();
							if( numberInput > 0)
							{
								String binaryString = convertToBinaryString( numberInput );
								boolean isPalindromic = isBinaryPalindromic( numberInput );
								if( isPalindromic )
								{
									System.out.println("The number " + numberInput + "in binary is " + binaryString + " which is palindromic.");
								}
								else
								{
									System.out.println("The number " + numberInput + "in binary is " + binaryString + ".");
								}
							}
							else System.out.println( "Please enter positive numbers.");
						}
						else if( input.hasNext("quit"))
						{
							System.out.println("Goodbye!");
							finished = true;
							input.close();
						}
						else System.err.println("This is not a valid number. Please enter a positive whole number.");
					}
				}
				catch (java.util.InputMismatchException exception) 
				{
					System.err.println("Please input a correct number and start again.");
				} 
			}	
		}
		public static String convertToBinaryString( int input )
		{
			String binaryNumberString = "";
			int dividedNumber = input;
			int binaryNumber = 0;
			for(int count = 0; dividedNumber > 0; count++)
			{
				binaryNumber = dividedNumber % 2;
				dividedNumber /= 2;
				binaryNumberString = binaryNumber + binaryNumberString;
			}
			return binaryNumberString;
		}
		public static int reverseBinaryNumber( int input )
		{
			String binaryNumber = convertToBinaryString( input );
			String reverseBinaryNumberString = "";
			boolean isReverse = false;
			int count = 1;
			for(count = 1; count < Integer.MAX_VALUE && !isReverse; count++)
			{
				int dividedNumber = count;
				int reverseBinaryNumber = dividedNumber % 2;
				dividedNumber /= 2;
				reverseBinaryNumberString += reverseBinaryNumber;
				if( reverseBinaryNumberString == binaryNumber )
				{
					isReverse = true;
					return count;
				}
			}	
			return count = 0;
		}
		public static boolean isBinaryPalindromic( int input )
		{
			String binaryNumber = convertToBinaryString( input);
			int reverseNumber = reverseBinaryNumber( input );
			String reverseBinaryNumber = convertToBinaryString( reverseNumber );
			if( binaryNumber == reverseBinaryNumber )
			{
				return true;
			}
			else return false;
		}

	

}
