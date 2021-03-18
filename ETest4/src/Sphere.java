
public class Sphere extends Shape{

    private double radius;
    private double area;
   // private String name;
    
	public Sphere( String name, double radius)
	{
		super( name );
		this.radius = radius;
	}
	
	@Override
	public double area()
	{
		area = ( 4 * Math.PI * Math.pow(radius, 2) );
		return area;
	}
	
	@Override
	public String toString()
	{
		return( "A " + super.toString() +  " of radius " + radius + " has an area of " + area());
	}
}
