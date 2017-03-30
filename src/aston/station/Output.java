package aston.station;

public class Output {
	private PetrolStation petrolstation= new PetrolStation();
	private int numSc, numM, numFs, TotalFuelP, totalVSpwnd, moneyFromFuel ;
	
	/*Things we need to keep track of:
	 * #At the end of simulation
	 * - Total number of vehicles
	 * - How many of each type of vehicle
	 * - Ammount of fuel pumped
	 * - Ammount of money earned from fuel
	 * - Ammount of money earned from store
	 * - Ammount of money missed
	 * 
	 * #Throughout simulation
	 * - What vehicles are in what pump queues
	 * - Current fuel tank of vehicle at front of queue
	 * - How much of the queue is taken up for each queue
	 * - What Customers are in the store?
	 * - What Customers are in what till queues?
	 * - What step it is on
	 * 
	 * #Truck
	 * - truck probability?
	 */
	
	Output(){ 
		
		
	}
		
	public int totalfuelPumped()
	{
		return  TotalFuelP;
		

	}
	
	public void TotalFP()
	
	{
		TotalFuelP++;
		moneyFromFuel = moneyFromFuel + 1200;
	}
	
	public int MoneyFFuel()
	
	{
		
		return moneyFromFuel;
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

}
