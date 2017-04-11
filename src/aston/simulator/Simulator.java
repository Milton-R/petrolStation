package aston.simulator;
import aston.station.*;
import aston.resources.*;
import aston.vehicles.*;
import aston.gui.*;

public class Simulator {
	
	//Constructor for GUI
	PetrolGUI pgui;
	public Simulator(PetrolGUI petrolGUI)
	{
		pgui = petrolGUI;
	}
	//constructor for text
	public Simulator()
	{
		//empty
	}
	//instances
	PetrolStation petrolStation;
	public Config config = new Config();
	String info = "";
	
	//variables
	private int step;
	
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
	
	public void createPetrolStation()
	{
		petrolStation = new PetrolStation(config);
	}
	
	public String toString(boolean gui){
		return petrolStation.run(gui);
	}

	
}
