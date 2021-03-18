import java.util.*;

import javax.swing.JOptionPane;

public class C4HumanPlayer extends ConnectPlayer {

	@Override
	public void makeMove(Connect4Grid grid, ConnectPlayer player) 
	{
		boolean finished = false;
		while(!finished)
		{
			String input = JOptionPane.showInputDialog( "Please enter the column you would like to place your piece into:");
			Scanner inputScanner = new Scanner( input );
			if( inputScanner.hasNextInt() )
			{
				int column = inputScanner.nextInt();
				if( grid.isValidColumn(column) )
				{
					grid.dropPiece(player, column);
					finished = true;
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "This is not a valid column.");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please enter a column value from 1 - 7");
			}
		}
		
	}

}
