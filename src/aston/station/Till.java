package aston.station;

import aston.resources.*;
import aston.vehicles.*;

public class Till {
	
	private TillQueue currentTillQueue = new TillQueue();
	private String name;
	
	public void addCustomer(Customer c)
	{
		currentTillQueue.addCustomer(c);
	}
	
	public int getQueueSize()
	{
		return currentTillQueue.getNumberC();
	}
	
	public void serveCustomers()
	{
		if (currentTillQueue.getNumberC() > 0)
		{
			currentTillQueue.getFrontCustomer().leave();
			currentTillQueue.removeFrontCustomer();
		}
	}
	
}
