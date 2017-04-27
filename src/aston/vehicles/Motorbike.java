package aston.vehicles;

import aston.resources.Config;
import aston.station.PetrolStation;

public class Motorbike extends Vehicle{
	
	/**
	 * Motorbike Constructor that is calling the super-class: Vehicle
	 */
	public Motorbike(String n, PetrolStation ps){
		super(ps);
		if (Config.motorBike_tankRange > 0)
		{
			tank = Config.motorBike_tank + petrolStation.rand.nextInt(Config.motorBike_tankRange);
		}
		else
		{
			tank = Config.motorBike_tank;
		}
		space = Config.motorBike_space;
		shopTimeLimit = Config.motorBikeShoppingTimeLimit;
		shoppingProbability = Config.motorBikeShoppingProbability;
		if (Config.motorBikeTimeTakenShoppingRange > 0)
		{
			timeTakenShopping = Config.motorBikeTimeTakenShopping + petrolStation.rand.nextInt(Config.motorBikeTimeTakenShoppingRange);
		}
		else
		{
			timeTakenShopping = Config.motorBikeTimeTakenShopping;
		}
		if (Config.motorBikeMoneySpentRange > 0)
		{
			moneySpentShopping = Config.motorBikeMoneySpent + petrolStation.rand.nextInt(Config.motorBikeMoneySpentRange);
		}
		else
		{
			moneySpentShopping = Config.motorBikeMoneySpent;
		}
		currentTank = 0;
		name = "Motorbike" + n;
	}
}