package aston.gui;

import aston.simulator.Simulator;

/**
 * The TextView ...
 * 
 * @author Tristan P.
 * @author Matas B.
 * @author Kelvin M.
 * @version 03/04/2017
 *
 */
public class TextView {
	/**
	 * Text View Constructor<br>
	 * This sets the format to print to the information to a file. 
	 * 
	 * @param steps how many steps to run for
	 * @param p	the p value, probabilty of SmallCars and Motorbikes arriving
	 * @param q the q value, probabilty of FamilySedans arriving
	 * @param pumps the number of pumps there are
	 * @param tills the number of tills there are
	 * @param gallonPrice the price of fuel in pence/gallon
	 * @param trucks whether trucks should be simulated
	 */
	public TextView(int steps, double p, double q, int pumps, int tills, int gallonPrice, boolean trucks)
	{
		//create simulation
		Simulator s = new Simulator();
				
		//set config values
		s.config.setScProb(p);
		s.config.setMProb(p);
		s.config.setFsProb(q);
		s.config.setNumPumps(pumps);
		s.config.setNumTills(tills);
		s.config.setNumSteps(steps);
		s.config.setPencePerGallon(gallonPrice);
		s.config.setIsChecked(trucks);
				
		//create PetrolStation
		s.createPetrolStation();
				
		//run simulation
		s.simulate(s.config.getNumSteps(),false);
	}

}
