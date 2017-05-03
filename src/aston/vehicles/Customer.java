package aston.vehicles;

import aston.resources.Config;
import aston.station.*;
/**
 * This is the Customer Class. This creates a customer based on the Vehicle
 * 
 * @author Tristan P.
 * @author Matas B.
 */
public class Customer {
	
	private Vehicle ownedVehicle;
	private String name;
	private int shoppingTime;
	private Shop shop;

	
	/**
	 * Constructor<br>
	 * Create a new customer with a set time to shop and state that the customer owns this vehicle
	 * 
	 * @param ov Current Vehicle
	 * @param shoppingTime
	 */
	public Customer(Vehicle ov, int shoppingTime, boolean happy)
	{
		ownedVehicle = ov;
		this.shoppingTime = shoppingTime;
		String vName = ov.getName();
		name = "Customer" + vName.substring(0,1) + vName.replaceAll("\\D+","");
		if(vName.equals("Truck"))
		{
			ov.petrolStation.getConfig().Service(happy);
		}	
	}
	
	/**
	 * Get the amount of time shopping
	 * 
	 * @return shoppingTime
	 */
	public int getShoppingTime()
	{		
		return shoppingTime;
	}
	
	/**
	 * Set the Shop
	 * 
	 * @param s Shop Class
	 */
	public void setShop(Shop s)
	{
		shop = s;
	}
	
	/**
	 * This states if the customer is withint he amount of time shopping
	 *  
	 * @return true if the Customer is going to the till
	 * @return false if it is over or below the tick counter
	 */
	public boolean passTime()
	{
		if (shoppingTime <= 0)
		{
			shop.sendToTill(this);
			System.out.println(name + " goes to till");
			return true;
		}
		else
		{
			shoppingTime -= Config.secondsPerTick;
			return false;
		}
	}
	
	/**
	 * Leave the Station
	 */
	public void leave()
	{
		ownedVehicle.vLeave();
		System.out.println(name + " drives away");
	}
	/**
	 * Grab the name of the customer
	 * @return name Name of the customer
	 */
	public String getName()
	{
		return name;
	}
}
