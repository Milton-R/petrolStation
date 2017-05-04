package aston.tests;
import aston.station.Output;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestOutput {
	
	Output output = new Output();
	public TestOutput()
	{
		
		output.addTruck();
		output.addSC();
		output.addFS();
		output.addM();
		output.incStep();
		output.addAdditionalMoney(1);
		output.addLostMoney(1);
		output.setFuelMoney(1);
		output.setNumGallons(1);
		testGetSC();
		testGetM();
		testGetFS();
		testGetTruck();
		testGetNumSteps();
		testGetFuelMoney();
		testGetLostMoney();
		testGetAdditionalMoney();
	}
	@Test
	public void testGetGallons()
	{
		assertEquals(" the number of gallons must be the same as 1 ",1, output.getGallons());
	}
	@Test
	public void testGetTotalVehicles()
	{
		assertEquals(" the number of vehicles must be 1" ,4, output.getTotalVehicles());
	}
	@Test
	public void testGetSC()
	{
		assertEquals(" the number of Small Cars must be 1" ,1, output.getSC());
	}
	@Test
	public void testGetM()
	{
		assertEquals(" the number of Motorbikes must be 1" ,1, output.getM());
	}
	@Test
	public void testGetFS()
	{
		assertEquals(" the number of Family Sedans must be 1", 1 , output.getFS());
	}
	@Test
	public void testGetTruck()
	{
		assertEquals(" the number of Trucks must be 1" ,1, output.getTruck());
	}
	@Test
	public void testGetNumSteps()
	{
		assertEquals(" the number of steps must be 1" ,1, output.getNumSteps());
	}
	@Test
	public void testGetFuelMoney()
	{
		assertEquals(" the amount of fuel money must be 1" ,1, output.getFuelMoney());
	}
	@Test
	public void testGetLostMoney() 
	{
		assertEquals(" the amount of lost money must be 1" ,1, output.getLostMoney());
	}
	@Test
	public void testGetAdditionalMoney() {
		assertEquals(" the amount of vehicles must be 1" ,1, output.getAdditionalMoney());
	}

}
