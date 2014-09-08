package dataCollection;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import util.ObservationSequence;
import util.TimerManager;
import com.leapmotion.leap.Controller;



/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class RecordingGesture extends javax.swing.JDialog{
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private  JLabel timerLabel;
	private JLabel jLabel1;
	private  TimerManager task;
    private  Controller controller;
    //public  List<ObservationVector> observationSequence = null;
    public  ObservationSequence OS;
    private String gestureName;
    private JButton testButton;
    private JPanel container;
    private String imageName;


	/**
	* Auto-generated main method to display this JDialog
	*/
		
	public RecordingGesture(ObservationSequence OS,String iName,String gName) {
		super();
		this.imageName = iName;
		this.gestureName = gName;
		this.OS = OS;
		
		initGUI();
		controller = new Controller();
		//getObservationSequence();
		
	}
	
	public void getObservationSequence(){
		
	
		/*for(int i=4;i>=0;i--){
			try {
				
			Thread.sleep(1000);
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			timerLabel.setText(String.valueOf(i));
			//timerLabel.repaint();
			
		
		}
		while(Integer.parseInt(timerLabel.getText()) != 0){System.out.println(timerLabel.getText()+"     "+String.valueOf(0));}*/
		task = new TimerManager(controller,OS);
		task.start();
		while(OS.flag ==false){
			
		}
		this.dispose();

	
	}
	

	
	
	
	private void initGUI() {
		try {
			{
				BorderLayout thisLayout = new BorderLayout();
				this.setTitle("Recording Gesture");
				getContentPane().setLayout(thisLayout);
				{
					container = new JPanel();
					getContentPane().add(container, BorderLayout.CENTER);
					GridBagLayout containerLayout = new GridBagLayout();
					containerLayout.rowWeights = new double[] {0.1, 0.0, 0.1, 0.1};
					containerLayout.rowHeights = new int[] {7, 197, 7, 7};
					containerLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.1};
					containerLayout.columnWidths = new int[] {101, 183, 94, 7};
					container.setLayout(containerLayout);
					container.setPreferredSize(new java.awt.Dimension(651, 474));
					{
						jLabel2 = new JLabel();
						container.add(jLabel2, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 8), 0, 0));
						jLabel2.setPreferredSize(new java.awt.Dimension(301, 216));
						jLabel2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/"+imageName+".png")));
					}
					{
						jLabel1 = new JLabel();
						container.add(jLabel1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabel1.setPreferredSize(new java.awt.Dimension(151, 155));
						jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/A.png")));
					}
					{
						jLabel3 = new JLabel();
						container.add(jLabel3, new GridBagConstraints(0, 0, 5, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jLabel3.setText("Please perform the transition when the timer goes to 0");
						jLabel3.setFont(new java.awt.Font("Andalus",2,24));
						jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
					}
					{
						timerLabel = new JLabel();
						container.add(timerLabel, new GridBagConstraints(0, 2, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						timerLabel.setLayout(null);
						timerLabel.setText("5");
						timerLabel.setFocusable(true);
						timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
						timerLabel.setFont(new java.awt.Font("MV Boli",0,48));
						timerLabel.addFocusListener(new FocusAdapter() {
							public void focusGained(FocusEvent evt) {
								timerLabelFocusGained(evt);
							}
						});
					}
					{
						jLabel4 = new JLabel();
						container.add(jLabel4, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabel4.setText("to");
						jLabel4.setFont(new java.awt.Font("Arial",0,20));
						jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
					}
					{
						testButton = new JButton();
						container.add(testButton, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						testButton.setText("Start");
						testButton.setVisible(false);
						testButton.setFocusable(true);
						testButton.addFocusListener(new FocusAdapter() {
							public void focusGained(FocusEvent evt) {
								testButtonFocusGained(evt);
							}
						});

					}
				}

			}
			this.setSize(667, 478);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void testButtonFocusGained(FocusEvent evt) {
		new Thread(new Runnable() {
            @Override
            public void run() {
            	for(int i=4;i>=0;i--){
        			try {
        				
        			Thread.sleep(1000);
        			
        			} catch (InterruptedException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
        			
        			timerLabel.setText(String.valueOf(i));
        			//timerLabel.repaint();
        			
        		
        		}
            	timerLabel.setText("RECORDING。。。。。。");
        		task = new TimerManager(controller,OS);
        		task.start();
        		while(OS.flag ==false){
        			
        		}
        		dispose();
        		
           
            }
        }).start();
	}
	
	private void timerLabelFocusGained(FocusEvent evt) {
	
		//TODO add your code for timerLabel.focusGained
		new Thread(new Runnable() {
            @Override
            public void run() {
            	for(int i=4;i>=-1;i--){
        			try {
        				
        			Thread.sleep(1000);
        			
        			} catch (InterruptedException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
        			
        			timerLabel.setText(String.valueOf(i));
        			//timerLabel.repaint();
        			
        		
        		}
            	timerLabel.setText("recording.......");
        		task = new TimerManager(controller,OS);
        		task.start();
        		while(OS.flag ==false){
        			
        		}
        		dispose();
           
            }
        }).start();
	}

}
