import java.util.ArrayList;
public class BankCustomer {


    private int accountNumber;
    private String customerName;
    private String customerAddress;
    private int customerDateOfBirth;

    public static String findCustomer( int accountNumber, BankCustomer[] bankCustomers)
    {
    	for(int i=0; i<bankCustomers.length; i++)
    	{
    	    if( bankCustomers[i].getAccountNumber() == accountNumber)
    	    {
    	    	return bankCustomers[i].getCustomerName();
    	    }
    	}
    	return " No Customer ";
    }
    
    public static String findCustomer( int dOB, String address, BankCustomer[] bankCustomers)
    {
    	for(int i=0; i<bankCustomers.length; i++)
    	{
    		if( bankCustomers[i].getCustomerAddress() == address && 
    				bankCustomers[i].getCustomerDateOfBirth() == dOB )
    		{
    			return bankCustomers[i].getCustomerName();
    		}
    	}
    	return "No such Customer";
    }
    
    public int getAccountNumber()
    {
	return accountNumber;
    }

    public void setAccountNumber(int accNumber)
    {
	accountNumber = accNumber;
    }

    public String getCustomerName()
    {
	return customerName;
    }

    public void setCustomerName(String name)
    {
	customerName = name;
    }

    public String getCustomerAddress()
    {
	return customerAddress;
    }

    public void setCustomerAddress(String address)
    {
	customerAddress = address;
    }

    public int getCustomerDateOfBirth()
    {
	return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(int dob)
    {
	customerDateOfBirth = dob;
    }

    public static void main(String[] args)
    {
	BankCustomer[] bankCustomers = new BankCustomer[10];
	
	int count = 0;
	for(int i=0; i<bankCustomers.length; i++ )
	{
		count++;
	    bankCustomers[i] = new BankCustomer();
        bankCustomers[i].setAccountNumber( count );
        bankCustomers[i].setCustomerName( "AB");
        bankCustomers[i].setCustomerAddress( "123 B");
        bankCustomers[i].setCustomerDateOfBirth( 1999 );
	}
	// ArrayList< BankCustomer > bankCustomers = new ArrayList< BakCustomer >();
	int accountNumberToCheck = 2;
	int dOB = 1999;
	String address = "123 B";
    String currentUser = findCustomer( accountNumberToCheck, bankCustomers); //notice same function name but will go to which ever method has the matching parameters
    String otherUser = findCustomer( dOB, address, bankCustomers );
    System.out.println( currentUser );
    System.out.println( otherUser );
	System.out.println("Customer Account Number is " + bankCustomers[6].getAccountNumber());
	for( BankCustomer a: bankCustomers) //for printing out an array list
	{
		System.out.println( a.getAccountNumber());
	}
    }
}


