package aston.station;

import aston.vehicles.*;
import aston.resources.*;

/**
 * Pump Information.
 * <br>This allows to get information about the type of car passing and
 * the 
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
	 * 
	 * @param n - Number of Pumps from the GUI
	 */
	public Pump(int n)
	{
		name = "Pump"+n;
	}
	
	/**
	 * Set the current vehicle to the vehicle in the front of the queue.
	 * <br>Checks if it's null, pumps fuel into the current vehicle
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
	 * Add the Vehicle to the queue
	 * 
	 * @param v - The Vehicle Object
	 * @return The selected queue with the vehicle added
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

	/**
	 * Get the Amount of Gallons in the Pump
	 * 
	 * @return The amount of gallons in the pump
	 */
	public int getNumOfGallons()
	{
		return numGallons;
		
	}
	
	/**
	 * Print out the Information as a String
	 * 
	 * @return A String with the Pump Name and the queue
	 */
	public String textToString()
	{
		return "\n" + name + ":\n" + currentQueue.toString();
	}
	
	/**
	 * Print out the information to the GUI
	 * 
	 * @return A method from the queue Object Class 
	 */
	public String guiToString()
	{
		return (currentQueue.toGuiString());
	}
	
	/**
	 * Get the current Queue's size
	 * 
	 * @return The current queue's size
	 */
	public double getQueueSize()
	{
		return currentQueue.getSize();
	}
}
