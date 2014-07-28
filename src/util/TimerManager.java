package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import be.ac.ulg.montefiore.run.jahmm.Observation;
import be.ac.ulg.montefiore.run.jahmm.ObservationVector;
import be.ac.ulg.montefiore.run.jahmm.io.ObservationRealWriter;
import be.ac.ulg.montefiore.run.jahmm.io.ObservationSequencesWriter;
import be.ac.ulg.montefiore.run.jahmm.io.ObservationVectorWriter;
import be.ac.ulg.montefiore.run.jahmm.io.ObservationWriter;

import com.leapmotion.leap.Controller;

import featureExtraction.FeatureExtractor;


//this class defines a timer ,we run feature extraction every certain time(in ms)
public class TimerManager {

	  public Timer timer = new Timer();
	  private Controller subController;
	  private ObservationVector observationVector;
	  
      public TimerManager(Controller controller){
    	  subController = controller;
      }
	  
	  public  void start() {  
	  timer.schedule(new RemindTask(), 0, 200); 
	  }

	  public  void stop(){
	         timer.cancel();
	  }
	  
	  
	  public  class RemindTask extends TimerTask {
	    	  
	           public void run() {
	        	   //TODO add code to do feature extraction
	            try {
	       			
	               Writer writer = new FileWriter("data/tempfile.seq",true);
	 	   		   FeatureExtractor fe =new FeatureExtractor();
	 	   		   
	 	   		   double[] featureVector = fe.getFeatureVector(subController);
		           System.out.println(new Date());
		           observationVector = new ObservationVector(featureVector);
		           ObservationVectorWriter ow = new ObservationVectorWriter();
		           ow.write(observationVector, writer);
		           writer.close();
		           
	       		} catch (IOException e) {
	       			// TODO Auto-generated catch block
	       			e.printStackTrace();
	       		}

	           
	           }
	  }


}
