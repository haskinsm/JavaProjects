
import java.io.*;
import java.util.Scanner;

public class Write
{
    public static void toDocument(FileWriter writer) throws Exception
    {

        BufferedWriter buffer = new BufferedWriter(writer);  	
	    InputStreamReader r = new InputStreamReader(System.in);    
        BufferedReader br = new BufferedReader(r);   

        Scanner input = new Scanner(System.in);
	    System.out.print("Enter next word: ");
	
	    String word;
		while ((word = br.readLine()) != null && !(word.equals("done")))
		{ 
		    buffer.write(word);
		    buffer.write(" ");
		    System.out.print("Enter next word: ");
		}
		buffer.close();
	 }

    public static void main(String[] args) throws Exception
    {
    	FileWriter writer = new FileWriter(args[0]);  
        toDocument(writer);
    }
}