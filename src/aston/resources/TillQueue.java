package aston.resources;
import aston.resources.*;
import aston.vehicles.*;
import java.util.ArrayList;
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
		System.out.println(getFrontCustomer().getName() + " leaves Till");
		t.remove();
		numC--;
	}
	
	public int getNumberC()
	{
		return numC;
	}
	
	
}
