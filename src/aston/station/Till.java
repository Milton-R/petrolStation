package aston.station;

import aston.vehicles.*;
import java.util.ArrayList;

public class Till {
	
	private ArrayList<Customer> shoppingCustomers = new ArrayList<Customer>();
	
	public void addCustomer(Customer c)
	{
		shoppingCustomers.add(c);
	}
	
	public void removerCustomer(Customer c)
	{
		shoppingCustomers.remove(c);
	}

}
