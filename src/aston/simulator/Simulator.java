package aston.simulator;
import aston.station.*;
import aston.resources.*;
import aston.vehicles.*;
import aston.gui.*;

public class Simulator {
	
	//instances
	PetrolStation petrolStation;
	public Config config = new Config();
	
	//variables
	private int step;
	
	public void simulate(int numSteps)
	{
		for(int step = 0; step <= numSteps-1; step++) {
			simulateStep();
		}
		System.out.println("Total Fuel Pumped: " + petrolStation.output.getGallons() + " gallons");
		System.out.println("Money From Fuel: " + petrolStation.output.getFuelMoney() + "p");
	}
	
	public String simulateStep()
	{
		petrolStation.output.incStep();
		//return petrolStation.run(); //Possible Error for Duplication
		return toString();
	}
	
	public void createPetrolStation()
	{
		petrolStation = new PetrolStation(config);
	}
	
	public String toString(){
		return petrolStation.run();
	}
	
}
