package aston.vehicles;

import aston.resources.Config;
import aston.station.PetrolStation;

public class SmallCar extends Vehicle{

	/**
	 * SmallCar Constructor that is calling the super-class: Vehicle
	 */
	public SmallCar(String n, PetrolStation ps, int steps){
		super(ps,steps);
		if (Config.smallCar_tankRange > 0)
		{
			tank = Config.smallCar_tank + petrolStation.rand.nextInt(Config.smallCar_tankRange);
		}

		space = Config.smallCar_space;
		shopTimeLimit = Config.smallCarShoppingTimeLimit;
		shoppingProbability = Config.smallCarShoppingProbability;
		timeTakenShopping = Config.smallCarTimeTakenShopping + petrolStation.rand.nextInt(Config.smallCarTimeTakenShoppingRange);
		moneySpentShopping = Config.smallCarMoneySpent + petrolStation.rand.nextInt(Config.smallCarMoneySpentRange);
		name = "SmallCar" + n;
	}
	
}
