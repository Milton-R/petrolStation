package aston.station;
import aston.resources.*;
import aston.vehicles.*;

public class Shop {
	
	//we need an array to hold the customers that are browing the store.
	//we need to create a customer queue to store our customers once they have finished browsing.
	
	public Shop(int numTills)
	{
		Till[] tills = new Till[numTills];
		for (int i = 0; i < numTills; i++)
		{
			Till t = new Till();
			tills[i] = t;
		}
	}
	
	//adds the customer to an array while timer counts down.
	public void enter(Customer c)
	{
		//put Customer c into the queue
	}

}
