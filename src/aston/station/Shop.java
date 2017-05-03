package aston.station;
import java.util.ArrayList;
import aston.vehicles.*;

/**
 * This is the Shop Class which allows to create Shop Simulator 
 * 
 * @author Tristan P.
 * @author Matas B.
 * @author Kelvin M
 *
 */
public class Shop {
	
	public Till[] tills;
	private ArrayList<Customer> shoppingCustomers = new ArrayList<Customer>();
	
	/**
	 * Constructor<br>
	 * Makes the tills to be used
	 * @param numTills Number of tills to use
	 */
	public Shop(int numTills)
	{
		tills = new Till[numTills];
		for (int i = 0; i < numTills; i++)
		{
			Till t = new Till(i+1);
			tills[i] = t;
		}	
	}
	
	/**
	 * Adds the customer to an array while timer counts down
	 * @param c Current Customer
	 */
	public void enter(Customer c)
	{
		c.setShop(this);
		shoppingCustomers.add(c);
	}

	/**
	 * Remove the customer from the array
	 * @param c
	 */
	public void removeCustomer(Customer c)
	{
		shoppingCustomers.remove(c);
	}
	/**
	 * This send the customer to the till
	 * 
	 * @param c Current Customer Object
	 */
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
	/**
	 * This allows the current customer to pass time inside the shop
	 * based on a probability
	 */
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
