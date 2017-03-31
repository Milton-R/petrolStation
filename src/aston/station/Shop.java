package aston.station;
import aston.resources.*;
import aston.vehicles.*;

public class Shop {
	
	//we need to create a customer queue to store out customers.
	
	
	public Shop(int numTills)
	{
		Till[] tills = new Till[numTills];
		for (int i = 0; i < numTills; i++)
		{
			Till t = new Till();
			tills[i] = t;
		}
	}
	
	public void goToShop(Customer c)
	{
		//put Customer c into the queue
	}

}
