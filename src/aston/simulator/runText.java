package aston.simulator;

import aston.gui.*;

public class runText {
	
	/**
	 * Create a simulation and run it for a specified number of steps, based on lab5 simulator
	 * takes arguements to change values for how simulator is run.
	 */
	public static void main(String[] args) {
		int numSteps = 1;  // By default, run for 1 step
		if (args.length >= 1) {
			numSteps = Integer.parseInt(args[0]);
		}
		if (numSteps <= 0)
		{
			numSteps = 1;
		}
		
		//change p
		double pValue = 0.03;
		if (args.length >= 2)
		{
			pValue = Double.parseDouble(args[1]);
		}
		
		//change q
		double qValue = 0.02;
		if (args.length >= 3)
		{
			qValue = Double.parseDouble(args[2]);
		}
		
		//change num pumps
		int numPumps = 2;
		if (args.length >= 4)
		{
			numPumps = Integer.parseInt(args[3]);
		}
		
		//change num tills
		int numTills = 2;
		if (args.length >= 5)
		{
			numTills = Integer.parseInt(args[4]);
		}
		
		//change pence per gallon
		int gallonPrice = 120;
		if (args.length >= 6)
		{
			gallonPrice = Integer.parseInt(args[5]);
		}
		
		TextView textView = new TextView(numSteps, pValue, qValue, numPumps, numTills, gallonPrice);
	}

}
