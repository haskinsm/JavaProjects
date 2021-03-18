import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Random;

public class ASS5HighLowGame{
	/* SELF ASSESSMENT 
	   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
	       Mark out of 5: 5 
	       Comment: Yes, e.g. JACK =11; and JACK_NAME = 'Jack';
	   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
	       Mark out of 5: 5
	       Comment: Yes, e.g. JACK=11
	   3. Did I use easy-to-understand meaningful variable names? 
	       Mark out of 10: 10
	       Comment:  Yes guessCount
	   4. Did I format the variable names properly (in lowerCamelCase)? 
	       Mark out of 5: 5 
	       Comment:  Yes guessCount
	   5. Did I indent the code appropriately? 
	       Mark out of 10: 10
	       Comment:  Yes 
	   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose? 
	       Mark out of 20: 20
	       Comment:  Yes used a while
	   7. Did I check the input to ensure that invalid input was handled appropriately? 
	       Mark out of 10: 10
	       Comment:  Yes
	   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)? 
	       Mark out of 10: 10
	       Comment:  Yes
	   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King? 
	       Mark out of 10: 10
	       Comment:  Yes
	   10. Did I report whether the user won or lost the game before the program finished? 
	       Mark out of 10:10
	       Comment:  Yes
	   11. How well did I complete this self-assessment? 
	       Mark out of 5:5
	       Comment:  Well.
	   Total Mark out of 100 (Add all the previous marks): 100
	*/
	
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	public static final int ACE_HIGH = 14;
	public static final int GUESSES_ALLOWED = 4;
	public static final String JACK_NAME = "Jack";
	public static final String QUEEN_NAME = "Queen";
	public static final String KING_NAME = "King";
	public static final String ACE_NAME = "Ace";

	public static void main(String[] args)
	{
		
			Random generator = new Random();
			int generatedCard = generator.nextInt(KING) + 1; //as want cards generated from 2-14.
			int guessCount = 0;
			String currentCard = "";
			String nextCard = "";
			boolean finished = false;

			while (guessCount < GUESSES_ALLOWED && finished == false) 
			{
				int nextGeneratedCard = generator.nextInt(KING) + 1;
				if (generatedCard == ACE_HIGH) 
				{
					currentCard = ACE_NAME;
				}
				else if (generatedCard == JACK) 
				{
					currentCard = JACK_NAME;
				} 
				else if (generatedCard == QUEEN) 
				{
					currentCard = QUEEN_NAME;
				} 
				else if (generatedCard == KING) 
				{
					currentCard = KING_NAME;
				} 
				else 
				{
					currentCard = "" + generatedCard;
				}
				if (nextGeneratedCard == ACE_HIGH) 
				{
					nextCard = ACE_NAME;
				} 
				else if (nextGeneratedCard == JACK) 
				{
					nextCard = JACK_NAME;
				} 
				else if (nextGeneratedCard == QUEEN) 
				{
					nextCard = QUEEN_NAME;
				} 
				else if (nextGeneratedCard == KING) 
				{
					nextCard = KING_NAME;
				} 
				else 
				{
					nextCard = "" + nextGeneratedCard;
				}

				String input = JOptionPane.showInputDialog("The card is a " + currentCard
						+ ". Do you think the next card will be higher, lower or equal to? " + "\n" + "You have "
						+ (GUESSES_ALLOWED - guessCount) + " guesses left till you win.");
				Scanner inputScanner = new Scanner(input);
				if (generatedCard > nextGeneratedCard && input.equalsIgnoreCase("lower")
						|| generatedCard < nextGeneratedCard && input.equalsIgnoreCase("higher")
						|| generatedCard == nextGeneratedCard && input.equalsIgnoreCase("equal"))
					//The java.lang.String.equalsIgnoreCase() method compares this String to another String, ignoring case considerations. 
					//See below for more.   Two strings are considered equal
					//ignoring case if they are of the same length and corresponding characters in the two strings are equal ignoring the characters cases.
				{
					JOptionPane.showMessageDialog(null, "You are correct. The next card was " + input + ".");
					guessCount++;
					generatedCard = nextGeneratedCard;
				} 
				else if (input.equalsIgnoreCase("lower") || input.equalsIgnoreCase("higher")
						|| input.equalsIgnoreCase("equal to")) 
				{
					JOptionPane.showMessageDialog(null,
							"This is not the correct answer. The next card was " + nextCard + ". Try again!");
					guessCount = 0;
					generatedCard = generator.nextInt(KING) + 2;
					inputScanner.close();
				} 
				else if( inputScanner.hasNext( "exit") || inputScanner.hasNext( "quit"))
				{
					finished = true;
				}
				else 
				{
					JOptionPane.showMessageDialog(null,
							"This is not a valid input. Please enter higher, lower or equal to.");
				}
			}
			if( finished = false)
			{
			    JOptionPane.showMessageDialog(null, "Congratulations! You have won.");
			}
			else if( finished = true)
			{
				JOptionPane.showMessageDialog(null, "Goodbye.");
			}

		
	}
    // .equals() and .euqalsIgnoreCase()
	// e.g: String str1 = "hi"   String str2 = "Hi"
	//System.out.println(str1.equals(str2)); .... is false
	//System.out.println(str1.equalsIgnoreCase(str2)); .... is true
}
