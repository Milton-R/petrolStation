package aston.vehicles;

import java.util.Random;
import aston.station.*;
import aston.resources.*;
import aston.simulator.*;

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
	 */
	public Vehicle(){
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
	public void fillTank(int pumpSpd)
	{
		if (currentTank < tank)
		{
			tank += pumpSpd;
		}
	}
	
	
	public VehiclePump[] goToQueue(PetrolPump[] p){
		//Counter to set the minimum
		int min = 10;
		//Loop into the Petrol Pump Array
		for(int i = 0; i < p.length(); i++){
			//If the queue is longer than the current queue
			if(min < p[i]){
				min = p[i];
			}
			//Else if no queues are avaliable
			if(min != p[i]){
				//Vehicle Leaves
			}
		}
	}
	
	public void goInPumpQueue(){
		
	}
	
	public void goOutPumpQueue(){
		
	}
	
	
}
