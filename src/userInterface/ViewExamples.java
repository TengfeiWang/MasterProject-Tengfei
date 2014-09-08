package userInterface;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import util.DataFileOperator;


public class ViewExamples extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane jScrollPane;
	private JTable sequenceTable;
	private String[] columnNames =new String[]{"GestureName","thumbDistal","thumbIntermediate","thumbProximal","thumbMetacarpals",
			"indexDistal","indexIntermediate","indexProximal","indexMetacarpals",	
			"middleDistal","middleIntermediate","middleProximal","middleMetacarpals",
			"ringDistal","ringIntermediate","ringProximal","ringMetacarpals",
			"pinkyDistal","pinkyIntermediate","pinkyProximal","pinkyMetacarpals",
			
	};
	//private String [][] columnData;


	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public ViewExamples() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setTitle("view examples");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jScrollPane = new JScrollPane();
				getContentPane().add(jScrollPane, BorderLayout.CENTER);
				{
					/*DataFileOperator dataFileOperator= new DataFileOperator("sequencedata/");
					int exampleNum = dataFileOperator.getFileNum();
					String[] names =  new String[exampleNum];
					names = dataFileOperator.getFileNames();//string names stores all the training data file names
					int rowNum = 0;
					for(int i =0;i<exampleNum;i++){

						Reader reader = new FileReader ("sequencedata/"+names[i]);
						List <ObservationVector> seq = ObservationSequencesReader.readSequence(new ObservationVectorReader(),  reader);
						rowNum += seq.size();
						reader.close ();
					}
					
					System.out.println(rowNum);
					columnData = new String[rowNum][21];
					for(int i =0;i<rowNum;i++){
						for(int j=0;j<21;j++)
							columnData[i][j]="0";
					}
					int currentRowNumBottom = 0;
					int currentRowNumTop=0;
					
					for(int i =0;i<exampleNum;i++){
						Reader reader = new FileReader ("sequencedata/"+names[i]);
						List <ObservationVector > seq =  ObservationSequencesReader.readSequence (new ObservationVectorReader (),  reader);
                        currentRowNumTop += seq.size();
                        int currentSeqIndex=0;
						for(int j=currentRowNumBottom;j<currentRowNumTop;j++){
                        	columnData[j][0]=names[i];
                        
                        	for(int k = 1;k< 21;k++){
                        		columnData[j][k]=String.valueOf(seq.get(currentSeqIndex).value(k-1));
                        	}
                        	currentSeqIndex++;
                        }
						currentRowNumBottom= currentRowNumTop;
						
						reader.close ();
					}*/
					//the above code read the data from all .seq files to the JTable
					String[][] columnData =  new DataFileOperator("sequencedata/").tableWriter();
   					TableModel sequenceTableModel = 
							new DefaultTableModel(columnData,columnNames);
					sequenceTable = new JTable();
					sequenceTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					sequenceTable.setModel(sequenceTableModel);
					jScrollPane.setViewportView(sequenceTable);
				}
			}
			//code to read sequence information and show in a table
			
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
