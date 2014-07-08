package userInterface;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;


public class HelpPanel extends javax.swing.JFrame {
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public HelpPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setTitle("Help information");
			{
				scrollPane = new JScrollPane();
				getContentPane().add(scrollPane, BorderLayout.CENTER);
				{
					textArea = new JTextArea();
					scrollPane.setViewportView(textArea);
					textArea.setText("this system is ...");
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
