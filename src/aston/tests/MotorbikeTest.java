package aston.tests;

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
		assertTrue("Motorbike's the tank size must be 5", (5 == testcar.getTankSize()));
	}
	@Test
	public void testGetVehicleSize()
	{
		assertTrue("Motorbike's size must be 0.75",( 0.75 == testcar.getVehicleSize()));
	}
	@Test
	public void getShopTimeLimit()
	{
		assertTrue("Motorbike's shop time limit bust be 0", (0 == testcar.getShopTimeLimit()));
	}
	@Test
	public void getShoppingProbability()
	{
		assertTrue("Motorbike's shopping probability must be 0 ", (0 == testcar.getShoppingProbability()));
	}
	@Test
	public void getTimeTakenShopping()
	{
		assertTrue("Motorbike's time taken must be 0",  (0 == testcar.getTimeTakenShopping()));
	}
	@Test
	public void getMoneySpentShopping()
	{
		assertTrue("Motorbike's money spent must be betweeen 0 pence", (0 == testcar.getMoneySpentShopping()));
	}

}
