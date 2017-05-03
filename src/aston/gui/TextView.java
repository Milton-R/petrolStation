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
