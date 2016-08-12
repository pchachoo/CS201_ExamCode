public class WeatherAccuracy {
    int Size=10;
    int count=0;
    WeatherDay[] WeatherDayArray= new WeatherDay[10];
    public WeatherAccuracy()
    {
        Size=10;
    }
   
    public boolean addData(WeatherDay newDay)
    {    if(newDay!=null)
        {    WeatherDay wd;
            if(count<Size)
            {
                if(newDay.setDay(newDay.getDay())==true)
                {
                wd= new WeatherDay(newDay.getDay(), newDay.getpredictedTemp2(), newDay.getpredictedTemp1(), newDay.getactualTemp());
                WeatherDayArray[count]=wd.clone();
                count++;
                return true;
                }
            }
        }
        return false;
    }
   
    public Date worstPrediction()
    {
        WeatherDay wdMaxError= WeatherDayArray[0];       
        for(int i=1; i<Size; i++)
        {
            if((Math.abs(WeatherDayArray[i].getError1())+Math.abs(WeatherDayArray[i].getError2()))>(Math.abs(wdMaxError.getError1())+Math.abs(wdMaxError.getError2())))
                {    wdMaxError=WeatherDayArray[i];
                }
        }
        return wdMaxError.getDay();
    }

    public int mostCommonActualTemp(int[] commonTemp)
    // returns in an array all temperatures that occur max number of times
    //(there may be more than one temperatures that occur same number of times)
        {//size of commonTemp should be Size/2 (5 in this case)
            int commonTempcount[] = new int[Size];
            int flag=-1; //invalid return implies no two temperatures are same
            for(int i=0; i<Size; i++)
            {for(int j=i+1; j<Size; j++) //eliminates chances of duplicates
                {    if(WeatherDayArray[i].getactualTemp()==WeatherDayArray[j].getactualTemp())
                        {commonTempcount[i]++; flag=0;}
                }
            }
            if(flag==-1)
                return -1; //invalid return implies no two temperatures are same
            int maxTempCount=commonTempcount[0];

            int maxTempIndex=0;
            for(int i=1; i<Size; i++)
            {if(commonTempcount[i]>maxTempCount)
                {    maxTempCount=commonTempcount[i];
                     maxTempIndex=i;
                     commonTemp[0]=WeatherDayArray[maxTempIndex].getactualTemp();
                }
            }
           
            //to find if any more temperatures appear same number of times as maxTempCount
            int index=0;
            for(int i=maxTempIndex; i<Size; i++)// i starts from maxTempIndex to prevent duplication
            //maxTempIndex stores first occurrence of max count of temperature
            {
                {    if(commonTempcount[i]==maxTempCount)
                        {commonTemp[index]=WeatherDayArray[i].getactualTemp(); index++;}
                }
            }
           
            return 1; //success
            //common temp is returned in argument passed
        }
   
    public String toString()
    {
        String display="";
        for(int i=0; i<Size; i++)
            display=display+(i+1)+". "+WeatherDayArray[i]+"\n\n";
        return display;
    }


}

/********************Test_Class_for_WeatherAccuracy******************/
public class WeatherApp {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Date d1= new Date();
        Date d2= new Date(5, 15, 2010);
        Date d3= new Date(5, 25, 2010);
        int common[] = new int[5];
        WeatherDay wd1= new WeatherDay(d1, 28, 25, 10);
        WeatherDay wd2= new WeatherDay(d2, 28, 20, 10);
        WeatherDay wd3= new WeatherDay(new Date(4, 7, 2010), 32, 33, 20);
        WeatherDay wd4= wd3.clone();
        WeatherDay wd5= new WeatherDay(new Date(6, 5, 2010), 32, 33, 30);
        WeatherDay wd6= new WeatherDay(new Date(7, 5, 2010), 32, 33, 30);
        WeatherDay wd7= new WeatherDay(new Date(8, 5, 2010), 32, 33, 30);
        WeatherDay wd8= new WeatherDay(new Date(9, 5, 2010), 32, 33, 40);
        WeatherDay wd9= new WeatherDay(new Date(10, 5, 2010), 32, 33, 50);
        WeatherDay wd10= new WeatherDay(d3, 32, 33, 10);
        WeatherAccuracy WA= new WeatherAccuracy();
        WA.addData(wd1);
        WA.addData(wd2);
        WA.addData(wd3);
        WA.addData(wd4);
        WA.addData(wd5);
        WA.addData(wd10);
        WA.addData(wd7);
        WA.addData(wd8);
        WA.addData(wd9);
        WA.addData(wd6);
        System.out.println(WA);
        System.out.println("Worst prediction:"+WA.worstPrediction());
        System.out.println("Most Common temperatures : ");
        WA.mostCommonActualTemp(common);
        for(int i=0; i<common.length; i++)
        {if(common[i]!=0)
            System.out.println(common[i]);
        }
    }

}
