package aston.resources;
import aston.resources.*;
import aston.vehicles.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class TillQueue {
	
	private Queue<Customer> t;
	private int numC = 0;
	
	public TillQueue()
	{
		t = new LinkedList<Customer>();
	}
	
	private void addCustomer(Customer c)
	{
		t.add(c);
		numC++;
	}
	private void removeCustomer(Customer c)
	{
		t.remove(c);
		numC--;
	}
	
	private void passTime()
	{
		for(Customer c : t)
		{
			c.passTime();
		}
	}
	
	
}
