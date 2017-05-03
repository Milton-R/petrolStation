package aston.vehicles;

import aston.station.*;
import aston.resources.*;
/**
 * A superclass for vehicles, extended by Family Sedan, Motorbike, Small Car.  
 * The vehicle takes up a certain amount of space and it has a tank that needs to be filled.
 *
 * @author Kelvin M.
 * @author Tristan P.
 * 
 * @version 27/03/2017
 * 
 */
public abstract class Vehicle{
	//Variables
	protected String name;
	protected int tank;							//Vehicle's Tank Size
	protected double space;						//How much space the vehicle uses in queue
	protected int currentTank; 					//Vehicle's Current Tank
	//protected int arrivalProbability;			//Probability that the vehicle will arrive
	protected int shopTimeLimit;				//Time that which pump must take less than in order for the customer to shop
	protected double shoppingProbability;		//Probability that the customer will shop if time is under shopTimeLimit
	protected int timeTakenShopping; 			//Time that customer will spend shopping
	//protected int timeTakenShoppingRange;		//Range of time in shop
	protected int moneySpentShopping; 			//Minimum Value in Payment
	//protected int moneySpentShoppingRange;	//Min + Random Value in Payment
	//protected Random random;					//Random Class
	protected Customer customer;
	protected boolean hasCustomer = false;
	protected VehicleQueue vQ;
	
	public PetrolStation petrolStation;
	
	//Methods
		//Constructors
	/**
	 * Constructor of the Vehicle
	 * 
	 * @param ps - Petrol Station
	 */
	public Vehicle(PetrolStation ps){
		petrolStation = ps;
		
		tank = 0;
		space = 0;
		currentTank = 0;
		shopTimeLimit = 2;
		shoppingProbability = 0.02;
		timeTakenShopping = 1;
		moneySpentShopping = 2;
	}
	
	/**
	 * Fill the Vehicle's Tank 
	 * 
	 * @param pumpSpd
	 */
	public boolean fillTank(int pumpSpd)
	{
		if (currentTank < tank)
		{
			currentTank += pumpSpd;
			//System.out.println("tank: "+currentTank);
			return true;
		}
		else
		{
			//System.out.println("tfull");
			return false;
		}
	}
	
	/**
	 * Gets the money that has been spent by the customers belonging to the Vehicle.
	 * 
	 * @return Money spent by the customers.
	 */
	public int getMoneySpentShopping()
	{
		return moneySpentShopping; 
		
	}
	
	/**
	 * Gets the time taken to shop, by the customers belonging to the Vehicle. 
	 * @return The time takan to shop.
	 */
	public int getTimeTakenShopping()
	{
		return timeTakenShopping;
	}
	
	/**
	 * Gets the probability that a belonging to the Vehicle will shop. 
	 * @return The time taken to shop.
	 */
	public double getShoppingProbability()
	{
		return shoppingProbability;
	}
	
	
	/**
	 * Gets the maximum amount of time that a customer belonging to the vehicle will spend shopping. 
	 * @return The the time limit.
	 */
	public int getShopTimeLimit()
	{
		return shopTimeLimit;
	}
	public int getTankSize()
	{
		return tank;
	}
	
	
	
	
	/**
	 * Gets the current amount of fuel in the vehicles tank. 
	 * @return The current amount of fuel.
	 */
	public int getCurrentTank()
	{
		return currentTank;
		
	}
	
	/**
	 * Gets the size of the vehicle in terms of the queue. 
	 * @return The space taken.
	 */
	public double getVehicleSize()
	{
		return space;
	}
	
	/**
	 * Create a Customer
	 */
	public void createCustomer()
	{
		hasCustomer = true;
		int shoppingTime = 20;
		if (name.contains("SmallCar"))
		{
			shoppingTime = Config.smallCarTimeTakenShopping + petrolStation.rand.nextInt(Config.smallCarTimeTakenShoppingRange);
		}
		else if (name.contains("Motorbike"))
		{
				shoppingTime = Config.motorBikeTimeTakenShopping;
		}
		else if (name.contains("FamilySedan"))
		{
			shoppingTime = Config.familySedanTimeTakenShopping + petrolStation.rand.nextInt(Config.familySedanTimeTakenShoppingRange);
		}
		else // creates customer truck
		{
			shoppingTime = Config.truck_shoppingtime + petrolStation.rand.nextInt(Config.truck_shoppingtime_range);
		}
		customer = new Customer(this, shoppingTime);
		System.out.println(customer.getName() + " goes into the store");
		petrolStation.goToShop(customer);
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean hasCustomer()
	{
		return hasCustomer;
	}
	
	public void setVehicleQueue(VehicleQueue vq)
	{
		vQ = vq;
	}
	
	public void vLeave()
	{
		vQ.removeFrontVehicle();
	}
	
	/**
	 * Gets the toString representation of the class. 
	 * @return The string representation.
	 */
	public String toString()
	{
		return "tank: "+tank+", space: "+space+", shop time limit: " + shopTimeLimit + ", shopping probability: " + shoppingProbability + ", time taken shopping: " + timeTakenShopping + ", moneySpentShopping: " + moneySpentShopping ;
	}

	/**
	 * Returns info for text view
	 * 
	 * @return String Representation for Console
	 */
	public String textToString()
	{
		return name + ", Tank: " + currentTank + "/" + tank + ", Size: " + space;
	}
	
	/**
	 * Returns info for GUI view
	 * 
	 * @return String Representation for GUI
	 */
	public String guiToString()
	{
		return name + ": " + currentTank + "/" + tank;
	}
	
}
