
public class Rectangle extends Shape{

	private double length;
	private double width;
	//private String shapeName;
	private double area;
	
	public Rectangle( String shapeName, double length, double width)
	{
		super( shapeName );
		this.length = length;
		this.width = width;
	}
	
	@Override
	public double area()
	{
		area = length * width;
		return area;
	}
	@Override 
	public String toString()
	{
		return ( "A " + super.toString() + " of width " + width + " and length " + length + " has an area of " + area() );
	}
}
