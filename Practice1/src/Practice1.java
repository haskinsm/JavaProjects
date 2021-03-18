import java.util.Scanner;
import javax.swing.JOptionPane;



public class Practice1 {

	public static void main(String[] args) {
		
		int answer = JOptionPane.showConfirmDialog(null, "Is it Raining?");
		boolean raining = (answer == JOptionPane.YES_OPTION);
		if(raining)
		{
			System.out.println("Your Grand with an umbrella");
		}
		if(!raining)
		{
			int answer2 = JOptionPane.showConfirmDialog(null, "Does it loo like it may rain?");
			boolean rainLikely = (answer2 == JOptionPane.YES_OPTION);
			System.out.println( (rainLikely) ? "Bring an umbrella" : "No brelli"); //Conditional 
		}
		
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Please enter a number as to how likely it is to rain from 0 to 10.");
		int likelyness = inputScanner.nextInt();
		System.out.println(likelyness);
		inputScanner.close();
}
	//Useful Functions
	public static boolean isPrime( int number )
	{
	  int divisor=number/2;
	  boolean isPrimeNumber = true;
	  while ((divisor > 1) && (isPrimeNumber))
	  {
	    if (number % divisor-- == 0) //decrementing here -> --
	      isPrimeNumber = false;
	  }
	  return isPrimeNumber;
	}

	public static int toPowerOf( int base, int exponent )
	{
	  int answer = 1;
	  for(int exponentCount = 0; (exponentCount < exponent); exponentCount++)
	  {
	    answer *= base;
	  }
	  return answer;
	}

}


