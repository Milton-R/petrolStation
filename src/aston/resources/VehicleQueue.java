package aston.resources;
import java.util.*;
import aston.vehicles.*;
import aston.station.*;

public class VehicleQueue {
	
	private Queue<Vehicle> q;
	private double queueSpace = Config.queueSize;
	
	public VehicleQueue()
	{
		q = new PriorityQueue<Vehicle>();
	}
	
	public void addVehicle(Vehicle v)
	{
		if (queueSpace < v.space)
	}

}
