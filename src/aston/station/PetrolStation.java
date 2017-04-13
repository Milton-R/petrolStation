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
	Config config;
	Vehicle generatedV;
	
	//instances
	public Random rand = new Random(Config.randomSeed); //temp static
	private Pump[] pumps;
	private Shop shop;
	public Output output = new Output();
	
	
	//constructor
	public PetrolStation(Config c)
	{
		config = c;
		int numOfPumps = config.getNumPumps();
		pumps = new Pump[numOfPumps];
		for (int i = 0; i < numOfPumps; i++)
		{
			Pump p = new Pump(i+1);
			pumps[i] = p;
		}
		shop = new Shop(config.getNumTills());
	}
	
	//Main run method, runs every step/tick.
	public String run(boolean gui)
	{
		String information = "";
		if (!gui)
		{
			information += ("\nStep: " + output.getNumSteps());
		}
		else
		{
			information += (output.getNumSteps() + ",");
		}
		//make each Pump pump fuel
		for (Pump p : pumps)
		{
			p.pumpFuel();
		}
		//create a new vehicle
		if (spawnVehicle())
		{
			Vehicle v = generatedV;
			boolean added = false;
			double size = pumps[0].getQueueSize();
			Pump shortestQueue = pumps[0];
			for (Pump p : pumps)
			{
				if (p.getQueueSize() < size)
				{
					shortestQueue = p;
				}
	
			}
			if (shortestQueue.addVehicleToQueue(v))
			{
				added = true;
			}
			else
			{
				//System.out.println("vehicle leaves as no space at pump");
			}
		}
		else
		{
			//System.out.println("no v");
		}
		
		//update output and print info
		int totalPumped = 0;
		for (Pump p : pumps)
		{
			totalPumped += p.getNumOfGallons();
			if (!gui)
			{
				information += (p.textToString());
			}
			else
			{
				information += (p.guiToString());
			}
			
		}
			
		for (int i = 4; i > pumps.length; i--)
		{
			information += "empty,empty,empty,empty,";
		}
		output.setNumGallons(totalPumped);
		output.setFuelMoney((int) totalPumped*config.getPencePerGallon());
		//System.out.println(output.getGallons());
		return information;
	}
	
	//send customer to the store
	public void goToShop(Customer c)
	{
		shop.enter(c);
	}
	
	/**
	 * creates one random subclass of the vehicle class, based on probabilities in config.
	 * @return Vehicle
	 */
	private boolean spawnVehicle()
	{
		double num = rand.nextDouble();
		//System.out.println(num);
		
		//chose a vehicle
		if (num < config.getScProb())
		{
			output.addSC();
			generatedV = new SmallCar(Integer.toString(output.getSC()),this);
			return true;
		}
		else if (num < (config.getScProb() + config.getMProb()))
		{
			output.addM();
			generatedV = new Motorbike(Integer.toString(output.getM()),this);
			return true;
		}
		else if (num < (config.getScProb() + config.getMProb() + config.getFsProb()))
		{
			output.addFS();
			generatedV = new FamilySedan(Integer.toString(output.getFS()),this);
			return true;
		}
		else
		{
			return false;
		}
	}
}
