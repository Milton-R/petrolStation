package aston.vehicles;

import java.util.Random;
import aston.station.*;
import aston.resources.*;

public abstract class Vehicle{
	//Variables
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
	
	//Methods
		//Constructors
	/**
	 * Constructor of the Vehicle
	 * 
	 * 
	 */
	public Vehicle(){
		
	}
	
	public void fillTank(int pumpSpd)
	{
		if (currentTank < tank)
		{
			tank += pumpSpd;
		}
	}
	
}
