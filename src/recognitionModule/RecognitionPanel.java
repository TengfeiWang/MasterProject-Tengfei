package recognitionModule;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import be.ac.ulg.montefiore.run.jahmm.ObservationVector;

import com.leapmotion.leap.Controller;

import util.ObservationSequence;
import util.TimerManager;

public class RecognitionPanel extends javax.swing.JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton jButton1;
	private JLabel jLabel1;
	private TimerManager task;
    private Controller controller;
    public  List<ObservationVector> observationSequence = null;
    public ObservationSequence OS;
	/**
	* Auto-generated main method to display this JDialog
	*/
		
	public RecognitionPanel(ObservationSequence OS) {
		this.OS = OS;
		initGUI();
		controller = new Controller();
	}
	
	private void initGUI() {
		try {
			{
				contentPane = new JPanel();
				GridBagLayout contentPaneLayout = new GridBagLayout();
				contentPaneLayout.columnWidths = new int[] {41, 307, 7, 7};
				contentPaneLayout.rowHeights = new int[] {32, 45, 42, 7};
				contentPaneLayout.columnWeights = new double[] {0.0, 0.0, 0.1, 0.1};
				contentPaneLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
				getContentPane().add(contentPane, BorderLayout.CENTER);
				contentPane.setLayout(contentPaneLayout);
				{
					jLabel1 = new JLabel();
					contentPane.add(jLabel1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabel1.setText("Please press \"ENTER\" to start recording");
				}
				{
					jButton1 = new JButton();
					contentPane.add(jButton1, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jButton1.setText("START");
					jButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							startButtonActionPerformed(evt);
						}
					});
				
					jButton1.addKeyListener(new KeyAdapter() {
						public void keyPressed(KeyEvent evt) {
							startButtonKeyPressed(evt);
						}
					});
				}
			}
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void startButtonKeyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		if(jButton1.getText() !="Stop"){
			task = new TimerManager(controller);
			task.start();
			jButton1.setText("Stop");
		}
		else{
			OS.observationSequence= task.stop();
			System.out.println(observationSequence);
			this.dispose();
		}
	}

	protected void startButtonActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if(jButton1.getText() !="Stop"){
			task = new TimerManager(controller);
			task.start();
			jButton1.setText("Stop");
		}
		else{
			OS.observationSequence= task.stop();
			System.out.println(observationSequence);
			this.dispose();
		}
		
	}

}
