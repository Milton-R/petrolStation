package aston.vehicles;

import aston.resources.*;
import aston.station.*;

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
		tank = Config.familySedan_tank + PetrolStation.rand.nextInt(Config.familySedan_tankRange);
		
	}
}
