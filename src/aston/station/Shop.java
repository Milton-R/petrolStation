package aston.station;
import java.util.ArrayList;
import java.util.Iterator;

import aston.resources.*;
import aston.vehicles.*;

public class Shop {
	
	private Till[] tills;
	private ArrayList<Customer> shoppingCustomers = new ArrayList<Customer>();
	
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
	}
	
	public void passTime()
	{
		for (Till t : tills)
		{
			t.serveCustomers();
		}
		if (shoppingCustomers.size() > 0)
		{
			ArrayList<Customer> toRemove = new ArrayList<Customer>();
			for (Customer c : shoppingCustomers)
			{
				if (c.passTime())
				{
					toRemove.add(c);
				}
			}
			shoppingCustomers.removeAll(toRemove);
		}
	}

}
