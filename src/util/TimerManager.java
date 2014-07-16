package util;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


//this class defines a timer ,we run feature extraction every certain time(in ms)
public class TimerManager {

	  public Timer timer = new Timer();
	  
	  public  void start() {  
	  timer.schedule(new RemindTask(), 0, 200); 
	  }

	  public  void stop(){
	         timer.cancel();
	  }
	  
	  public  class RemindTask extends TimerTask {
	    	  
	           public void run() {
	        	   //TODO add code to do feature extraction
	           System.out.println(new Date());
	           }
	  }


}
