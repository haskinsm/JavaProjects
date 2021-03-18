import java.util.*;

public class HarnessRecords {

	private static ArrayList < Harness > harnessRecord; //= new ArrayList < Harness >();
	
	HarnessRecords(){
		harnessRecord = new ArrayList < Harness >();
		harnessRecord = null; // do i need to do this?
	}
	/*
	HarnessRecords( String[] hCharacteristics){ //pass array in with index 1 being make index 2 being model etc...
		String make = hCharacteristics[ 0 ];
		int modelNum = Integer.parseInt( hCharacteristics[ 1 ]);
		int numUses = Integer.parseInt( hCharacteristics[ 2 ]);
		String nameCI = hCharacteristics[ 3 ];
		boolean onLoan = Boolean.parseBoolean( hCharacteristics[ 4 ]);
		String loanedTo = hCharacteristics[ 5 ];
		Harness a = new Harness(make, modelNum, numUses, nameCI, onLoan, loanedTo);
		harnessRecord = new ArrayList < Harness >();
		addHarness( a );
		//harnessRecord.add( a );
	}
	*/
	//pass in a 2D array where rows are (empty) harness objects and columns are Strings which can be used to parse out info
	HarnessRecords( List<List<String>> harCharacteristics){ 
		for( int i = 0; i < harCharacteristics.size(); i++ )
		{
			String make = harCharacteristics.get( i ).get( 0 );
			int modelNum = Integer.parseInt( harCharacteristics.get( i ).get( 1 ));
			int numUses = Integer.parseInt( harCharacteristics.get( i ).get( 2 ));
			String nameCI = harCharacteristics.get( i ).get( 3 );
			boolean onLoan = Boolean.parseBoolean( harCharacteristics.get( i ).get( 4 ) );
			String loanedTo = harCharacteristics.get( i ).get( 5 );
			Harness a = new Harness(make, modelNum, numUses, nameCI, onLoan, loanedTo);
			harnessRecord = new ArrayList < Harness >();
			addHarness( a );
		}
		//harnessRecord.add( a );
	}


	private static boolean isEmpty()
	{
		return harnessRecord.isEmpty();
	}
	
	private static void addHarness( Harness a )
	{
		harnessRecord.add(a); 
	}
	
	public Harness findHarness( String make, int modelNumber )
	{
		for( int i = 0; i < harnessRecord.size(); i++)
		{
			Harness a = harnessRecord.get( i );
			if( a.sameMakeAndModel( make, modelNumber))
			{
				return a;
			}
		}
		return null; 
	}
	
	public Harness checkHarness( String checker, String make, int modelNum )
	{
		Harness a = findHarness( make, modelNum); //if method cannot find a harness will return null
		if( !a.isHarnessOnLoan())
		{
			a.checkHarness( checker );
			return a;
		}
		return null;
	}
	
	public Harness loanHarness( String clubMember )
	{
		boolean freeHarnessFound = false;
		for( int i = 0; i < harnessRecord.size() && !freeHarnessFound; i++)
		{
			Harness a = harnessRecord.get( i );
			if( a.canHarnessBeLoaned() && !freeHarnessFound )
			{
				freeHarnessFound = true; //would have worked without this
				return a;
			}
		}
		return null;
	}
	
	public Harness returnHarness( String make, int modelNum )
	{
		Harness a = findHarness( make, modelNum);
		if( a.isHarnessOnLoan() )
		{
			return null;
		}
		a.returnHarness();
		return a;
	}
	
	public Harness removeHarness( String make, int modelNum )
	{
		Harness a = findHarness( make, modelNum );
		if( a.isHarnessOnLoan() )
		{
			return null; //as harness is out on loan and can't be removed
		}
		harnessRecord.remove( harnessRecord.indexOf( a ) );
		return a;
	}
	
}
