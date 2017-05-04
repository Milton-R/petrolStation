package aston.simulator;

//IS THIS STILL IN USE????

import aston.gui.*;

/**
 * Create a simulation and run it for a specified number of steps, based on lab5 simulator
 * takes arguements to change values for how simulator is run.
 * 
 * @author Tristan P.
 * @author Matas B.
 * 
 * @version 10/04/2017
 */
public class runText {
	/**
	 * Main Argument<br>
	 * Standard to run a class as an executable
	 * 
	 * @param args the arguements which change how the program will be run in text mode e.g. the p and q values
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
		
		boolean trucks = true;
		if (args.length >= 7)
		{
			int i = Integer.parseInt(args[6]);
			if (i == 1)
			{
				trucks = true;
			}
			else
			{
				trucks = false;
			}
		}
		
		TextView textView = new TextView(numSteps, pValue, qValue, numPumps, numTills, gallonPrice, trucks);
	}

}
