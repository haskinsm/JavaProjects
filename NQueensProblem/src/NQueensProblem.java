import java.util.*;

import javax.swing.JOptionPane;

public class NQueensProblem {
	
    public static int rows;
    public static int columns;

	public static void display( int[][] matrix)
	{
		
	}
	public static void initializeMatrix( int[][] matrix )
	{
		for( int i = 0; i < matrix.length; i++)
		{
			for( int i2 = 0; i2 < matrix[ i ].length; i2++ )
			{
				matrix[ i ][ i2 ] = 0;
			}
		}
	}
	public static void buildMatrix( int[][] matrix )
	{
		for( int i = 0; i < matrix.length; i++)
		{
			for( int i2 = 0; i2 < matrix[i].length; i2++)
			if( matrix[i][i2])
		}
	}
	public static void main(String[] args) {
		
		String input = JOptionPane.showInputDialog( "Please enter in how many rows & columns you would like"
				+ " to have for the matrix" + "\n" + "Sample input: '4' would create a 4x4 matrix");
		Scanner inputScanner = new Scanner( input );
		if( inputScanner.hasNext() )
		{
			int userInput = inputScanner.nextInt();
			if( userInput >= 2 && userInput <= 10)
			{
				rows = userInput;
				columns = userInput;
				int[][] matrix = new int[ rows ][ columns ];
				initializeMatrix( matrix );
				buildMatrix( matrix );
				display( matrix );		
			}
		}
		inputScanner.close();
		
	}

}
