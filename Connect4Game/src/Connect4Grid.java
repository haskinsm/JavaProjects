
public interface Connect4Grid {
	
	public static final int COLUMNS = 7;
	public static final int ROWS = 6;
	public final char PLAYER_ONE_PIECE = 'O';
	public final char PLAYER_TWO_PIECE = 'X';
	public static final char BLANK = ' ';
	public final int PLAYER_ONE = 1;
	public final int PLAYER_TWO = 2;
	public char [] playerPieces = {PLAYER_ONE_PIECE, PLAYER_TWO_PIECE};
	public char [] [] board = new char[ COLUMNS ][ ROWS ];
	
	public abstract void emptyGrid();
	
	public abstract String toString();
	
	public abstract boolean isValidColumn( int column );
	
	public abstract boolean isColumnFull(int column);
	
	public abstract void dropPiece(ConnectPlayer player, int column);
	
	public abstract boolean didLastPieceConnect4();
	
	public abstract boolean isGridFull();
	
}
