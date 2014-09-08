package util;

import com.leapmotion.leap.Bone;
import com.leapmotion.leap.FingerList;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Vector;

public class HandDetector {
	
	public boolean isStable(Hand hand1,Hand hand2){
		
		if(Math.abs(sumOfDistance(hand1)-sumOfDistance(hand1))==0.0){
			
			return true;
			
		}
		return false;
		
	}
	
	public double sumOfDistance(Hand hand){
		 FingerList fingers = hand.fingers();
         Vector handCenter = hand.palmPosition();
         double result= 0.0;
         for(int i =0;i<5;i++){
        	result += fingers.get(i).bone(Bone.Type.TYPE_DISTAL).center().distanceTo(handCenter);
         }
		return result;
	}
	


}
