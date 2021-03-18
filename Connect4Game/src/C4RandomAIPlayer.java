import java.util.*;

public class C4RandomAIPlayer extends ConnectPlayer{

	@Override
	public void makeMove(Connect4Grid grid, ConnectPlayer player) 
	{
		Random generator = new Random();
		boolean finished = false;
		while(!finished)
		{
			int randomColumn = generator.nextInt((Connect4Grid.COLUMNS) + 1); // 0 will not be a valid column so if 0 will loop again
			if( !grid.isColumnFull(randomColumn) && grid.isValidColumn(randomColumn) )
			{
				grid.dropPiece(player, randomColumn);
				finished = true;
			}
		}
		
	}
}
