package aston.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import aston.resources.Config;
import aston.station.PetrolStation;
import aston.vehicles.Motorbike;

	
public class MotorbikeTest {
	
	String n = "1";
	int steps= 30;
	PetrolStation ps = new PetrolStation(new Config());
	Motorbike testcar = new Motorbike(n, ps, steps);
	
	public MotorbikeTest()
	{
		testGetTankSize();
		testGetVehicleSize();
		getShopTimeLimit();
		getShoppingProbability();
		getTimeTakenShopping();
		getMoneySpentShopping();
	}
	@Test
public void testGetTankSize()
{
	assertEquals("the tank size must be between 0.5", (0.5 == testcar.getTankSize()));
}
	@Test
public void testGetVehicleSize()
{
	assertTrue("small car's size must be 0.75",( 0.75 == testcar.getVehicleSize()));
}
	@Test
public void getShopTimeLimit()
{
	assertTrue("small car's shop time limit bust be 0", (0 == testcar.getShopTimeLimit()));
}
	@Test
public void getShoppingProbability()
{
	assertTrue("small car's shopping probability must be 0.5 ", (0.5== testcar.getShoppingProbability()));
}
	@Test
public void getTimeTakenShopping()
{
	assertTrue("small car's time taken must be 0",  (0 == testcar.getTimeTakenShopping()));
}
	@Test
public void getMoneySpentShopping()
{
	assertTrue("small car's money spent must be betweeen 0 pence", (0 == testcar.getMoneySpentShopping()));
}

}
