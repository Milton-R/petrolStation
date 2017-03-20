package aston.gui;

import java.awt.*;

import javax.swing.*;

import aston.gui.*;
import aston.resources.*;
import aston.simulator.*;

public class PetrolGUI {
	
	//JFrame for the 
	private JFrame mainFrame;
	private Object o;
	private JTextArea log;
	private JTextArea timeFrame;
	
	
	public PetrolGUI(Object o){
		this.o = o;
		
		// Step 1: Create the components
			//Title
		JLabel title = new JLabel();
			//Simulation
		//JPanel simPanel = new JPanel();
			//Log Section
		JPanel logPanel = new JPanel();
		log = new JTextArea();
		JScrollPane listScroll = new JScrollPane(log);
			//Buttons
		JButton quitButton = new JButton();
		JButton addCar = new JButton();
		
		// Step 2: Set the properties of the components 
			//Title
		title.setText("Petrol Station Simulation");
			//Time
		
			//Buttons
		quitButton.setText("Quit");
		addCar.setText("");
			//List
		listScroll.setPreferredSize(new Dimension(300,300));
		listScroll.setMinimumSize(new Dimension(200,200));
		// Step 3: Create containers to hold the components
		mainFrame = new JFrame("Petrol Simulator");
		// Step 4: Specify LayoutManagers
		// Step 5: Add components to containers 
		// Step 6: Arrange to handle events in the user interface
		
		// Step 7: Display the GUI
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
}
