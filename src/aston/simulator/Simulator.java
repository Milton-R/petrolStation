package aston.simulator;

public class Simulator {
	
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
		
		//s.simulate(numSteps); // we need to create a simulate method
	}

}
