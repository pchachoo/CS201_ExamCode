/*Write a class WeatherDay.java which keeps track of a day (Date), two predicted temperatures 
 * (each int) and an actual temperature (int). One prediction was made 2 days before the "day", the other
prediction was made 1 day before the "day". You will need standard constructors, get*, set* and
toString methods. You also need methods to calculate and return the error in each prediction, and to
clone WeatherDay objects. Also, the WeatherDay class has a couple public class constants, the range
of temperatures allowed (HIGH_TEMP=120, LOW_TEMP=-20).   IN THE INTEREST OF TIME YOU ONLY NEED WRITE
CODE FOR ALL ATTRIBUTES, CLASS CONSTANTS AND THESE METHODS AND ASSUME THE OTHERS ARE SIMILAR

public WeatherDay (Date newDay, int p2, int p1, int a)  // Non- default constructor
public boolean setDay(Date newDay) 
public boolean setPredict2(int p2)  // set the two day prior prediction
public int getError2()// get the two day prior prediction error
public WeatherDay clone()
*/
public class WeatherDay {
	Date day =  new Date();
	int predictedTemp1;
	int predictedTemp2;
	int actualTemp;
	static final int HIGH_TEMP=120, LOW_TEMP=-20;
	public WeatherDay (Date newDay, int p2, int p1, int a)
	{// Non- default constructor
		setDay(newDay);
		setPredictedTemp1(p1);
		setPredictedTemp2(p2);
		setactualTemp(a);
	}
	public boolean setDay(Date newDay) //setDate might need to be changed to return boolean
	{
		if(day.setDate(newDay.getMonth(), newDay.getDay(), newDay.getYear())==true)
			return true;
		else return false;
	}
	public boolean setPredictedTemp1(int ptemp1)
	{if((ptemp1<=HIGH_TEMP)&&(ptemp1>=LOW_TEMP))
		{predictedTemp1=ptemp1;
		return true;}
	else return false;
	}
	public boolean setPredictedTemp2(int ptemp2)
	{if((ptemp2<=HIGH_TEMP)&&(ptemp2>=LOW_TEMP))
		{predictedTemp2=ptemp2;
		return true;}
	else return false;
	}
	public boolean setactualTemp(int atemp)
	{if((atemp<=HIGH_TEMP)&&(atemp>=LOW_TEMP))
		{actualTemp=atemp; return true;}
	else return false;
	}
	public Date getDay()
	{return day;}
	public int getpredictedTemp2()
	{return predictedTemp2;}
	public int getpredictedTemp1()
	{return predictedTemp1;}
	public int getactualTemp()
	{return actualTemp;	}

	public int getError2()
	{
		return actualTemp-predictedTemp2;
		// get the two day prior prediction error
	}
	public Object clone()
	{
		return new WeatherDay(this.day, this.predictedTemp2, this.predictedTemp1, this.actualTemp);
	}
	public String toString()
	{
		return "Date: "+day+"\nActual Temperature= "+actualTemp+
		"\nPredicted Temperature 1= "+predictedTemp1+"\nPredicted Temperature 2= "+predictedTemp2;	
	}
		

}
