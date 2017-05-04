package aston.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import aston.station.PetrolStation;
import aston.vehicles.SmallCar;
import aston.vehicles.Vehicle;
import aston.resources.*;

public class SmallCarTest {

	String n = "3";
	int steps= 30;
	PetrolStation ps = new PetrolStation(new Config());
	SmallCar testcar = new SmallCar(n, ps, steps);


	@Test 
	public void testGetTankSize()
	{
		assertEquals("cba to type error message", 7 ,testcar.getTankSize(), 2);

	}

	@Test 
	public void testGetVehicleSize()
	{
		assertTrue("small car's size must be 1",( 1.0 == testcar.getVehicleSize()));

	}


	//make it loop , and keep using if it's done filling up
	//when it's false , it is done
	//store the number of steps taken to fill it up and make sure it lies within the tank size range


	@Test 
	public void testGetShoppingtime()
	{
		assertEquals("small car's shop time limit bust be 30", 30 ,testcar.getShopTimeLimit(), 12);
	}

	@Test 
	public void testGetShoppingProbability()
	{
		assertTrue("small car's shopping probability must be 0.3 ", (0.3==testcar.getShoppingProbability()));
	}

	@Test 
	public void testGetMoneySpentShopping()
	{
		assertEquals("small car's money spent must be betweeen 500 to 1000 pence", 500, ((Vehicle) testcar).getMoneySpentShopping(), 500 );
	}

}