import java.util.Scanner;
import javax.swing.JOptionPane;

public class SportsPrizes {

	public static void main(String[] args) {
		
		int numberCompetitors = 0;
		boolean finished = false;
		boolean prime = true;
	 do
	 {
		  String input = JOptionPane.showInputDialog("Enter in the number of competitors "
		  		+ "(or enter 'exit' or 'quit' to leave the program):");
		  Scanner inputScanner = new Scanner( input );
		  if(inputScanner.hasNextInt())
		  {
			  numberCompetitors =  inputScanner.nextInt();
		  }
		  else if((inputScanner.hasNext("quit") || inputScanner.hasNext("exit")));
		  {
			  finished = true;
		  }
		  inputScanner.close();
		  String prizeWinners = "The prize winners are the contestants who placed 1st,";
		  for( int currentNumber = 1; (currentNumber <= numberCompetitors); currentNumber ++)
		  {
			  for(int divisor = 1; (divisor <= currentNumber) ; divisor++)
			  {
				  if(currentNumber % divisor == 0)
				  {
					  prime = false;
				  }
				  else
				  {
					  prizeWinners = prizeWinners + "," + currentNumber;
				  }
			  }
		  }
		  JOptionPane.showMessageDialog(null, prizeWinners);
	  }while(!finished);
		
		

	}

}
