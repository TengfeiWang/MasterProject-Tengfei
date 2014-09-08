package hmm;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JProgressBar;

import util.DataFileOperator;
import be.ac.ulg.montefiore.run.jahmm.Hmm;
import be.ac.ulg.montefiore.run.jahmm.ObservationVector;
import be.ac.ulg.montefiore.run.jahmm.OpdfMultiGaussianFactory;
import be.ac.ulg.montefiore.run.jahmm.io.HmmWriter;
import be.ac.ulg.montefiore.run.jahmm.io.ObservationSequencesReader;
import be.ac.ulg.montefiore.run.jahmm.io.ObservationVectorReader;
import be.ac.ulg.montefiore.run.jahmm.io.OpdfMultiGaussianWriter;
import be.ac.ulg.montefiore.run.jahmm.learn.BaumWelchLearner;
import be.ac.ulg.montefiore.run.jahmm.learn.KMeansLearner;

public class TrainHmmModels {
	
	public JProgressBar progressBar;
	
	public TrainHmmModels(JProgressBar trainingProcess){
		progressBar = trainingProcess;
	}
	
	public void trainAll(){
        System.out.println("start  to write");
		try{
		      DataFileOperator dataFileOperator= new DataFileOperator("sequencedata/");
		
	          int exampleNum = dataFileOperator.getFileNum();
	          String[] names =  new String[exampleNum];
	          names = dataFileOperator.getFileNames();//string names stores all the training data file names
	    
	          for(int i =0;i<exampleNum;i++){

		            Reader reader = new FileReader ("sequencedata/"+names[i]+".seq");
			        List<List<ObservationVector>> seqs = new ArrayList<List<ObservationVector>>();
			        seqs =  
			        		ObservationSequencesReader .
			        		readSequences (new ObservationVectorReader (),  
			        		reader);
		            reader.close ();
		            //use K-mean leaner
		            KMeansLearner <ObservationVector > kml =
		            		new KMeansLearner <ObservationVector >(5,
		            		new OpdfMultiGaussianFactory (3) , seqs);
		
		            System.out.println(seqs);
		            
		            Hmm <ObservationVector> initHmm = kml.learn();
		         
		           /* OpdfMultiGaussianFactory factory = new OpdfMultiGaussianFactory(15);
		            Hmm<ObservationVector > initHmm =
		            		new Hmm <ObservationVector >(5, factory
		            		);
		      */
		            
		          
		           BaumWelchLearner bwl =
		            		new BaumWelchLearner ();
		            		Hmm <ObservationVector > learntHmm = bwl.learn(initHmm ,  
		            		seqs);
		
		           // Hmm <ObservationVector > initHmm =
		           //		new Hmm <ObservationVector >(5, new OpdfMultiGaussianFactory(20));
		            Writer writer = new FileWriter ("hmmdata/"+names[i]+".hmm");
		            HmmWriter.write(writer,new OpdfMultiGaussianWriter(), learntHmm);
		            writer.close();
		            System.out.println("hmm has been written to the txt file");
		            progressBar.setValue((i+1)*(100/exampleNum));
	          }
	          
	         }catch (Exception e) {
	     	    //add your error handling code here
	     		e.printStackTrace();
	     	}
	}

}
