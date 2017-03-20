package aston.gui;

import javax.swing.*;

import aston.gui.*;
import aston.resources.*;
import aston.simulator.*;

public class PetrolGUI {
	
	//JFrame for the 
	private JFrame mainFrame;
	private Object o;
	private JTextArea log;
	
	
	public PetrolGUI(Object o){
		this.o = o;
		
		// Step 1: Create the components
			//Title
		JLabel title = new JLabel();
			//Simulation
		JPanel simPanel = new JPanel();
			//Log Section
		JPanel logPanel = new JPanel();
		JScrollPane listScroll = new JScrollPane(logPanel);
		
		JButton quitButton = new JButton();
		JButton newButton = new JButton();
		
		// Step 2: Set the properties of the components 
		title.setText("Petrol Station Simulation");
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
