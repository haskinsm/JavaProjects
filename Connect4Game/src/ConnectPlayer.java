
public abstract class ConnectPlayer {

	public int playerNumber;
	public char playerPiece;
	
	public void setPlayer(int player)
	{
		playerNumber = player;
	}
	
	public int getPlayer()
	{
		return playerNumber;
	}
	
	public void setPlayerPiece()
	{
		if( playerNumber == Connect4Grid.PLAYER_TWO)
		{
			playerPiece = Connect4Grid.PLAYER_TWO_PIECE;
		}
		else playerPiece = Connect4Grid.PLAYER_ONE_PIECE;
	}
	
	public char getPlayerPiece()
	{
		return playerPiece;
	}
	
	public abstract void makeMove(Connect4Grid grid, ConnectPlayer player);
	
	
}
