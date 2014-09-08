package util;

import java.util.ArrayList;
import java.util.List;

import be.ac.ulg.montefiore.run.jahmm.ObservationVector;

public class ObservationSequence {

	public List<ObservationVector> observationSequence;
	public boolean flag;
    public ObservationSequence(){
    	observationSequence = new ArrayList<ObservationVector>();
    	flag= false;
    }
}
