package aston.vehicles;

import aston.resources.Config;
import aston.station.PetrolStation;

/**
 * Truck Class<br>
 * This is a Level 1 feature that is controlled by the Config Class.
 * 
 * @author Milton R.
 * @author Matas B.
 *
 */
public class Truck extends Vehicle{
	protected int waitingTickLimit;
	protected double arrivalProbability;

	/**
	 * Motorbike Constructor that is calling the super-class: Vehicle
	 * 
	 * @param n the number of trucks taht have been created, used to generate unique name
	 * @param ps the instance of the petrol station running
	 * @param steps What step the vehicle was created on, used to work out how long spent in queue
	 */
	public Truck(String n, PetrolStation ps, int steps) {
		super(ps, steps);
		waitingTickLimit = Config.truck_shoppingTimeLimit;
		tank = Config.truck_tank + petrolStation.rand.nextInt(Config.truck_tankRange);
		space = Config.truck_space;
		shopTimeLimit = Config.truck_shoppingTimeLimit;
		shoppingProbability = Config.truck_ShoppingProbability;
		timeTakenShopping = Config.truck_timeTakenShopping + petrolStation.rand.nextInt(Config.truck_timeTakenShoppingRange);
		moneySpentShopping = Config.truck_money_spent + petrolStation.rand.nextInt(Config.truck_money_spent_range);
		currentTank = 0;
		name = "Truck" + n;
	}
	
}
