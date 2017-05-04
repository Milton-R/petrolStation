package aston.station;

/**
 * This presents the information with the amount of information required to present to user.
 * 
 * @author Tristan P.
 * @version 19/04/2017
 */

public class Output {

	
	private int numTruck, numSc, numM, numFs, numGallons, totalVSpwnd, currentStep = 0, fuelMoney, lostMoney, additionalMoney;
	
	/**
	 * Output Consructor
	 */
	public Output(){ 
		
		
		
	}
	
	/**
	 * Set the number of Gallons
	 * 
	 * @param i Integer Data Type
	 */
	public void setNumGallons(int i)
	{
		numGallons = i;
	}
		
	/**
	 * Set the Gallon size 
	 * 
	 * @return numGallons
	 */
	public int getGallons()
	{
		return numGallons;
	}
	
	/**
	 * Money Store Method
	 */
	public void MoneyStore(){
		
		
	}
	
	/**
	 * Vehicle in Queue
	 */
	public void VehicleInQueue()
	{
		
		
		
	}
   
	/**
	 * Get the total Vehicles 
	 * @return totalVSpwnd the total amount of Vehicles spawned in the 
	 */
	public int getTotalVehicles()
	{
		return totalVSpwnd;
	}
	
	/**
	 * Store Small Car
	 */
	public void addSC()
	{
		numSc++;
		totalVSpwnd++;
	}
	
	/**
	 * Store number of motorcycles
	 */
	public void addM()
	{
		numM++;
		totalVSpwnd++;
	}
	
	
	/**
	 * Store family sudans
	 */
	public void addFS()
	{
		numFs++;
		totalVSpwnd++;
	}
	
	/**
	 * Add a Truck to the 
	 */
	public void addTruck()
	{
		numTruck++;
		totalVSpwnd++;
	}
	
	/**
	 * Store the Small Car
	 * @return numSc
	 */
	public int getSC()
	{
		return numSc;
	}
	
	
	/**
	 * Get M
	 * @return numM
	 */
	public int getM()
	{
		return numM;
	}
	
	/**
	 * Get FS
	 * @return numFS
	 */
	public int getFS()
	{
		return numFs;
	}
	
	/**
	 * Get Truck Vehicle Objects 
	 * @return numTrucks
	 */
	public int getTruck()
	{
		return numTruck;
	}
	
	/**
	 * Get the current Number of Steps
	 * 
	 * @return currentStep Step Counter
	 */
	public int getNumSteps()
	{
		return currentStep;
	}
	
	/**
	 * Increment Step Method<br>
	 * This increase the current step counter by 1
	 */
	public void incStep()
	{
		currentStep++;
	}
	
	/**
	 * Set the Fuel Money
	 * 
	 * @param m Integer Data Type Parameter
	 */
	public void setFuelMoney(int m)
	{
		fuelMoney += m;
	}
	
	/**
	 * Get the Fuel Money 
	 * @return fuelMoney
	 */
	public int getFuelMoney()
	{
		return fuelMoney;
	}

	/**
	 * Accessor Method of Money Lost during each tick
	 * 
	 * @return Money loss
	 */
	public int getLostMoney() {
		return lostMoney;
	}

	/**
	 * Add the current amount of lost money by the next amount of money lost
	 * @param lostMoney money lost when customer doesnt go to store or vehicle has no space at pump and leaves
	 */
	public void addLostMoney(int lostMoney) {
		this.lostMoney += lostMoney;
	}

	/**
	 * Accessor Method of Addtional Money
	 * @return additionalMoney
	 */
	public int getAdditionalMoney() {
		return additionalMoney;
	}

	/**
	 * Mutator Method of Addtional Money
	 * @param additionalMoney the money that is made in the store for a customer
	 */
	public void addAdditionalMoney(int additionalMoney) {
		this.additionalMoney += additionalMoney;
	}

}
