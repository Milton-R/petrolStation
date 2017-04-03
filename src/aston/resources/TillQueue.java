package aston.resources;
import aston.resources.*;
import aston.vehicles.*;
import java.util.ArrayList;
public class TillQueue {
	
	private ArrayList<Customer> tillQueue = new ArrayList<Customer>();
	
	TillQueue()
	{
		
	}
	
	private void addCustomer(Customer e)
	{
		tillQueue.add(e);
	}
	private void removeCustomer(Customer e)
	{
		tillQueue.remove(e);
	}
	private void passTime()
	{
		for(Customer c : tillQueue)
		{
			c.ticks -= 10;
		}
	}
	
	
}
