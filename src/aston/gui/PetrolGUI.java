package aston.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import aston.gui.*;
import aston.resources.*;
import aston.simulator.*;

public class PetrolGUI {
	
	//JFrame for the 
	private JFrame mainFrame;
	private JFrame logFrame;
	private JSlider pSlider;
	private JSlider qSlider;
	private JTextField stepField;
	private JTextField priceField;
	private JCheckBox truckCheck;
	
	/**
	 * The GUI Simulation of the Petrol Pump Simulator 
	 * 
	 */
	public PetrolGUI(){
		
		// Step 1: Create the components
		JLabel title = new JLabel();
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		JLabel label4 = new JLabel();
		pSlider = new JSlider(1,5);
		JLabel slidePNum = new JLabel();
		qSlider = new JSlider(1,5);
		JLabel slideQNum = new JLabel();
		stepField = new JTextField();
		priceField = new JTextField();
		JButton runButton = new JButton();
		JButton quitButton = new JButton();
		JLabel label5 = new JLabel();
		truckCheck = new JCheckBox();
		
		// Step 2: Set the properties of the components 
		title.setText("Petrol Simulator");
		label1.setText("Probability of p:");
		label2.setText("Probability of q:");
		label3.setText("Simulation Time (steps):");
		label4.setText("Price per Gallon:");
		label5.setText("With/Without Trucks:");
			//numPump slider
		pSlider.setMinimum(1);
		pSlider.setMaximum(5);
		pSlider.setValue(0);
		pSlider.setMajorTickSpacing(1);
		pSlider.setToolTipText("Number of Petrol Pumps");
		pSlider.setPaintTicks(true);
		slidePNum.setText("0.01");
			//numTill slider
		qSlider.setMinimum(0);
		qSlider.setMaximum(2);
		qSlider.setValue(0);
		qSlider.setMajorTickSpacing(1);
		qSlider.setPaintTicks(true);
		slideQNum.setText("1");
			//Step Field
		stepField.setText("0");
			//Price Field
		priceField.setText("12.34");
			//Button
		runButton.setText("Run Simulation");
		runButton.setToolTipText("Start the Simulation");
		quitButton.setText("Quit Simulation");
		quitButton.setToolTipText("Quit the Program");
			//Checkbox
		truckCheck.setSelected(false);
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
		
		JPanel truckPanel = new JPanel();
		truckPanel.setLayout(new BorderLayout());
		truckPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel paramPanel = new JPanel();	
		paramPanel.setLayout(new BorderLayout());
		paramPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel paramTopPanel = new JPanel();	
		paramTopPanel.setLayout(new BorderLayout());
		paramTopPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel paramBotPanel = new JPanel();	
		paramBotPanel.setLayout(new BorderLayout());
		paramBotPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		// Step 5: Add components to containers 
		pumpPanel.add(label1, BorderLayout.WEST);
		pumpPanel.add(pSlider, BorderLayout.CENTER);
		pumpPanel.add(slidePNum, BorderLayout.EAST);
		
		tillPanel.add(label2,BorderLayout.WEST);
		tillPanel.add(qSlider, BorderLayout.CENTER);
		tillPanel.add(slideQNum, BorderLayout.EAST);
		
		stepPanel.add(label3,BorderLayout.WEST);
		stepPanel.add(stepField, BorderLayout.CENTER);
		
		pricePanel.add(label4, BorderLayout.WEST);
		pricePanel.add(priceField, BorderLayout.CENTER);
		
		truckPanel.add(label5, BorderLayout.WEST);
		truckPanel.add(truckCheck, BorderLayout.CENTER);
		
		paramTopPanel.add(pumpPanel, BorderLayout.NORTH);
		paramTopPanel.add(tillPanel, BorderLayout.SOUTH);
		
		paramBotPanel.add(stepPanel, BorderLayout.NORTH);
		paramBotPanel.add(pricePanel, BorderLayout.SOUTH);
		
		buttonPanel.add(runButton, BorderLayout.WEST);
		buttonPanel.add(quitButton, BorderLayout.EAST);
		
		paramPanel.add(paramTopPanel, BorderLayout.NORTH);
		paramPanel.add(paramBotPanel, BorderLayout.CENTER);
		paramPanel.add(truckPanel, BorderLayout.SOUTH);
		
		mainFrame.add(title, BorderLayout.NORTH);
		mainFrame.add(paramPanel, BorderLayout.CENTER);
		mainFrame.add(buttonPanel, BorderLayout.SOUTH);
		
		// Step 6: Arrange to handle events in the user interface
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exitApp();
			}
		});
		
		quitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				exitApp();
			}
		});
		
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				startSimulation();
			}
				
		});
		
		pSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				int value = ((JSlider)e.getSource()).getValue();
				slidePNum.setText("0.0" + value + "");
				
			}
		});
		
		qSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				int value = ((JSlider)e.getSource()).getValue();
				int present = (int) Math.pow(2, value);
				slideQNum.setText(present + "");
				
			}
		});
		
		// Step 7: Display the GUI
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	/**
	 * Helper method to ensure consistency in leaving application.
	 */
	private void exitApp() {
		// Display confirmation dialog before exiting application
		int response = JOptionPane.showConfirmDialog(mainFrame, 
				"Do you really want to quit?",
				"Quit?",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
		// Don't quit
	}
	
	/**
	 * Starts the Simulation Steps
	 */
	private void startSimulation(){
		//Link Simulator Logic
		
		// Step 1: Create the components
		JButton stopButton = new JButton();
		JLabel titleLog = new JLabel();
		
		JTextArea logOutput1 = new JTextArea();
		JTextArea logOutput2 = new JTextArea();
		JTextArea logOutput3 = new JTextArea();
		JTextArea logOutput4 = new JTextArea();
		
		logOutput1.setEditable(false);
		JScrollPane listScroll1 = new JScrollPane(logOutput1);
		listScroll1.setPreferredSize(new Dimension(300, 300));
		listScroll1.setMinimumSize(new Dimension(200,200));
		
		logOutput2.setEditable(false);
		JScrollPane listScroll2 = new JScrollPane(logOutput2);
		listScroll2.setPreferredSize(new Dimension(300, 300));
		listScroll2.setMinimumSize(new Dimension(200,200));
		
		logOutput3.setEditable(false);
		JScrollPane listScroll3 = new JScrollPane(logOutput3);
		listScroll3.setPreferredSize(new Dimension(300, 300));
		listScroll3.setMinimumSize(new Dimension(200,200));
		
		logOutput4.setEditable(false);
		JScrollPane listScroll4 = new JScrollPane(logOutput4);
		listScroll4.setPreferredSize(new Dimension(300, 300));
		listScroll4.setMinimumSize(new Dimension(200,200));
		// Step 2: Set the properties of the components
		stopButton.setText("Stop");
		titleLog.setText("Simulation");
		
		// Step 3: Create containers to hold the components
		logFrame = new JFrame("Simulation");
		logFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		logFrame.setVisible(true);
		// Step 4: Specify LayoutManagers
		logFrame.setLayout(new BorderLayout());	
		((JPanel)logFrame.getContentPane()).setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel logPanel = new JPanel();
		logPanel.setLayout(new BorderLayout());
		logPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		// Step 5: Add components to containers
		leftPanel.add(listScroll1, BorderLayout.NORTH);
		leftPanel.add(listScroll2, BorderLayout.SOUTH);
		
		rightPanel.add(listScroll3, BorderLayout.NORTH);
		rightPanel.add(listScroll4, BorderLayout.NORTH);
		
		logPanel.add(leftPanel, BorderLayout.WEST);
		logPanel.add(rightPanel, BorderLayout.EAST);
		
		logFrame.add(titleLog, BorderLayout.NORTH);
		logFrame.add(logPanel, BorderLayout.NORTH);
		logFrame.add(stopButton, BorderLayout.SOUTH);
		// Step 6: Arrange to handle events in the user interface
		logFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				logFrame.dispose();
			}
		});
		
		stopButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Logic to stop then
				logFrame.dispose();
			}
		});
		
		// Step 7: Display the GUI
		logFrame.pack(); 
		//logFrame.setVisible(true);
	}
	
	/**
	 * Takes the input from the MainFrame and passes to the 
	 */
	public void update(){
		int var1 = pSlider.getValue();
		int var2 = qSlider.getValue();
		String var3 = stepField.getText();
		String var4 = priceField.getText();
		boolean withTrucks = truckCheck.isSelected();
	}
	
	/**
	 * Makes the GUI Visible to the user 
	 */
	public void guiVisible(){
		mainFrame.setVisible(true);
	}
}