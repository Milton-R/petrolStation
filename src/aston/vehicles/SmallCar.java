package aston.vehicles;

import aston.resources.Config;
import aston.station.PetrolStation;

public class SmallCar extends Vehicle{
	//Variables
	private int currentTank; //Vehicle's Maximum Tank Size
	
	//Methods
		//Constructors
	/**
	 * SmallCar Constructor that is calling the super-class: Vehicle
	 */
	public SmallCar(){
		super();
		tank = Config.smallCar_tank + PetrolStation.rand.nextInt(Config.smallCar_tankRange);
		space = Config.smallCar_space;
		shopTimeLimit = Config.smallCarShoppingTimeLimit;
		shoppingProbability = Config.smallCarShoppingProbability;
		timeTakenShopping = Config.smallCarTimeTakenShopping + PetrolStation.rand.nextInt(Config.smallCarTimeTakenShoppingRange);
		moneySpentShopping = Config.smallCarMoneySpent + PetrolStation.rand.nextInt(Config.smallCarMoneySpentRange);
		
	}
	
}
