package userInterface;


import hmm.TrainHmmModels;
import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.leapmotion.leap.Hand;

import dataCollection.DataRecording;
import dataCollection.RecordingGesture;

import recognitionModule.GestureRecognition;
import recognitionModule.RecognitionPanel;

import util.CountingDown;
import util.DataFileOperator;
import util.ObservationSequence;
import util.recordingManager;

import be.ac.ulg.montefiore.run.jahmm.ObservationVector;
import be.ac.ulg.montefiore.run.jahmm.io.ObservationSequencesWriter;
import be.ac.ulg.montefiore.run.jahmm.io.ObservationVectorWriter;




public class MainGUI extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

    
	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Map<String ,String> unrecordedGesture;
	private Hand previousHand;
    private List<ObservationVector> observationSequence;
    private String gestureName;
	private JPanel controlPanel;
	private JButton dataCollection;
	private JButton training;
	private JLabel infoLabel;
	private JPanel part2datacollePanel;
	private JPanel part1datacollePanel;
	private JButton viewExample;
	private JButton deleteExample;
	private JPanel evalutatonPanel;
	private JLabel resultLabel;
	private JButton learnAlphabet;
	private JTable featureInfoTable;
	private JPanel resultPanel;
	private JTextArea dataAnalysis;
	private JButton runRecognitionB;
	private JPanel runRecognition;
	private JMenu File;
	private JMenu Help;
	private JMenuBar jMenuBar;
	private JButton cancelTraining;
	private JProgressBar trainingProcess;
	private JPanel trainingprocessPanel;
	private JLabel numofModels;
	private JButton trainModels;
	private JPanel trainmodelPanel;
	private JScrollPane featureinfoPanel;
	private JPanel dataCollePanel;
	private JPanel switchPanel;
	private JButton recognition;
	private JPanel trainingPanel;
	private JPanel recognitionPanel;
    private JButton startRecording;
 
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainGUI inst = new MainGUI();
				inst.setResizable(false);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainGUI() {
		super();
		initGUI();
	}
	


	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setTitle("German Fingerspelling alphabet recognition");
			{
				jMenuBar = new JMenuBar();
				setJMenuBar(jMenuBar);
				{
					File = new JMenu();
		     		jMenuBar.add(File);
					File.setText("File");
					jMenuBar.add(Box.createHorizontalGlue());
					Help = new JMenu();
					jMenuBar.add(Help);
					Help.setText("Help");
				}
			}
			{
				controlPanel = new JPanel();
				GridBagLayout controlPanelLayout = new GridBagLayout();
				controlPanelLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
				controlPanelLayout.rowHeights = new int[] {87, 84, 85, 7};
				controlPanelLayout.columnWeights = new double[] {0.0, 0.1, 0.1, 0.1};
				controlPanelLayout.columnWidths = new int[] {140, 7, 7, 7};
				controlPanel.setLayout(controlPanelLayout);
				getContentPane().add(controlPanel, BorderLayout.WEST);
				controlPanel.setPreferredSize(new java.awt.Dimension(165, 662));
				{
					dataCollection = new JButton();
					controlPanel.add(dataCollection, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(22, 10, 22, 13), 0, 0));
					dataCollection.setText("1.Data Collection");
					dataCollection.setPreferredSize(new java.awt.Dimension(119, 32));
					dataCollection.addActionListener(new ButtonListener());
				}
				{
					training = new JButton();
					controlPanel.add(training, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(20, 10, 20, 22), 0, 0));
					training.setText("2.Train");
					/*int numExamples = new DataFileOperator("sequencedata").getFileNum();
					if(numExamples ==0){
						training.setEnabled(false);
					}*/
					training.setPreferredSize(new java.awt.Dimension(119, 32));
					training.addActionListener(new ButtonListener());
				}
				{
					recognition = new JButton();
					controlPanel.add(recognition, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(20, 10, 20, 10), 0, 0));
					recognition.setText("3.Recognition");
					/*int numHMMs = new DataFileOperator("hmmdata").getFileNum();
					if(numHMMs ==0){
						recognition.setEnabled(false);
					}*/
					recognition.setPreferredSize(new java.awt.Dimension(93, 27));
					recognition.addActionListener(new ButtonListener());
				}
				{
					learnAlphabet = new JButton();
					controlPanel.add(learnAlphabet, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(150, 12, 190, 8), 0, 0));
					learnAlphabet.setText("Learn Alphabet");
					learnAlphabet.addActionListener(new ButtonListener());
				}
			}
			{
				switchPanel = new JPanel();
				CardLayout switchPanelLayout = new CardLayout();
				switchPanel.setLayout(switchPanelLayout);
				getContentPane().add(switchPanel, BorderLayout.CENTER);
				{
					dataCollePanel = new JPanel();
					GridBagLayout dataCollePanelLayout = new GridBagLayout();
					dataCollePanelLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
					dataCollePanelLayout.rowHeights = new int[] {12, 106, 191, 7};
					dataCollePanelLayout.columnWeights = new double[] {0.0, 0.0, 0.1, 0.1};
					dataCollePanelLayout.columnWidths = new int[] {58, 410, 7, 7};
					dataCollePanel.setLayout(dataCollePanelLayout);
					switchPanel.add(dataCollePanel, "jPanel1");
					dataCollePanel.setPreferredSize(new java.awt.Dimension(400, 250));
					{
						part1datacollePanel = new JPanel();
						GridBagLayout part1datacollePanelLayout = new GridBagLayout();
						part1datacollePanelLayout.rowWeights = new double[] {0.0, 0.0, 0.1, 0.1};
						part1datacollePanelLayout.rowHeights = new int[] {36, 72, 7, 7};
						part1datacollePanelLayout.columnWeights = new double[] {0.0, 0.0, 0.1, 0.1};
						part1datacollePanelLayout.columnWidths = new int[] {52, 197, 7, 7};
						part1datacollePanel.setLayout(part1datacollePanelLayout);
						dataCollePanel.add(part1datacollePanel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(8, 1, 17, 0), 0, 0));
						part1datacollePanel.setPreferredSize(new java.awt.Dimension(320, 211));
						part1datacollePanel.setBorder(BorderFactory.createTitledBorder("Record Gesture"));
						//part1datacollePanel.setLayout(new BorderLayout());
						startRecording = new JButton("start recording gesture");
						part1datacollePanel.add(startRecording, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(14, 0, 0, 0), 0, 0));
						startRecording.setPreferredSize(new java.awt.Dimension(250, 79));
						startRecording.addActionListener(new ButtonListener());
					}
					{
						part2datacollePanel = new JPanel();
						TableLayout part2datacollePanelLayout1 = new TableLayout(new double[][] {{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}, {TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}});
						part2datacollePanelLayout1.setHGap(5);
						part2datacollePanelLayout1.setVGap(5);
						GridBagLayout part2datacollePanelLayout = new GridBagLayout();
						part2datacollePanelLayout.rowWeights = new double[] {0.0, 0.1, 0.1, 0.1};
						part2datacollePanelLayout.rowHeights = new int[] {24, 7, 7, 7};
						part2datacollePanelLayout.columnWeights = new double[] {0.0, 0.0, 0.1, 0.1};
						part2datacollePanelLayout.columnWidths = new int[] {27, 248, 7, 7};
						dataCollePanel.add(part2datacollePanel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						part2datacollePanel.setPreferredSize(new java.awt.Dimension(320, 211));
						part2datacollePanel.setBorder(BorderFactory.createTitledBorder("Manage Recorded Gesture"));
						part2datacollePanel.setLayout(part2datacollePanelLayout);
						{
							infoLabel = new JLabel();
							part2datacollePanel.add(infoLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							int numExamples = new DataFileOperator("sequencedata").getFileNum();
							infoLabel.setText(numExamples+"  examples recorded!");
						}
						{
							viewExample = new JButton();
							part2datacollePanel.add(viewExample, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							viewExample.setText("View Examples");
							viewExample.addActionListener(new ButtonListener());
						}
						{
							deleteExample = new JButton();
							part2datacollePanel.add(deleteExample, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 6, 0, 0), 0, 0));
							deleteExample.setText("Delete Examples!");
							deleteExample.setLocale(new java.util.Locale("en"));
							deleteExample.addActionListener(new ButtonListener());
						}
					}

					trainingPanel = new JPanel();
					GridBagLayout trainingPanelLayout = new GridBagLayout();
					//trainingPanel.setLayout(new BoxLayout(trainingPanel, BoxLayout.LINE_AXIS));
					switchPanel.add(trainingPanel,"jPanel1");
					trainingPanel.setPreferredSize(new java.awt.Dimension(59, 10));
					trainingPanelLayout.rowWeights = new double[] {0.0, 0.0, 0.1, 0.1};
					trainingPanelLayout.rowHeights = new int[] {207, 207, 7, 7};
					trainingPanelLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.1};
					trainingPanelLayout.columnWidths = new int[] {315, -431, 309, 7};
					trainingPanel.setLayout(trainingPanelLayout);
					{
						featureinfoPanel = new JScrollPane();
						featureinfoPanel.setBorder(BorderFactory.createTitledBorder("Feature Sets"));
						trainingPanel.add(featureinfoPanel, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(23, 0, 0, 0), 0, 0));
						{
							String[][] columnData =  new DataFileOperator("sequencedata/").tableWriter();
							
							TableModel featureInfoTableModel = 
									new DefaultTableModel(
											columnData,
											new String[]{"GestureName","thumbDistal","thumbIntermediate","thumbProximal","thumbMetacarpals",
													"indexDistal","indexIntermediate","indexProximal","indexMetacarpals",	
													"middleDistal","middleIntermediate","middleProximal","middleMetacarpals",
													"ringDistal","ringIntermediate","ringProximal","ringMetacarpals",
													"pinkyDistal","pinkyIntermediate","pinkyProximal","pinkyMetacarpals",
													
											});
							featureInfoTable = new JTable();
							featureInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							featureinfoPanel.setViewportView(featureInfoTable);
							featureInfoTable.setModel(featureInfoTableModel);
						}
					}
					{
						trainmodelPanel = new JPanel();
						GridBagLayout trainmodelPanelLayout = new GridBagLayout();
						trainmodelPanel.setBorder(BorderFactory.createTitledBorder("Train Models"));
						trainingPanel.add(trainmodelPanel, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 23, 0), 0, 0));
						trainmodelPanel.setPreferredSize(new java.awt.Dimension(10, 41));
						trainmodelPanelLayout.rowWeights = new double[] {0.1, 0.0, 0.1, 0.1};
						trainmodelPanelLayout.rowHeights = new int[] {7, 38, 7, 7};
						trainmodelPanelLayout.columnWeights = new double[] {0.1, 0.0, 0.1, 0.1};
						trainmodelPanelLayout.columnWidths = new int[] {7, 245, 7, 7};
						trainmodelPanel.setLayout(trainmodelPanelLayout);
						{
							trainModels = new JButton();
							trainmodelPanel.add(trainModels, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
							trainModels.setText("Train Models");
							trainModels.addActionListener(new ButtonListener());
						}
						{
							numofModels = new JLabel();
							int numHmms = new DataFileOperator("hmmdata").getFileNum();
							trainmodelPanel.add(numofModels, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							numofModels.setText(numHmms+"  models to be trained.");
						}
					}
					{
						trainingprocessPanel = new JPanel();
						GridBagLayout trainingprocessPanelLayout = new GridBagLayout();
						trainingprocessPanel.setBorder(BorderFactory.createTitledBorder("Training Precess"));
						trainingPanel.add(trainingprocessPanel, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						trainingprocessPanelLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
						trainingprocessPanelLayout.rowHeights = new int[] {7, 7, 7, 7};
						trainingprocessPanelLayout.columnWeights = new double[] {0.1, 0.0, 0.1, 0.1};
						trainingprocessPanelLayout.columnWidths = new int[] {7, 235, 7, 7};
						trainingprocessPanel.setLayout(trainingprocessPanelLayout);
						{
							trainingProcess = new JProgressBar();
							trainingprocessPanel.add(trainingProcess, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						}
						{
							cancelTraining = new JButton();
							trainingprocessPanel.add(cancelTraining, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							cancelTraining.setText("Cancel");
						}
					}

					recognitionPanel = new JPanel();
					switchPanel.add(recognitionPanel, "jPanel1");
					GridBagLayout recognitionPanelLayout = new GridBagLayout();
					recognitionPanelLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
					recognitionPanelLayout.rowHeights = new int[] {171, 214, 175, 7};
					recognitionPanelLayout.columnWeights = new double[] {0.0, 0.0, 0.1, 0.1};
					recognitionPanelLayout.columnWidths = new int[] {31, 405, 7, 7};
					recognitionPanel.setLayout(recognitionPanelLayout);
					recognitionPanel.setPreferredSize(new java.awt.Dimension(515, 660));
					{
						runRecognition = new JPanel();
						GridBagLayout runRecognitionLayout = new GridBagLayout();
						recognitionPanel.add(runRecognition, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(26, 36, 0, 48), 0, 0));
						runRecognitionLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
						runRecognitionLayout.rowHeights = new int[] {15, 2, 84, 7};
						runRecognitionLayout.columnWeights = new double[] {0.1, 0.0, 0.1, 0.1};
						runRecognitionLayout.columnWidths = new int[] {7, 304, 7, 7};
						runRecognition.setLayout(runRecognitionLayout);
						runRecognition.setBorder(BorderFactory.createTitledBorder("Recognition"));
						{
							runRecognitionB = new JButton();
							runRecognition.add(runRecognitionB, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 7, 0, 0), 0, 0));
							runRecognitionB.setText("Run Recognition");
							runRecognitionB.addActionListener(new ButtonListener());
						}
					}
					{
						resultPanel = new JPanel();
						GridBagLayout resultPanelLayout = new GridBagLayout();
						resultPanel.setBorder(BorderFactory.createTitledBorder("Result"));
						recognitionPanel.add(resultPanel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(16, 33, 14, 47), 0, 0));
						resultPanelLayout.rowWeights = new double[] {0.1, 0.0, 0.1, 0.1};
						resultPanelLayout.rowHeights = new int[] {7, 46, 7, 7};
						resultPanelLayout.columnWeights = new double[] {0.0, 0.0, 0.1, 0.1};
						resultPanelLayout.columnWidths = new int[] {133, 154, 7, 7};
						resultPanel.setLayout(resultPanelLayout);
						{
							resultLabel = new JLabel();
							resultLabel.setFont(new java.awt.Font("Dialog", 1, 15));
							resultPanel.add(resultLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
							resultLabel.setPreferredSize(new java.awt.Dimension(16, 16));
						}
					}
					{
						evalutatonPanel = new JPanel();
						GridBagLayout evalutatonPanelLayout = new GridBagLayout();
						recognitionPanel.add(evalutatonPanel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(17, 34, 7, 46), 0, 0));
						evalutatonPanelLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
						evalutatonPanelLayout.rowHeights = new int[] {23, 124, 36, 7};
						evalutatonPanelLayout.columnWeights = new double[] {0.0, 0.0, 0.1, 0.1};
						evalutatonPanelLayout.columnWidths = new int[] {17, 292, 7, 7};
						evalutatonPanel.setLayout(evalutatonPanelLayout);
						evalutatonPanel.setBorder(BorderFactory.createTitledBorder("Evaluation"));
						{
							dataAnalysis = new JTextArea();
							evalutatonPanel.add(dataAnalysis, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 4, 0, 0), 0, 0));
							dataAnalysis.setText("this area will show the probability of each model during the computation");
							dataAnalysis.setEditable(false);
							dataAnalysis.setLineWrap(true);
						
							
						}
					}
					{
						 /*JButton trainingb =new JButton("this is the recognition panel");
						 trainingb.setBorder(BorderFactory.createEtchedBorder(
					                EtchedBorder.RAISED));

						 recognitionPanel.add(trainingb);*/
					}
				}
			}
			pack();
			this.setSize(700, 700);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	

	class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	
            JButton o = (JButton) e.getSource();
            String label = o.getText();
            if(label=="2.Train"){
            	dataCollePanel.setVisible(false);
            	trainingPanel.setVisible(true);
            	recognitionPanel.setVisible(false);
            }
            if(label=="1.Data Collection"){
            	dataCollePanel.setVisible(true);
            	//dataCollePanel.updateUI();
            	trainingPanel.setVisible(false);
               	recognitionPanel.setVisible(false);
            }
            if(label=="3.Recognition"){
            	recognitionPanel.setVisible(true);
            	dataCollePanel.setVisible(false);
            	trainingPanel.setVisible(false);
            }
            if(label=="View Examples"){
            	ViewExamples newFrame = new ViewExamples();
            	newFrame.setVisible(true);
            }
            if(label=="Delete Examples!"){
            	JOptionPane.showConfirmDialog(null, "Are you sure to delete the examples?", "DeleteExamples", JOptionPane.YES_NO_OPTION);
            	
            }
            if(label =="start recording gesture"){
            	    unrecordedGesture = new recordingManager().unrecordedGesture();
            	    System.out.print(unrecordedGesture);
            	    List<List<ObservationVector>> seqs = new ArrayList<List<ObservationVector>>();

                    //gestureName = JOptionPane.showInputDialog(null,"Gesture Name:","Enter Recording Parameters",JOptionPane.QUESTION_MESSAGE);
            	    Iterator<Entry<String, String>> iter = unrecordedGesture.entrySet().iterator(); 
            	    while (iter.hasNext()) {
            	         Map.Entry<String, String> entry = (Map.Entry<String,String>) iter.next(); 
            	         String key = entry.getKey(); 
            	         String val = entry.getValue();
            	    	
            	         for(int i=0;i<5;i++){
                            /* RecordingPanel recordingPanel = null;
                             if(recordingPanel ==null){
            	        	     ObservationSequence OS = new ObservationSequence();
            	        	     
            	        	     recordingPanel = new RecordingPanel(i,key,OS);
            	    	         recordingPanel.setModal(true);
            	    	         recordingPanel.setVisible(true);
            	    	         recordingPanel.getObservationSequence();
            	    	         observationSequence=OS.observationSequence;
            	    	         System.out.println("hi"+observationSequence);
            	    	         seqs.add(observationSequence);
                             }*/
            	        	 ObservationSequence OS = new ObservationSequence();
                             RecordingGesture recordingPanel = new RecordingGesture(OS,val,key);
                       
                             recordingPanel.setModal(true);
                             recordingPanel.setVisible(true);
                   
              
                            // while(OS.flag ==false){};
                             //CountingDown cd = new CountingDown(recordingPanel);
                             //cd.start();
                            // while(cd.flag ==false){};
        	    	         observationSequence=OS.observationSequence;
        	    	         System.out.println("hi"+observationSequence);
        	    	         seqs.add(observationSequence);
         
            	    	    
            	    	     
            	        }
                			try {
                				Writer writer = new FileWriter("sequencedata/"+key+".seq");
                				ObservationSequencesWriter.write(writer, new ObservationVectorWriter(), seqs);
                				writer.close();
                			} catch (IOException e1) {
                				// TODO Auto-generated catch block
                				e1.printStackTrace();
                			}
            	    }
 
        			
           
            }
            if(label=="Learn Alphabet"){
            	AlphabetPanel ap = new AlphabetPanel();
            	ap.setVisible(true);
            }

            if(label=="Train Models"){
            	TrainHmmModels trainModels = new TrainHmmModels(trainingProcess);
            	trainModels.trainAll();

            }
            if(label =="Run Recognition"){
            	ObservationSequence OS = new ObservationSequence();
            	RecognitionPanel recognitionPanel = new RecognitionPanel(OS);
            	recognitionPanel.setModal(true);
            	recognitionPanel.setVisible(true);
   	    	    observationSequence=OS.observationSequence;
   	    	    System.out.println("hi"+observationSequence);
   	    	    GestureRecognition gestureRecognition = new GestureRecognition(OS,dataAnalysis,resultLabel);
   	    	    gestureRecognition.showResult();
            }

        }
    }
}

