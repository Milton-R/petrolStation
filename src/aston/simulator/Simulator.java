package aston.simulator;
import aston.station.*;
import aston.resources.*;
import aston.vehicles.*;
import aston.gui.*;

public class Simulator {
	
	//instances
	PetrolStation petrolStation = new PetrolStation();
	PetrolGUI gui = new PetrolGUI();
	
	//variables
	private int step;
	
	/**
	 * Create a simulation and run it for a specified number of steps, based on lab5 simulator
	 */
	public static void main(String[] args) {
		//gui
		int numSteps = 1;  // By default, run for 1 step
		if (args.length >= 1) {
			numSteps = Integer.parseInt(args[0]);
		}
		if (numSteps <= 0) 
			numSteps = 1;
		
		Simulator s = new Simulator();
		s.simulate(numSteps);
		
	}
	
	private void simulate(int numSteps)
	{
		for(int step = 0; step <= numSteps-1; step++) {
			simulateStep();
		}
	}
	
	private void simulateStep()
	{
		petrolStation.run();
		updateGUI();
	}
	
	private void updateGUI(){
		
	}
}
