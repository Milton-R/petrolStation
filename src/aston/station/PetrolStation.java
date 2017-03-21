package aston.station;

import java.util.*;
import aston.resources.*;
import aston.vehicles.*;

/**
 * 
 * @author Kelvin M.
 * @author Tristan P
 * @author Matas B.
 * @author Milton R.
 * @author Jordan L.
 * @version 0.1
 *
 */

public class PetrolStation {
	
	//variables
	int numOfPumps = Config.numberOfPumps;
	
	//instances
	public static Random rand = new Random(Config.randomSeed); //temp static
	private Pump[] pumps = new Pump[numOfPumps];
	private Shop shop = new Shop();
	
	//constructor
	public PetrolStation()
	{
		for (int i = 0; i < numOfPumps; i++)
		{
			Pump p = new Pump();
			pumps[i] = p;
		}
	}
	
	//Main run method, runs every step/tick.
	public void run()
	{
		//make each Pump pump fuel
		for (Pump p : pumps)
		{
			p.pumpFuel();
		}
		//create a new vehicle
		Vehicle v = spawnVehicle();
		if (v != null)
		{
			boolean added = false;
			for (Pump p : pumps)
			{
				if (p.addVehicleToQueue(v))
				{
					added = true;
					break;
				}
			}
			if (!added)
			{
				//code that stores info on missed money
			}
		}
	}
	
	/**
	 * creates one random subclass of the vehicle class, based on probabilities in config.
	 * @return Vehicle
	 */
	private Vehicle spawnVehicle()
	{
		double num = rand.nextDouble();
		Vehicle v = null;
		
		//chose a vehicle
		if (num < Config.smallCar_probability)
		{
			v = new SmallCar();
		}
		else if (num < (Config.smallCar_probability + Config.motorBike_probability))
		{
			v = new Motorbike();
		}
		else if (num < (Config.smallCar_probability + Config.motorBike_probability + Config.familySedan_probability))
		{
			v = new FamilySedan();
		}
		
		return v;
	}
}
