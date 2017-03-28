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
	Vehicle generatedV;
	
	//instances
	public static Random rand = new Random(Config.randomSeed); //temp static
	private Pump[] pumps = new Pump[numOfPumps];
	private Shop shop = new Shop();
	private Output output = new Output();
	
	
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
	public String run()
	{
		//make each Pump pump fuel
		for (Pump p : pumps)
		{
			p.pumpFuel();
			System.out.println("Pumping: "+p);
		}
		//create a new vehicle
		if (spawnVehicle())
		{
			Vehicle v = generatedV;
			System.out.println(v);
			boolean added = false;
			for (Pump p : pumps)
			{
				System.out.println(p);
				System.out.println(p.currentQueue.spaceTaken);
				System.out.println(v);
				if (p.addVehicleToQueue(v))
				{
					added = true;
					System.out.println("vehicle added to a que");
					System.out.println(p.currentQueue.spaceTaken);
					break;
				}
				else
				{
					System.out.println("no space");
				}
			}
			if (!added)
			{
				System.out.println("vehicle leaves as no space at pump");
			}
		}
		else
		{
			System.out.println("no v");
		}
		return "all the info";
	}
	
	/**
	 * creates one random subclass of the vehicle class, based on probabilities in config.
	 * @return Vehicle
	 */
	private boolean spawnVehicle()
	{
		double num = rand.nextDouble();
		System.out.println(num);
		
		//chose a vehicle
		if (num < Config.smallCar_probability)
		{
			generatedV = new SmallCar();
			output.addSC();
			return true;
		}
		else if (num < (Config.smallCar_probability + Config.motorBike_probability))
		{
			generatedV = new Motorbike();
			output.addM();
			return true;
		}
		else if (num < (Config.smallCar_probability + Config.motorBike_probability + Config.familySedan_probability))
		{
			generatedV = new FamilySedan();
			output.addFS();
			return true;
		}
		else
		{
			return false;
		}
	}
}
