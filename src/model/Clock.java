package model;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Clock {
	
	public static final String[] monthList = new String[] {"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER",
			"OCTOBER","NOVEMBER","DECEMBER"};
	
	
	public static int getDayofDate(Date date){
		Calendar temp =Calendar.getInstance();
		temp.setTime(date);
		return temp.get(Calendar.DAY_OF_MONTH); 
	}
	
	public static String getMonthofDate(Date date){
		Calendar temp =Calendar.getInstance();
		temp.setTime(date);
		return monthList[temp.get(Calendar.MONTH)]; 
	}
	public static int getHours(){
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}
	
	public static int getHours(Date date){
		Calendar temp =Calendar.getInstance();
		temp.setTime(date);
		return temp.get(Calendar.HOUR_OF_DAY);	
	}

	public static int getMinutes(){
		return Calendar.getInstance().get(Calendar.MINUTE);
	}
	
	public static int getMinutes(Date date){
		Calendar temp =Calendar.getInstance();
		temp.setTime(date);
		return temp.get(Calendar.MINUTE);
	}
	
	public static int getYear(Date date){
		Calendar temp =Calendar.getInstance();
		temp.setTime(date);
		return temp.get(Calendar.YEAR);
	}

	
	public static int getSeconds(){
		return Calendar.getInstance().get(Calendar.SECOND);
	}
	
	/**
	 * Return hours,minutes,seconds from now until given date.
	 * @param date
	 * @return
	 */
	public static int[] getTimeTo(Date date){
		Calendar timeInterval= Calendar.getInstance();
		timeInterval.setTimeInMillis(date.getTime()-Calendar.getInstance().getTimeInMillis());
		return new int[] {timeInterval.get(Calendar.HOUR_OF_DAY)-1,timeInterval.get(Calendar.MINUTE),timeInterval.get(Calendar.SECOND)};
	}

	public static Date toDate(int beginHour, int beginMinute) {
		Calendar temp = Calendar.getInstance();
		temp.set(Calendar.HOUR_OF_DAY, beginHour);
		temp.set(Calendar.MINUTE, beginMinute);
		temp.set(Calendar.SECOND,0);
		return temp.getTime();
	}

	public static String getCurrentTime() {
		return Calendar.getInstance().getTime().toString();
	}
	
	public static boolean isToday(Date date){
		Calendar temp = Calendar.getInstance();
		temp.set(Calendar.HOUR_OF_DAY, 0);
		temp.set(Calendar.MINUTE, 0);
		temp.set(Calendar.SECOND, 0);
		Date hourCheck = temp.getTime();
		if(date.before(hourCheck))
			return false;
		temp.set(Calendar.HOUR_OF_DAY, 23);
		temp.set(Calendar.MINUTE, 59);
		temp.set(Calendar.SECOND, 59);
		hourCheck = temp.getTime();
		if(hourCheck.before(date))
			return false;
		return true;
	}

	private static Date incrementDate(Date date){
		Calendar result = Calendar.getInstance();
		result.setTime(date);
		result.add(Calendar.MINUTE, 1);
		return result.getTime();
	}
	
	public static boolean areAlmostEqual(Date date1, Date date2){
		if(date1.equals(date2))
			return true;
		return (!date1.before(date2) && date1.before(incrementDate(date2)))
				||(!date2.before(date1) && date2.before(incrementDate(date1)));
	}

	public static Date getDateFromExcel(Date date) {
		Calendar dateCal =Calendar.getInstance();
		dateCal.setTime(date);
		Calendar temp = Calendar.getInstance();
		temp.set(Calendar.HOUR_OF_DAY, dateCal.get(Calendar.HOUR_OF_DAY));
		temp.set(Calendar.MINUTE, dateCal.get(Calendar.MINUTE));
		temp.set(Calendar.SECOND, 0);
		return temp.getTime();
	}
	
	public static String getHourStringFromDate(Date date){
		Calendar temp = Calendar.getInstance();
		temp.setTime(date);
		return temp.get(Calendar.HOUR_OF_DAY)%100/10+""+temp.get(Calendar.HOUR_OF_DAY)%10+":"+
		temp.get(Calendar.MINUTE)%100/10+""+temp.get(Calendar.MINUTE)%10;
	}

	public static boolean sameDay(Date date1, Date date2){
		Calendar firstDate = Calendar.getInstance();
		firstDate.setTime(date1);
		firstDate.set(Calendar.HOUR_OF_DAY, 0);
		firstDate.set(Calendar.MINUTE, 0);
		firstDate.set(Calendar.SECOND, 1);
		if( date2.before(firstDate.getTime()))
			return false;
		firstDate.set(Calendar.HOUR_OF_DAY, 23);
		firstDate.set(Calendar.MINUTE, 59);
		firstDate.set(Calendar.SECOND, 59);
		if( date2.after(firstDate.getTime()))
			return false;
		return true;
	}

	public static String getHourStringBetween(Date start, Date end) {
		Date result = new Date(end.getTime()-start.getTime()-3600000);
		return getHourStringFromDate(result);
	}
	
	public static int getHoursFromHourString(String hourString){
		return Integer.parseInt(hourString.substring(0,1))*10+Integer.parseInt(hourString.substring(1,2));
	}
	
	public static int getMinutesFromHourString(String hourString){
		return Integer.parseInt(hourString.substring(3,4))*10+Integer.parseInt(hourString.substring(4,5));
	}
	
	public static boolean isHourStringSmallerThan(String hourString, int hours, int minutes){
		if(getHoursFromHourString(hourString)<hours){
			return true;
		}
		if(getHoursFromHourString(hourString)==hours&&getMinutesFromHourString(hourString)<minutes){
			return true;
		}
		return false;
	}

	
	public static ArrayList<Date> getDatesFromTo(Date begin, Date end, int intervalMinutes){
		ArrayList<Date> result = new ArrayList<>();
		final long nbODates = (end.getTime()-begin.getTime())/60000/intervalMinutes;
		Calendar temp = Calendar.getInstance();
		temp.setTime(begin);
		for(int i=0; i < nbODates+1;i++){
			result.add(temp.getTime());
			temp.add(Calendar.MINUTE, intervalMinutes);
		}
		return result;
	}
	
	/**
	 * Returns true if hourString1 is smaller than hourString2
	 */
	public static boolean isHourStringSmaller(String hourString1, String hourString2){
		for(int i=0;i<5;i++){
			if(i==2)
				continue;
			if(Integer.parseInt(hourString1.substring(i,i+1))<Integer.parseInt(hourString2.substring(i,i+1)))
				return true;
		}
		return false;
	}
}
