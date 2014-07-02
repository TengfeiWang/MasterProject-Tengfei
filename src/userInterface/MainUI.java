package userInterface;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

public class MainUI extends JFrame {

    JLabel statusbar;

    public MainUI() {

        initUI();
    }

    public final void initUI() {
    	
         	
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 350, 700);
        JButton dataCollection = new JButton("Data Collection");
        dataCollection.setBounds(40, 30, 100 , 40);
        dataCollection.addActionListener(new ButtonListener());

        JButton training = new JButton("Training");
        training.setBounds(40, 80, 100, 40);
        training.addActionListener(new ButtonListener());

        JButton recognition = new JButton("Recognition");
        recognition.setBounds(40, 130, 100, 40);
        recognition.addActionListener(new ButtonListener());

        JButton evaluation = new JButton("Evaluation");
        evaluation.setBounds(40, 180, 100, 40);
        evaluation.addActionListener(new ButtonListener());

        panel.add(dataCollection);
        panel.add(training);
        panel.add(recognition);
        panel.add(evaluation);

        statusbar = new JLabel(" Developed by Tengfei Wang");

        statusbar.setBorder(BorderFactory.createEtchedBorder(
                EtchedBorder.RAISED));


        add(statusbar, BorderLayout.SOUTH);
        
        JPanel recognitionPanel = new JPanel();
        recognitionPanel.setLayout(null);
        recognitionPanel.setBounds(350, 0, 350, 350);
        JButton deleteSample = new JButton("Delete Sample");
        deleteSample.setBounds(400, 40, 100, 40);
        recognitionPanel.add(deleteSample);
    
        

        add(panel);
        add(recognitionPanel);
        setTitle("German Fingerspelling Recognition");
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton o = (JButton) e.getSource();
            String label = o.getText();
            statusbar.setText(" " + label + " button clicked");
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                MainUI ui = new MainUI();
                ui.setVisible(true);
            }
        });
    }
}
