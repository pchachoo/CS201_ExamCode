
public class DailySales {
	/*Write a DailySales class to store a collection of a company's daily sales records for a single
month (up to 31 days). A day's sales are in integer units. Your class should do no input/output. You
do not have to worry about verifying the number of days actually in the month. Please code a class
with the following methods:
. DailySales() - default constructor
. DailySales (int daysInMonth) - constructor
. public boolean addSales(int dayNumber, int sales)  - add "sales" to the current sales for
"dayNumber". Return true of successful, else return false (if invalid sales amount or invalid
dayNumber)
. public int maxDay() - return the day number with the maximum sales
. public int[] daysBelowGoal() - return an array of day numbers that have less than 100 units
sold 
*/ 
//toString()?
	int SIZE=0;
	final int GOAL=100;
	DailySales()
	{
		SIZE=31;
//		CreateArray(SIZE);
	}
	DailySales (int daysInMonth)
	{
		SIZE=daysInMonth;
//		CreateArray(SIZE);
	}
	int DailySales[]= new int[SIZE];
/*	public void CreateArray(int size)
	{
		int DailySales[]= new int[size];
	} */
	
	public int[] getDailySales()
	{
		return DailySales;
	}
	
	public void setDailySales(int[] dsales)
	{
		if(dsales.length==SIZE)
		{
			for(int i=0; i<SIZE; i++)
			{
				DailySales[i]=dsales[i];
			}
		}
		else 
		{	int i;
			for(i=0; i<dsales.length; i++)
			{
				DailySales[i]=dsales[i];
			}
			for(i=dsales.length; i<SIZE; i++)
			{
				DailySales[i]=0;
			}
		}
	}
	public boolean addSales(int dayNumber, int sales)
	{
		if(sales>=0)
		{
			DailySales[dayNumber]=sales;
			return true;
		}
		else return false;
	}
	
	public int maxDay()
	{
		int Max_Sales=DailySales[0];
		int MaxSalesIndex=0;
		for(int i=1;i<SIZE;i++)
		{	if(DailySales[i]>Max_Sales)
			{
				Max_Sales=DailySales[i];
				MaxSalesIndex=i;
			}
		}
		return MaxSalesIndex;
	}
	
	public int[] daysBelowGoal()
	{
		int count=0;
		for(int i=0;i<SIZE;i++)
		{
			if(DailySales[i]<100)
				count++;
		}
		int Arr[]=new int[count];
		for(int i=0;i<SIZE;i++)
		{for(int j=0;j<count;j++)
			if(DailySales[i]<100)
				Arr[j]=DailySales[i];
		}
		return Arr;
	}

}
