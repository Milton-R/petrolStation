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
	private JTextArea logOutput;
	
	/**
	 * The GUI Simulation of the Petrol Pump Simulator 
	 * 
	 * @param Object o
	 */
	public PetrolGUI(Object o){
		this.o = o;
		
		// Step 1: Create the components
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		
		
		// Step 2: Set the properties of the components 

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
