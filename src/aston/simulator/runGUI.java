package aston.simulator;

import aston.gui.PetrolGUI;

public class runGUI {
	
	static PetrolGUI gui = new PetrolGUI();
	static Simulator s;
	
	/**
	 * Create a simulation and run it for a specified number of steps, based on lab5 simulator
	 */
	public static void main(String[] args) {
		
		int numSteps = 1;  // By default, run for 1 step
		if (args.length >= 1) {
			numSteps = Integer.parseInt(args[0]);
		}
		if (numSteps <= 0) 
			numSteps = 1;
		
		s = new Simulator();
		s.simulate(numSteps);
		gui.guiVisible();
		s.updateGUI();
	}
}
