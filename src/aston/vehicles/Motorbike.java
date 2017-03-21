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
		if (Config.motorBike_tankRange > 0)
		{
			tank = Config.motorBike_tank + PetrolStation.rand.nextInt(Config.motorBike_tankRange);
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
			timeTakenShopping = Config.motorBikeTimeTakenShopping + PetrolStation.rand.nextInt(Config.motorBikeTimeTakenShoppingRange);
		}
		else
		{
			timeTakenShopping = Config.motorBikeTimeTakenShopping;
		}
		if (Config.motorBikeMoneySpentRange > 0)
		{
			moneySpentShopping = Config.motorBikeMoneySpent + PetrolStation.rand.nextInt(Config.motorBikeMoneySpentRange);
		}
		else
		{
			moneySpentShopping = Config.motorBikeMoneySpent;
		}
		currentTank = 0;
	}
}