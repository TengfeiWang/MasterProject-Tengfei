package util;

import java.util.Timer;
import java.util.TimerTask;

import util.TimerManager.RemindTask;

import dataCollection.DataRecording;

public class CountingDown {
	
	private DataRecording dataRecording;
	private int clock;
	public Timer timer = new Timer();
	public boolean flag ;
	
	private  TimerManager task;
	
	
	public CountingDown(DataRecording dataRecording){
		
		this.dataRecording = dataRecording;
		clock = 5;
		flag = false;
		
	}
	
	  public  void start() {  
	  timer.schedule(new CountdownClock(), 0, 1000); 
	  }

	  public  void stop(){
		    task = new TimerManager(dataRecording.controller,dataRecording.OS);
			task.start();
			while(dataRecording.OS.flag ==false){
				
			}
			dataRecording.dispose();
		    flag = true;
	        timer.cancel();
		  
	  }
	
	public  class CountdownClock extends TimerTask {
  	  
        public void run() {
        	
        	dataRecording.jTextField1.setText(String.valueOf(clock));
        	clock--;
        	if(clock<0){
        		stop();
        	}
        }
	}

}
