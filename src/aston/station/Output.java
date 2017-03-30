package aston.station;

import aston.resources.Config;

public class Output {

	
	private int numSc, numM, numFs, numGallons, totalVSpwnd, currentStep = 0, fuelMoney;
	
	/*Things we need to keep track of:
	 * #At the end of simulation
	 * - Total number of vehicles
	 * - How many of each type of vehicle
	 * - Amount of fuel pumped
	 * - Amount of money earned from fuel
	 * - Amount of money earned from store
	 * - Amount of money missed
	 * 
	 * #Throughout simulation
	 * - What vehicles are in what pump queues
	 * - Current fuel tank of vehicle at front of queue
	 * - How much of the queue is taken up for each queue
	 * - What Customers are in the store?
	 * - What Customers are in what till queues?
	 * - What step it is on.
	 * 
	 * #Truck
	 * - truck probability?
	 */
	
	Output(){ 
		
		
	}
	
	public void setNumGallons(int i)
	{
		numGallons = i;
	}
		

	public int getGallons()
	{
		return numGallons;
	}
	
	public void MoneyStore(){
		
		
	}
	
	public void VehicleInQueue()
	{
		
		
		
	}
   
	
	public int getTotalVehicles()
	{
		return totalVSpwnd;
	}
	
	public void addSC()
	{
		numSc++;
		totalVSpwnd++;
	}
	
	//stores number of motorcycles
	public void addM()
	{
		numM++;
		totalVSpwnd++;
	}
	
	
	// stores family sudans
	public void addFS()
	{
		numFs++;
		totalVSpwnd++;
	}
	
	
	//stores small car
	public int getSC()
	{
		return numSc;
	}
	
	
	//gets motorcycle
	public int getM()
	{
		return numM;
	}
	
	public int getFS()
	{
		return numFs;
	}
	
	public int getNumSteps()
	{
		return currentStep;
	}
	
	public void incStep()
	{
		currentStep++;
	}
	
	public void setFuelMoney(int m)
	{
		fuelMoney = m;
	}
	
	public int getFuelMoney()
	{
		return fuelMoney;
	}

}
