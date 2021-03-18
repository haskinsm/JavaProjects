import java.util.*;

import javax.swing.JOptionPane;

// E-Test 3
public class Stack {
	
	public ArrayList < Integer > stack = new ArrayList< Integer >(); //should have been private
	
	public void push( int toAdd)
	{
		stack.add( toAdd );
	}
	public void pop( )
	{
		if( stack != null)  //should have also checked if the stack arrayList is empty: stack.isEmpty();
		{
			stack.remove( stack.size() - 1);
		}
		else
		{
			JOptionPane.showMessageDialog( null, "The book you have selected is currently out of stock.", 
				"ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	public int peek( )
	{
		if( stack != null && !stack.isEmpty())
		{
			return stack.get( stack.size() - 1);
		}
		return -1;
	}
	public int search( int toFind )
	{
		if( stack != null && !stack.isEmpty() )
		{
			int index = stack.indexOf( toFind );
			if( index != -1)
			{
				return ( stack.size() - (index + 1) ); //returns the position of the element from the top of the stack
			}
		}
		return -1;
	}
	public void move( int toMove )
	{
		int indexFromTop = search( toMove); //top  is considered the last element entered
		if( indexFromTop != -1)
		{
			int temp = peek();
			stack.remove( stack.size( ) - 1); //asked to move two items not remove one
			stack.add( toMove );
			stack.set( stack.size() - (indexFromTop + 1) , temp);
			
		}
	}
	public String toString()
	{
		String output = ( "Your remaining stack: ");
		for( int i : stack)
		{
			output += ( stack.get(i));
		}
		return output;
	}
}
