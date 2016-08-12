import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class UnsortedDataApp {

	/**
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input= new Scanner(System.in);
		System.out.println("What is the name of the input file? ");
		String fileName=input.next();
		double[] doubleArray= new double[100];
		File inFile= new File (fileName);
		Scanner fileinput= new Scanner(inFile);
		for(int i=0; i<100; i++)
		{
			double temp= fileinput.nextDouble();
			doubleArray[i]=temp;
		}
		
		System.out.println("Total Out of Order BEFORE Bubble: " + UnsortedData.countOutOfPosition(doubleArray));
		UnsortedData.bubble(doubleArray);
		System.out.println("Total Out of Order BEFORE Bubble: " + UnsortedData.countOutOfPosition(doubleArray));

	}

}
