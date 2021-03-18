
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class OnlineBookStore {
	public static int ISBN_INDEX = 0;
	public static int TITLE_INDEX = 1;
	public static int AUTHOR_INDEX = 2;
	public static int PUBLISHER_INDEX = 3;
	public static int PUBLISHER_YEAR_INDEX = 4;
	public static int QUANTITY_INDEX = 5;
	public static int PRICE_INDEX = 6;
	
	public static void printBookDetails( ArrayList < Book > booklist)
	{
		int count = 1;
		for( int i = 0; i < booklist.size(); i++)
		{
			Book a = booklist.get( i );
			System.out.println( "Book " + count + ":");
			System.out.print( "ISNB: " + a.getIsbn());
			System.out.print( " Title: " + a.getTitle());
			System.out.print( " Author: " + a.getAuthor());
			System.out.print( " Publisher: " + a.getPublisher());
			System.out.print( " Published in: " + a.getPublishYear());
			System.out.print( " Quantity: " + a.getQuantity());
			System.out.print( " Price of book: " + a.getPrice());
			System.out.println("");
			count ++;  //Should have just done System.out.println( a.toString() )
		}
	}
	public static Book getBook( ArrayList<Book> booklist, String title)
	{
		if( booklist != null)
		{
			/*
			for( int i = 0; i < booklist.size(); i++)
			{
				Book a = booklist.get( i ); 
				if( title == a.getTitle() )  //Wouldn't work
				{
					return a;
				}
			}
			*/
			for( Book a: booklist)
			{
				if( a.getTitle().equalsIgnoreCase( title) ) //Would not work any other way
				{
					return a;
				}
			}
		}
		return null;
	}
	public static void topUpCard( ChargeCard Card, double amount)
	{
		if( amount > 0)
		{
			Card.topUpFunds( amount );
		}
	}
	public static void purchaseBook( ArrayList< Book > bookList)
	{
		boolean correctInput = false;
		ChargeCard userCard = new ChargeCard();
		do
		{
			String input = JOptionPane.showInputDialog( "Please enter in the amount you would like to"
					+ " top up your charge card by. E.g: '€65.00'");
			Scanner inputScanner = new Scanner( input );
			if( inputScanner.hasNextDouble())
			{
				double amount = inputScanner.nextDouble();
				if( amount > 0)
				{
					topUpCard( userCard, amount);
					correctInput = true;
				}
				else
				{
					errorOutput();
				}
			}
			else
			{
				errorOutput();
			}
		}while( !correctInput );
		boolean finished = false;
		do
		{
			String input2 = JOptionPane.showInputDialog( "Please enter in the name of the book you would like to buy." +
					"\n" + "You have a current balance of €" + userCard.getFunds() + " on your charge card." );
			Scanner inputScanner2 = new Scanner( input2 );
			String bookTitle = "";
			while( inputScanner2.hasNext())
			{
				bookTitle += inputScanner2.next();
				if( inputScanner2.hasNext())
				{
					bookTitle += " ";
				}
			}
	        if( bookTitle != "")
	        {
				Book a = getBook(bookList, bookTitle);
				if( a == null)
				{
					titleNotFound( bookList );
				}
				else if( a.getQuantity() == 0)
				{
					JOptionPane.showMessageDialog( null, "The book you have selected is currently out of stock.", 
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String input3 = JOptionPane.showInputDialog( "You have selected " + a.getTitle() + " this book costs €" + a.getPrice() + "\n" +
							"Enter 'yes' if you would like to purchase this book");
					Scanner inputScanner3 = new Scanner( input3 );
					if( inputScanner3.hasNext( "yes" ))
					{
						if( a.getPrice() <= userCard.getFunds())
					    {
							a.setQuantity( a.getQuantity() - 1 );
							userCard.removeFunds( a.getPrice() );
							JOptionPane.showMessageDialog( null, "Thank you. You have successfully bought the book " + a.getTitle());			
						}
						else
						{
							JOptionPane.showMessageDialog( null, "Insufficient funds on your charge card! "+ "\nYou have €" + userCard.getFunds() + " remaining.", 
									"ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				int answer = JOptionPane.showConfirmDialog(null, "Would you like to exit the program?"); 
				finished = ( answer == JOptionPane.YES_OPTION);
			}
		}while( !finished );
	}
	public static void errorOutput()
	{
		JOptionPane.showMessageDialog( null, "You have not entered in valid input, please try again sample input: '20.00'", 
				"ERROR", JOptionPane.ERROR_MESSAGE);
	}
	public static void titleNotFound( ArrayList< Book > booklist)
	{
		JOptionPane.showMessageDialog( null, "The book title you have entered is not in stock, please try again sample input: "
				+ "'Java By Dissection'", "ERROR", JOptionPane.ERROR_MESSAGE);
		printBookDetails( booklist );
	}
	
	public static void main(String[] args) {
		ArrayList<Book> bookList = new ArrayList<Book>();
		try {                                                                  // need to add the two dashes here, copy and pasted from file folder top bar beside the search bar
			FileReader fileReader = new FileReader("C:\\Users\\micha\\Downloads\\books.txt");// Enter the entire path of the file if needed
			BufferedReader bufferedReader = new BufferedReader(fileReader);  // normally would just download and drag and drop into the project src in the project explorer tab
			boolean endOfFile = false;
	        while(!endOfFile){
	        	String bookLine = bufferedReader.readLine();
	        	if (bookLine != null) {
	        		String[] bookData = bookLine.split(", ");
	        		String isbn = bookData[ISBN_INDEX];
	        		String title = bookData[TITLE_INDEX];
	        		String author = bookData[AUTHOR_INDEX];
	        		String publisher = bookData[PUBLISHER_INDEX];
	        		int publishYear = Integer.parseInt (bookData[PUBLISHER_YEAR_INDEX]);
	        		int quantity = Integer.parseInt (bookData[QUANTITY_INDEX]);
	        		double price = Double.parseDouble (bookData[PRICE_INDEX]);
	        		Book book = new Book(isbn, title, author, publisher, publishYear, quantity, price);
	        		bookList.add(book);

	        	} else {
	        		endOfFile = true;
	        	}
	        }
	        
	        bufferedReader.close();    
	        fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		printBookDetails(bookList);
		purchaseBook(bookList);
	}
}