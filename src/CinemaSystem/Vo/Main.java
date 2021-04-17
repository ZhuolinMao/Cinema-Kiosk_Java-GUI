package CinemaSystem.Vo;
/**
 * 
 * @author Group 73
 * @version 3.0
 */
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import userInterface.Welcome_UI;

public class Main {
    public static void main(String[] args0){
    	Welcome_UI start = new Welcome_UI();
    	start.welcome();
    	new Main();
    }
    	private static final long PERIOD_DAY = 24*60*60*1000;
    	public Main(){
    		Calendar calender = Calendar.getInstance();
    		calender.set(Calendar.HOUR_OF_DAY, 23);
    		calender.set(Calendar.MINUTE, 59);
    		calender.set(Calendar.SECOND, 59);
    		Date date = calender.getTime();
    		if(date.before(new Date())){
    			date = this.addDay(date,1);
    		}
    		Timer timer = new Timer();
    		Report report = new Report();
    		timer.schedule(report, date, PERIOD_DAY);
    		}
    	/**
    	 * 
    	 * @param date, the date of the system right now
    	 * @param num, add 1 day to execute if the time right now is after 0:00
    	 * @return Date, the date of the timer been executed
    	 */
    	 public Date addDay(Date date, int num) {  
    	        Calendar startDT = Calendar.getInstance();  
    	        startDT.setTime(date);  
    	        startDT.add(Calendar.DAY_OF_MONTH, num);  
    	        return startDT.getTime();  
    	    }  
}

