package aston.station;

import aston.vehicles.*;
import aston.resources.*;

public class Pump {
	
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
			currentVehicle = currentQueue.getFrontVehicle();
			if(currentVehicle.fillTank(pumpSpeed))
			{
				//do nothing
			}
			else
			{
				removeFrontVehicle();
			}
		} 
		catch (Exception e)
		{
			//do nothing
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

}
