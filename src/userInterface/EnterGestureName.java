package userInterface;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;


public class EnterGestureName extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel instrucLabel;
	private JButton okButton;
	private JTextField gestureNameField;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public EnterGestureName() {
		super();
		initGUI();
	}
	

	private void okButtonActionPerformed(ActionEvent evt) {
		// if OK is clicked,we rename the tempfile.seq to "the name of the gesture".seq
		String gestureName = gestureNameField.getText();
		if(gestureName.length() ==0){
			JOptionPane.showMessageDialog(null, "Please enter the name!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else{
		    File newFile = new File("sequencedata/"+gestureName+".seq");
		    		  System.out.println(gestureName);
		    File oldFile = new File("sequencedata/tempfile.seq");
		    oldFile.renameTo(newFile);
		    this.dispose();
		}
		
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
				okButton = new JButton();
				getContentPane().add(okButton, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(19, 55, 27, 55), 0, 0));
				okButton.setText("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						okButtonActionPerformed(evt);
					}

				});
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
