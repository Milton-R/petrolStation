package aston.vehicles;

import aston.resources.*;
import aston.station.*;
import aston.simulator.*;

public class FamilySedan extends Vehicle{
	//Variables
	private int currentTank; //FamilySedan's Maximum Tank Size
	
	//Methods
		//Constructors
	/**
	 * Motorbike Constructor that is calling the super-class: Vehicle
	 */
	public FamilySedan(){
		super();
		if (Config.familySedan_tankRange > 0)
		{
			tank = Config.familySedan_tank + PetrolStation.rand.nextInt(Config.familySedan_tankRange);
		}
		else
		{
			tank = Config.familySedan_tank;
		}
		space = Config.familySedan_space;
		shopTimeLimit = Config.familySedanShoppingTimeLimit;
		shoppingProbability = Config.familySedanShoppingProbability;
		timeTakenShopping = Config.familySedanTimeTakenShopping + PetrolStation.rand.nextInt(Config.familySedanTimeTakenShoppingRange);
		moneySpentShopping = Config.familySedanMoneySpent + PetrolStation.rand.nextInt(Config.familySedanMoneySpentRange);
		currentTank = 0;
	}
}
