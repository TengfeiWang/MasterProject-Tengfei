package dataCollection;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
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
public class DataRecording extends javax.swing.JFrame {
	private  TimerManager task;
    public  Controller controller;
    //public  List<ObservationVector> observationSequence = null;
    public  ObservationSequence OS;
    private String gestureName;
    public JTextField jTextField1;
    private JPanel container;
    private String imageName;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public DataRecording(ObservationSequence OS,String iName,String gName) {
		super();
		initGUI();
		this.imageName = iName;
		this.gestureName = gName;
		this.OS = OS;
		controller = new Controller();

	
	}
	
	/*public void getObservationSequence(){
		
		for(int i=4;i>=0;i--){
			try {
			
			Thread.sleep(1000);
		
			jTextField1.setText(String.valueOf(i));	
			
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		while(Integer.parseInt(jTextField1.getText()) != 0){System.out.println(jTextField1.getText()+"     "+String.valueOf(0));}
		task = new TimerManager(controller,OS);
		task.start();
		while(OS.flag ==false){
			//System.out.println("caocaocoacoaocoaocaocoaoc");
		}
		dispose();

	
	}*/
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Data Collection");
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			{
				jTextField1 = new JTextField();
				jTextField1.setText("5");
				jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
				getContentPane().add(jTextField1, BorderLayout.CENTER);
				
			
			}

			//pack();
			this.setSize(522, 412);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
