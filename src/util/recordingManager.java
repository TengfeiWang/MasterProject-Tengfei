package util;

import java.util.HashMap;
import java.util.Map;

public class recordingManager {
	
	private Map<String,String> gestureMap;
	
	public recordingManager(){//construct method
		
		gestureMap = new HashMap<String,String>();
		gestureMap.put("AB", "B");
		gestureMap.put("AC", "C");
		gestureMap.put("AD", "D");
		gestureMap.put("AE", "E");
		gestureMap.put("AF", "F");
		gestureMap.put("AG", "G");
		gestureMap.put("AH", "H");
		gestureMap.put("AI", "I");
		gestureMap.put("AJ", "J");
		gestureMap.put("AK", "K");
		gestureMap.put("AL", "L");
		gestureMap.put("AM", "M");
		gestureMap.put("AN", "N");
	}
	
	
	public Map<String,String> unrecordedGesture(){
		 String[] names = new DataFileOperator("sequencedata/").getFileNames();
		 for(int i =0;i< names.length;i++){
			 if(gestureMap.containsKey(names[i]) == true){
				 gestureMap.remove(names[i]);
			 }
		 }
		 return gestureMap;
	}
	
	

}
