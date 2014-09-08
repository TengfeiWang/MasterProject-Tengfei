package userInterface;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import be.ac.ulg.montefiore.run.jahmm.ObservationVector;
import com.leapmotion.leap.Controller;

import util.ObservationSequence;
import util.TimerManager;



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
public class RecordingPanel extends javax.swing.JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel pictureLabel;
	private JButton startButton;
	private JLabel instruLabel;
	private TimerManager task;
    private Controller controller;
    private int obsIndex;
    private String gestureName;
    public  List<ObservationVector> observationSequence = null;
    public ObservationSequence OS;
	/**
	* Auto-generated main method to display this JDialog
	*/


	public RecordingPanel(int index ,String name,ObservationSequence OS) {
		this.OS = OS;
        obsIndex = index+1;
        gestureName=name;
		initGUI();
		controller = new Controller();
		
	}
	
	public List<ObservationVector> getObservationSequence(){
		return observationSequence;
	}
	
	private void initGUI() {
		try {
			{
				setTitle("Recording Gesture");
				GridBagLayout thisLayout = new GridBagLayout();
				thisLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
				thisLayout.rowHeights = new int[] {7, 7, 7, 7};
				thisLayout.columnWeights = new double[] {0.0, 0.0, 0.1, 0.1};
				thisLayout.columnWidths = new int[] {35, 470, 7, 7};
				getContentPane().setLayout(thisLayout);
				{
					//Icon image = new ImageIcon("image\\a.png"); 
					//image.setImage(image.getImage().getScaledInstance(WIDTH,HEIGHT,Image.SCALE_DEFAULT)); 
					pictureLabel = new JLabel();
					getContentPane().add(pictureLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(6, 0, 7, 0), 0, 0));
					pictureLabel.setVisible(true);
					pictureLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/example.gif")));
				}
				{
					instruLabel = new JLabel();
					getContentPane().add(instruLabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
					instruLabel.setText("Plesae start with letter A showed in the picture and press \"Enter\" to start");
				}
				{
					startButton = new JButton();
					getContentPane().add(startButton, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 100, 0, 100), 0, 0));
					startButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							startButtonActionPerformed(evt);
						}
					});
					startButton.setText("Start"+" recording observation "+obsIndex+" for "+gestureName);
					startButton.addKeyListener(new KeyAdapter() {
						public void keyPressed(KeyEvent evt) {
							startButtonKeyPressed(evt);
						}
					});
				}
			}

			this.setSize(561, 474);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void startButtonKeyPressed(KeyEvent evt) {
		//System.out.println("startButton.keyPressed, event="+evt);

		if(startButton.getText() !="Stop"){
			//startButton.setText("Press"+" "+"Enter"+" " +"to stop ");
	        //add code to do feature extraction

			//FeatureExtractor fe =new FeatureExtractor();
			//fe.getFeatureVector( controller);
			task = new TimerManager(controller,OS);
			task.start();
			
			startButton.setText("Stop");
			while(OS.flag ==false){
				
			}
			this.dispose();
		}
		else{
			task.stop();
			System.out.println(OS.observationSequence);
			this.dispose();
		}
		//TODO add your code for startButton.keyPressed
	}
	
	private void startButtonActionPerformed(ActionEvent evt) {
		//System.out.println("startButton.actionPerformed, event="+evt);
		if(startButton.getText() != "Stop"){

	        
			//FeatureExtractor fe =new FeatureExtractor();
			//fe.getFeatureVector( controller);
			
			task = new TimerManager(controller,OS);
			task.start();
			startButton.setText("Stop"); 

			//startButton.setText("Press"+" "+"Enter"+" " +"to stop ");
	        //add code to do feature extraction
		}
		else{
			//OS.observationSequence = task.stop();
			this.dispose();
		}
		//TODO add your code for startButton.actionPerformed
	}



}
