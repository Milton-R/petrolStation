package aston.vehicles;

import aston.resources.*;
import aston.station.*;
/**
 * The Family Sedan is a subclass of the Abstract Vehicle Class.<br>
 * This will cointain information that comes from the Config File.
 *  * 
 * @author Tristan P.
 * @author Kelvin M.
 * @author Matas B.
 *
 */
public class FamilySedan extends Vehicle{
	/**
	 * Family Sedan Constructor that is calling the super-class: Vehicle
	 * 
	 * @param n
	 * @param ps PetrolStation Class
	 * @param steps
	 */
	public FamilySedan(String n, PetrolStation ps, int steps){
		super(ps,steps);

		tank = Config.familySedan_tank;
		
		space = Config.familySedan_space;
		shopTimeLimit = Config.familySedanShoppingTimeLimit;
		shoppingProbability = Config.familySedanShoppingProbability;
		timeTakenShopping = Config.familySedanTimeTakenShopping + petrolStation.rand.nextInt(Config.familySedanTimeTakenShoppingRange);
		moneySpentShopping = Config.familySedanMoneySpent + petrolStation.rand.nextInt(Config.familySedanMoneySpentRange);
		currentTank = 0;
		name = "FamilySedan" + n;
	}
}
