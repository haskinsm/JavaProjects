import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.ArrayList; // or java.util.*;

/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment:  Yes, worked I did this exactly.
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8 ].
Comment:  Yes, my program does this making use of the Wallet class.
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5 ].
Comment:  Yes I called this method from the wallet class.
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15 ]..
Comment:  Yes I used a public static int variable to store the sum.
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment:  Yes I did this with a series of if and else if statements.
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10].
Comment:  Yes once user places bet the bet amount is removed from the users wallet and is only added back along with the winnings if the users wins

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15 ]
Comment: Yes I used a loop which only stops once the user has entered in an appropriate amount of cash or when the user enters quit or exit.
              If the user runs out of money they can top up their wallet also.
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5 ]
Comment: Yes, the user can top up their wallet if their cash balance is 0. They can enter quit or exit to leave the program
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment: Yes, this worked fine.
My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment: Yes it does for each bet type entered.
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment: Yes it gives the balances of the wallet after each bet and then the winnings and loses below and also the total amount toped up and current amount in the wallet.

 Total Mark out of 100 (Add all the previous marks): 100
*/
public class ChuckALuckDiceGame {

	public static final int TRIPLE_PAYOUT = 60; // 30:1
	public static final int FIELD_PAYOUT = 2;  //  1:1
	public static final int HIGH_PAYOUT = 2;   // 1:1
	public static final int LOW_PAYOUT = 2;    // 1:1
	
	public static int sumOfDie = 0; 
	public static String betType = "";
	public static boolean finished = false;
	public static double firstTopUp = 0;
 
	
	public static void resolveBet( String betType, Wallet playerWallet)
	{
		boolean correctBet = false;
		double betAmount = 0;
		do
		{
			String input = JOptionPane.showInputDialog(null, "Please enter how much money you would like to bet on "
					+ betType + "\n" + "Your current wallet balance is €" + playerWallet.check());
			Scanner inputScanner3 = new Scanner( input );
			if( inputScanner3.hasNextDouble() )
			{
				betAmount = inputScanner3.nextDouble();
				if( betAmount > 0 )
				{
					if( playerWallet.get( betAmount ) == true )  //This method also takes bet away from wallet balance
					{
						correctBet = true;
						//playerWallet.take( betAmount ); // (not needed)
					}
					else
					{
						invalidBet( playerWallet );
					}
		
				}
				else
				{
					invalidBet( playerWallet );
				}
			}
		}while( !correctBet );
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		Dice dice3 = new Dice();
		sumOfDie = dice1.roll() + dice2.roll() + dice3.roll();
		double playerWinnings = 0;
		boolean betLost = false;
		if( betType == "Triple" && same3FacesOnDie( dice1, dice2, dice3 ) == true && 
				dice1.topFace() != 1 && dice1.topFace() != 6 ) 
		{
			playerWinnings = TRIPLE_PAYOUT * betAmount;
			playerWallet.put( playerWinnings );
		}
		else if( betType == "Field" && sumOfDie > 8 && sumOfDie < 12 )
		{
			playerWinnings = FIELD_PAYOUT * betAmount;
			playerWallet.put( playerWinnings );
		}
		else if( betType == "High" && sumOfDie > 10 && !same3FacesOnDie( dice1, dice2, dice3 ) )
		{
			playerWinnings = HIGH_PAYOUT * betAmount;
			playerWallet.put( playerWinnings );
		}
		else if( betType == "Low" && (sumOfDie < 11) && ( !same3FacesOnDie( dice1, dice2, dice3 ) ) )
		{
			playerWinnings = LOW_PAYOUT * betAmount;
			playerWallet.put( playerWinnings );
		}
		else
		{
			betLost = true;
		}
		JOptionPane.showMessageDialog(null, "You have bet €" + betAmount + " on " + betType +
				"\n" + "Top Face of:" + "\n" + "Dice 1: " + dice1.topFace() 
				+ "\n" + "Dice 2: " + dice2.topFace() + "\n" + "Dice 3: " +
				dice3.topFace() + "\n" + "The sum of the three Die is: "+sumOfDie + "\n" 
				+ "Your bet has " + ( ( betLost == true) ? "lost" : "won! Congratulations!" ) 
				+ "\n" + "Your current wallet Balance is €" + playerWallet.check() );
		//ArrayList<  > playersWallet = new ArrayList<  >( 1 ); 
		//playersWallet.add( playerWallet.check() );
		
	}
	
	public static boolean same3FacesOnDie( Dice dice1 , Dice dice2, Dice dice3)
	{
		if( ( dice1.topFace() == dice2.topFace() ) && 
					(dice2.topFace() == dice3.topFace()) )
		{
			return true;
		}
		return false;
	}
	
	public static void invalidBet( Wallet playerWallet )
	{
		JOptionPane.showMessageDialog(null, "You have not entered in a valid bet." +
				"\n" + "Please Enter a postive bet less than or equal to your current wallet balance"
				+ "\n" + "of €" + playerWallet.check(), "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void errorOutput()
	{
		JOptionPane.showMessageDialog(null, "You have not entered in a positive amount of money"
				+ " to be added to your wallet. Please try again." + "\n" + "Sample input: €20.50", "ERROR", 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public static void main(String[] args) {
		
		boolean correctInput = false;
		//boolean finished = false;
		boolean fundsInWallet = false;
		Wallet playerWallet = new Wallet();
		int betCount = 0;
		double walletTopUpTotal = 0;
		boolean noError = true;
		ArrayList< Double > playersWalletArray = new ArrayList< Double >( 1 ); 
		do
		{
			do
			{
				String input = JOptionPane.showInputDialog( "Please enter in the amount of Euro's you"
						+ " would like to place in your wallet." + "\n" + "Or enter 'exit' or 'quit' "
								+ "to leave the program.");
				Scanner inputScanner = new Scanner( input );
				if( inputScanner.hasNextDouble())
				{
					double temp = inputScanner.nextDouble();
					if( temp > 0.00 )
					{
						correctInput = true;
						firstTopUp = temp;
						walletTopUpTotal += temp;
						fundsInWallet = true;
						playerWallet.put( temp );
						JOptionPane.showMessageDialog(null, "You have successfully added €" + playerWallet.check() +
								" to your current wallet."); 
					}
					else
					{
						errorOutput();
					}
				}
				else if( inputScanner.hasNext( "quit") || inputScanner.hasNext( "exit") )
				{
					finished = true;
					//break;
				}
				else 
				{
					errorOutput();
				}
			}while( !correctInput && !finished );
			if( finished == false) // Included this because if user enters quit in do while loop above and finished becomes true..
			{                       // ... program will still enter this loop before quitting. (prob to do with my big do while having same quit parameters)
				do
				{
					noError = true;
					String input = JOptionPane.showInputDialog( "Please enter the name of which Bet you would like to place:"
							+ "\n" + "1. Triple (All 3 dice show same number (but not 1s or 6s).  Payout: 30:1"
							+ "\n" + "2. Field  (Total of 3 dice < 8 or total is > 12. )	 Payout: 1:1"
							+ "\n" + "3. High	(Total of 3 dice > 10 (but not a Triple) ).  Payout: 1:1"
							+ "\n" + "4. Low	(Total of 3 dice < 11 (but not a Triple) ).	 Payout: 1:1"
						    + "\n" + "Sample input: 'High'"
							+ "\n" + "To leave the program enter 'quit' or 'exit'.");
					Scanner inputScanner2 = new Scanner( input );
					if (inputScanner2.hasNext( "Triple" ) )
					{
				        betType = "Triple";
					}
					else if(inputScanner2.hasNext( "Field") )
					{
						betType = "Field";
					}
					else if( inputScanner2.hasNext( "High") )
					{
						betType = "High";
					}
					else if( inputScanner2.hasNext( "Low") )
					{
						betType = "Low";
					}
					else if( inputScanner2.hasNext( "quit") || inputScanner2.hasNext( "exit") )
					{
						finished = true;
						//break;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You have not entered in a correct bet type." + "\n" +
								"Please try again. Sample input: 'High' ", "ERROR",
								JOptionPane.ERROR_MESSAGE);
						noError = false;
					}
					if( betType != "" && !finished && noError)
					{
						playersWalletArray.add( playerWallet.check() );
						resolveBet( betType, playerWallet);
						betCount++;
						//ArrayList< Double > playersWallet = new ArrayList< Double >( 1 ); 
					}
					if( playerWallet.check() == 0 )
					{
						fundsInWallet = false;
					}
				}while( !finished && fundsInWallet);
			}
		}while( !finished );
		String outputString = "This is your wallet balance before each bet: " + "\n";
		String winningsAndLosses = "";
		double totalWinnings = playerWallet.check() - walletTopUpTotal;
		for( int index = 0; index < playersWalletArray.size() - 1; index++ )
		{
			outputString += ( index + 1 ) + ":  " + playersWalletArray.get( index ) + "0 ";
			double temp = playersWalletArray.get( index + 1 ) - playersWalletArray.get( index );
			if( temp != 0)
			{
				winningsAndLosses += ( index + 1 ) + ":  " + ( (temp > 0) ? "+" + temp : "" + temp ) + "  " ; // Code fails to find the winnings and losses after the player tops up.
			}
		}
		outputString += (playersWalletArray.size() ) + ":  " + playersWalletArray.get( playersWalletArray.size() - 1 ) + "0 ";
		winningsAndLosses += ( betCount ) + ":  " + ( playerWallet.check() - playersWalletArray.get( playersWalletArray.size() - 1 ) );
		JOptionPane.showMessageDialog(null, "You placed a total of " + betCount + " bets." + "\n" + outputString
				+ "\n" + "This is your winnings and losses after each bet:" + "\n" + winningsAndLosses + "\n"+
				"In total you have topped up your wallet by €" + walletTopUpTotal + "\n" + "Net earnings: €"
				+ totalWinnings  + "\n" + "Now your "  + playerWallet.toString() + ". Goodbye.");
	}

}
