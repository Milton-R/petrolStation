package aston.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import aston.simulator.*;

/**
 * The Simulation as a Graphical Interface. This first creates the Parameter GUI that sets
 * the information, from probability to the number of tills and pumps. This runs a
 * simulation b ased on the given informaiton from the Parameter GUI
 * 
 * @author Kelvin M.
 * @author Tristan P.
 * 
 * @version 19/04/2017
 *
 */
public class PetrolGUI {

	// JFrame for the Parameter Setting
	private JFrame mainParameterFrame;
	
	private JSlider pSlider;			//Probability of P
	private JSlider qSlider;			//Probability of Q
	private JSlider pumpSlider;			//Number of Pumps
	private JSlider tillSlider;			//Number of Tills
	private JTextField stepField;		//Simulation Steps
	private JTextField priceField;		//Price per Gallon
	private JCheckBox truckCheck;		//L1: With/Without Trucks
	
	// JFrame for the Actual Simulation
	private JFrame simulationFrame;
	
	private JLabel ticksStep;			//Simulation Step Tracker
	private JLabel simMoney;			//Overall Total Amount of Money from Current Simulation
	private JLabel simLoss;				//Overall Total Amount of Money Loss from Current Simulation
	
	// Array of JTextFields instead of declaring each JTextField one by one
	private JTextField pumpFields[];	//Array of JTextFields for Pumps
	// Text Areas
	private JTextArea tillFields[];
	
	// Class Declaration for Simulation
	private Simulator s;

	/**
	 * Petrol GUI Constructor.<br>
	 * The GUI Simulation of the Petrol Pump Simulator to set the Parameters
	 */
	public PetrolGUI() {

		// Instantiate the Simulator
		s = new Simulator(this);

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
		
			// probabilityP slider
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
		stepField.setText("1000");
			
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
		mainParameterFrame = new JFrame("Petrol Station Simulation Parameters");
		mainParameterFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		// Step 4: Specify LayoutManagers
		mainParameterFrame.setLayout(new BorderLayout());
		((JPanel) mainParameterFrame.getContentPane()).setBorder(new EmptyBorder(6, 6, 6, 6));

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

		mainParameterFrame.add(title, BorderLayout.NORTH);
		mainParameterFrame.add(paramPanel, BorderLayout.CENTER);
		mainParameterFrame.add(buttonPanel, BorderLayout.SOUTH);

		// Step 6: Arrange to handle events in the user interface
			//When the red close button is clicked
		mainParameterFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exitApp();
			}
		});
		
			//When the Quit Button is clicked
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitApp();
			}
		});
		
			//When the Run Button is clicked
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//If the Truck is Selected
				if(truckCheck.isSelected() == true){
					//Run the Simulation WITH TRUCK
					newSimulation();
				} else {
					//Run the Simulation WITH OUT TRUCK
					newSimulation();
				}
			}
		});

			//When the Probability of P is moved
		pSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = ((JSlider) e.getSource()).getValue();
				slidePNum.setText("0.0" + value + "");

			}
		});

			//When the Probability of Q is moved
		qSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = ((JSlider) e.getSource()).getValue();
				slideQNum.setText("0.0" + value + "");

			}
		});

			//When the Number of Pump Slider is moved
		pumpSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = ((JSlider) e.getSource()).getValue();
				int present = (int) Math.pow(2, value);
				pumpSlideNum.setText(present + "");

			}
		});

			//When the Number of Tills Slider is moved
		tillSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = ((JSlider) e.getSource()).getValue();
				int present = (int) Math.pow(2, value);
				tillSlideNum.setText(present + "");

			}
		});

		// Step 7: Display the GUI
		mainParameterFrame.pack();
		mainParameterFrame.setVisible(true);
	}

	/**
	 * GUI Simulation presenting the Pump's/Till's queue.<br>
	 * This is created based on the parameters given from the Main GUI Frame
	 */
	private void newSimulation() {
		
		//Set up JTextField for output
		initJTxtFld();
		
		// Step 1: Create the components
		JButton stopButton = new JButton();
		JLabel titleLog = new JLabel();
		
		ticksStep = new JLabel();
		simMoney = new JLabel();
		simLoss = new JLabel();

		//Pumps
			//Row 1
		JLabel pumpLabel1 = new JLabel();

		pumpFields[0] = new JTextField(12);
		pumpFields[0].setEditable(false);
		pumpFields[0].setBackground(new Color(218, 247, 166));
		pumpFields[1] = new JTextField(12);
		pumpFields[1].setEditable(false);
		pumpFields[2] = new JTextField(12);
		pumpFields[2].setEditable(false);
		pumpFields[3] = new JTextField(12);
		pumpFields[3].setEditable(false);

			//Row 2
		JLabel pumpLabel2 = new JLabel();

		pumpFields[4] = new JTextField(12);
		pumpFields[4].setEditable(false);
		pumpFields[4].setBackground(new Color(218, 247, 166));
		pumpFields[5] = new JTextField(12);
		pumpFields[5].setEditable(false);
		pumpFields[6] = new JTextField(12);
		pumpFields[6].setEditable(false);
		pumpFields[7] = new JTextField(12);
		pumpFields[7].setEditable(false);

			//Row 3
		JLabel pumpLabel3 = new JLabel();
		
		pumpFields[8] = new JTextField(12);
		pumpFields[8].setEditable(false);
		pumpFields[8].setBackground(new Color(218, 247, 166));
		pumpFields[9] = new JTextField(12);
		pumpFields[9].setEditable(false);
		pumpFields[10] = new JTextField(12);
		pumpFields[10].setEditable(false);
		pumpFields[11] = new JTextField(12);
		pumpFields[11].setEditable(false);

			//Row 4
		JLabel pumpLabel4 = new JLabel();
		
		pumpFields[12] = new JTextField(12);
		pumpFields[12].setEditable(false);
		pumpFields[12].setBackground(new Color(218, 247, 166));
		pumpFields[13] = new JTextField(12);
		pumpFields[13].setEditable(false);
		pumpFields[14] = new JTextField(12);
		pumpFields[14].setEditable(false);
		pumpFields[15] = new JTextField(12);
		pumpFields[15].setEditable(false);

		//Tills
			//Row 1
		JLabel tillLabel1 = new JLabel();
	
		tillFields[0] = new JTextArea(6,12);
		tillFields[0].setEditable(false);

			//Row 2
		JLabel tillLabel2 = new JLabel();
	
		tillFields[1] = new JTextArea(6,12);
		tillFields[1].setEditable(false);
		
			//Row 3
		JLabel tillLabel3 = new JLabel();
		
		tillFields[2] = new JTextArea(6,12);
		tillFields[2].setEditable(false);

			//Row 4
		JLabel tillLabel4 = new JLabel();
		
		tillFields[3] = new JTextArea(6,12);
		tillFields[3].setEditable(false);
		
		// Step 2: Set the properties of the components
		titleLog.setText("Petrol Station Simulation");
		pumpLabel1.setText("Pump: 1");
		pumpLabel2.setText("Pump: 2");
		pumpLabel3.setText("Pump: 3");
		pumpLabel4.setText("Pump: 4");
		
		tillLabel1.setText("Till: 1");
		tillLabel2.setText("Till: 2");
		tillLabel3.setText("Till: 3");
		tillLabel4.setText("Till: 4");
		
		ticksStep.setText("Step:");
		simMoney.setText("Amount of Money Gained:");
		simMoney.setHorizontalAlignment(JLabel.CENTER);
		simLoss.setText("Money Missed:");
		
		stopButton.setText("Close Current Simulation");
		
		// Step 3: Create containers to hold the components
			
		simulationFrame = new JFrame("Petrol Station Simulation");
			//Make sure that the red close button doesn't close
		simulationFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		// Step 4: Specify LayoutManagers
			//Simulation Frame 
		simulationFrame.setLayout(new BorderLayout());
		((JPanel) simulationFrame.getContentPane()).setBorder(new EmptyBorder(12, 12, 12, 12));

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
			//Left Pump 2
		JPanel leftSidePump2 = new JPanel();
		leftSidePump2.setLayout(new BorderLayout());
		leftSidePump2.setBorder(new EmptyBorder(6, 6, 6, 6));
			//Right Pump 2
		JPanel rightSidePump2 = new JPanel();
		rightSidePump2.setLayout(new BorderLayout());
		rightSidePump2.setBorder(new EmptyBorder(6, 6, 6, 6));
		
			//Pump 3
		JPanel pump3 = new JPanel();
		pump3.setLayout(new BorderLayout());
		pump3.setBorder(new EmptyBorder(6, 6, 6, 6));
			//Left Pump 3
		JPanel leftSidePump3 = new JPanel();
		leftSidePump3.setLayout(new BorderLayout());
		leftSidePump3.setBorder(new EmptyBorder(6, 6, 6, 6));
			//Right Pump 3
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

			//Till 2
		JPanel till2 = new JPanel();
		till2.setLayout(new BorderLayout());
		till2.setBorder(new EmptyBorder(6, 6, 6, 6));
		
			//Till 3
		JPanel till3 = new JPanel();
		till3.setLayout(new BorderLayout());
		till3.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		//Till 4
		JPanel till4 = new JPanel();
		till4.setLayout(new BorderLayout());
		till4.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		// Step 5: Add components to containers
			//Pumps
				//Pump 1
		leftSidePump1.add(pumpFields[0], BorderLayout.WEST);
		leftSidePump1.add(pumpFields[1], BorderLayout.EAST);
		rightSidePump1.add(pumpFields[2], BorderLayout.WEST);
		rightSidePump1.add(pumpFields[3], BorderLayout.EAST);
		
				//Merge Left and Right Side
			pump1.add(pumpLabel1, BorderLayout.NORTH);
			pump1.add(leftSidePump1, BorderLayout.WEST);
			pump1.add(rightSidePump1, BorderLayout.EAST);
			
				//Pump 2
		leftSidePump2.add(pumpFields[4], BorderLayout.WEST);
		leftSidePump2.add(pumpFields[5], BorderLayout.EAST);
		rightSidePump2.add(pumpFields[6], BorderLayout.WEST);
		rightSidePump2.add(pumpFields[7], BorderLayout.EAST);
				//Merge Left and Right Side
			pump2.add(pumpLabel2, BorderLayout.NORTH);
			pump2.add(leftSidePump2, BorderLayout.WEST);
			pump2.add(rightSidePump2, BorderLayout.EAST);
		
				//Pump 3
		leftSidePump3.add(pumpFields[8], BorderLayout.WEST);
		leftSidePump3.add(pumpFields[9], BorderLayout.EAST);
		rightSidePump3.add(pumpFields[10], BorderLayout.WEST);
		rightSidePump3.add(pumpFields[11], BorderLayout.EAST);
				//Merge Left and Right Side
			pump3.add(pumpLabel3, BorderLayout.NORTH);
			pump3.add(leftSidePump3, BorderLayout.WEST);
			pump3.add(rightSidePump3, BorderLayout.EAST);
		
				//Pump 4
		leftSidePump4.add(pumpFields[12], BorderLayout.WEST);
		leftSidePump4.add(pumpFields[13], BorderLayout.EAST);
		rightSidePump4.add(pumpFields[14], BorderLayout.WEST);
		rightSidePump4.add(pumpFields[15], BorderLayout.EAST);
				//Merge Left and Right Side
			pump4.add(pumpLabel4, BorderLayout.NORTH);
			pump4.add(leftSidePump4, BorderLayout.WEST);
			pump4.add(rightSidePump4, BorderLayout.EAST);
		
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
			till1.add(tillLabel1, BorderLayout.NORTH);
			till1.add(tillFields[0], BorderLayout.CENTER);
		
			//Till 2
			till2.add(tillLabel2, BorderLayout.NORTH);
			till2.add(tillFields[1], BorderLayout.CENTER);
			
			//Till 3
				//Merge Left and Right Side
			till3.add(tillLabel3, BorderLayout.NORTH);
			till3.add(tillFields[2], BorderLayout.CENTER);
			
			//Till 4
			till4.add(tillLabel4, BorderLayout.NORTH);
			till4.add(tillFields[3], BorderLayout.WEST);
		
			//Merge Both sides
		topTills.add(till1, BorderLayout.WEST);
		topTills.add(till2, BorderLayout.EAST);
		bottomTills.add(till3, BorderLayout.WEST);
		bottomTills.add(till4, BorderLayout.EAST);
		
			//Merge Pumps Together
		tillsPanel.add(topTills, BorderLayout.NORTH);
		tillsPanel.add(bottomTills, BorderLayout.SOUTH);
		
		//Merge Simulators
		simPanel.add(pumpsPanel, BorderLayout.WEST);
		simPanel.add(tillsPanel, BorderLayout.EAST);
		
		//Merge Title Panel Componenets
		titlePanel.add(titleLog, BorderLayout.NORTH);
		titlePanel.add(ticksStep, BorderLayout.WEST);
		titlePanel.add(simMoney, BorderLayout.CENTER);
		titlePanel.add(simLoss, BorderLayout.EAST);

		//Stuff To Present
		simulationFrame.add(titlePanel, BorderLayout.NORTH);
		simulationFrame.add(simPanel, BorderLayout.CENTER);
		simulationFrame.add(stopButton, BorderLayout.SOUTH);
		
		// Step 6: Arrange to handle events in the user interface
			//When the red close button is clicked
		simulationFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				simulationFrame.dispose();
			}
		});
			//When the Stop Button is Pressed
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Logic to stop
				simulationFrame.dispose();
			}
		});
		
		// Step 7: Display the GUI
		simulationFrame.pack();
		simulationFrame.setResizable(false);
		simulationFrame.setVisible(true);
		
		//Call method to grab the parameter values from the Paramter GUI
		getDetails();
		
	}

	/**
	 * Closes the Program.
	 * <br>This is only used within the parameter GUI.
	 */
	private void exitApp() {
		// Display confirmation dialog before exiting application
		int response = JOptionPane.showConfirmDialog(mainParameterFrame, "Do you really want to quit?", "Quit?",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (response == JOptionPane.YES_OPTION) {
			System.exit(0);		//Quit
		}
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
	}
	
	/**
	 * This Displays the info to the Simulation GUI in parts to the JTextFields.
	 * <br>The information is split using a comma delimiter. 
	 * 
	 * @param info - The Queue Information.
	 * 			 	<br>This is split for the GUI to
	 * 				accommodate the JTextFields. 
	 */
	public void display(String info){
		//Stores the delimited info String to a String Array named 'splitInfo'
		String[] splitInfo = info.split(",");
		//Output the info String to the Console
		System.out.println(info);
		//Loop through the splitInfo array
		for (int i = 0; i < 16; i++)
		{
			//Set the ticksStep JLabel to the current tick
			ticksStep.setText("Step: " + splitInfo[0] + "\t");
			
			//If the number of Pumps are in used based on the Pump Slider value in Parameter GUI
			if(i < ((4 * Math.pow(2, pumpSlider.getValue())))){ 
				//Each pumpField is placed on its respective TextField
				pumpFields[i].setText(splitInfo[i+1]);
			} else {
				//Pump states its not in use
				pumpFields[i].setText("Pump not in use");
				pumpFields[i].setBackground(Color.white);
			}
			
			//If the number of tills are in used based on the Pump Slider value in Parameter GUI
			if(i < ((4 * Math.pow(2, tillSlider.getValue())))){ 
				//Each tillField is placed on its respective TextField
				tillFields[i].setText("Sample");
				//tillFields[i].setText(splitInfo[i+1]);
			} else {
				//Till states its not in use
				tillFields[i].setText("Till not in use");
				tillFields[i].setBackground(Color.white);
			}
		}
	}

	/**
	 * Makes the GUI Visible to the user.
	 */
	public void guiVisible() {
		mainParameterFrame.setVisible(true);
	}
	
	/**
	 * Initialises all the JTextFields and stores them in an array.
	 */
	private void initJTxtFld()
	{
		//Create JTextField arrays with a text width of 16
		pumpFields = new JTextField[16];
		tillFields = new JTextArea[16];
		//Loop
		for (int i = 0; i < 16; i++)
		{
			//Create the new JTextField, based on info from arrays
			pumpFields[i] = new JTextField();
			if(i >= tillSlider.getValue()){
				tillFields[i] = new JTextArea();
			}
		}
	}
}