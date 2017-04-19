package aston.resources;
/**
 * This is a class file which contains all the modifiable variables.
 * 
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
	private double smallCar_probability = 0.03;
	public static final int smallCarShoppingTimeLimit = 30;//ticks
	public static final double smallCarShoppingProbability = 0.3;
	public static final int smallCarTimeTakenShopping = 12;//ticks
	public static final int smallCarTimeTakenShoppingRange = 12;//ticks
	public static final int smallCarMoneySpent = 500; //pence
	public static final int smallCarMoneySpentRange = 500; //pence
	
	//SC Get/Set methods
	public double getScProb()
	{
		return smallCar_probability;
	}
	public void setScProb(double p)
	{
		smallCar_probability = p;
	}
	
	//Motorbike
	public static final int motorBike_tank = 5;//gallons
	public static final int motorBike_tankRange = 0;//gallons
	public static final double motorBike_space = 0.75;//u
	private double motorBike_probability = 0.03;
	public static final int motorBikeShoppingTimeLimit = 0;//ticks
	public static final double motorBikeShoppingProbability = 0;
	public static final int motorBikeTimeTakenShopping = 0;//ticks
	public static final int motorBikeTimeTakenShoppingRange = 0;//ticks
	public static final int motorBikeMoneySpent = 0; //pence
	public static final int motorBikeMoneySpentRange = 0; //pence
	
	//M Get/Set methods
	public double getMProb()
	{
		return motorBike_probability;
	}
	
	public void setMProb(double p)
	{
		motorBike_probability = p;
	}
	
	//FamilySedan
	public static final int familySedan_tank = 12;//gallons
	public static final int familySedan_tankRange = 6;//gallons
	public static final double familySedan_space = 1.5;//u
	private double familySedan_probability = 0.02;
	public static final int familySedanShoppingTimeLimit = 60;//ticks
	public static final double familySedanShoppingProbability = 0.5;
	public static final int familySedanTimeTakenShopping = 12;//ticks
	public static final int familySedanTimeTakenShoppingRange = 18;//ticks
	public static final int familySedanMoneySpent = 800; //pence
	public static final int familySedanMoneySpentRange = 800; //pence
	
	//FS Get/Set methods
	public double getFsProb()
	{
		return familySedan_probability;
	}
	public void setFsProb(double q)
	{
		familySedan_probability = q;
	}
	
	public static final int truck_tank = 30; //gallons
	public static final int truck_tankRange = 10; //gallons
	public static final int truck_space = 2; //space taken by truck
	public double truck_probability = 0.02; // truck probability
	public static final int truck_shoppingtime = 4; // truck shopping time
	public static final int truck_shoppingtime_range = 2; // truck shopping range 
	public static final int truck_money_spent = 1500 ; // money spent by truck
	public static final int truck_money_spent_range = 1500; // money range
	public static final double truck_badservice = 0.2; // bad satisfaction percentage drop
	public static final double truck_goodservice = 0.05; // good satisfaction percentage increase
	
	public double getTruckProb() {
		return truck_probability;
	}
	public void setTruckprob(double t){
		
		truck_probability = t;
	}
	
	
	//RandomSeed
	public static final int randomSeed = 42;
	
	//Number of steps to run for
	public int numSteps = 1;
	public void setNumSteps(int i)
	{
		numSteps = i;
	}
	public int getNumSteps()
	{
		return numSteps;
	}
	
	//Queue
	public static final int queueSize = 3;
	
	//Pump
	public static final int gallonPerTick = 1;//gallon
	private int numberOfPumps = 2;
	private int pencePerGallon = 120;//pence
	
	//Tills
	private int numberOftills = 4;
	
	//Pump and Tills Get/Set
	public int getNumPumps()
	{
		return numberOfPumps;
	}
	public void setNumPumps(int i)
	{
		numberOfPumps = i;
	}
	public int getPencePerGallon()
	{
		return pencePerGallon;
	}
	public void setPencePerGallon(int i)
	{
		pencePerGallon = i;
	}
	public int getNumTills()
	{
		return numberOftills;
	}
	public void setNumTills(int i)
	{
		numberOftills = i;
	}
	
	
}

