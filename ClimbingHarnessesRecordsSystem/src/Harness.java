

public class Harness {

	private static final int MAX_USES = 25; //before service required
	private static boolean onLoan;
	private static int numberOfUses;
	private static String borrower;
	private final String harnessMake;
	private final int harnessModelNumber;
	private static String lastSafetyChecker;
	
	Harness( String make, int modelNumber, int numberOfUses, String lastSafetyChecker, boolean onLoan,
			String loanedToClubMember){
		 Harness.onLoan = onLoan;
		 Harness.borrower = loanedToClubMember;
		 Harness.numberOfUses = numberOfUses;
		 harnessMake = make;
		 harnessModelNumber = modelNumber;
	}
	
	Harness( String make, int modelNumber, String lastSafetyChecker){
		onLoan = false;
		numberOfUses = 0;
		harnessMake = make;
		harnessModelNumber = modelNumber;
		Harness.lastSafetyChecker = lastSafetyChecker;
	}
	
	public void checkHarness( String checker)
	{
		if( !onLoan )
		{
			lastSafetyChecker = checker;
			numberOfUses = 0;
		}
	}
	
	public boolean isHarnessOnLoan()
	{
		return onLoan;
	}
	
	public boolean canHarnessBeLoaned()
	{
		if( onLoan ) {
			return false;
		}
		else if( numberOfUses >= MAX_USES ) {
			return false;
		}
		return true;
	}
	
	public void loanHarness( String clubMember)
	{
		if( canHarnessBeLoaned() ) {
			onLoan = true;
			borrower = clubMember;
			numberOfUses++;
		}
	}
	
	public void returnHarness( )
	{
		if( isHarnessOnLoan() ) {
			onLoan = false;
			borrower = null;
		}
		
	}
	
	public String toString( ) //gives description of harness
	{
		String harnessStatus = "Harness make: " + harnessMake + "\n" + "Harness model number: " + harnessModelNumber + "\n"
				+ "Harness" + (isHarnessOnLoan() == true ? (" is on loan to " + borrower) : " is not on loan ")  + "\n" + 
				"Last safety check was conducted by " + lastSafetyChecker + " since this check"
						+ " the harness has been used " + numberOfUses + " times.";
		if( numberOfUses >= 25)
		{
			harnessStatus += "\n " + "Harness must be checked for safety reasons as it has been used 25 or more times"
					+ " since its last check.";
		}
		else
		{
			harnessStatus += "\n" + "Harness has " +  ( MAX_USES - numberOfUses) + " uses left until its next Safety check is due";
		}
		return harnessStatus;
	}
	
	public boolean sameMakeAndModel( String make, int model)
	{
		if( harnessMake == make && harnessModelNumber == model)
		{
			return true;
		}
		return false;
	}
	

}
