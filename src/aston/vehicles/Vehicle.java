package aston.vehicles;

import java.util.Random;
import aston.station.*;
import aston.resources.*;
import aston.simulator.*;
/**
 * A superclass for vehicles, extended by Family Sedan, Motorbike, Small Car.  
 * The vehicle takes up a certain amount of space and it has a tank that needs to be filled.
 *
 * @author Tristan P. , Matas B., Kelvin M. and Milton R.
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
	
	PetrolStation petrolStation;
	
	//Methods
		//Constructors
	/**
	 * Constructor of the Vehicle
	 * 
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
	
	//creates the Customer object
	public void createCustomer()
	{
		int shoppingTime = 0;
		if (name.contains("SmallCar"))
		{
			shoppingTime = Config.smallCarTimeTakenShopping + petrolStation.rand.nextInt(Config.smallCarTimeTakenShoppingRange);
		}
		else if (name.contains("Motorbike"))
		{
			shoppingTime = Config.motorBikeTimeTakenShopping + petrolStation.rand.nextInt(Config.motorBikeTimeTakenShoppingRange);
		}
		else if (name.contains("FamilySedan"))
		{
			shoppingTime = Config.familySedanTimeTakenShopping + petrolStation.rand.nextInt(Config.familySedanTimeTakenShoppingRange);
		}
		Customer customer = new Customer(this, shoppingTime);
		petrolStation.goToShop(customer);
	}
	
	/**
	 * Gets the toString representation of the class. 
	 * @return The string representation.
	 */
	public String toString()
	{
		return "tank: "+tank+", space: "+space+", shop time limit: " + shopTimeLimit + ", shopping probability: " + shoppingProbability + ", time taken shopping: " + timeTakenShopping + ", moneySpentShopping: " + moneySpentShopping ;
	}
	
	//returns info for text view
	public String textToString()
	{
		return name + ", Tank: " + currentTank + "/" + tank + ", Size: " + space;
	}
	
}
