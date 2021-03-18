
public class Rational {
	
	private int numerator;
	private int denominator;
	
	Rational()
	{
		numerator = 1;
		denominator = 1;
	}
	Rational( int n, int d)
	{
		numerator = n;
		denominator = d;
	}
	Rational( int singleNumber) //This is for integers like 3.
	{
		numerator = singleNumber;
		denominator = 1;
	}
	
	public Rational add( Rational b) //suppose to only take in one rational 
	{
		int newD = b.denominator * denominator;
		int newN = (b.numerator * denominator) + (numerator * b.denominator);
		Rational c = new Rational( newN, newD );
		c.simplify();
		return c;
	}
	
	public Rational subtract( Rational b)
	{
		int newD = b.denominator * denominator;
		int newN = (numerator * b.denominator) - (b.numerator * denominator);
		Rational c = new Rational( newN, newD );
		c.simplify();
		return c;
	}
	
	public Rational multiply( Rational b)
	{
		Rational c = new Rational( numerator * b.numerator, denominator * b.denominator );
		c.simplify();
		return c;
	}
	
	public Rational divide( Rational b) //invert second fraction and multiply
	{
		Rational c = new Rational( numerator * b.denominator, denominator * b.numerator );
		c.simplify();
		return c;
	}
	
	public boolean equals( Rational b)
	{
		if( numerator * b.denominator == denominator * b.numerator)
		{
			return true;
		}
		return false;
	}
	
	public boolean isLessThan( Rational b)
	{
		int numberOne = numerator * b.denominator;
		int numberTwo = denominator * b.numerator;
		if( numberOne < numberTwo )
		{
			return true; // Rational Number A is less than Rational Number B
		}
		return false;
	}
	
	public static int GCD( int numerator, int denominator)
	{
		int GCD = 1; //GCD is Greatest Common Divisor
		for(int index = 1; index <= denominator; index++)
		{
			if( (numerator % index) == 0 && 0 == (denominator % index) )
			{
				GCD = index;
			}
		}
		return GCD;
	}
	
	public void simplify( )
	{
		int GCD = GCD( numerator, denominator);
		numerator /= GCD;
		denominator /= GCD;
	}
	
	public String toString( )
	{
		if( numerator < 0 && denominator < 0)
		{
			numerator *= -1;
			denominator *= -1;
		}
		if( numerator > 0 && denominator < 0) // To get the minus on the numerator if numerator is pos & denominator is neg
		{
			numerator *= -1;
			denominator *= -1;
		}
		String outputString = numerator + ( (denominator == 1) ? "": "/" + denominator);
		return outputString;
	}
	
	public static void main(String[] args) {
		
	}

}
