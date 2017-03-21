package aston.gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import aston.gui.*;
import aston.resources.*;
import aston.simulator.*;

public class PetrolGUI {
	
	//JFrame for the 
	private JFrame mainFrame;
	private Object o;
	private JTextArea logOutput;
	
	/**
	 * The GUI Simulation of the Petrol Pump Simulator 
	 * 
	 * @param Object o
	 */
	public PetrolGUI(Object o){
		this.o = o;
		
		// Step 1: Create the components
		JLabel title = new JLabel();
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		JLabel label4 = new JLabel();
		JSlider pSlider = new JSlider(1,4);
		JSlider qSlider = new JSlider(1,4);
		JTextField stepField = new JTextField();
		JTextField priceField = new JTextField();
		JButton runButton = new JButton();
		
		// Step 2: Set the properties of the components 
		title.setText("Petrol Simulator");
		label1.setText("Probability of p:");
		label2.setText("Probability of q:");
		label3.setText("Simulation Time (steps):");
		label4.setText("Price per Gallon:");
			//numPump slider
		pSlider.setMinimum(1);
		pSlider.setMaximum(4);
		pSlider.setValue(1);
		pSlider.setMajorTickSpacing(1);
		pSlider.setToolTipText("Number of Petrol Pumps");
			//numTill slider
		qSlider.setMinimum(1);
		qSlider.setMaximum(4);
		qSlider.setValue(1);
		qSlider.setMajorTickSpacing(1);
			//Step Field
		stepField.setText("");
			//Price Field
		priceField.setText("");
			//Button
		runButton.setText("Run Simulation");
		runButton.setToolTipText("Start the Simulation");
		// Step 3: Create containers to hold the components
		mainFrame = new JFrame("Petrol Simulator");
		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		// Step 4: Specify LayoutManagers
		mainFrame.setLayout(new BorderLayout());	
		((JPanel)mainFrame.getContentPane()).setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel pumpPanel = new JPanel();
		pumpPanel.setLayout(new BorderLayout());
		pumpPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel tillPanel = new JPanel();
		tillPanel.setLayout(new BorderLayout());
		tillPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel stepPanel = new JPanel();
		stepPanel.setLayout(new BorderLayout());
		stepPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel pricePanel = new JPanel();
		pricePanel.setLayout(new BorderLayout());
		pricePanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel paramPanel = new JPanel();	
		paramPanel.setLayout(new BorderLayout());
		paramPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel paramTopPanel = new JPanel();	
		paramTopPanel.setLayout(new BorderLayout());
		paramTopPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel paramBotPanel = new JPanel();	
		paramBotPanel.setLayout(new BorderLayout());
		paramBotPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		// Step 5: Add components to containers 
		pumpPanel.add(label1, BorderLayout.WEST);
		pumpPanel.add(pSlider, BorderLayout.CENTER);
		
		tillPanel.add(label2,BorderLayout.WEST);
		tillPanel.add(qSlider, BorderLayout.CENTER);
		
		stepPanel.add(label3,BorderLayout.WEST);
		stepPanel.add(stepField, BorderLayout.CENTER);
		
		pricePanel.add(label4, BorderLayout.WEST);
		pricePanel.add(priceField, BorderLayout.CENTER);
		
		paramTopPanel.add(pumpPanel, BorderLayout.NORTH);
		paramTopPanel.add(tillPanel, BorderLayout.SOUTH);
		
		paramBotPanel.add(stepPanel, BorderLayout.NORTH);
		paramBotPanel.add(stepPanel, BorderLayout.SOUTH);
		
		paramPanel.add(paramTopPanel, BorderLayout.NORTH);
		paramPanel.add(paramBotPanel, BorderLayout.CENTER);
		
		mainPanel.add(title, BorderLayout.NORTH);
		mainPanel.add(paramPanel, BorderLayout.CENTER);
		mainPanel.add(runButton, BorderLayout.SOUTH);
		
		// Step 6: Arrange to handle events in the user interface
		
		// Step 7: Display the GUI
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
}
