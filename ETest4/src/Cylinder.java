
public class Cylinder extends Shape {

	private double radius;
	private double height;
	//private String shapeName;
	private double surfaceArea;
	
	public Cylinder( String shapeName ,double radius, double height)
	{
		super( shapeName );
		this.height = height;
		this.radius = radius;
	}
	
	@Override
	public double area()
	{
		surfaceArea = Math.PI * Math.pow( radius , 2 ) * height;
		return surfaceArea;
	}
	
	@Override
	public String toString()
	{
		return ( "A " +  super.toString() + " with radius " + radius + " and height " + height + " has a surface area of " + area() );
	}
}
