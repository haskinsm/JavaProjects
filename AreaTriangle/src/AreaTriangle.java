import java.lang.Math;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class AreaTriangle {

	public static void main(String[] args) {
		
		String input= JOptionPane.showInputDialog("Enter the coordinates of the vertices of a triangle, with each x and y \n"
				+ "coordinate seperated by spaces()");
		
		Scanner inputScanner= new Scanner( input );
		
		double x1= inputScanner.nextDouble();
		double y1= inputScanner.nextDouble();
		double x2= inputScanner.nextDouble();
		double y2= inputScanner.nextDouble();
		double x3= inputScanner.nextDouble();
		double y3= inputScanner.nextDouble();
		inputScanner.close();
		
		double area= ((x1*(y2-y3)+ x2*(y3-y1)+ x3*(y1-y2))/2);
		area = Math.abs(area);
		System.out.println("Area of entered triangle is " + area + " units squared");
		
	/*
	 * Instead of using absolute function can be done:
	 * if(area <0)
	 *	{
			double areaPositive= area*-1;
			System.out.println("Area of entered triangle is " + areaPositive + " units squared");
		}
		else
		{
			System.out.println("Area of entered triangle is " + area + " units squared");
	 *	}
	 */
	}

}
