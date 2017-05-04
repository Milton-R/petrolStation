package aston.tests;
import aston.station.Output;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestOutput {
	private int numTruck = 3;
	private int numSc = 4;
	private int numM = 6;
	private int numFs = 8;
	private int numGallons= 0;
	private int totalVSpwnd= 1; 
	private int currentStep = 2;
	private int fuelMoney= 7; 
	private int lostMoney= 9; 
	private int additionalMoney= 12;
	private Output output = new Output();
	TestOutput()
	{
		testGetGallons();
		
		
	}
	@Test
	/*public void testSetNumGallons()
	{
		assertEquals(" the number of gallons must be the same as the setter ", , (setNumGallons(6))));
	}
	
	public void setNumGallons(int i)
	{
		numGallons = i;
	}
	*/
	public void testGetGallons()
	{
		assertEquals(" the number of gallons must be the same as " + numGallons +"",numGallons, output.getGallons());
	}
	public void testGetTotalVehicles()
	{
		assertEquals(" the number of vehicles must be "+totalVSpwnd+"" ,totalVSpwnd, output.getTotalVehicles());
	}
	/*public void testAddM()
	{
		int i;
		assertEquals(" the number of num of m must be one more than before ",(numM++) , i= output.addM());
		numM++;
		totalVSpwnd++;
	}
	public void addFS()
	{
		numFs++;
		totalVSpwnd++;
	}
	public void addTruck()
	{
		numTruck++;
		totalVSpwnd++;
	}*/
	public void testGetSC()
	{
		assertEquals(" the number of Small Cars must be "+numSc+"" ,numSc, output.getSC());
	}
	public void testGetM()
	{
		assertEquals(" the number of Motorbikes must be "+numM+"" ,numM, output.getM());
	}
	public void getFS()
	{
		assertEquals(" the number of Family Sedans must be "+numFs+"" ,numFs, output.getFS());
	}
	public void testGetTruck()
	{
		assertEquals(" the number of Trucks must be "+numTruck+"" ,numTruck, output.getTruck());
		
	}
	public void testGetNumSteps()
	{
		assertEquals(" the number of steps must be "+currentStep+"" ,currentStep, output.getNumSteps());
		
	}
	/*public void incStep()
	{
		currentStep++;
	}
	public void setFuelMoney(int m)
	{
		fuelMoney += m;
	}
	*/
	public void testGetFuelMoney()
	{
		assertEquals(" the amount of fuel money must be "+fuelMoney+"" ,fuelMoney, output.getFuelMoney());
	}

	public void testGetLostMoney() 
	{
		assertEquals(" the amount of lost money must be "+lostMoney+"" ,lostMoney, output.getLostMoney());
	}
	
	/*
	public void addLostMoney(int lostMoney) {
		this.lostMoney += lostMoney;
	}
	*/


	public void getAdditionalMoney() {
		assertEquals(" the amount of vehicles must be "+additionalMoney+"" ,additionalMoney, output.getAdditionalMoney());
	}

	/*
	public void addAdditionalMoney(int additionalMoney) {
		this.additionalMoney += additionalMoney;
	}
	*/

}
