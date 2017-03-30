package aston.resources;
import java.util.*;
import aston.vehicles.*;
import aston.station.*;

public class VehicleQueue {
	
	private Queue<Vehicle> q;
	private double queueSpace = Config.queueSize;
	public double spaceTaken = 0;
	
	//Constructor
	public VehicleQueue()
	{
		q = new LinkedList<Vehicle>();
	}
	
	/*
	 * Adds a vehicle to the queue if there is enough space for it to fit, adds the size of the vehicle to the space taken
	 * 
	 * @return boolean true if vehicle is added, otherwise false
	 */
	public boolean addVehicle(Vehicle v)
	{
		if (queueSpace > v.getVehicleSize() + spaceTaken)
		{
			spaceTaken += v.getVehicleSize();
			q.add(v);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*
	 * Gets the vehicle at the front of the queue
	 * 
	 * @return Vehicle The vehicle at the front
	 */
	public Vehicle getFrontVehicle()
	{
		Vehicle v = q.peek();
		return v;
	}
	
	/*
	 * Removes a vehicle from the front of the queue and changes the ammount of space taken in the queue
	 */
	public void removeFrontVehicle()
	{
		Vehicle v = q.peek();
		if (v != null)
		{
			q.remove();
			spaceTaken -= v.getVehicleSize();
		}
	}
	
	public String toString()
	{
		String s = "Space Taken: " + spaceTaken;
		for (Vehicle v : q)
		{
			s += ", (" + v.textToString() + ")";
		}
		return s;
	}
}
