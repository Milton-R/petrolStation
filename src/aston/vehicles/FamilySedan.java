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
	 * @param n the number of trucks taht have been created, used to generate unique name
	 * @param ps the instance of the petrol station running
	 * @param steps What step the vehicle was created on, used to work out how long spent in queue
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
