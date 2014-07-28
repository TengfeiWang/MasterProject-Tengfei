package featureExtraction;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.swing.JOptionPane;

import be.ac.ulg.montefiore.run.jahmm.Observation;
import be.ac.ulg.montefiore.run.jahmm.ObservationVector;

import com.leapmotion.leap.Bone;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.FingerList;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.HandList;
import com.leapmotion.leap.Vector;

public class FeatureExtractor {
	
	
	public double[] getFeatureVector(Controller controller){
		//this function returns an array with double real values which is the direction information
		//20 bones of the detected hand
       double[] result = new double[20];
       
       if(controller.isConnected()==true) //controller is a Controller object
       {
    	   int counter=0;
           Frame frame = controller.frame(); //The latest frame
           HandList hands = frame.hands();
           Hand hand = hands.get(0);
  
           for (Finger finger : hand.fingers()) {
        	    for(Bone.Type boneType : Bone.Type.values()) {
        	        Bone bone = finger.bone(boneType);
        	        double average=(double)(bone.direction().getX()+bone.direction().getX()+bone.direction().getX())/3;
        	        result[counter]=average;
        	        counter++;
        	        System.out.println(bone.direction());
        	        // ... Use the bone
        	    }
        	}
           System.out.println("device is connected and  "+counter+"  bones are detected!" );
           
       }
       else{

    	   JOptionPane.showMessageDialog(null, "The leap is not connected!", "Error", JOptionPane.ERROR_MESSAGE);
    	   System.exit(0);
       }
       
       return result;
		
	}

}
