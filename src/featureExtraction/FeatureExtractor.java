package featureExtraction;

import javax.swing.JOptionPane;

import com.leapmotion.leap.Bone;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.FingerList;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.HandList;
import com.leapmotion.leap.Vector;

public class FeatureExtractor {
	
	private Controller controller;
	
	public FeatureExtractor(Controller controller){
		   this.controller = controller;
		   if(controller.isConnected()==false) //controller is a Controller object
	       {

	    	   JOptionPane.showMessageDialog(null, "The leap is not connected!", "Error", JOptionPane.ERROR_MESSAGE);
	    	   System.exit(0);
	       }
	}
	
	
	public Hand getHandObject(){
	
		Frame frame = controller.frame(); //The latest frame
        HandList hands = frame.hands();
        Hand hand = hands.get(0);
        return hand;
	}
	

	public double[] getFeatureVector(){
		//this function returns an array with double real values which is a feature vector
           double[] result = new double[3];
       
    
    	   //int counter=0;
           Frame frame = controller.frame(); //The latest frame
           HandList hands = frame.hands();
           Hand hand = hands.get(0);
           FingerList fingers = hand.fingers();
           Vector handCenter = hand.palmPosition();
           Vector thumbDistalCenter = fingers.get(0).bone(Bone.Type.TYPE_DISTAL).center(); 
           Vector indexDistalCenter = fingers.get(1).bone(Bone.Type.TYPE_DISTAL).center();
           result[0]=thumbDistalCenter.distanceTo(handCenter);
           result[1]=indexDistalCenter.distanceTo(handCenter);
           result[2]=thumbDistalCenter.distanceTo(indexDistalCenter);
           /*for (int i =0;i<2;i++) {
        	   Finger finger = fingers.get(i);
        	   System.out.println(finger.type());
        	   TYPE_THUMB
        	   TYPE_INDEX
        	   TYPE_MIDDLE
        	   TYPE_RING
        	   TYPE_PINKY
        	   //if(finger.id()==1010 || finger.id()==1011)
        	    for(Bone.Type boneType : Bone.Type.values()) {
        	    	//System.out.println(boneType.name());
        	    	
        	    	TYPE_METACARPAL
        	    	TYPE_PROXIMAL
        	    	TYPE_INTERMEDIATE
        	    	TYPE_DISTAL
        	    	if(boneType.name() == "TYPE_PROXIMAL" ){
        	 
 
        	        counter++;
        	    	}
        	        //System.out.println(bone.direction());
        	        // ... Use the bone
        	    }
        	}*/
          // System.out.println("device is connected and  "+counter+"  bones are detected!" );
           
 
       
       return result;
		
	}

}
