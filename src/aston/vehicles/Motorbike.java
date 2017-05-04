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
	 * 
	 * @param n the number of trucks taht have been created, used to generate unique name
	 * @param ps the instance of the petrol station running
	 * @param steps What step the vehicle was created on, used to work out how long spent in queue
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