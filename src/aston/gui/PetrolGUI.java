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

	// JFrame for the Parameter Setting
	private JFrame mainFrame;
	
	private JSlider pSlider;
	private JSlider qSlider;
	private JSlider pumpSlider;
	private JSlider tillSlider;
	private JTextField stepField;
	private JTextField priceField;
	private JCheckBox truckCheck;
	
	// JFrame for the Simulation in Action
	private JFrame logFrame;
	
		//Pump Row 1
	JTextField pump1Text11;
	JTextField pump1Text12;
	JTextField pump1Text13;
	JTextField pump1Text14;
		//Pump Row 2
	JTextField pump1Text21;
	JTextField pump1Text22;
	JTextField pump1Text23;
	JTextField pump1Text24;
		//Pump Row 3
	JTextField pump1Text31;
	JTextField pump1Text32;
	JTextField pump1Text33;
	JTextField pump1Text34;
		//Pump Row 4
	JTextField pump1Text41;
	JTextField pump1Text42;
	JTextField pump1Text43;
	JTextField pump1Text44;
		//Till Row 1
	JTextField till1Text11;
	JTextField till1Text12;
	JTextField till1Text13;
	JTextField till1Text14;
		//Till Row 2
	JTextField till1Text21;
	JTextField till1Text22;
	JTextField till1Text23;
	JTextField till1Text24;
	
		//Till Row 3
	JTextField till1Text31;
	JTextField till1Text32;
	JTextField till1Text33;
	JTextField till1Text34;
		//Till Row 4
	JTextField till1Text41;
	JTextField till1Text42;
	JTextField till1Text43;
	JTextField till1Text44;
	
	// create simulation
	private Simulator s = new Simulator(this);
	private PetrolStation petrol;	

	/**
	 * The GUI Simulation of the Petrol Pump Simulator
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
		title.setText("Petrol Simulator Parameters");
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
				//oldSimulation();
				newSimulation();
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
	 * Closes the Program
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

	/**
	 * New GUI Simulation presenting the Pump's/Till's queue
	 */
	private void newSimulation() {
		// Step 1: Create the components
		JButton stopButton = new JButton();
		JLabel titleLog = new JLabel();
		
		JLabel ticksStep = new JLabel();
		JLabel simMoney = new JLabel();
		JLabel simLoss = new JLabel();

		//Pumps
			//Row 1
		JLabel pumpLabel1 = new JLabel();

		pump1Text11 = new JTextField(10);
		pump1Text11.setEditable(false);
		pump1Text12 = new JTextField(10);
		pump1Text12.setEditable(false);
		pump1Text13 = new JTextField(10);
		pump1Text13.setEditable(false);
		pump1Text14 = new JTextField(10);
		pump1Text14.setEditable(false);
		
		JLabel pumpCost1 = new JLabel();
			//Row 2
		JLabel pumpLabel2 = new JLabel();

		pump1Text21 = new JTextField(10);
		pump1Text21.setEditable(false);
		pump1Text22 = new JTextField(10);
		pump1Text22.setEditable(false);
		pump1Text23 = new JTextField(10);
		pump1Text23.setEditable(false);
		pump1Text24 = new JTextField(10);
		pump1Text24.setEditable(false);
		
		JLabel pumpCost2 = new JLabel();
			//Row 3
		JLabel pumpLabel3 = new JLabel();
		
		pump1Text31 = new JTextField(10);
		pump1Text31.setEditable(false);
		pump1Text32 = new JTextField(10);
		pump1Text32.setEditable(false);
		pump1Text33 = new JTextField(10);
		pump1Text33.setEditable(false);
		pump1Text34 = new JTextField(10);
		pump1Text34.setEditable(false);
		
		JLabel pumpCost3 = new JLabel();
			//Row 4
		JLabel pumpLabel4 = new JLabel();
		
		pump1Text41 = new JTextField(10);
		pump1Text41.setEditable(false);
		pump1Text42 = new JTextField(10);
		pump1Text42.setEditable(false);
		pump1Text43 = new JTextField(10);
		pump1Text43.setEditable(false);
		pump1Text44 = new JTextField(10);
		pump1Text44.setEditable(false);
		
		JLabel pumpCost4 = new JLabel();
		
		//Tills
			//Row 1
		JLabel tillLabel1 = new JLabel();
	
		till1Text11 = new JTextField(10);
		till1Text11.setEditable(false);
		till1Text12 = new JTextField(10);
		till1Text12.setEditable(false);
		till1Text13 = new JTextField(10);
		till1Text13.setEditable(false);
		till1Text14 = new JTextField(10);
		till1Text14.setEditable(false);
		
		JLabel tillCost1 = new JLabel();
			//Row 2
		JLabel tillLabel2 = new JLabel();
	
		till1Text21 = new JTextField(10);
		till1Text21.setEditable(false);
		till1Text22 = new JTextField(10);
		till1Text22.setEditable(false);
		till1Text23 = new JTextField(10);
		till1Text23.setEditable(false);
		till1Text24 = new JTextField(10);
		till1Text24.setEditable(false);
		
		JLabel tillCost2 = new JLabel();
			//Row 3
		JLabel tillLabel3 = new JLabel();
		
		till1Text31 = new JTextField(10);
		till1Text31.setEditable(false);
		till1Text32 = new JTextField(10);
		till1Text32.setEditable(false);
		till1Text33 = new JTextField(10);
		till1Text33.setEditable(false);
		till1Text34 = new JTextField(10);
		till1Text34.setEditable(false);
		
		JLabel tillCost3 = new JLabel();
			//Row 4
		JLabel tillLabel4 = new JLabel();
		
		till1Text41 = new JTextField(10);
		till1Text41.setEditable(false);
		till1Text42 = new JTextField(10);
		till1Text42.setEditable(false);
		till1Text43 = new JTextField(10);
		till1Text43.setEditable(false);
		till1Text44 = new JTextField(10);
		till1Text44.setEditable(false);
		
		JLabel tillCost4 = new JLabel();
		
		// Step 2: Set the properties of the components
		titleLog.setText("Petrol Station Simulation");
		pumpLabel1.setText("Pump: 1");
		pumpLabel2.setText("Pump: 2");
		pumpLabel3.setText("Pump: 3");
		pumpLabel4.setText("Pump: 4");
		
		pumpCost1.setText("Cost: ");
		pumpCost2.setText("Cost: ");
		pumpCost3.setText("Cost: ");
		pumpCost4.setText("Cost: ");
		
		tillLabel1.setText("Till: 1");
		tillLabel2.setText("Till: 2");
		tillLabel3.setText("Till: 3");
		tillLabel4.setText("Till: 4");
		
		tillCost1.setText("Cost: ");
		tillCost2.setText("Cost: ");
		tillCost3.setText("Cost: ");
		tillCost4.setText("Cost: ");
		
		ticksStep.setText("Step: \t");
		simMoney.setText("Amount of Money Gained: \t");
		simLoss.setText("Money Missed: \t");
		
		stopButton.setText("Close Current Simulation");
		
		// Step 3: Create containers to hold the components
		logFrame = new JFrame("Station Simulation");
		logFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		// Step 4: Specify LayoutManagers
		logFrame.setLayout(new BorderLayout());
		((JPanel) logFrame.getContentPane()).setBorder(new EmptyBorder(12, 12, 12, 12));

			//Title Info Panel
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
			//Simulation Info Panel
		JPanel simPanel = new JPanel();
		simPanel.setLayout(new BorderLayout());
		simPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
			//Main Pump Panel
		JPanel pumpsPanel = new JPanel();
		pumpsPanel.setLayout(new BorderLayout());
		pumpsPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
			//Stores First 2 Pumps
		JPanel topPumps = new JPanel();
		topPumps.setLayout(new BorderLayout());
		topPumps.setBorder(new EmptyBorder(6, 6, 6, 6));
			//Stores Last 2 Pumps
		JPanel bottomPumps = new JPanel();
		bottomPumps.setLayout(new BorderLayout());
		bottomPumps.setBorder(new EmptyBorder(6, 6, 6, 6));

			//Pump 1
		JPanel pump1 = new JPanel();
		pump1.setLayout(new BorderLayout());
		pump1.setBorder(new EmptyBorder(6, 6, 6, 6));
			//Left Pump 1
		JPanel leftSidePump1 = new JPanel();
		leftSidePump1.setLayout(new BorderLayout());
		leftSidePump1.setBorder(new EmptyBorder(6, 6, 6, 6));
			//Right Pump 1
		JPanel rightSidePump1 = new JPanel();
		rightSidePump1.setLayout(new BorderLayout());
		rightSidePump1.setBorder(new EmptyBorder(6, 6, 6, 6));
		
			//Pump 2
		JPanel pump2 = new JPanel();
		pump2.setLayout(new BorderLayout());
		pump2.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel leftSidePump2 = new JPanel();
		leftSidePump2.setLayout(new BorderLayout());
		leftSidePump2.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel rightSidePump2 = new JPanel();
		rightSidePump2.setLayout(new BorderLayout());
		rightSidePump2.setBorder(new EmptyBorder(6, 6, 6, 6));
		
			//Pump 3
		JPanel pump3 = new JPanel();
		pump3.setLayout(new BorderLayout());
		pump3.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel leftSidePump3 = new JPanel();
		leftSidePump3.setLayout(new BorderLayout());
		leftSidePump3.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel rightSidePump3 = new JPanel();
		rightSidePump3.setLayout(new BorderLayout());
		rightSidePump3.setBorder(new EmptyBorder(6, 6, 6, 6));
		
			//Pump 4
		JPanel pump4 = new JPanel();
		pump4.setLayout(new BorderLayout());
		pump4.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel leftSidePump4 = new JPanel();
		leftSidePump4.setLayout(new BorderLayout());
		leftSidePump4.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel rightSidePump4 = new JPanel();
		rightSidePump4.setLayout(new BorderLayout());
		rightSidePump4.setBorder(new EmptyBorder(6, 6, 6, 6));
		
			//Main Till Panel
		JPanel tillsPanel = new JPanel();
		tillsPanel.setLayout(new BorderLayout());
		tillsPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
		
			//Stores First 2 Tills
		JPanel topTills = new JPanel();
		topTills.setLayout(new BorderLayout());
		topTills.setBorder(new EmptyBorder(6, 6, 6, 6));
			//Stores Last 2 Tills
		JPanel bottomTills = new JPanel();
		bottomTills.setLayout(new BorderLayout());
		bottomTills.setBorder(new EmptyBorder(6, 6, 6, 6));
		
			//Till 1
		JPanel till1 = new JPanel();
		till1.setLayout(new BorderLayout());
		till1.setBorder(new EmptyBorder(6, 6, 6, 6));
			//Left Till 1
		JPanel leftSideTill1 = new JPanel();
		leftSideTill1.setLayout(new BorderLayout());
		leftSideTill1.setBorder(new EmptyBorder(6, 6, 6, 6));
			//Right Till 1
		JPanel rightSideTill1 = new JPanel();
		rightSideTill1.setLayout(new BorderLayout());
		rightSideTill1.setBorder(new EmptyBorder(6, 6, 6, 6));
		
			//Till 2
		JPanel till2 = new JPanel();
		till2.setLayout(new BorderLayout());
		till2.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel leftSideTill2 = new JPanel();
		leftSideTill2.setLayout(new BorderLayout());
		leftSideTill2.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel rightSideTill2 = new JPanel();
		rightSideTill2.setLayout(new BorderLayout());
		rightSideTill2.setBorder(new EmptyBorder(6, 6, 6, 6));
		
			//Till 3
		JPanel till3 = new JPanel();
		till3.setLayout(new BorderLayout());
		till3.setBorder(new EmptyBorder(6, 6, 6, 6));
				
		JPanel leftSideTill3 = new JPanel();
		leftSideTill3.setLayout(new BorderLayout());
		leftSideTill3.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel rightSideTill3 = new JPanel();
		rightSideTill3.setLayout(new BorderLayout());
		rightSideTill3.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		//Till 4
		JPanel till4 = new JPanel();
		till4.setLayout(new BorderLayout());
		till4.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel leftSideTill4 = new JPanel();
		leftSideTill4.setLayout(new BorderLayout());
		leftSideTill4.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		JPanel rightSideTill4 = new JPanel();
		rightSideTill4.setLayout(new BorderLayout());
		rightSideTill4.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		// Step 5: Add components to containers
			//Pumps
				//Pump 1
		leftSidePump1.add(pump1Text11, BorderLayout.EAST);
		leftSidePump1.add(pump1Text12, BorderLayout.CENTER);
		rightSidePump1.add(pump1Text13, BorderLayout.EAST);
		rightSidePump1.add(pump1Text14, BorderLayout.CENTER);
		
				//Merge Left and Right Side
			pump1.add(pumpLabel1, BorderLayout.NORTH);
			pump1.add(leftSidePump1, BorderLayout.WEST);
			pump1.add(rightSidePump1, BorderLayout.EAST);
			pump1.add(pumpCost1, BorderLayout.SOUTH);
			
				//Pump 2
		leftSidePump2.add(pump1Text21, BorderLayout.EAST);
		leftSidePump2.add(pump1Text22, BorderLayout.CENTER);
		rightSidePump2.add(pump1Text23, BorderLayout.EAST);
		rightSidePump2.add(pump1Text24, BorderLayout.CENTER);
				//Merge Left and Right Side
			pump2.add(pumpLabel2, BorderLayout.NORTH);
			pump2.add(leftSidePump2, BorderLayout.WEST);
			pump2.add(rightSidePump2, BorderLayout.EAST);
			pump2.add(pumpCost2, BorderLayout.SOUTH);
		
				//Pump 3
		leftSidePump3.add(pump1Text31, BorderLayout.EAST);
		leftSidePump3.add(pump1Text32, BorderLayout.CENTER);
		rightSidePump3.add(pump1Text33, BorderLayout.EAST);
		rightSidePump3.add(pump1Text34, BorderLayout.CENTER);
				//Merge Left and Right Side
			pump3.add(pumpLabel3, BorderLayout.NORTH);
			pump3.add(leftSidePump3, BorderLayout.WEST);
			pump3.add(rightSidePump3, BorderLayout.EAST);
			pump3.add(pumpCost3, BorderLayout.SOUTH);
		
				//Pump 4
		leftSidePump4.add(pump1Text41, BorderLayout.EAST);
		leftSidePump4.add(pump1Text42, BorderLayout.CENTER);
		rightSidePump4.add(pump1Text43, BorderLayout.EAST);
		rightSidePump4.add(pump1Text44, BorderLayout.CENTER);
				//Merge Left and Right Side
			pump4.add(pumpLabel4, BorderLayout.NORTH);
			pump4.add(leftSidePump4, BorderLayout.WEST);
			pump4.add(rightSidePump4, BorderLayout.EAST);
			pump4.add(pumpCost4, BorderLayout.SOUTH);
		
			//Merge Both sides
		topPumps.add(pump1, BorderLayout.NORTH);
		topPumps.add(pump2, BorderLayout.SOUTH);
		bottomPumps.add(pump3, BorderLayout.NORTH);
		bottomPumps.add(pump4, BorderLayout.SOUTH);
		
			//Merge Pumps Together
		pumpsPanel.add(topPumps, BorderLayout.NORTH);
		pumpsPanel.add(bottomPumps, BorderLayout.SOUTH);
		
		//Tills
			//Till 1
		leftSideTill1.add(till1Text11, BorderLayout.EAST);
		leftSideTill1.add(till1Text12, BorderLayout.CENTER);
		rightSideTill1.add(till1Text13, BorderLayout.EAST);
		rightSideTill1.add(till1Text14, BorderLayout.CENTER);
				//Merge Left and Right Side
			till1.add(tillLabel1, BorderLayout.NORTH);
			till1.add(leftSideTill1, BorderLayout.WEST);
			till1.add(rightSideTill1, BorderLayout.EAST);
			till1.add(tillCost1, BorderLayout.SOUTH);
		
			//Till 2
		leftSideTill2.add(till1Text21, BorderLayout.EAST);
		leftSideTill2.add(till1Text22, BorderLayout.CENTER);
		rightSideTill2.add(till1Text23, BorderLayout.EAST);
		rightSideTill2.add(till1Text24, BorderLayout.CENTER);
			//Merge Left and Right Side
			till2.add(tillLabel2, BorderLayout.NORTH);
			till2.add(leftSideTill2, BorderLayout.WEST);
			till2.add(rightSideTill2, BorderLayout.EAST);
			till2.add(tillCost2, BorderLayout.SOUTH);
			
			//Till 3
		leftSideTill3.add(till1Text31, BorderLayout.EAST);
		leftSideTill3.add(till1Text32, BorderLayout.CENTER);
		rightSideTill3.add(till1Text33, BorderLayout.EAST);
		rightSideTill3.add(till1Text34, BorderLayout.CENTER);
				//Merge Left and Right Side
			till3.add(tillLabel3, BorderLayout.NORTH);
			till3.add(leftSideTill3, BorderLayout.WEST);
			till3.add(rightSideTill3, BorderLayout.EAST);
			till3.add(tillCost3, BorderLayout.SOUTH);
			
			//Till 4
		leftSideTill4.add(till1Text41, BorderLayout.EAST);
		leftSideTill4.add(till1Text42, BorderLayout.CENTER);
		rightSideTill4.add(till1Text43, BorderLayout.EAST);
		rightSideTill4.add(till1Text44, BorderLayout.CENTER);
			
				//Merge Left and Right Side
			till4.add(tillLabel4, BorderLayout.NORTH);
			till4.add(leftSideTill4, BorderLayout.WEST);
			till4.add(rightSideTill4, BorderLayout.EAST);
			till4.add(tillCost4, BorderLayout.SOUTH);
		
			//Merge Both sides
		topTills.add(till1, BorderLayout.NORTH);
		topTills.add(till2, BorderLayout.SOUTH);
		bottomTills.add(till3, BorderLayout.NORTH);
		bottomTills.add(till4, BorderLayout.SOUTH);
		
			//Merge Pumps Together
		tillsPanel.add(topTills, BorderLayout.NORTH);
		tillsPanel.add(bottomTills, BorderLayout.SOUTH);
		
		//Merge Simulators
		simPanel.add(pumpsPanel, BorderLayout.NORTH);
		simPanel.add(tillsPanel, BorderLayout.SOUTH);
		
		//Merge Title Panel Componenets
		titlePanel.add(titleLog, BorderLayout.NORTH);
		titlePanel.add(ticksStep, BorderLayout.WEST);
		titlePanel.add(simMoney, BorderLayout.CENTER);
		titlePanel.add(simLoss, BorderLayout.EAST);

		//Stuff To Present
		logFrame.add(titlePanel, BorderLayout.NORTH);
		logFrame.add(simPanel, BorderLayout.CENTER);
		logFrame.add(stopButton, BorderLayout.SOUTH);
		
		// Step 6: Arrange to handle events in the user interface
		logFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				logFrame.dispose();
			}
		});

		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Logic to stop
				logFrame.dispose();
			}
		});
		
		// Step 7: Display the GUI
		logFrame.pack();
		logFrame.setResizable(false);
		logFrame.setVisible(true);
		
		getDetails();
		
	}

	/**
	 * Gets the details from the Main GUI Parameter Checker
	 */
	private void getDetails(){
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
		s.simulate(s.config.getNumSteps(),true);

		/*
		 * Test System.out.println(s.config.getScProb());
		 * System.out.println(s.config.getMProb());
		 * System.out.println(s.config.getFsProb());
		 * System.out.println(s.config.getNumPumps());
		 * System.out.println(s.config.getNumTills());
		 * System.out.println(s.config.getNumSteps());
		 * System.out.println(s.config.getPencePerGallon());
		 */
	}
	
	/**
	 * This Displays the info to the Simulation GUI in parts
	 * @param info
	 */
	public void display(String info){
		//add code that splits "info" string into parts and displays them in the GUI output interface
		String[] splitInfo = info.split(",");
		System.out.println(info);
		for(String details: splitInfo){
			
		}
	}

	/**
	 * Makes the GUI Visible to the user
	 */
	public void guiVisible() {
		mainFrame.setVisible(true);
	}
}