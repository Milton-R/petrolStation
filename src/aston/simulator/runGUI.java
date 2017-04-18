package aston.simulator;

import aston.gui.PetrolGUI;
/**
 * This is the starting class of the GUI.
 * <br> This what runs the PetrolGUI class.
 * 
 * @author Tristan P., Matas B., Kelvin M. and Milton R.
 * @version 12/04/2017
 *
 */
public class runGUI {
	
	private static PetrolGUI gui = new PetrolGUI();
	
	/**
	 * Create a simulation and run it for a specified number of steps.
	 * <br> This is based on simulator from Lab5
	 */
	public static void main(String[] args) {
		//Make the GUI Visible
		gui.guiVisible();
	}
}
