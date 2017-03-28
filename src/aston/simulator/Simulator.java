package aston.simulator;
import aston.station.*;
import aston.resources.*;
import aston.vehicles.*;
import aston.gui.*;

public class Simulator {
	
	//instances
	PetrolStation petrolStation;
	
	//variables
	private int step;
	 
	public void resetSim()
	{
		petrolStation = new PetrolStation();
	}
	
	public void simulate(int numSteps)
	{
		for(int step = 0; step <= numSteps-1; step++) {
			simulateStep();
		}
	}
	
	private String simulateStep()
	{
		return petrolStation.run();
	}
	
	public void updateGUI()
	{
		
	}
	
	public void updateText()
	{
		
	}
	
}
