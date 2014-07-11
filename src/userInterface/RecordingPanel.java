package userInterface;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class RecordingPanel extends javax.swing.JDialog {
	private JLabel pictureLabel;
	private JButton startButton;
	private JLabel instruLabel;

	/**
	* Auto-generated main method to display this JDialog
	*/
		
	public RecordingPanel() {

		initGUI();
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
					pictureLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/c.gif")));
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
					startButton.setText("Start");
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
		System.out.println("startButton.keyPressed, event="+evt);
		if(startButton.getText() =="Start"){
			startButton.setText("Press"+" "+"Enter"+" " +"to stop ");
	        //add code to do feature extraction
		}
		else{
			this.dispose();
			EnterGestureName inst = new EnterGestureName(); 
			inst.setVisible(true);
		}
		//TODO add your code for startButton.keyPressed
	}
	
	private void startButtonActionPerformed(ActionEvent evt) {
		System.out.println("startButton.actionPerformed, event="+evt);
		if(startButton.getText() =="Start"){
			startButton.setText("Press"+" "+"Enter"+" " +"to stop ");
	        //add code to do feature extraction
		}
		else{
			this.dispose();
			EnterGestureName inst = new EnterGestureName(); 
			inst.setVisible(true);
		}
		//TODO add your code for startButton.actionPerformed
	}

}
