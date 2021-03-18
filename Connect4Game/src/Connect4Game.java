import java.util.*;

import javax.swing.JOptionPane;

public class Connect4Game {
	public ConnectPlayer playerOne;
	public ConnectPlayer playerTwo;
	public Connect4Grid grid;

	/* SELF ASSESSMENT

	Connect4Game class (35 marks) : 35
	My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
	Comment: Yes. User has option to quit after every loop. Grid was created in constructor of Connect4game class. Both players were initialized with the type ConnectPlayer. The game then starts and user is asked every time if it is a human player what column he/she would like to place their piece into. Checks are performed and checks for winner.

	Connect4Grid interface (10 marks) : 10
	I define all 7 methods within this interface.
	Comment: Yes defined all prescribed methods.

	Connect4Grid2DArray class (25 marks) : 25
	My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column
	 to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full.
	It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
	Comment: Yes interface is implemented and 2D array is created in interface. I checked if column selected is valid, checked if column selected was full,
				I implemented a dropPiece method here and also checked for every winning possibility.

	ConnectPlayer abstract class (10 marks) : 10
	My class provides at lest one non-abstract method and at least one abstract method. 
	Comment:  MakeMove was an abstract method here and I had multiple non abstract methods such as setPlayer.

	C4HumanPlayer class (10 marks) : 10
	My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
	Comment:  Overrides the abstract method make move and takes input from the human player.

	C4RandomAIPlayer class (10 marks) : 10
	My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
	Comment:  My class here overrides the makeMove abstract method and selects a random column for the AI player. 

	Total Marks out of 100: 100

	*/
	Connect4Game( boolean player1Human, boolean player2Human)  //creates Grid and both player's types
	{
		if( player1Human )
		{
			playerOne = new C4HumanPlayer();
		}
		else
		{
			playerOne = new C4RandomAIPlayer();
		}
		if( player2Human )
		{
			playerTwo = new C4HumanPlayer();
		}
		else
		{
			playerTwo = new C4RandomAIPlayer();
		}
		grid = new Connect4Grid2DArray(); 
	}
	
	public static void main(String[] args) {
		
		boolean finished = false;
		int answerPlayer1Type = JOptionPane.showConfirmDialog(null, "Welcome to Connect4! " + "\n" + "Would you like player 1 to be a human player?" 
				+ "\n" + "If not select No to select an AI player. To quit select Cancel. " );
		finished = ( answerPlayer1Type == JOptionPane.CANCEL_OPTION );
		boolean player1Human = ( answerPlayer1Type == JOptionPane.YES_OPTION);
		boolean player2Human = false;
		if( !finished )
		{
			int answerPlayer2Type = JOptionPane.showConfirmDialog(null, "Welcome to Connect4! " + "\n" + "Would you like player 2 to be a human player?" 
					+ "\n" + "If not select No to select an AI player. To quit select Cancel.");
			finished = ( answerPlayer2Type == JOptionPane.CANCEL_OPTION );
			player2Human = ( answerPlayer2Type == JOptionPane.YES_OPTION);
		}
		Connect4Game newGame = new Connect4Game( player1Human, player2Human );
		newGame.grid.emptyGrid();
		newGame.playerOne.setPlayer( 1 );
		newGame.playerTwo.setPlayer( 2 ); //replace with named variables later
		newGame.playerOne.setPlayerPiece();
		newGame.playerTwo.setPlayerPiece();
		JOptionPane.showMessageDialog(null, newGame.grid.toString() );
		ConnectPlayer currentPlayer = newGame.playerOne;
		if( !finished )
		{
			do
			{
				//int playOn = JOptionPane.showConfirmDialog(null, "Would you like to quit?" );
				//finished = ( playOn == JOptionPane.YES_OPTION );
				if( !finished)
				{
					JOptionPane.showMessageDialog(null, "Player" + (currentPlayer.equals(newGame.playerOne) ? " One's":" Two's") + " go. Current Board:"
							+ "\n" + newGame.grid.toString());
					if(currentPlayer.equals(newGame.playerOne))
					{
						newGame.playerOne.makeMove(newGame.grid, newGame.playerOne);
						currentPlayer = newGame.playerTwo;
					}
					else 
					{
						newGame.playerTwo.makeMove(newGame.grid, newGame.playerTwo);
						currentPlayer = newGame.playerOne;
					}
					if( newGame.grid.didLastPieceConnect4() )
					{
						JOptionPane.showMessageDialog(null, "Game over! " + (currentPlayer.equals(newGame.playerOne) ? "Player Two": "Player One") + " has Won! Congratulations!"
								+ "\n" + "Winning board:" + "\n" + newGame.grid.toString() );
					}
				}
			}while( !finished && !newGame.grid.isGridFull() && !newGame.grid.didLastPieceConnect4());
		}
	}

}
