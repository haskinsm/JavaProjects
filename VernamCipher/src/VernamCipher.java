import java.util.*;

import javax.swing.JOptionPane;

public class VernamCipher {

	public static final String alphabet = "abcdefghijklmnopqrstuvxyz ";
	
	public static char[] randomizeKey( char[] alpha, char[] userMessage)
	{
		char [] key = userMessage.clone();
		for( int i = 0; i < userMessage.length; i++)
		{
			Random randomGenerator = new Random();
			int randomNumber = randomGenerator.nextInt( userMessage.length ); //+1
			key[ i ] = alpha[ randomNumber ]; 
		}
		return key;
	}
	
	public static char[] encrypt( char[] key, char[] userMessage)
	{
		char [] codedUserMessage = userMessage.clone();
		for( int i = 0; i < userMessage.length; i++ )
		{                                                                     //When using XoR ('^') need to cast
			codedUserMessage[ i ] =  (char) (userMessage[ i ] ^  key[ i ]); //need to cast from int to char
		}
		return codedUserMessage;
	}
	
	public static char[] decrypt( char[] key, char[] codedUserMessage)
	{
		char[] decodedUserMessage = codedUserMessage.clone();
		for( int i = 0; i < codedUserMessage.length; i++ )
		{
			decodedUserMessage[ i ] = (char) (codedUserMessage[ i ] ^ key[ i ]);
		}
		return decodedUserMessage;
	}
	
	public static void printArray( char[] array)
	{
		String output = "";
		for( int i = 0; i < array.length; i++)
		{
			output += array[i];
		}
		System.out.println( output + "\n" );
	}
	
	public static void main(String[] args) {
		

		char [] alpha = alphabet.toCharArray();
		String userInput = "";
		String input = JOptionPane.showInputDialog( "Enter in your message to be encrypted");
		Scanner inputScanner = new Scanner( input );
		do
		{
			userInput += inputScanner.next() + " ";
		}while( inputScanner.hasNext() );
		inputScanner.close();
		userInput.toLowerCase();
		char [] userMessage = userInput.toCharArray();
		char[] key = randomizeKey( alpha, userMessage );
		char[] encryptedUserMessage = encrypt( key, userMessage );
		char[] decryptedUserMessage = decrypt( key, encryptedUserMessage );
		System.out.println( "User Message: ");
		printArray( userMessage );
		System.out.println( "Key: ");
		printArray( key );
		System.out.println( "Encrypted user message: ");
		printArray( encryptedUserMessage );
		System.out.println( "Decrypted user Message: ");
	    printArray( decryptedUserMessage );
	/*	char test = 'h' ^ 'g';
		System.out.println( test );
		char t2 = (char) (test ^ 'h');
		char t3 = (char) (test ^ 'g');
		System.out.println( t2 + "\n" + t3);
		*/
	}

}
