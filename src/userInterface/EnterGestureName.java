package userInterface;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class EnterGestureName extends javax.swing.JFrame {
	private JLabel instrucLabel;
	private JButton okButtton;
	private JTextField gestureNameField;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public EnterGestureName() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			GridBagLayout thisLayout = new GridBagLayout();
			this.setTitle("Enter Gesture Name");
			thisLayout.rowWeights = new double[] {0.0, 0.0, 0.1, 0.1};
			thisLayout.rowHeights = new int[] {68, 86, 7, 7};
			thisLayout.columnWeights = new double[] {0.0, 0.0, 0.1, 0.1};
			thisLayout.columnWidths = new int[] {53, 270, 7, 7};
			getContentPane().setLayout(thisLayout);
			{
				instrucLabel = new JLabel();
				getContentPane().add(instrucLabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
				instrucLabel.setText("Please Enter the name of the gesture(e.g. AB)");
				instrucLabel.setFont(new java.awt.Font("Arial",0,14));
			}
			{
				gestureNameField = new JTextField();
				getContentPane().add(gestureNameField, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(26, 30, 26, 30), 0, 0));
			}
			{
				okButtton = new JButton();
				getContentPane().add(okButtton, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(19, 55, 27, 55), 0, 0));
				okButtton.setText("OK");
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
