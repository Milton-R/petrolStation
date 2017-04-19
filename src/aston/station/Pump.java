package aston.station;

import aston.vehicles.*;
import aston.resources.*;

/**
 * This is the information about
 * 
 * @author Kelvin M.
 * @author Tristan P.
 * @author Matas B.
 * 
 * @version 19/04/2017
 *
 */
public class Pump {
	
	int numGallons;
	private Vehicle currentVehicle;
	private VehicleQueue currentQueue = new VehicleQueue();
	int pumpSpeed = Config.gallonPerTick;
	private String name;
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
		if (currentQueue.getSize() > 0)
		{
			currentVehicle = currentQueue.getFrontVehicle();
			if(currentVehicle.fillTank(pumpSpeed))
			{
				numGallons ++;
				//System.out.println("FILLING TANK");
			}
			else
			{
				//removeFrontVehicle();
				if (!currentVehicle.hasCustomer())
				{
					//System.out.println("made customer");
					currentVehicle.createCustomer();
				}
				else
				{
					//wait here
					System.out.println("waiting for owner");
				}
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

	
	public int getNumOfGallons()
	{
		return numGallons;
		
	}
	
	public String textToString()
	{
		return "\n" + name + ":\n" + currentQueue.toString();
	}
	
	public String guiToString()
	{
		return (currentQueue.toGuiString());
	}
	
	public double getQueueSize()
	{
		return currentQueue.getSize();
	}
}
