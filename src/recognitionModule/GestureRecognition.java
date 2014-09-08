package recognitionModule;

import java.io.FileReader;
import java.io.Reader;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import be.ac.ulg.montefiore.run.jahmm.ForwardBackwardScaledCalculator;
import be.ac.ulg.montefiore.run.jahmm.Hmm;
import be.ac.ulg.montefiore.run.jahmm.ObservationVector;
import be.ac.ulg.montefiore.run.jahmm.io.HmmReader;
import be.ac.ulg.montefiore.run.jahmm.io.OpdfMultiGaussianReader;
import util.DataFileOperator;
import util.ObservationSequence;

public class GestureRecognition {
	
	private JTextArea dataAnalysis;
	private JLabel resultLabel;
	private ObservationSequence OS;
	
	
	public GestureRecognition(ObservationSequence OS,JTextArea dataAnalysis, JLabel resultLabel){
		this.OS =OS;
		this.dataAnalysis = dataAnalysis;
		this.resultLabel = resultLabel;
		dataAnalysis.setText("");
	}
	
	public void showResult(){
		
		try{
		    
			 DataFileOperator fileOperator = new DataFileOperator("hmmdata/");
		     int modelNumber = fileOperator.getFileNum();
		     String[] modelNames = fileOperator.getFileNames();
		     
		     double tempProbability = 0.0;
		     String bestFitModel = null;
		     
		     for(int i= 0;i<modelNumber; i ++){
			
			      Reader reader = new FileReader ("hmmdata/"+modelNames[i]+".hmm");
			      Hmm <ObservationVector> hmm = HmmReader.read(reader, new OpdfMultiGaussianReader());
			      ForwardBackwardScaledCalculator forwardBackward = new ForwardBackwardScaledCalculator(OS.observationSequence,hmm);
			      double probability = forwardBackward.probability();
			      reader.close();
			      dataAnalysis.append(modelNames[i]+"............"+probability+"\n");
			      //dataAnalysis.setText(modelNames[i]+"............"+probability);
			      if(probability >tempProbability){
			    	  bestFitModel = modelNames[i];
			    	  tempProbability = probability;
			      }
		     }
		     
		     resultLabel.setText(bestFitModel);
		     
		    
		}catch (Exception e) {
     	    //add your error handling code here
     		e.printStackTrace();
     	}
		
	}

}
