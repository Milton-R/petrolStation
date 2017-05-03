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
	
	public TillQueue()
	{
		t = new LinkedList<Customer>();
	}
	
	public void addCustomer(Customer c)
	{
		t.add(c);
		numC++;
	}
	
	public Customer getFrontCustomer()
	{
		return t.peek();
	}
	
	public void removeFrontCustomer()
	{
		t.remove();
		numC--;
	}
	
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
		
		//add empty info if less cars
		for (int i = 4; i > numC; i--)
		{
			s += "empty,";
		}
		return s;
	}
	
	
}
