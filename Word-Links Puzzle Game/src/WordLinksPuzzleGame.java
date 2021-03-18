import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

public class WordLinksPuzzleGame {
	
	/* SELF ASSESSMENT 

	1. readDictionary
	- I have the correct method definition [Mark out of 5: 5]
	- Comment: Yes, returns an ArrayList, with no parameters.
	- My method reads the words from the "words.txt" file. [Mark out of 5: 5]
	- Comment: Yes, used a fileReader.
	- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5: 5]
	- Comment: Yes, returns an ArrayList.

	2. readWordList
	- I have the correct method definition [Mark out of 5: 5]
	- Comment: Yes.
	- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5: 5]
	- Comment: Yes, I used a delimiter and then added the words to an ArrayList

	3. isUniqueList
	- I have the correct method definition [Mark out of 5: 5]
	- Comment: Yes.
	- My method compares each word in the array with the rest of the words in the list. [Mark out of 5: 5]
	- Comment: Yes, loops through for each word checking to see if it equals any other word in the array.
	- Exits the loop when a non-unique word is found. [Mark out of 5: 5]
	- Comment: Yes, returns false when a non-unique word is found.
	- Returns true is all the words are unique and false otherwise. [Mark out of 5: 5]
	- Comment: yes.

	4. isEnglishWord
	- I have the correct method definition [Mark out of 5: 5]
	- Comment: yes
	- My method uses the binarySearch method in Arrays library class. [Mark out of 3: 2]
	- Comment: No I used an ArrayList so just used the .contain() method
	- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2: 1]
	- Comment: No

	5. isDifferentByOne
	- I have the correct method definition [Mark out of 5: 5]
	- Comment: yes
	- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10: 10]
	- Comment: yes my method does this.

	6. isWordChain
	- I have the correct method definition [Mark out of 5: 5]
	- Comment: yes
	- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10: 10]
	- Comment: It has all those methods, but I printed the appropriate message in the mainline.

	7. main
	- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures [Mark out of 10: 10]
	- Comment:  I read all the words of the file words.txt in the readDictionary method.
	- Asks the user for input and calls isWordChain [Mark out of 5: 5]
	- Comment: Yes

	 Total Mark out of 100 (Add all the previous marks): 98
	*/
	
	public static ArrayList< String > readDictionary()
	{
		ArrayList< String > dictionary = new ArrayList< String >();
		try {                                                              
			FileReader fileReader = new FileReader("words.txt");// Enter the entire path of the file if needed
			BufferedReader bufferedReader = new BufferedReader(fileReader);  
			boolean endOfFile = false;
	        while(!endOfFile){
	        	String wordOnLine = bufferedReader.readLine();
	        	if (wordOnLine != null) {
	        		dictionary.add( wordOnLine );
	        	} else {
	        		endOfFile = true;
	        	}
	        }
	        bufferedReader.close();    
	        fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dictionary;
	}
	public static ArrayList< String > readWordList( ArrayList< String > dictionary, String userInput)
	{
		ArrayList< String > userWords = new ArrayList< String >();
		Scanner inputScanner = new Scanner( userInput );
		inputScanner.useDelimiter( ", " ); 
		while( inputScanner.hasNext())
		{
			userWords.add( inputScanner.next() );		
		}
		inputScanner.close();
		return userWords;  
	}
	public static boolean isUniqueList( ArrayList< String > a)
	{
		for( int i = 0; i < a.size(); i++)
		{
			String temp = a.get( i );
			for( int j = i + 1; j < a.size(); j++)
			{
				if( temp == a.get( j ) )
				{
					return false;
				}
			}
		}
		return true; // might need to do null error checking
	}
	public static boolean isEnglishWord( ArrayList< String > dictionary, String word)
	{
		return dictionary.contains( word );
		// int index = binarySearch( dictionary, word);
	    // if( index > 0){ return true; }
	}
	public static boolean isDifferentByOne( String a, String b)
	{
		int count = 0;
		if( a.length() != b.length() )
		{
			count = (int) Math.pow(a.length() - b.length(), 2);
			//added Math.pow to act like a modulus, could have enclosed it in a square root but no need here.
			//Is there an easier way to get the same effect of a modulus?
			if( count >= 2 )
			{
				return false;
			}
		}
		for( int i = 0; i < a.length(); i++)
		{
			if(  a.charAt( i ) != b.charAt( i ) )
			{
				count++;
			}
			if( count >= 2 )
			{
				return false;
			}
		}
		return true;
	}
	public static boolean isWordChain( ArrayList< String > wordChain, ArrayList< String > dictionary )
	{
		for( int i = 0; i < wordChain.size(); i++ )
		{
			if( !isEnglishWord( dictionary, wordChain.get( i ) ) )
			{
				return false;
			}
		}
		if( !isUniqueList( wordChain ) )
		{
			return false;
		}	
		for( int j = 1; j < wordChain.size(); j++ )
		{
			if( !isDifferentByOne( wordChain.get( j ), wordChain.get( j - 1) ) )
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		boolean finished = false;
		ArrayList< String > dictionary = readDictionary();
		do
		{
			String input = JOptionPane.showInputDialog( "Please enter a comma seperated list of words( or an empty list to quit): ");
			if( input.isEmpty() )
			{
				System.out.println("Goodbye.");
				finished = true;
			}
			else
			{
				ArrayList< String > wordChain = readWordList( dictionary, input);
				boolean isWordChain = isWordChain( wordChain, dictionary);
				if( isWordChain )
				{
					System.out.println("Valid chain of words from Lewis Carroll's word-links game." + "\n");
				}
				else
				{
					System.out.println("Invalid chain of words from Lewis Carroll's word-links game." + "\n");
				}
			}
		}while( !finished );
	}

}
