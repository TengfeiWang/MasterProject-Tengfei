package userInterface;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class AlphabetPanel extends javax.swing.JFrame {
	private JScrollPane scrollPanel;
	private JPanel picturePanel;
	private JLabel pictureLabel;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public AlphabetPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Das deutsche Fingeralphabet");
			{
				scrollPanel = new JScrollPane();
				getContentPane().add(scrollPanel, BorderLayout.CENTER);
				{
					picturePanel = new JPanel();
					BorderLayout picturePanelLayout = new BorderLayout();
					picturePanel.setLayout(picturePanelLayout);
					scrollPanel.setViewportView(picturePanel);
					{
						pictureLabel = new JLabel();
						picturePanel.add(pictureLabel, BorderLayout.CENTER);
						pictureLabel.setPreferredSize(new java.awt.Dimension(597, 1350));
						pictureLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/Fingeralphabet.png")));
					}
				}
			}
			pack();
			this.setSize(419, 341);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
