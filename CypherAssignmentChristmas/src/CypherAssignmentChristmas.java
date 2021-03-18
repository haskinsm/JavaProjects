import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Random;

/*  Assignment Instructions:
   Write a Java program which repeatedly converts (user entered) plain text to cipher text using a substitution cipher (in which plain text letters are randomly assigned to cipher text letters), and then converts it back again (just to be sure that we can decrypt it).  Note that a Substitution Cipher replaces plaintext with cipher-text. The most common substitution ciphers replace single characters of plaintext with predefined single characters of cipher-text (e.g. the plain-text character `a' might be replaced by cipher text character 'q', 'b' might be replaced by 'x', 'c' by 'k' and so on).  Each plain-text character should be replaced by a different cipher-text character.

As part of your solution you must write and use at least the following functions/methods:

(i)    createCipher() which determines and returns the mapping from plain text to cipher text.  Each plain text character ('a' .. 'z', ' ') must be randomly assigned a cipher-text character;

(ii)   an encrypt() method which takes a plain text phrase (as an array of characters) & the cipher and returns an encrypted version of the phrase according to the substitution cipher;

(iii)  a decrypt() which takes an encrypted phrase (as an array of characters) & the cipher mapping and returns a plain text version of the phrase according to the substitution cipher
*/


/* SELF ASSESSMENT

1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

       Mark out of 5: 5
       Comment:  Yes, e.g. userMessage.

2. Did I indent the code appropriately?

       Mark out of 5: 5
       Comment:  Yes.

3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?

      Mark out of 20: 20
       Comment:  Yes, it all works and I found was easier to use a void function.

4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?

      Mark out of 20: 20  
       Comment:  Yes, everything worked.

5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?

      Mark out of 20: 20  
       Comment:  Yes, everything worked fine.

6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?

      Mark out of 25:  25
       Comment:  Yes, you can enter messages repeatedly to be encrypted and then decrypted to the original message.

7. How well did I complete this self-assessment?

       Mark out of 5: 5
       Comment: Well I think.

Total Mark out of 100 (Add all the previous marks): 100

*/ 

public class CypherAssignmentChristmas {
	
    public static final String ALPHABET_NUMBERS_PUNCTUATION_MARKS =  "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz !.,:?@()"
    		+ "+-&;/<>#=*1234567890";
   
	public static void main(String[] args) {
	
		char [] alpha = ALPHABET_NUMBERS_PUNCTUATION_MARKS.toCharArray();
		char [] cypher = alpha.clone();
		//System.out.println(cypher[3]);
		boolean finished = false;
		createCypher( cypher );
		//System.out.println(cypher[3]);
		//String testString = new String( cypher );
		//System.out.println(testString);
		do
		{
			String userInput = JOptionPane.showInputDialog("Please enter in your message to be encrypted.  "
					+ "\n" + "E.g. 'Hello! How are you?' " + "\n" + 
					"Enter 'quit' or 'exit' to leave the program.");
			Scanner inputScanner = new Scanner( userInput );
			String userMessage = "";
			if(inputScanner.hasNext("quit") || inputScanner.hasNext("exit"))
			{
				finished = true;
				JOptionPane.showMessageDialog(null, "Goodbye.");
			}
			else
			{
				while(inputScanner.hasNext())
				{
					userMessage += inputScanner.next() + (inputScanner.hasNext() ? " " : "");
				}
				// String userMessage = mixedCase.toLowerCase(); ... 
				// ...not now needed as included lower case and capitals in my character array
				char [] uncodedUserMessage = userMessage.toCharArray();
				char [] codedMessage = encyrpt(uncodedUserMessage, cypher, alpha);
				String encryptedUserMessage = new String( codedMessage );
				JOptionPane.showMessageDialog(null, "This is your encrypted message: " + "\n" + 
				           encryptedUserMessage);
				char [] decryptedUserMessage = decrypt( codedMessage, cypher, alpha );
				String decryptedMessage = new String( decryptedUserMessage);
				JOptionPane.showMessageDialog(null, "This is your orginal message, that has been"
						+ " decrypted: " + "\n" + decryptedMessage) ;
			}
			//No error condition is needed as there cannot be any errors relating to the user entered Dialog.
			//(I have tested this).
		}while(!finished);	
		
	}
	
	//**FUNCTIONS below**
	public static void createCypher( char[] cypher)
	{
		Random randomGenerator = new Random();
		for(int index = cypher.length-1 ; 0 < index ; index--)
		{
			int random = randomGenerator.nextInt(index+1);
		    char temp = cypher[ random ]; 
		    //Basically switching last character in array with a random one repeatedly until..
		    cypher[ random ] = cypher[ index ]; // ..every character has been switched at least once.
		    cypher[ index ] = temp;
		}
	}
	
	public static final char[] encyrpt( char[] uncodedUserMessage, char[] cypher, char[] alpha)
	{
		char[] codedUserMessage = uncodedUserMessage.clone();
		for(int index = 0; index < uncodedUserMessage.length ; index++ )
		{
			char character = uncodedUserMessage[ index ];
			boolean arrivedAtCorrectLetter = false;
			for(int index2 = 0; ( index2 < alpha.length   ||  arrivedAtCorrectLetter == false); index2++ )
			{
				if( character == alpha[ index2] && arrivedAtCorrectLetter == false)
				{
					codedUserMessage[ index ] = cypher[ index2 ];
					arrivedAtCorrectLetter = true;
				}
			}
		}
		return (codedUserMessage);
	} 
	
	public static final char[] decrypt( char[] codedUserMessage, char[] cypher, char[] alpha)
	{
		char[] decryptedUserMessage = codedUserMessage.clone();
		for(int index = 0; index < codedUserMessage.length ; index++ )
		{
			char character = codedUserMessage[ index ];
			boolean arrivedAtCorrectLetter = false;
			for(int index2 = 0; (index2 < cypher.length || !arrivedAtCorrectLetter); index2++ )
			{
				if( character == cypher[ index2 ] && arrivedAtCorrectLetter == false)
				{
					decryptedUserMessage[ index ] = alpha[ index2 ];
				    arrivedAtCorrectLetter = true;
				}
			}
		}
		return (decryptedUserMessage);
	}
 
}
 