import javax.swing.JOptionPane;
import java.util.Scanner;

public class Tutorial9Vectors {

	public static void main(String[] args) {
		//Hard Coded attempt Works
		/*double[] array = {12, 5};
		double magnitudeOfVector = determineVectorMagnitude( array);
		System.out.println(magnitudeOfVector);
		String output = normaliseVector( array );
		System.out.println( output);
		double[] array2 = {3, 4};
		double dotProductOfTwoVectors = determineDotProductOfTwoVectors( array, array2 );
		System.out.println( dotProductOfTwoVectors);
		String newVector = combinedTwoVectors( array, array2);
		System.out.println(newVector);
		*/
		
		
		double[] array = null;
		double[] array2 = null;
		String input = JOptionPane.showInputDialog("Please enter a cordinate from a plane of"
				+ " your choice and seperate each x, y, z....etc entry by spaces");
		Scanner inputScanner = new Scanner( input);
		if( inputScanner.hasNextDouble())
		{
			do
			{
				double[] cordArray = new double[(array == null)?1:array.length+1];
				if(array!=null)
				{
					System.arraycopy(array, 0, cordArray, 0, array.length);
					array = cordArray;
				}
				cordArray[cordArray.length-1] = inputScanner.nextDouble();
				
			}while( inputScanner.hasNextDouble());
		}	
		String input2 = JOptionPane.showInputDialog("Please enter a cordinate from a plane of"
				+ " your choice and seperate each x, y, z....etc entry by spaces");
		Scanner input3 = new Scanner( input2);
		do
		{
			double[] cordArray = new double[(array2 == null)?1:array2.length+1];
			if(array!=null)
			{
				System.arraycopy(array2, 0, cordArray, 0, array2.length);
				array2 = cordArray;
			}
			cordArray[cordArray.length-1] = input3.nextDouble();
			
		}while( input3.hasNextDouble());
		double magnitudeOfVector = determineVectorMagnitude( array);
		System.out.println(magnitudeOfVector);
		String output2 = normaliseVector( array );
		System.out.println( output2);
		System.out.println(determineDotProductOfTwoVectors(array, array2));
		System.out.println(combinedTwoVectors( array, array2));
		
	}

	public static final double determineVectorMagnitude(double[] cordArray )
	{
		double sumOfPlanePowers = 0;
		for( int index = 0; index < cordArray.length ; index++)
		{
			double numberPlane = Math.pow(cordArray[index], 2);
			sumOfPlanePowers += numberPlane;
		}
		double magnitudeOfVector = Math.pow(sumOfPlanePowers, 0.5);
		return (magnitudeOfVector);
	}
	public static final String normaliseVector(double[] cordArray)
	{
		String outputString = "";
		double normalizedPoint = 0;
		for( int index = 0; index < cordArray.length ; index++)
		{
	      double planePoint = cordArray[index];
	      normalizedPoint = planePoint / determineVectorMagnitude( cordArray);
	      outputString += normalizedPoint + ", ";
		}
		return (outputString);
	}
	public static final double determineDotProductOfTwoVectors(double[] cordArray1, double[] cordArray2)
	{
		double dotProduct = 0;
		for(int index = 0 ; (index < cordArray1.length) && (index < cordArray2.length); index ++)
		{
			double productOfPlane = cordArray1[index] * cordArray2[index];
			dotProduct += productOfPlane;
		}
		return (dotProduct);
	}
	public static final String combinedTwoVectors( double[] cordArray1 , double[] cordArray2)
	{
		String outputString = "(";
		for( int index = 0; (index < cordArray1.length) && (index < cordArray2.length); index++)
		{
			double newVector = cordArray1[index] + cordArray2[index];
			outputString += newVector + ", ";
		}
		outputString += ")";
		return (outputString);
	}


}
