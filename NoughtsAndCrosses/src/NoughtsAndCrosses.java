import java.util.Scanner;
import javax.swing.JOptionPane;
// Assignment 2, semester 2 first year MSISS .... program fixed

public class NoughtsAndCrosses {
   
	/*
	 * You must write the following methods:

void clearBoard (char[][] board) which sets all locations on the board to the BLANK (' ') character.
void printBoard (char[][] board) which prints the board to the screen.
boolean canMakeMove (char[][] board, int row, int column) which takes a board and a location and returns whether a move can be made there.
void makeMove (char[][] board, char currentPlayerPiece , int row, int column) which adds a piece (NOUGHT or CROSS) to the board in the specified location.
boolean isBoardFull(char[][] board) which indicates whether the board is full.
char winner ( char[][] board) which returns the piece which has won or BLANK if no-one has yet won.
main which gets input (location on the board) from the user until there is a winner or the board is full. It calls all of the above methods and when the game is over presents the winner.
	 */
	
	/* SELF ASSESSMENT  
	   1.  clearBoard:
	Did I use the correct method definition?
	Mark out of 5: 5
	Comment: Yes, used as specified.
	Did I use loops to set each position to the BLANK character?
	Mark out of 5: 5
	Comment: Yes, a nested for loop.
	   2.  printBoard
	Did I use the correct method definition?
	Mark out of 5: 5
	Comment: 5
	Did I loop through the array and prints out the board in a way that it looked like a board?
	Mark out of 5: 5
	Comment: Yes, it looked fine.
	   3.  canMakeMove
	Did I have the correct function definition and returned the correct item?
	Mark out of 5: 5
	Comment: Yes, this worked fine and returned true/ false.
	Did I check if a specified location was BLANK?
	Mark out of 5: 5
	Comment: Yes
	   4.  makeMove
	Did I have the correct function definition?
	Mark out of 5: 5
	Comment: Yes
	Did I set the  currentPlayerPiece in the specified location?
	Mark out of 5: 5
	Comment:  Yes, worked well.  
	   5.  isBoardFull
	Did I have the correct function definition and returned the correct item?
	Mark out of 5: 5
	Comment:   Yes 
	Did I loop through the board to check if there are any BLANK characters?
	Mark out of 5: 5
	Comment:  Yes
	   6.  winner
	Did I have the correct function definition and returned the winning character
	Mark out of 5: 5
	Comment:  Yes works for horizontal, vertical and both the diagonal winning possibilities.   
	Did I identify all possible horizontal, vertical and diagonal winners  
	Mark out of 15: 15
	Comment: Yes, tested this a lot and works for everything.
	   7.main

	Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
	Mark out of 3: 2
	Comments: I used a 4 by 4 and this worked just as well as a 3 by 3 and caused no errors when co-ordinates were entered by the user.
	Did I loop asking the user for a location until wither the board was full or there was a winner?
	Mark out of 5: 5
	Comments: Yes this worked well
	Did I call all of the methods above?
	Mark out of 5: 5
	Comments: Yes
	Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
	Mark out of 3: 3
	Comments: Yes
	Did I switch the current player piece from cross to nought and vice versa after every valid move?
	Mark out of 3: 3
	Comments: Yes also maintains the same piece after every invalid move so the 
	               game can still be played after an invalid input.
	Did I display the winning player piece or a draw at the end of the game?
	Mark out of 3: 3
	Comments: Yes, it worked well.

	   8.  Overall
	Is my code indented correctly?
	Mark out of 3: 3
	Comments: Yes
	Do my variable names and Constants (at least four of them) make sense?
	Mark out of 3: 3
	Comments: Yes
	Do my variable names, method names and class name follow the Java coding standard
	Mark out of 2: 2
	Comments: Yes
	      Total Mark out of 100 (Add all the previous marks): 99 
	*/
	 
	public static final char NOUGHTS = 'O';
	public static final char CROSSES = 'X';
	public static final char BLANK = ' ';
	public static final int BOARD_SIZE = 3;
	
	public static void clearBoard( char[][] board)
	{
		for(int index = 0; index < board.length; index ++) // Fixed: shouldn't have taken away one from board.length and then could have used 3 x 3 array
		{
			for(int index2 = 0; index2 < board[ index ].length; index2 ++) 
			{
				board [index][index2] = BLANK;
			}
		}
	}
	
	public static void printBoard( char[][] board)
	{
		String output =  "Columns: 1  2  3" + "\n";
		for( int count = 0; count < board.length; count ++)
		{
			output += "Row " + (count + 1) + ":     | ";
			for( int index = 0; index < board[ count ].length; index ++)
			{
		        	output += board [count][index] + " | " ;
			}
			output += "\n";
		}
		JOptionPane.showMessageDialog( null, "This is your board:"+ "\n" + output );
	}
	
	public static final boolean canMakeMove ( char[][] board, int row, int column)
	{
		if( board[ row ][ column ] == BLANK )
		{
			return true;
		}
		return false;
	}
	
	public static void makeMove ( char[][] board, char currentPiece, int row, int column)
	{
		board [ row ][ column ] = currentPiece;
	}
	
	public static final boolean isBoardFull ( char[][] board)
	{
		int index1 = 0;
		do
		{
			index1 ++;
			for( int index2 = 0; index2 < board.length ; index2 ++)
			{
		        if( board [ index1 ][ index2 ] == BLANK )
	        	{
	        		return false;
	        	}
			}
		}while( index1 < board.length); //Would have been better using a for loop instead of a do-while
		return true;
	}
	
	public static final char winner( char[][] board )
	{
		for( int index1 = 0; index1 < board.length; index1 ++ )
		{
			if( board[ index1 ][ 0 ] == board[ index1 ][ 1 ] && board[ index1 ][ 1 ] == board[ index1 ][ 2 ]
					&& board[ index1 ][ 1 ] != BLANK )
			{
				return board[ index1 ][ 1 ];
			} // These two if statements return horizontal or vertical winning straight's
			if( board[ 0 ][ index1 ] == board[ 1 ][ index1 ] && board[ 1 ][ index1 ] == board[ 2 ][ index1 ]
					&& board[ 1 ][ index1 ] != BLANK )
			{
				return board[ 1 ][ index1 ];
			}
			//for( int index2 = 0; index2 < board[ index1 ].length; index2 ++)
		}
		if( board[ 0 ][ 0 ] == board[ 1 ][ 1 ] && board[ 1 ][ 1 ] == board[ 2 ][ 2 ]
				&& board[ 1 ][ 1 ] != BLANK )
		{
			//This if statement will return the winner of a diagonal straight from top left to bottom right.
			return board[ 1 ][ 1 ];
		}
		if( board[ 0 ][ 2 ] == board[ 1 ][ 1 ] && board[ 1 ][ 1 ] == board[ 2 ][ 0 ]
				&& board[ 1 ][ 1 ] != BLANK )
		{
			//This if statement will return the winner of a diagonal straight from bottom left to top right.
			return board[ 1 ][ 1 ];
		}
		return ' ';
	}
	
	public static void errorOutput ()
	{
		JOptionPane.showMessageDialog(null, "You have not entered in the correct input, please try again.",
				"ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void main(String[] args) {
		
        char[][] board = new char[ BOARD_SIZE ][ BOARD_SIZE ]; // Use constants where possible
        clearBoard( board ); // Problem fixed: Should have used a 3 x 3, wouldn't work because of my loop conditions should of had index < array.length()
        char currentPiece = NOUGHTS;
        char otherPiece = CROSSES;
        boolean finished = false;
        do
        {
	        String input = JOptionPane.showInputDialog( "What piece would you like to start the game with? "
	        		+ "\n" + "E.G. 'Noughts' or 'Crosses'");
	        Scanner inputScanner = new Scanner ( input );
	        if( inputScanner.hasNext("Noughts") || inputScanner.hasNext("noughts") )
	        {
	        	currentPiece = NOUGHTS;
	        	otherPiece = CROSSES;
	        	finished = true;
	        }
	        else if( inputScanner.hasNext( "Crosses") || inputScanner.hasNext( "crosses" ) )
	        {
	        	currentPiece = CROSSES;
	        	otherPiece = NOUGHTS;
	        	finished = true;
	        }
	        else
	        {
	        	errorOutput();
	        }
        }while( finished != true);
        int row = 0;
        int column = 0;
        int count = 0; 
        boolean noWinner = true;
        boolean possibleMove = true;
        do 
        {
        	count++;
        	if( count != 1 )
        	{
        		char temp = currentPiece;
        		currentPiece = otherPiece;
        		otherPiece = temp;
        	}
	        String input2 = JOptionPane.showInputDialog( "Please enter in what row and what column you would"
	        		+ " like to place a " + currentPiece + "\n" + "Sample input: '1' '2' "
	        				+ "\n" + "(Please seperate your two entries by a space.)" );
	        Scanner inputScanner2 = new Scanner( input2 );
	        // Scanner using system.out.println and system.in is not waiting for second input so abandon & use JOPtion
	        if( inputScanner2.hasNext() )
	        {
	        	row = inputScanner2.nextInt();
	        	if( inputScanner2.hasNextInt() )
	        	{
		        	column = inputScanner2.nextInt();
		        	boolean errorMessageOutputted = false;
	        	if( column != 1 && 3 != column && 2 != column)
		        	{
		        		errorOutput();
		        		errorMessageOutputted = true;
		        		JOptionPane.showMessageDialog(null, "The input you have entered contains "
		        				+ "an invalid column number, please enter an integer number from 1 to 3.");
		        	}
		        	if( row != 1 && 3 != row && 2 != row)
		        	{
		        		if(errorMessageOutputted == false) //So error message isn't outputted twice
		        		{
		        			errorOutput();
		        		}
		        		JOptionPane.showMessageDialog(null, "The input you have entered contains"
		        				+ " an invalid row number, please enter an integer number from 1 to 3");
		        	}
		        	else
		        	{
		        		row = row - 1;
		     	        column = column - 1; //To make them appropriate index's for my arrays
		     	        possibleMove = canMakeMove( board, row, column);
		     	        if( possibleMove == true)
		     	        {
		     	        	makeMove( board, currentPiece, row, column);
		     	        }
		     	        else if( possibleMove == false)
		     	        {
		     	        	char temp2 = currentPiece; // This statement will keep the current piece the 'active' piece if invalid input is entered.
		             		currentPiece = otherPiece; // i.e. if invalid input on crosses turn they will get another turn.
		             		otherPiece = temp2;
		     	        }
		     	        printBoard( board );
		     	        if( winner( board ) != ' ')
		     	        {
		     	        	noWinner = false;
		     	        }
		        	}
	            }
	        	else
	        	{
	        		errorOutput();
	        	}
	        }
        }while( isBoardFull( board ) == false && noWinner == true);  
        if( noWinner == false)
	    {
	    	JOptionPane.showMessageDialog(null, "" + ( (currentPiece == NOUGHTS) ? "Noughts" : "Crosses") 
	    			+ " have won. Congratulations!" + "\n" + "Goodbye.");
	    }
	    else if( isBoardFull( board ) == true )
        {
        	JOptionPane.showMessageDialog(null,"Game Over! No one has won." + "\n" + "Goodbye.");
        }
	} 

}
