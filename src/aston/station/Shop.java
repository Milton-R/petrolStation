package aston.station;
import java.util.ArrayList;

import aston.resources.*;
import aston.vehicles.*;

public class Shop {
	
	private Till[] tills;
	private ArrayList<Customer> shoppingCustomers = new ArrayList<Customer>();
	//we need to create a customer queue to store our customers once they have finished browsing.
	
	//makes the tills
	public Shop(int numTills)
	{
		tills = new Till[numTills];
		for (int i = 0; i < numTills; i++)
		{
			Till t = new Till();
			tills[i] = t;
		}
	}
	
	//adds the customer to an array while timer counts down.
	public void enter(Customer c)
	{
		c.setShop(this);
		shoppingCustomers.add(c);
	}

	
	public void removeCustomer(Customer c)
	{
		shoppingCustomers.remove(c);
	}
	
	public void sendToTill(Customer c)
	{
		/*
		int size = tills[0].getQueueSize();
		Till shortestQueue = tills[0];
		for (Till t: tills)
		{
			if (t.getQueueSize() < size)
			{
				shortestQueue = t;
			}
		}
		shortestQueue.addCustomer(c);
		*/
	}

}
