package aston.station;

public class Output {
	
	private Pump pump;
	private int numSc, numM, numFs, numGallons;
	
	Output()
	{
		
	public void getGallons()
		{
			pump= new Pump();
			numGallons = pump.getNumOfGallons();
			
		}
	}

}
