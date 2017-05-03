package aston.vehicles;

import aston.resources.Config;
import aston.station.PetrolStation;

public class Motorbike extends Vehicle{
	
	/**
	 * Motorbike Constructor that is calling the super-class: Vehicle
	 */
	public Motorbike(String n, PetrolStation ps){
		super(ps);
		tank = Config.motorBike_tank;

		space = Config.motorBike_space;
		shopTimeLimit = Config.motorBikeShoppingTimeLimit;
		shoppingProbability = Config.motorBikeShoppingProbability;

		timeTakenShopping = Config.motorBikeTimeTakenShopping;

		moneySpentShopping = Config.motorBikeMoneySpent;
		
		currentTank = 0;
		name = "Motorbike" + n;
	}
}