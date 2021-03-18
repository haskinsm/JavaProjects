import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class toDocument {

	public static void wordsToDocument( BufferedWriter a)
	{
		boolean finished = false;
		while( !finished ){
			System.out.println("Please enter in one word. Or enter nothing to quit the program.");
			Scanner inputScanner = new Scanner( System.in );
			if( inputScanner.hasNext() )
			{
				String input = inputScanner.next();
				if( input.isEmpty() )
				{
					finished = true;
				}
				else
				{
					try {
						a.write( input + " ");
						a.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		    }
		}
		try {
			a.close();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		String filePath = "../";
		filePath.concat( args[ 1 ] );		
		File myFile = new File( filePath );
		try {
			FileReader fileWriter = new FileReader( args[1] );
			BufferedWriter a = new BufferedWriter( fileWriter );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	} 
/* Not needed or applicable here.
 * Return String representation of CommissionEmployee object         
   @Override // indicates that this method overrides a superclass method
   public String toString()                                             
   {                                                                    
      return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f",    
         "commission employee", firstName, lastName,                    
         "social security number", socialSecurityNumber,                
         "gross sales", grossSales,                                     
         "commission rate", commissionRate); 
         
         In different class:
         System.out.println(
         "Employee information obtained by get methods:");
      System.out.printf("%n%s %s%n", "First name is",
         employee.getFirstName());
      System.out.printf("%s %s%n", "Last name is", 
         employee.getLastName());
      System.out.printf("%s %s%n", "Social security number is", 
         employee.getSocialSecurityNumber());
      System.out.printf("%s %.2f%n", "Gross sales is", 
         employee.getGrossSales());
      System.out.printf("%s %.2f%n", "Commission rate is",
         employee.getCommissionRate());
         
         
         public class BasePlusCommissionEmployee extends CommissionEmployee
{
   private double baseSalary; // base salary per week

   // Six-argument constructor
   public BasePlusCommissionEmployee(String firstName, String lastName, 
      String socialSecurityNumber, double grossSales, 
      double commissionRate, double baseSalary)
   {
      // Explicit call to superclass CommissionEmployee constructor
      super(firstName, lastName, socialSecurityNumber, 
         grossSales, commissionRate);

      // If baseSalary is invalid throw exception
      if (baseSalary < 0.0)                      
         throw new IllegalArgumentException(    
            "Base salary must be >= 0.0");       

      this.baseSalary = baseSalary;
   } 
   } 
 */
}
