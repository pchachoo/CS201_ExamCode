public class Date
{
  private int month;
  private int day;
  private int year;

  public Date( )
  {
    setDate( 1, 1, 2000 );
  }

  public Date( int mm, int dd, int yyyy )
  {
    setDate( mm, dd, yyyy );
  }
  
  public Date(int mm, int yyyy)
  {
	  setDate(mm, 1, yyyy);
  }

  /* accessor methods */
  int getMonth( ) { return month; }
  int getDay( )   { return day; }
  int getYear( )  { return year; }

  public boolean setMonth( int mm )
  {if( mm >= 1 && mm <= 12 )
  	{ month = mm;
  	return true;}

  	else {mm=1;
  	return false;}
  }

  public boolean setDay( int dd )
  {
	  int [] validDays = { 0,  31, 29, 31, 30,
			  31, 30, 31, 31, 30,
			  31, 30, 31 };
	  if(( dd >= 1 && dd <= validDays[month]))
	  {day = dd;
	  return true;}
	  else 
	  {day= 1;
	  return false;}
  }

  public boolean setYear( int yyyy )
  {	if(yyyy>0&&yyyy<9999)
  {year = yyyy;
  return true;}
  else {year=2000;
  return false;}
  }

  public boolean setDate( int mm, int dd, int yyyy )
  {
/*    setYear(yyyy);
    setMonth( mm );
    setDay( dd );*/
    if(setYear(yyyy)==true && setMonth( mm )==true && setDay( dd ))
    	return true;
    else return false;
  }

  /** toString
  *  @return String
  *  returns date in mm/dd/yyyy format
  */
  public String toString( )
  {
    return month + "/" + day + "/" + year;
  }

  public boolean equals( Date d )
  {
    if ( month == d.month
         && day == d.day
         && year == d.year )
      return true;
    else
      return false;
  }
  public int daysLeftInMonth(int mm, int dd)
  {
	 int [] Days_count = { 0,  31, 29, 31, 30,
             31, 30, 31, 31, 30,
             31, 30, 31 };
	 return Days_count[mm]-dd;	
  }

}


