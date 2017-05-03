package aston.vehicles;

import aston.resources.Config;
import aston.station.PetrolStation;

public class Truck extends Vehicle{


	public Truck(String n, PetrolStation ps) {
		super(ps);

		tank = Config.truck_tank + petrolStation.rand.nextInt(Config.truck_tankRange);

		space = Config.truck_space;
		shopTimeLimit = Config.truck_shoppingtime_range;
		shoppingProbability = 
				timeTakenShopping = Config.truck_shoppingtime + petrolStation.rand.nextInt(Config.truck_shoppingtime_range);
		moneySpentShopping = Config.truck_money_spent + petrolStation.rand.nextInt(Config. truck_money_spent_range);
		currentTank = 0;
		name = "Truck" + n;


	}

}
