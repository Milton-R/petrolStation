package aston.vehicles;

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
	private int additionalMoney;
	private int tillTime = 13;	//min time in till queue + 1


	/**
	 * Constructor<br>
	 * Create a new customer with a set time to shop and state that the customer owns this vehicle
	 * 
	 * @param ov Instance of the vehicle which the customer owns
	 * @param shoppingTime how long the customer will spend shopping
	 * @param happy boolean whether the customer is happy
	 * @param shopMoney how much the customer will spend in the shop
	 */
	public Customer(Vehicle ov, int shoppingTime, boolean happy, int shopMoney)
	{
		setAdditionalMoney(shopMoney);
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
			tillTime += ownedVehicle.petrolStation.rand.nextInt(6);
			shop.sendToTill(this);
			System.out.println(name + " goes to till");
			return true;
		}
		else
		{
			shoppingTime--;
			return false;
		}
	}

	/**
	 * Paid method where the customer is still in the Shop or the queue.
	 * 
	 * @return true Customer  has no more time or has paid in the Till
	 * @return false Customer still has time to shop around or are in the queue.
	 */
	public boolean paid()
	{
		tillTime--;
		if (tillTime > 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Leave the Station
	 */
	public void leave()
	{
		PetrolStation ps = ownedVehicle.petrolStation;
		ps.output.addAdditionalMoney(additionalMoney);
		ps.output.setFuelMoney(ownedVehicle.getTankSize()*ps.getConfig().getPencePerGallon());
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

	/**
	 * Accessor Method for Additional Money
	 * @return additionalMoney
	 */
	public int getAdditionalMoney() {
		return additionalMoney;
	}

	/**
	 * Mutator Method for additional Money
	 * @param additionalMoney sets the value of the money that will be spent by the customer in the shop
	 */
	public void setAdditionalMoney(int additionalMoney) {
		this.additionalMoney = additionalMoney;
	}
}
