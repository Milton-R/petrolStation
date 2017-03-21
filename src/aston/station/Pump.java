package aston.station;

import aston.vehicles.*;
import aston.resources.*;

public class Pump {
	
	Vehicle currentVehicle;
	VehicleQueue currentQueue;
	int pumpSpeed = Config.gallonPerTick;
	
	/**
	 * sets current vehicle to the vehicle in the front of the queue, checks if it's null, pumps fuel into the current vehicle
	 */
	public void pumpFuel()
	{
		currentVehicle = currentQueue.getFrontVehicle();
		if (currentQueue.getFrontVehicle() != null)
		{	
			if(currentVehicle.fillTank(pumpSpeed))
			{
				//do nothing
			}
			else
			{
				removeFrontVehicle();
			}
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
