package aston.vehicles;

import aston.resources.Config;
import aston.station.PetrolStation;

/**
 * The Motorbike is a subclass of the Abstract Vehicle Class.<br>
 * This will cointain information that comes from the Config File.
 * 
 * @author Matas B.
 * @author Tristan P.
 *
 */
public class Motorbike extends Vehicle{
	
	/**
	 * Motorbike Constructor that is calling the super-class: Vehicle
	 */
	public Motorbike(String n, PetrolStation ps, int steps){
		super(ps, steps);
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