package aston.vehicles;

import java.util.Random;

public class Vehicle{
	//Variables
	protected int tank;							//Vehicle's Tank Size
	protected int space;						//Vehicle's Space
	protected int currentTank; 					//Vehicle's Current Tank
	protected int arrivalProbability;			//Store Value for Probability
	protected int shopTimeLimit;				//Time spent in the Shop
	protected double shoppingProbability;		//
	protected int timeTakenShopping; 			//Minimum Value in Shop
	//protected int timeTakenShoppingRange;		//Min + Random Value in Shop
	protected int moneySpentShopping; 			//Minimum Value in Payment
	//protected int moneySpentShoppingRange;	//Min + Random Value in Payment
	protected Random random;					//Random Class
	
	//Methods
		//Constructors
	/**
	 * Constructor of the Vehicle
	 * 
	 * 
	 */
	public Vehicle(){
		
	}
	
}
