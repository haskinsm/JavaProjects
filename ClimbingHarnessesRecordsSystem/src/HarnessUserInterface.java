import java.util.*;

import javax.swing.JOptionPane;

/* SELF ASSESSMENT

Harness Class: Member variables (8 marks)
All my data members are declared, private and the ones that don't change are marked as private. I also have a constant for the maximum number of uses of a harness.
Comment: 8, Yes all are private and the ones that change such as numUses is static and I do have a constant for max num of Uses.

Harness Class: Harness constructor 1 & constructor 2 (6 marks)
I initialize all the variables using the parameters given and set the other members to reasonable default values.
Comment: 6, Yes I did this.

Harness Class: checkHarness method (5 marks)
My method takes an instructor's name as a parameter, and if the harness is not on loan sets the instructor member variable to the given parameter value (assuming the instructor's name is not null/empty). It also resets the number of times the harness was used.
Comment: 5, Yes I used a static variable to set the instructor name to given parameter and reset the uses count.

Harness Class: isHarnessOnLoan method (2 marks)
My method has no parameters and returns the value of the loan status variable.
Comment: 2, my method has no parameters and returns a boolean.

Harness Class: canHarnessBeLoaned method (4 marks)
My method has no parameters and returns true if the harness is not on loan and if the number of times it was used is less than the maximum allowed number of times.
Comment: 4, method did this and would not loan out the harness if the number of uses was 25 or greater since its last safety check.

Harness Class: loanHarness method (6 marks)
My method has a member name as a parameter and it checks if harness can be loaned by using the canHarnessBeLoaned method. If true, it sets the club member value to the parameter value, sets the on loan status to true and increments the number of times used variable.
Comment: 6, yes my method does this exactly.
 
Harness Class: returnHarness method (5 marks)
My method has no parameters, checks if the harness is on loan, and if so, changes its on-loan status to false, and resets the club member value.
Comment: 5, Yes my method does this.

Harness Class: toString method (3 marks)
My method returns a String representation of all the member variables.
Comment: 5, Yes my method gives a summary or status of the harness and if it has been used 25 or more times then it instructs the user that a safety check must be conducted.

HarnessRecords Class: member variables (3 marks)
I declare the member variable as a private collection of Harnesses 
Comment: 3, I created an ArrayList of Harnesses.

HarnessRecords Class: HarnessRecords constructor 1 & 2 (9 marks)
In the first constructor, I set the member variable to null [1 mark]. In the second constructor, I use the set of characteristics in the list to create Harness objects and add them to the collection. 
Comment: 9, I didn't really understand what I was meant to pass in here but I passed in a 2D String ArrayList and then was able to parse out info and create Harness objects and add them to the collection of Harness objects.

HarnessRecords Class: isEmpty method (1 marks)
I return true if the collection is null/empty and, false otherwise.
Comment: 1, used .empty() operation for an arrayList.

HarnessRecords Class: addHarness method (5 marks)
My method takes a Harness object as a parameter and adds the harness to the collection.
Comment: 5, my method does this.

HarnessRecords Class: findHarness method (6 marks)
My method takes a make and model number as parameters. It checks if a harness with such properties exists and if it does it returns harness object, otherwise returns null.
Comment: 6, my method does this and returns null if no harness is found. I created a sameMakeAndModel method in the Harness class which I then used in this method.

HarnessRecords Class: checkHarness method (6 marks)
must take instructor name, make and model number as parameters and return a Harness. If a harness with the make and model number exists by using the findHarness method and is not on loan, the Harness method checkHarness is called with the instructor name as a parameter and the updated Harness object is returned. If the harness is not available returns null.
Comment: 6, my method does this exactly.

HarnessRecords Class: loanHarness method (7 marks)
My method takes a club member name as a parameter and looks for an available harness by calling the method canHarnessBeLoaned be loaned. If an available harness is found it is loaned by using the Harness method loanHarness with the club member as a parameter, returning the harness. If there's no available harness null is returned.
Comment: 7, my method returns a harness when one is found

HarnessRecords Class: returnHarness method (7 marks)
My method takes a make and model number as parameters. It checks if a harness with those properties exists by using the findHarness method. If the found harness is not null, it returns the harness object by using Harness method returnHarness, otherwise returns null.
Comment: 7, my method works.

HarnessRecords Class: removeHarness method (8 marks)
My method takes a make and model number as parameters and check the collection for a harness with those properties and removes it. It returns the harness object if it is found, otherwise returns null.
Comment: 8, My method removes from the harnessRecords array and returns a harness object if one matching the make and model num is found and this harness is not on loan otherwise it returns null and removes nothing

GUI (Java main line) (5 marks)
My test class has a menu which implements at least the five points specified using the HarnessRecords class methods.
Comment: 2, I can't get it to work because of out of bounds exceptions on my 2D arrayList, I know this is a big thing to mess up but I don't think there is much else wrong with it. I also gave up on error checking a bit. Also is it ok to use only one scanner here?

Total Marks: 98/100.
*/




public class HarnessUserInterface {

	
	// Could have used two array lists separately and then put one arrayList which holds the characteristics of a certain Harness into the first index of the second array.....
	
	public static void main(String[] args) {
		
		boolean inputFinished = false;
		boolean finished = false;
		int indexForArray = 0;
		List<List< String >> harCharact = new ArrayList<List< String >>( ); //Is this how to create a 2D arrayList??
		HarnessRecords records = null;
		do
		{
			String input = JOptionPane.showInputDialog( "Please enter in the make, model Number, number of Uses since last "
					+ "safety check, " + "\n" + "name of last Safety Checker, and enter in true or false as to whether the "
					+ "Harness is currently on Loan, and finally if it is on" + "\n" + "Loan please enter in the name of the"
					+ " club member who it is loaned to." + "\n" + "Please do this for each existing Harness the club owns one"
					+ " at a time." + "\n" + "Enter: 'finished' when you are finished entering "
					+ "all the existing details of the Clubs Harnesses. " + "\n" + 
					"Sample Input: 'PETZL 4567 10 OCONNELLJOHN TRUE SIMPSONJANE'" );
			Scanner inputScanner = new Scanner( input );
			if( inputScanner.hasNext( "finished" ) || inputScanner.hasNext( "Finished" ) )
			{
				inputFinished = true;
			}
			if( !inputFinished)
			{
				//harCharact.add( ).add( inputScanner.next());
				if( inputScanner.hasNext() )
				{
					harCharact.get(indexForArray).add( inputScanner.next() ); //make
				}
				harCharact.get(indexForArray).add( inputScanner.next() ); //model
				harCharact.get(indexForArray).add( inputScanner.next() ); //uses
				harCharact.get(indexForArray).add( inputScanner.next() ); //lastSafetyChecker
				harCharact.get(indexForArray).add( inputScanner.next() ); //onLoan?
				if( inputScanner.hasNext() )
				{
					harCharact.get(indexForArray).add( inputScanner.next() ); //if on Loan who is it loaned to?
				}
				indexForArray++;
				records = new HarnessRecords( harCharact );	
			}
		}while( !inputFinished );
		do
		{
			String input = JOptionPane.showInputDialog( "Please enter: " + "\n" + "'1' to add a newly purchased Harness to the system." 
					+ "\n" + "'2' to remove a unsafe, sold or lost Harness" + "\n" + "'3' to record safety"
					+ " Check of a Harness." + "\n" + "'4' to loan harness if one is available. " + "\n" 
					+ "'5' to return a Harness that has been loaned." + "\n" + "'6' to get a summary of the condition of a harness" 
					+ "\n" + "When you are finished please enter 'quit' or 'exit' to leave the program.");
			Scanner inputScanner = new Scanner( input );
			boolean correctInput = false;
			int operation = 0;
			if( inputScanner.hasNextInt() )
			{
				operation = inputScanner.nextInt();
				if( operation >= 1 && operation <= 5)
				{
					correctInput = true;
				}
			}
			else if( inputScanner.hasNext( "quit") || inputScanner.hasNext( "exit") )
			{
				finished = true;
			}
			if( !correctInput )
			{
				JOptionPane.showMessageDialog(null, "You have not entered in valid input." + "\n"
						+ "Please enter in only one operation at a time. " + "\n" +
						"Sample input: '3' (This will then allow you to record a safety check on a harness)"
						, "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			if( correctInput && !finished )
			{
				if( operation == 1) //add purchased Har
				{
					input = JOptionPane.showInputDialog( "To add the newly purchased Harnness," + "\n" +
							"Please enter in the make, model Number, " + "name of the last Club "
							+ "Instructor who safety checked the harness." + "\n" +
							"Please seperate each entry by a space. " + "\n" + 
							"Sample Input: 'PETZL 4567 OCONNELLJOHN");
					int count = 0;
					while( inputScanner.hasNext() && count < 3)
					{
						count++;
						harCharact.get(indexForArray).add( inputScanner.next());
					}
					while( count < 5)
					{
						harCharact.get(indexForArray).add( null );
					}
					records = new HarnessRecords( harCharact );	
				}
				if( operation == 2) //remove har
				{
					input = JOptionPane.showInputDialog( "To remove a Harness, please enter in the make and"
							+ " model Number seperated by spaces. " + "\n" + "Sample input: 'PETZL 4567'");
					String make = inputScanner.next();
					int modelNum = Integer.parseInt( inputScanner.next() );
					Harness temp = records.removeHarness(make, modelNum);
					if( temp == null)
					{
						JOptionPane.showMessageDialog(null, "No matching Harness could be found, please try again"
								, "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				if( operation == 3)
				{
					input = JOptionPane.showInputDialog( "To record a safety check please enter in the name of the"
							+ "\n" + " person who performed the safety check, the make and the model Number." + 
							"Sample input: 'OCONNELLJOHN PETZL 4567");
					String checker = inputScanner.next();
					String make = inputScanner.next();
					int modelNum = Integer.parseInt( inputScanner.next() );
					Harness temp = records.checkHarness(checker, make, modelNum);
					if( temp == null)
					{
						JOptionPane.showMessageDialog(null, "No matching Harness could be found, please try again"
								, "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				if( operation == 4) //loan
				{
					input = JOptionPane.showInputDialog( "To Loan a harness if one is available please enter in"
							+ " the Club memebers name who wishes to loan the harness." + "\n" + 
							"Sample Input: 'SimpsonJane");
					String clubMember = inputScanner.next();
					Harness temp = records.loanHarness( clubMember );
					if( temp == null)
					{
						JOptionPane.showMessageDialog(null, "No available Harness could be found"
								, "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				if( operation == 5) //return
				{
					input = JOptionPane.showInputDialog( "Please enter the make and model number to return a harness."
							+ "\n " + "Sample Input: 'PETZL 4567' ");
					String make = inputScanner.next();
					int modelNum = Integer.parseInt( inputScanner.next() );
					Harness temp = records.returnHarness(make, modelNum);
					if( temp == null)
					{
						JOptionPane.showMessageDialog(null, "No matching Harness could be found, please try again"
								, "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				if( operation == 6) //Summary of a condition of a harness
				{
					input = JOptionPane.showInputDialog( "Please enter in the make and model of the Harness you would like a summary of." + "\n" 
							+ "Sample input: 'PETZL 4567' ");
					String make = inputScanner.next();
					int modelNumber = inputScanner.nextInt();
					Harness temp = records.findHarness(make, modelNumber);
					JOptionPane.showMessageDialog(null, temp.toString() ); 
				}
				indexForArray ++;
			}
		}while( !finished );
		JOptionPane.showMessageDialog( null, "Goodbye");
	}

}
