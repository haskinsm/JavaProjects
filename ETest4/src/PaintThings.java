
public class PaintThings {

	public static void main(String[] args) {
	

		Shape deck = new Rectangle( "Rectangle called deck" , 20.0, 35.0 ); 
		Shape bigBall = new Sphere( "Sphere called BigBall", 15.0 );
		Shape tank = new Cylinder( "Cylinder called tank", 10.0, 30.0);
		Paint a = new Paint( 2.0 ); //Assumed to be 2
		System.out.println( a.amountOfPaint( deck ) + "\n" );
		System.out.println( a.amountOfPaint( bigBall ) + "\n");
		System.out.println( a.amountOfPaint( tank ) + "\n" );
	}

}
