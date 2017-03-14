package aston.resources;
/**
 * This is a class file which contains all the modifiable variables.
 * @author Bartosem
 * @author Ramalhom
 *
 */
public class Config {
	
	//Tick
	public static final int secondsPerTick = 10;
	
	//SmallCar
	public static final int smallCar_tank = 7;//gallons
	public static final int smallCar_tankRange = 2;//gallons
	public static final double smallCar_space = 1;//u
	public static final double smallCar_probability = 0.03;
	public static final int smallCarShoppingTimeLimit = 30;//ticks
	public static final double smallCarShoppingProbability = 0.3;
	public static final int smallCarTimeTakenShopping = 12;//ticks
	public static final int smallCarTimeTakenShoppingRange = 12;//ticks
	public static final int smallCarMoneySpent = 500; //pence
	public static final int smallCarMoneySpentRange = 500; //pence
	
	//Motorbike
	public static final int motorBike_tank = 5;//gallons
	public static final double motorBike_space = 0.75;//u
	public static final double motorBike_probability = 0.02;
	public static final int motorBikeShoppingTimeLimit = 0;//ticks
	public static final double motorBikeShoppingProbability = 0;
	public static final int motorBikeTimeTakenShopping = 0;//ticks
	public static final int motorBikeTimeTakenShoppingRange = 0;//ticks
	public static final int motorBikeMoneySpent = 0; //pence
	public static final int motorBikeMoneySpentRange = 0; //pence
	
	//FamilySedan
	public static final int familySedan_tank = 12;//gallons
	public static final int familySedan_tankRange = 6;//gallons
	public static final double familySedan_space = 1.5;//u
	public static final double familySedan_probability = 0.01;
	public static final int familySedanShoppingTimeLimit = 60;//ticks
	public static final double familySedanShoppingProbability = 0.5;
	public static final int familySedanTimeTakenShopping = 12;//ticks
	public static final int familySedanTimeTakenShoppingRange = 18;//ticks
	public static final int familySedanMoneySpent = 800; //pence
	public static final int familySedanMoneySpentRange = 800; //pence
	
	//RandomSeed
	public static final int randomSeed = 42;
	
	//Queue
	public static final int queueSize = 3;
	
	//Pump
	public static final int gallonPerTick = 1;//gallon
	public static final int numberOfPumps = 2;
	public static final int pencePerGallon = 1200;//pence
	
	//Tills
	public static final int numberOftills = 4;
	}

