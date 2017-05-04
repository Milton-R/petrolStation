package aston.resources;
import aston.vehicles.*;
import java.util.LinkedList;
import java.util.Queue;

/** 
 * This presents with the Information about the till's queue line length.
 * 
 * @author Tristan P.
 * @author Matas B.
 * 
 * @version 19/04/2017
 *
 */
public class TillQueue {
	
	private Queue<Customer> t;
	private int numC = 0;
	
	/**
	 * Till Queue Constructor<br>
	 * This creates a new Till in the Shop Class to use. 
	 */
	public TillQueue()
	{
		t = new LinkedList<Customer>();
	}
	
	/**
	 * Add a customer to the Queue
	 * @param c Customer
	 */
	public void addCustomer(Customer c)
	{
		t.add(c);
		numC++;
	}
	
	/**
	 * Get the front of the Customer
	 * @return The first person of the Customer being served 
	 */
	public Customer getFrontCustomer()
	{
		return t.peek();
	}
	
	/**
	 * Remove the front of the customer of the till.
	 */
	public void removeFrontCustomer()
	{
		t.remove();
		numC--;
	}
	
	/**
	 * Accessor Method of the Number of Customers
	 * @return numC Number of Customers
	 */
	public int getNumberC()
	{
		return numC;
	}
	
	/**
	 * This outputs the string information to the console
	 * @return s String concatination
	 */
	public String toTextString()
	{
		String s = "Space Taken: " + numC;
		for (Customer c : t)
		{
			s += ", (" + c.getName() + ")";
		}
		return s;
	}
	/**
	 * This prints the string information to the GUI 
	 * @return s String Concatination
	 */
	public String toGuiString()
	{
		String s = "";
		for (Customer c : t)
		{
			s += c.getName() + ",";
		}
		
		return s;
	}
	
	
}
