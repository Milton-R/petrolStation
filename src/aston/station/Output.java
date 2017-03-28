package aston.station;

public class Output {
	private PetrolStation petrolstation= new PetrolStation();
	private int numSc, numM, numFs, numGallons, totalVSpwnd;
	
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
	 * - What Customes are in the store?
	 * - What Customers are in what till queues?
	 * - What step it is on
	 * 
	 * #Truck
	 * - truck probability?
	 */
	
	Output(){ 
		
		
	}
		
	public void getGallons()
	{
			numGallons = pump.getNumOfGallons();
			System.out.println(numGallons);	
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
	
	public void addM()
	{
		numM++;
		totalVSpwnd++;
	}
	
	public void addFS()
	{
		numFs++;
		totalVSpwnd++;
	}
	
	public int getSC()
	{
		return numSc;
	}
	
	public int getM()
	{
		return numM;
	}
	
	public int getFS()
	{
		return numFs;
	}

}
