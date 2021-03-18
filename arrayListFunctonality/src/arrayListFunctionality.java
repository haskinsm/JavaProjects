import java.util.*;

public class arrayListFunctionality {

	public static void main(String[] args) {
		
		ArrayList< Integer > test = new ArrayList< Integer >(); //must be Integer entered not int
		int count = 1;
		for( int i = 0; i < 20; i++)
		{
			count ++;
			test.add( count );
		}
		System.out.println( test.size() );
		System.out.println( "find index of 6: " + test.indexOf( 6 )); 
		for( int i = 0; i < 10; i++ )
		{
			test.remove( i  ); 
		}
		System.out.println( test.size() );
		System.out.println( "empty? " + test.isEmpty());
		System.out.println( "contain 6? " + test.contains( 6 )); //boolean returns
		for( int a : test)
		{
			System.out.println( test.get( a ));
		}
		test.clear();
	}

}
