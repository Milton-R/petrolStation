package aston.station;

import aston.vehicles.*;
import aston.resources.*;

public class Pump {
	
	int numGallons;
	Vehicle currentVehicle;
	VehicleQueue currentQueue = new VehicleQueue();
	int pumpSpeed = Config.gallonPerTick;
	String name;
	/**
	 * Constructor
	 * @param n Number of Pumps from the GUI
	 */
	public Pump(int n)
	{
		name = "Pump"+n;
	}
	
	/**
	 * sets current vehicle to the vehicle in the fronst of the queue, checks if it's null, pumps fuel into the current vehicle
	 */
	public void pumpFuel()
	{
		try 
		{
			currentVehicle = currentQueue.getFrontVehicle();
			if(currentVehicle.fillTank(pumpSpeed))
			{
				numGallons ++;
			}
			else
			{
				//removeFrontVehicle();
				currentVehicle.createCustomer();
			}
		} 
		catch (Exception e)
		{
			//do nothing
			//System.out.println("queue empty");
		}
	}
	
	/**
	 * adds Vehicle to queue
	 */
	public boolean addVehicleToQueue(Vehicle v)
	{
		return currentQueue.addVehicle(v);
	}
	
	/**
	 * Removes the vehicle at the front of the queue
	 */
	private void removeFrontVehicle()
	{
		currentQueue.removeFrontVehicle();
	}

	
	public int getNumOfGallons()
	{
		return numGallons;
		
	}
	
	public String textToString()
	{
		return name + ":\n" + currentQueue.toString();
	}
}
