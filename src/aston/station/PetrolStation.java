package aston.station;

import java.util.*;
import aston.resources.*;
import aston.vehicles.*;

/**
 * This creates the current utilized GUI that the user will simulate 
 * 
 * @author Tristan P
 * @author Matas B.
 * @author Jordan L.
 * 
 * @version 19/04/2017
 *
 */

public class PetrolStation {
	
	//Variables
	Config config;
	Vehicle generatedV;
	
	//instances
	public Random rand = new Random(Config.randomSeed); //temp static
	private Pump[] pumps;
	private Shop shop;
	public Output output = new Output();
	
	
	/**
	 * Constructor<br>
	 * This creates the inital Petrol Station of the Simulation 
	 * @param c Configuration class
	 */
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
	
	/**
	 * Main run method, runs every step/tick.
	 * 
	 * @param gui Takes the instance of the gui being used
	 * @return String all the information about the current state of the simulation
	 */
	public String run(boolean gui)
	{
		String information = "";
		if (!gui)
		{
			information += ("\nStep: " + output.getNumSteps() + ", Lost Money: " + output.getLostMoney() + ", Additional Money: " + output.getAdditionalMoney() + ", Fuel Money: " + output.getFuelMoney());
		}
		else
		{
			information += (output.getNumSteps() + "," + output.getLostMoney() + "," + (output.getAdditionalMoney()+output.getFuelMoney()) + ",");
		}
		
		//customers
		shop.passTime();
		
		//make each Pump pump fuel
		for (Pump p : pumps)
		{
			p.pumpFuel();
		}
		
		//create a new vehicle
		if (spawnVehicle())
		{
			Vehicle v = generatedV;
			double size = pumps[0].getQueueSize();
			Pump shortestQueue = pumps[0];
			for (Pump p : pumps)
			{
				if (p.getQueueSize() < size)
				{
					shortestQueue = p;
					size = p.getQueueSize();
				}
			}
			if (shortestQueue.addVehicleToQueue(v))
			{
				//vehicle goes into a pump queue
			}
			else
			{
				System.out.println(v.getName() + " leaves as no space at pump");
				output.addLostMoney(v.getTankSize()*config.getPencePerGallon());
			}
		}
		
		//Update output and print Pump info
		for (Pump p : pumps)
		{
			if (!gui)
			{
				information += (p.textToString());
			}
			else
			{
				information += (p.guiToString());
			}
			
		}
		
		//Update output and print Till info
		for (Till t : shop.tills)
		{
			if (!gui)
			{
				information += (t.textToString());
			}
			else
			{
				information += (t.getName()+",");
				information += (t.guiToString());
				if (t.getQueueSize() == 0)
				{
					information += "empty,";
				}
			}
			
		}	
		return information;
	}
	
	/**
	 * Send the customer to the store
	 * @param c Customer Class
	 * @param i Integer is 0 normally, but may be 1 if the customer goes straight to the till (motorbikes and unhappy customers)
	 */
	public void goToShop(Customer c, int i)
	{
		if (i == 0)
		{
			shop.enter(c);
		}
		else
		{
			shop.tillEnter(c);
			output.addLostMoney(c.getAdditionalMoney());
		}
	}
	
	/**
	 * Get the current configuration
	 * @return config Config Class
	 */
	public Config getConfig()
	{
		return config;
	}
	
	/**
	 * Creates one random subclass of the vehicle class, based on probabilities in config.
	 * 
	 * @return true if the number is equivalent to the probablities or false if its greater.
	 */
	private boolean spawnVehicle()
	{
		double num = rand.nextDouble();
		//System.out.println(num);
		
		//chose a vehicle
		if (num < config.getScProb())
		{
			output.addSC();
			generatedV = new SmallCar(Integer.toString(output.getSC()),this, output.getNumSteps());
			return true;
		}
		else if (num < (config.getScProb() + config.getMProb()))
		{
			output.addM();
			generatedV = new Motorbike(Integer.toString(output.getM()),this, output.getNumSteps());
			return true;
		}
		else if (num < (config.getScProb() + config.getMProb() + config.getFsProb()))
		{
			output.addFS();
			generatedV = new FamilySedan(Integer.toString(output.getFS()),this,output.getNumSteps());
			return true;
		}
		else if (num < (config.getTruckProb() + config.getScProb() + config.getMProb() + config.getFsProb()) && (config.getisChecked())) {
			
			output.addTruck();
			generatedV = new Truck(Integer.toString(output.getTruck()),this, output.getNumSteps());
			return true;
		}
		else	
		{
			return false;
		}
	}
}
