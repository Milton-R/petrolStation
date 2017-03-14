package aston.simulator;
import aston.station.*;
import aston.resources.*;
import aston.vehicles.*;

public class Simulator {
	
	//instances
	PetrolStation petrolStation = new PetrolStation();
	
	//variables
	private int step;
	
	/**
	 * Create a simulation and run it for a specified number of steps
	 */
	public static void main(String[] args) {
		int numSteps = 1;  // By default, run for 1 step
		if (args.length >= 1) {
			numSteps = Integer.parseInt(args[0]);
		}
		if (numSteps <= 0) 
			numSteps = 1;
		
		Simulator s = new Simulator();
		s.simulate(numSteps);
	}
	
	public void simulate(int numSteps)
	{
		for(int step = 0; step <= numSteps-1; step++) {
			simulateStep();
		}
	}
	
	public void simulateStep()
	{
		petrolStation.run();
	}
}
