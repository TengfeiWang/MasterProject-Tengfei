package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import be.ac.ulg.montefiore.run.jahmm.ObservationVector;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Hand;

import featureExtraction.FeatureExtractor;
import util.HandDetector;


//this class defines a timer ,we run feature extraction every certain time(in ms)
public class TimerManager {

	  public Timer timer = new Timer();
	  private Controller subController;
	  private ObservationVector observationVector;
	 // public  List<ObservationVector> observationSequence = null;
	  public ObservationSequence OS;
	  private double currentHandParameterSum;
	  private double previousHandParameterSum;
	  private long startTime; 
     
	  
      public TimerManager(Controller controller,ObservationSequence OS){
    	  subController = controller;
    	  this.OS = OS;
    	  currentHandParameterSum = 0.0;
    	  previousHandParameterSum = 0.0;
    	  startTime=System.currentTimeMillis();
    	 // observationSequence = new ArrayList<ObservationVector>();
    	  
      }
	  
	  public  void start() {  
	  timer.schedule(new RemindTask(), 0, 100); 
	  }

	  public  void stop(){
	         timer.cancel();
		  
	  }
	  
	  
	  public  class RemindTask extends TimerTask {
	    	  
	           public void run() {
	      
	        	   FeatureExtractor fe =new FeatureExtractor(subController);	        	 
	 	   		   double[] featureVector =  fe.getFeatureVector();
	 	   		   Hand currentHand = fe.getHandObject();
	 	   		   currentHandParameterSum = new HandDetector().sumOfDistance(currentHand);
		           observationVector = new ObservationVector(featureVector);
		           System.out.println(observationVector);
		           if(currentHandParameterSum !=0.0 && previousHandParameterSum != 0.0){
		               System.out.println(Math.abs(currentHandParameterSum-previousHandParameterSum)+"........has already run"+(System.currentTimeMillis()-startTime));
		   	           if(Math.abs(currentHandParameterSum-previousHandParameterSum) <0.2 && System.currentTimeMillis()-startTime >700){
		   	              System.out.println("nima");
		   	              OS.flag = true;
		   	        	  cancel();
		   	        	   
		   	           }
		           }
		          OS.observationSequence.add(observationVector);
		          previousHandParameterSum = currentHandParameterSum;
	        	   
	           }
	  }


}
