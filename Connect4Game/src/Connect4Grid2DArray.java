

public class Connect4Grid2DArray implements Connect4Grid {
	

	public void emptyGrid()
	{
		for( int i = 0; i < COLUMNS; i++ )
		{
			for( int j = 0; j < ROWS; j++ )
			{
				board[ i ][ j ] = ' ';
			}
		}
	}
	
	public String toString() // board[COLUMNS][ROWS]
	{
		String boardOutput = "       1  |  2  |  3  |  4  |  5  |  6  |  7  |" + "\n" + "__________________________" + "\n";
		for( int i = 0; i < ROWS; i++)
		{
			boardOutput +=  (i + 1) + "  |  ";
			for( int j = 0; j < COLUMNS; j++)
			{
				boardOutput += board[ j ][ i ] + "   |   ";
			}
			boardOutput += "\n" + "___________________________" + "\n";
		}
		return boardOutput;
	}
	
	public boolean isValidColumn( int column )
	{
		if( column > 0 && column <= COLUMNS )
		{
			return true;
		}
		return false;
	}
	
	public boolean isColumnFull( int column )
	{
		if( isValidColumn( column ))
		{
			for( int i = 0; i < ROWS; i++ )
			{
				if( board[ column - 1 ][ i ] == BLANK )
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public void dropPiece( ConnectPlayer player, int column )  //board[column][row]
	{
		boolean finished = false;
		for (int row = (ROWS - 1); row >= 0 && !finished; row--) 
		{
			if (board[ column - 1 ][ row ] == BLANK) 
			{
				board[ column - 1 ][ row ] = player.getPlayerPiece(); 
				finished = true;
			}
		}
	}
	
	public boolean didLastPieceConnect4()
	{
		boolean horizontal = horizontalWin();
		boolean vertical = verticalWin();
		boolean diagonal1 = ascendingDiagonal(); //left to right
		boolean diagonal2 = descendingDiagonal();//right to left
		if( horizontal || vertical || diagonal1 || diagonal2 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean horizontalWin() //board[COLUMNS][ROWS]
	{
		for( int j = 0; j < ROWS; j++)
		{
			for( int i =0; i < 4; i++) 
			{
				int a = i;
				int b = i + 1;
				int c = i + 2;
				int d = i + 3;
				if( board[a][j] == board[b][j] && board[b][j] == board[c][j] && board[c][j] == board[d][j] && board[d][j] != BLANK)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean verticalWin() //board[COLUMNS][ROWS]
	{
		for( int j = 0; j < COLUMNS; j++)
		{
			for( int i = 0; i < 3; i++)
			{
				int a = i;
				int b = i + 1;
				int c = i + 2;
				int d = i + 3;
				if( board[j][a] == board[j][b] && board[j][b] == board[j][c] && board[j][c] == board[j][d] && board[j][d] != BLANK)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean ascendingDiagonal()    /// board [columns] [rows]
	{
		for( int j = 3; j < ROWS; j++) //ROWS
		{
			int a = j - 3;
			int b = j - 2;
			int c = j - 1;
			int d = j;
			for( int i = 3; i < COLUMNS; i++) //COLUMNS
			{
				int e = i;
				int f = i - 1;
				int g = i - 2;
				int h = i - 3;
				if( board[h][d] == board[g][c] && board[g][c] == board[f][b] && board[f][b] == board[e][a] && board[e][a] != BLANK)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean descendingDiagonal() // board[COLUMNS][ROWS]
	{
		for( int j = 3; j < ROWS; j++) //ROWS
		{
			int a = j - 3;
			int b = j - 2;
			int c = j - 1;
			int d = j;
			for( int i = 3; i < COLUMNS; i++) //COLUMNS
			{
				int e = i;
				int f = i - 1;
				int g = i - 2;
				int h = i - 3;
				if( board[h][a] == board[g][b] && board[g][b] == board[f][c] && board[f][c] == board[e][d] && board[e][d] != BLANK)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isGridFull()
	{
		int topRow = 0;
		for( int i = 0; i < COLUMNS; i++)
		{
			//only check the top of each columns to see if it is full
			if( board[i][topRow] == BLANK)
			{
				return false;
			}
		}
		return true;
	}
}
