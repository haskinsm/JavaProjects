
public class LABassignmentWeek8 {

	/*
	 Write a program to produce the lyrics (all 12 verses) of the Twelve Days of Christmas. This is a cumulative song as each verse is build on top of the previous verses.  You must
     have a loop for the verses,
     build up each of the verses within a loop (or switch statement),
     use at least one switch statement in your solution,
     only write the lines of text (or constants representing them) from the song once in your program (e.g. you cannot have more than one statement in the entire program which prints out "my true love sent to me")... 
     Sample output.

  1. On the first day of Christmas 
     my true love sent to me: 
     a Partridge in a Pear Tree.  

  ....
 12. On the twelfth day of Christmas
     my true love sent to me:
     12 Drummers Drumming
     11 Pipers Piping
     10 Lords a Leaping
     9 Ladies Dancing
     8 Maids a Milking
     7 Swans a Swimming
     6 Geese a Laying
     5 Golden Rings
     4 Calling Birds
     3 French Hens
     2 Turtle Doves
     and a Partridge in a Pear Tree 

	 */
	/* SELF ASSESSMENT 
	   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
	       Mark out of 5: 5
	           yes, MAX_NUMBER_VERSES was set to 12.
	   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
	       Mark out of 5:  5
	           yes, MAX_NUMBER_VERSES
	   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)? 
	       Mark out of 10: 10
	           yes, verseNumber 
	   4. Did I indent the code appropriately? 
	       Mark out of 10: 10
	           yes, it is correctly indented I think.
	   5. Did I use an appropriate loop (or loops) to produce the different verses? 
	       Mark out of 20:  20
	           yes, my for loop worked successfully.
	   6. Did I use a switch to build up the verses? 
	       Mark out of 25:  25
	           yes and also one to account for the 'first' or 'second' day etc.
	   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))? 
	       Mark out of 10:  10
	           yes used two switch statements to ensure this.
	   8. Does the program produce the correct output? 
	       Mark out of 10: 10
	           yes everything worked well. 
	   9. How well did I complete this self-assessment? 
	       Mark out of 5: 5
	           well.
	   Total Mark out of 100 (Add all the previous marks): 100 
	*/ 
	public static final int MAX_NUMBER_VERSES = 12;
	
	public static void main(String[] args) {
		
		for(int verseNumber = 1; (verseNumber <= MAX_NUMBER_VERSES); verseNumber ++)
		{
			int dayCount = verseNumber;
			String outputString = "On the";
			String endOfLine = "day of Christmas" + "\n" + "my true love sent to me:";
			switch( dayCount )
			{
			case 1:
                    outputString += " first " + 
			                  endOfLine + "\n" + "A";
                    break;
			case 2: 
				    outputString += " second " + endOfLine ;
				    break;
			case 3:
				    outputString += " third " + endOfLine ;
				    break;
			case 4:
				    outputString += " fourth " + endOfLine;
				    break;
			case 5:
				    outputString += " fifth " + endOfLine;
				    break;
			case 6:
				    outputString += " sixth " + endOfLine;
				    break;
			case 7:
				    outputString += " seventh " + endOfLine;
				    break;
			case 8:
				    outputString += " eigth " + endOfLine;
				    break;
			case 9: 
				    outputString += " ninth " + endOfLine;
				    break;
			case 10:
				    outputString += " tenth " + endOfLine;
				    break;
			case 11:
				    outputString += " eleventh " + endOfLine;
				    break;
			case 12:
				    outputString += " twelvth " + endOfLine;
				    break;
			}
			// Removed breaks in next switch statement so when the verseNumber is 11 for
			// example it will not break what is being added to the outputString after
			// '11 pipers piping' has been added in the 11th case, it will continue to
			// add everything underneath it and complete the 11th verse.
			// This method only works if switch statement is done in reverse. 
			// i.e. by starting with case 12.
			switch( verseNumber )
			{
			case 12: 
				    outputString += "\n" + "12 Drummers Drumming ";
			case 11:
				    outputString += "\n" + "11 Pipers Piping ";
			case 10:
				    outputString += "\n" + "10 Lords a Leaping";
			case 9: 
				    outputString += "\n" + "9 Ladies Dancing";
			case 8:
				    outputString += "\n" + "8 Maids a Milking";
			case 7:
				    outputString += "\n" + "7 Swans a Swimming";
			case 6:
				    outputString += "\n" + "6 Geese a Laying";
			case 5: 
				    outputString += "\n" + "5 Golden Rings";
			case 4: 
				    outputString += "\n" + "4 Calling Birds";
			case 3: 
				    outputString += "\n" + "3 French Hens";
			case 2:
				    outputString += "\n" + "2 Turtle Doves" + "\n" + "and a";
			case 1:
				    outputString += " Partridge in a Pear Tree" + "\n";	    
			}
			System.out.println( outputString);
		}

	}

}
