package util;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import be.ac.ulg.montefiore.run.jahmm.ObservationVector;
import be.ac.ulg.montefiore.run.jahmm.io.ObservationSequencesReader;
import be.ac.ulg.montefiore.run.jahmm.io.ObservationVectorReader;

public class DataFileOperator {
	
	private String dir;
	
	public DataFileOperator(String directory){
		dir= directory;
	}
	public int getFileNum() {
        //this function returns the number of files  in the folder "dir".

		File f=new File(dir);
		String[] str=f.list();
		return str.length;

	}
	
	public String[] getFileNames(){
		
		File f=new File(dir);
		String[] str=f.list();
		for(int i =0;i<str.length;i++){
			str[i]=str[i].substring(0,str[i].lastIndexOf("."));
		}
		return str;
	}
	
	public String[][] tableWriter(){
        String[][] columnData = null;
		try{
			DataFileOperator dataFileOperator= new DataFileOperator(dir);
		
		    int exampleNum = dataFileOperator.getFileNum();
		    String[] names =  new String[exampleNum];
		    names = dataFileOperator.getFileNames();//string names stores all the training data file names
		    int rowNum = 0;
		    for(int i =0;i<exampleNum;i++){
		    	 int sequenceNum = 0;
			     Reader reader = new FileReader (dir+names[i]+".seq");
			     List<List <ObservationVector>> seqs = ObservationSequencesReader.readSequences(new ObservationVectorReader(),  reader);
			     sequenceNum = seqs.size();
			     for(int j = 0; j<sequenceNum;j++){
			    	 rowNum +=seqs.get(j).size();
			     }
			     reader.close ();
		    }
		
		System.out.println(rowNum);

		/*for(int i =0;i<rowNum;i++){
			for(int j=0;j<21;j++)
				columnData[i][j]="0";
		}*/
		    
	
	    columnData = new String[rowNum][4];
		int currentRowNumBottom = 0;
		int currentRowNumTop=0;
		int currentRowNum = 0;
		for(int i =0;i<exampleNum;i++){
			Reader reader = new FileReader ("sequencedata/"+names[i]+".seq");
			List<List <ObservationVector >> seqs =  ObservationSequencesReader.readSequences (new ObservationVectorReader (),  reader);
			for(int m= 0;m<seqs.size();m++){
            	currentRowNumTop += seqs.get(m).size();
            }
			for(int j=currentRowNumBottom;j<currentRowNumTop;j++){
            	columnData[j][0]=names[i];
            	
            }
			currentRowNumBottom= currentRowNumTop;
			
			
			for(int sequenceNum = 0;sequenceNum<5;sequenceNum++){
				for(int currentSeqIndex = 0;currentSeqIndex<seqs.get(sequenceNum).size();currentSeqIndex++){
			     for(int k = 1;k<4;k++){
			    	 
        		      columnData[currentRowNum][k]=String.valueOf(seqs.get(sequenceNum).get(currentSeqIndex).value(k-1));
        	     }
			     currentRowNum ++;
				}
			}
			
			reader.close ();
			
	
		}
	}catch (Exception e) {
	    //add your error handling code here
		e.printStackTrace();
	}
		return columnData;
	}

}
