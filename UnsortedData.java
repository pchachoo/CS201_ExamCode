/*Write a class, UnsortedData, that has two public static methods:
. A method "countOutOfPosition" that takes as argument an array of doubles, and returns a
count of how far  out of position all the items are. Do this by summing up (for each item "i" in the
array) how many items after item "i" in the unsorted list are smaller than item "i".
. A method "bubble"that takes as parameter and array of doubles, and performs the following
operation once on every item in the unsorted list: If an item is larger than the item after it, swap
the items. 
Write a UnsortedDataApp program, that prompts the user for a name of an input file, then reads 100
real numbers from the file. You can assume the file exists, and contains 100 valid real numbers.
Then call 
"countOutOfPosition" and display the result. Then call "bubble" and your first function again and
see if there items are not as far "out of position" as before.
*/
public class UnsortedData {

	public static int countOutOfPosition(double[] d1)
	{
		int count=0;
		for(int index=0; index<d1.length; index++)
		{
			for(int i=index+1; i<d1.length; i++)
			{
				if(d1[index]>d1[i])
					count++;
			}
		}
		return count;
	}
	
	public static void bubble(double[] d1)
	{
		double temp=0.0;
		for(int index=0; index<d1.length-1; index++)
			{
			if(d1[index]>d1[index+1])
			{
			temp=d1[index];
			d1[index]=d1[index+1];
			d1[index+1]=temp;
			}
		}
	}
}

