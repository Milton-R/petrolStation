package aston.station;

import aston.resources.*;
import aston.vehicles.*;
/**
 * This is the Till Class which constructs a Till for the simulatiuon to use
 * 
 * @author Matas B.
 * @author Tristan P.
 *
 */
public class Till {
	
	private TillQueue currentTillQueue = new TillQueue();
	private String name;
	
	/**
	 * Till Constructor<br>
	 * This creates a new Till and names the till with a designated number
	 * 
	 * @param n Number
	 */
	public Till(int n)
	{
		name = "Till"+n;
	}
	
	/**
	 * Accessor Method of the Name of the Till
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * This adds a customer to the current queue of the till 
	 * @param c
	 */
	public void addCustomer(Customer c)
	{
		currentTillQueue.addCustomer(c);
	}
	
	/**
	 * This gets the current size of the Queue
	 * @return The current till's queue size
	 */
	public int getQueueSize()
	{
		return currentTillQueue.getNumberC();
	}
	
	/**
	 * Serve the customer's in the till
	 */
	public void serveCustomers()
	{
		if (currentTillQueue.getNumberC() > 0)
		{
			if (currentTillQueue.getFrontCustomer().paid())
			{
				currentTillQueue.getFrontCustomer().leave();
				currentTillQueue.removeFrontCustomer();
			}
		}
	}
	/**
	 * Print the till to Text for TextView Use
	 * @return The name of the till and the Queue
	 */
	public String textToString()
	{
		return "\n" + name + ":\n" + currentTillQueue.toTextString();
	}
	
	/**
	 * Print the String to the GUI
	 * @return The Queue of a Till.
	 */
	public String guiToString()
	{
		return (currentTillQueue.toGuiString());
	}
}
