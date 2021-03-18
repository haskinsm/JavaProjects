
public class Paint {
	
	private double coverage;
	private double amountOfPaint;

	public Paint( double coverage )
	{
		this.coverage = coverage;
	}
	
	public String amountOfPaint( Shape a)
	{
		if( coverage != 0)
		{
			amountOfPaint = a.area() / coverage;
		}
		return ( a.toString() + "\n" + "Amount of Paint required with a coverage of " + coverage + " is " + amountOfPaint);
	}
}
