
public class ASS7TriangularStars {

	/*
	 * A “star number”, s, is a number defined by the formula:  s = 6n(n-1) + 1  
	 *    where n is the index of the star number.  Thus the star numbers are:   1, 13, 37, 73, 121, 181, 253, …
	 *    A “triangle number”, t, is the sum of the numbers from 1 to n:   t = 1 + 2 + … + (n-1) + n. 
	 *    Thus the triangle numbers are:  1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105, 120, 136, 153, 171, 190, 210, 231, 253, …
	 *    Write a Java application that produces a list of all the values of type int 
	 *    that are simultaneously star numbers and triangle numbers.
	 */
	/* SELF ASSESSMENT

	 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
         Mark out of 5: 5         Comment: Yes, count is the count.

	 2. Did I indent the code appropriately?
         Mark out of 5: 5       Comment: Yes, I think so.

	 3. Did I write the determineStarNumber or determineTriangleNumber function correctly (parameters, return type and function body) and invoke it correctly?
         Mark out of 20: 20         Comment: Yes my function worked and so did my program.

	 4. Did I write the isStarNumber function correctly (parameters, return type and function body) and invoke it correctly?
         Mark out of 20: 20         Comment: Yes, it worked and I think its easy enough to understand.

	 5. Did I calculate and/or check triangle numbers correctly?
         Mark out of 15:   15       Comment: Yes, the output was correct.

	 6. Did I loop through all possibilities in the program using system defined constants to determine when to stop?
	       Mark out of 10:  10        Comment: Yes,
	        calculated all number that are both star and triangle numbers up to max integer value.

	 7. Does my program compute and print all the correct triangular star numbers?
	       Mark out of 20:   20     Comment: Yes, it gives five answers.

	 8. How well did I complete this self-assessment?
	        Mark out of 5:   5     Comment: Well, it took a bit of time due to mistakes I couldn't
	        find for a while.

	 Total Mark out of 100 (Add all the previous marks): 100

	 */ 

	public static void main(String[] args) {


		String outputString ="The following numbers are both triangle and star numbers:";
		int previousSum = 0;
		int triangleNumber = 0;
		int count = 0;
		do {
			previousSum ++;
			triangleNumber += previousSum;
			if( isStarNumber( triangleNumber) == true)
			{
				count ++; //This is to prevent comma at end of line.
				switch( count)
				{
				case 1:
					outputString += "\n" + triangleNumber + " ";
					break;
				default:
					outputString += ", " + triangleNumber;
					break;
				}
			}

		}while(previousSum < (Integer.MAX_VALUE - triangleNumber)); 
		//previousSum is basically used as a count
		System.out.println(outputString);

	}

	//Functions below
	public static boolean isStarNumber( int number) // s = 6n(n-1) + 1  
	{
		boolean starNumber = false;
		int currentStarNumber = 0;
		int count = 0;
		// Function will not work correctly if currentStarNumber <= number. Use debugger to see why. 
		// When doing this the loop will go around again when currentStarNummber == number
		// so will never get a true output this way.
		while( currentStarNumber < number  ) 
		{
			count ++;
			currentStarNumber = 6*count*( count -1 ) + 1;
		}
		if( number == currentStarNumber)
		{
			starNumber = true;
		}
		return( starNumber);
	}

}
