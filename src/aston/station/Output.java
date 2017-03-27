package aston.station;

public class Output {
	private PetrolStation petrolstation= new PetrolStation();
	private Pump pump= new Pump();
	private int numSc, numM, numFs, numGallons;
	
	Output(){ 
		
		
	}
		
	public void getGallons()
		{
			numGallons = pump.getNumOfGallons();
			System.out.println(numGallons);
			
		}

	public void getVehicles()
	{
		
	}
	

}
