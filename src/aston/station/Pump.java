package aston.station;

import aston.vehicles.*;
import aston.resources.*;

public class Pump {
	
	int numGallons;
	Vehicle currentVehicle;
	VehicleQueue currentQueue = new VehicleQueue();
	int pumpSpeed = Config.gallonPerTick;
	
	/**
	 * sets current vehicle to the vehicle in the front of the queue, checks if it's null, pumps fuel into the current vehicle
	 */
	public void pumpFuel()
	{
		try 
		{
			System.out.println("1");
			currentVehicle = currentQueue.getFrontVehicle();
			System.out.println(currentVehicle);
			if(currentVehicle.fillTank(pumpSpeed))
			{
				numGallons ++;
				System.out.println("filling tank");
			}
			else
			{
				removeFrontVehicle();
				System.out.println("removed v: "+currentVehicle);
			}
		} 
		catch (Exception e)
		{
			//do nothing
			System.out.println("queue empty");
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
}
