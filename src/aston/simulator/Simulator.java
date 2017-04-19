package aston.simulator;
import aston.station.*;
import aston.resources.*;
import aston.vehicles.*;
import aston.gui.*;

/**
 * 
 * The Simulator Class is the logic behind the program and details what information to the
 * console and GUI. 
 * 
 * @author Tristan P.
 * @author Matas B.
 * 
 * @version 03/04/2017
 *
 */
public class Simulator {
	
	private PetrolGUI pgui;
	private PetrolStation petrolStation;
	public Config config = new Config();
	private String info = "";
	private int step;
	
	//Constructors
		//Constructor for GUI Usage
	public Simulator(PetrolGUI petrolGUI)
	{
		pgui = petrolGUI;
	}
	
		//Constructor for Text Usage
	public Simulator()
	{
		//empty
	}
	
	//Methods	
	/**
	 * Simulate the Station in a Tick
	 * 
	 * @param numSteps - Current Step
	 * @param gui - Boolean to state if the GUI is present or not
	 */
	public void simulate(int numSteps, boolean gui)
	{
		for(int step = 0; step <= numSteps-1; step++) {
			info = simulateStep(gui);
			if (gui)
			{
				pgui.display(info);
			}
		}
		if (!gui)
		{
			System.out.println("Total Fuel Pumped: " + petrolStation.output.getGallons() + " gallons");
			System.out.println("Money From Fuel: " + petrolStation.output.getFuelMoney() + "p");
		}
	}
	
	/**
	 * This simulates a step tick and presents the output.
	 * 
	 * @version 2.1 
	 * @param gui - Boolean to state if the GUI is in use or not
	 * @return info
	 */
	public String simulateStep(boolean gui)
	{
		petrolStation.output.incStep();
		String info = "";
		//return petrolStation.run(); //Possible Error for Duplication
		info = toString(gui);
		if (!gui)
		{
			System.out.println(info);
		}
		return info;

	}
	
	/**
	 * This creates an instance of a Petrol Station
	 */
	public void createPetrolStation()
	{
		petrolStation = new PetrolStation(config);
	}
	
	/**
	 * toString Method to give the information out.
	 * 
	 * @param gui - State if the GUI is true or false
	 * @return Petrol Station Run Method
	 */
	public String toString(boolean gui){
		return petrolStation.run(gui);
	}

	
}
