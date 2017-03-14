package aston.vehicles;

import aston.resources.Config;
import aston.station.PetrolStation;

public class Motorbike extends Vehicle{
	//Variables
	private int currentTank; //Motorbike's Maximum Tank Size
	
	//Methods
		//Constructors
	/**
	 * Motorbike Constructor that is calling the super-class: Vehicle
	 */
	public Motorbike(){
		super();
		space = Config.motorBike_space;
		shopTimeLimit = Config.motorBikeShoppingTimeLimit;
		shoppingProbability = Config.motorBikeShoppingProbability;
		timeTakenShopping = Config.motorBikeTimeTakenShopping + PetrolStation.rand.nextInt(Config.motorBikeTimeTakenShoppingRange);
		moneySpentShopping = Config.motorBikeMoneySpent + PetrolStation.rand.nextInt(Config.motorBikeMoneySpentRange);
		currentTank = 0;
	}
}