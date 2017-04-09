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
import aston.station.*;

public class PetrolGUI {

	// JFrame for the
	private JFrame mainFrame;
	private JFrame logFrame;
	private JSlider pSlider;
	private JSlider qSlider;
	private JSlider pumpSlider;
	private JSlider tillSlider;
	private JTextField stepField;
	private JTextField priceField;
	private JCheckBox truckCheck;
	JTextArea logOutput1 = new JTextArea();
	JTextArea logOutput2 = new JTextArea();
	JTextArea logOutput3 = new JTextArea();
	JTextArea logOutput4 = new JTextArea();
	// create simulation
	Simulator s = new Simulator();
	private PetrolStation petrol;	
	
	/**
	 * The GUI Simulation of the Petrol Pump Simulator
	 * 
	 */
	public PetrolGUI() {

		// Step 1: Create the components
		JLabel title = new JLabel();

		JLabel label1 = new JLabel();
		pSlider = new JSlider();
		JLabel slidePNum = new JLabel();

		JLabel label2 = new JLabel();
		qSlider = new JSlider();
		JLabel slideQNum = new JLabel();

		JLabel label5 = new JLabel();
		pumpSlider = new JSlider();
		JLabel pumpSlideNum = new JLabel();

		JLabel label6 = new JLabel();
		tillSlider = new JSlider();
		JLabel tillSlideNum = new JLabel();

		JLabel label3 = new JLabel();
		stepField = new JTextField();

		JLabel label4 = new JLabel();
		priceField = new JTextField();

		JButton runButton = new JButton();
		JButton quitButton = new JButton();

		JLabel label7 = new JLabel();
		truckCheck = new JCheckBox();

		// Step 2: Set the properties of the components
		title.setText("Petrol Simulator");
		label1.setText("Probability of p:");
		label2.setText("Probability of q:");
		label3.setText("Simulation Time (ticks):");
		label4.setText("Price per Gallon:");
		label5.setText("Number of Pumps:");
		label6.setText("Number of Tills:");
		label7.setText("With/Without Trucks:");
		// probabilityQ slider
		qSlider.setMinimum(1);
		qSlider.setMaximum(5);
		qSlider.setValue(0);
		qSlider.setMajorTickSpacing(1);
		qSlider.setToolTipText("Probability of Q");
		qSlider.setPaintTicks(true);
		slideQNum.setText("0.01");
		//// probabilityP slider
		pSlider.setMinimum(1);
		pSlider.setMaximum(5);
		pSlider.setValue(0);
		pSlider.setMajorTickSpacing(1);
		pSlider.setToolTipText("Probability of P");
		pSlider.setPaintTicks(true);
		slidePNum.setText("0.01");
		// numPump slider
		pumpSlider.setMinimum(0);
		pumpSlider.setMaximum(2);
		pumpSlider.setValue(0);
		pumpSlider.setMajorTickSpacing(1);
		pumpSlider.setPaintTicks(true);
		pumpSlider.setToolTipText("Number of Pumps");
		pumpSlideNum.setText("1");
		// numTill Slider
		tillSlider.setMinimum(0);
		tillSlider.setMaximum(2);
		tillSlider.setValue(0);
		tillSlider.setMajorTickSpacing(1);
		tillSlider.setPaintTicks(true);
		tillSlider.setToolTipText("Number of Tills");
		tillSlideNum.setText("1");
		// Step Field
		stepField.setText("10");
		// Price Field
		priceField.setText("1.20");
		// Button
		runButton.setText("Run Simulation");
		runButton.setToolTipText("Start the Simulation");
		quitButton.setText("Quit Simulation");
		quitButton.setToolTipText("Quit the Program");
		// Checkbox
		truckCheck.setSelected(false);

		// Step 3: Create containers to hold the components
		mainFrame = new JFrame("Petrol Simulator");
		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		// Step 4: Specify LayoutManagers
		mainFrame.setLayout(new BorderLayout());
		((JPanel) mainFrame.getContentPane()).setBorder(new EmptyBorder(6, 6, 6, 6));

		JPanel pPanel = new JPanel();
		pPanel.setLayout(new BorderLayout());
		pPanel.setBorder(new EmptyBorder(6, 6, 6, 6));

		JPanel qPanel = new JPanel();
		qPanel.setLayout(new BorderLayout());
		qPanel.setBorder(new EmptyBorder(6, 6, 6, 6));

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
		pPanel.add(label1, BorderLayout.WEST);
		pPanel.add(pSlider, BorderLayout.CENTER);
		pPanel.add(slidePNum, BorderLayout.EAST);

		qPanel.add(label2, BorderLayout.WEST);
		qPanel.add(qSlider, BorderLayout.CENTER);
		qPanel.add(slideQNum, BorderLayout.EAST);

		pumpPanel.add(label5, BorderLayout.WEST);
		pumpPanel.add(pumpSlider, BorderLayout.CENTER);
		pumpPanel.add(pumpSlideNum, BorderLayout.EAST);

		stepPanel.add(label3, BorderLayout.WEST);
		stepPanel.add(stepField, BorderLayout.CENTER);

		pricePanel.add(label4, BorderLayout.WEST);
		pricePanel.add(priceField, BorderLayout.CENTER);

		tillPanel.add(label6, BorderLayout.WEST);
		tillPanel.add(tillSlider, BorderLayout.CENTER);
		tillPanel.add(tillSlideNum, BorderLayout.EAST);

		truckPanel.add(label7, BorderLayout.WEST);
		truckPanel.add(truckCheck, BorderLayout.CENTER);

		paramTopPanel.add(pPanel, BorderLayout.NORTH);
		paramTopPanel.add(qPanel, BorderLayout.CENTER);
		paramTopPanel.add(pumpPanel, BorderLayout.SOUTH);

		paramBotPanel.add(tillPanel, BorderLayout.NORTH);
		paramBotPanel.add(stepPanel, BorderLayout.CENTER);
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

		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitApp();
			}
		});

		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startSimulation();
			}

		});

		pSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = ((JSlider) e.getSource()).getValue();
				slidePNum.setText("0.0" + value + "");

			}
		});

		qSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = ((JSlider) e.getSource()).getValue();
				slideQNum.setText("0.0" + value + "");

			}
		});

		pumpSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = ((JSlider) e.getSource()).getValue();
				int present = (int) Math.pow(2, value);
				pumpSlideNum.setText(present + "");

			}
		});

		tillSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = ((JSlider) e.getSource()).getValue();
				int present = (int) Math.pow(2, value);
				tillSlideNum.setText(present + "");

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
		int response = JOptionPane.showConfirmDialog(mainFrame, "Do you really want to quit?", "Quit?",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

		// Don't quit
	}

	private void newSimulation() {
		// Step 1: Create the components
		// JButton stopButton = new JButton();
		// JLabel titleLog = new JLabel();

		// Step 2: Set the properties of the components

		// Step 3: Create containers to hold the components

		// Step 4: Specify LayoutManagers

		// Step 5: Add components to containers

		// Step 6: Arrange to handle events in the user interface

		// Step 7: Display the GUI
	}

	/**
	 * Starts the Simulation Steps
	 */
	private void startSimulation() {
		
		// set config values
		s.config.setScProb((double) pSlider.getValue() / 100);
		s.config.setMProb((double) pSlider.getValue() / 100);
		s.config.setFsProb((double) qSlider.getValue() / 100);
		s.config.setNumPumps((int) Math.pow(2, pumpSlider.getValue()));
		s.config.setNumTills((int) Math.pow(2, tillSlider.getValue()));
		s.config.setNumSteps(Integer.parseInt(stepField.getText()));
		s.config.setPencePerGallon((int) (Double.parseDouble(priceField.getText()) * 100));

		// create PetrolStation
		s.createPetrolStation();

		// run simulation
		s.simulate(s.config.getNumSteps());

		/*
		 * Test System.out.println(s.config.getScProb());
		 * System.out.println(s.config.getMProb());
		 * System.out.println(s.config.getFsProb());
		 * System.out.println(s.config.getNumPumps());
		 * System.out.println(s.config.getNumTills());
		 * System.out.println(s.config.getNumSteps());
		 * System.out.println(s.config.getPencePerGallon());
		 */
		
		// Step 1: Create the components
		JButton stopButton = new JButton();
		JLabel titleLog = new JLabel();

		JLabel pumpLabel1 = new JLabel();
		JLabel pumpLabel2 = new JLabel();
		JLabel pumpLabel3 = new JLabel();
		JLabel pumpLabel4 = new JLabel();

		logOutput1.setEditable(false);
		JScrollPane listScroll1 = new JScrollPane(logOutput1);
		listScroll1.setPreferredSize(new Dimension(200, 200));
		listScroll1.setMinimumSize(new Dimension(100, 100));

		logOutput2.setEditable(false);
		JScrollPane listScroll2 = new JScrollPane(logOutput2);
		listScroll2.setPreferredSize(new Dimension(200, 200));
		listScroll2.setMinimumSize(new Dimension(100, 100));

		logOutput3.setEditable(false);
		JScrollPane listScroll3 = new JScrollPane(logOutput3);
		listScroll3.setPreferredSize(new Dimension(200, 200));
		listScroll3.setMinimumSize(new Dimension(100, 100));

		logOutput4.setEditable(false);
		JScrollPane listScroll4 = new JScrollPane(logOutput4);
		listScroll4.setPreferredSize(new Dimension(200, 200));
		listScroll4.setMinimumSize(new Dimension(100, 100));
		// Step 2: Set the properties of the components
		stopButton.setText("Stop");
		titleLog.setText("Simulation");
		pumpLabel1.setText("Pump 1");
		pumpLabel2.setText("Pump 2");
		pumpLabel3.setText("Pump 3");
		pumpLabel4.setText("Pump 4");

		// Step 3: Create containers to hold the components
		logFrame = new JFrame("Simulation");
		logFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		// Step 4: Specify LayoutManagers
		logFrame.setLayout(new BorderLayout());
		((JPanel) logFrame.getContentPane()).setBorder(new EmptyBorder(6, 6, 6, 6));

		JPanel logPanel = new JPanel();
		logPanel.setLayout(new BorderLayout());
		logPanel.setBorder(new EmptyBorder(6, 6, 6, 6));

		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setBorder(new EmptyBorder(6, 6, 6, 6));

		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setBorder(new EmptyBorder(6, 6, 6, 6));

		JPanel pump1Panel = new JPanel();
		pump1Panel.setLayout(new BorderLayout());
		pump1Panel.setBorder(new EmptyBorder(6, 6, 6, 6));

		JPanel pump2Panel = new JPanel();
		pump2Panel.setLayout(new BorderLayout());
		pump2Panel.setBorder(new EmptyBorder(6, 6, 6, 6));

		JPanel pump3Panel = new JPanel();
		pump3Panel.setLayout(new BorderLayout());
		pump3Panel.setBorder(new EmptyBorder(6, 6, 6, 6));

		JPanel pump4Panel = new JPanel();
		pump4Panel.setLayout(new BorderLayout());
		pump4Panel.setBorder(new EmptyBorder(6, 6, 6, 6));

		// Step 5: Add components to containers
		pump1Panel.add(pumpLabel1, BorderLayout.NORTH);
		pump1Panel.add(listScroll1, BorderLayout.SOUTH);

		pump2Panel.add(pumpLabel2, BorderLayout.NORTH);
		pump2Panel.add(listScroll2, BorderLayout.SOUTH);

		leftPanel.add(pump1Panel, BorderLayout.NORTH);
		leftPanel.add(pump2Panel, BorderLayout.SOUTH);

		pump3Panel.add(pumpLabel3, BorderLayout.NORTH);
		pump3Panel.add(listScroll3, BorderLayout.SOUTH);

		pump4Panel.add(pumpLabel4, BorderLayout.NORTH);
		pump4Panel.add(listScroll4, BorderLayout.SOUTH);

		rightPanel.add(pump3Panel, BorderLayout.NORTH);
		rightPanel.add(pump4Panel, BorderLayout.SOUTH);

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

		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Logic to stop then
				logFrame.dispose();
			}
		});
		
		// Step 7: Display the GUI
		logFrame.pack();
		logFrame.setVisible(true);
		

	}

	/**
	 * Makes the GUI Visible to the user
	 */
	public void guiVisible() {
		mainFrame.setVisible(true);
	}
}