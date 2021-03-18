
public class TutorialObjectOP { //should of called the class bank customer

	private int accountNumber;
	private String customerName;
	private String customerAddress;
	private int customerDOB;
	

		//These are all like functions
		public int getAccountNumber()
		{
			return accountNumber;
		}
		public void setAccountNumber(int a)
		{
			accountNumber = a;
		}
		public String getcustomerName()
		{
			return customerName;
		}
		public void setCustomerName( String b )
		{
			customerName = b;
		}
		public String getCustomerAddress() 
		{
			return customerAddress;
		}
		public void  setCustomerAddress( String c )
		{
			customerAddress = c;
		}
		public int getCustomerDOB()
		{
			return customerDOB; 
		}
		public void setCustomerDOB( int d )
		{
			customerDOB = d;
		}
		
		public static void main(String[] args) {	
			TutorialObjectOP c = new TutorialObjectOP(); //This is the name of the class basically
			c.setAccountNumber(1234);
			c.setCustomerAddress( " Street");
			c.setCustomerDOB(241099);
			c.setCustomerName("M");
			TutorialObjectOP[] bankCustomerArray = new TutorialObjectOP[10];
			TutorialObjectOP customer = bankCustomerArray[0];
			int temp = c.getAccountNumber();
			System.out.println( temp);
			
	}

}
