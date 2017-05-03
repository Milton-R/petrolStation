package aston.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import aston.resources.Config;
import aston.station.PetrolStation;
import aston.vehicles.FamilySedan;
import aston.vehicles.Vehicle;

	
public class FamilySedanTest {
	
	String n = "3";
	int steps= 30;
	PetrolStation ps = new PetrolStation(new Config());
	FamilySedan testcar = new FamilySedan(n, ps, steps);
	
	public FamilySedanTest()
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
	assertEquals("the tank size must be between 12-18", 12.0 ,testcar.getTankSize(), 6.0);
}
	@Test
public void testGetVehicleSize()
{
	assertTrue("small car's size must be 1",( 1.5 == testcar.getVehicleSize()));
}
	@Test
public void getShopTimeLimit()
{
	assertEquals("small car's shop time limit bust be 60", 60, ((Vehicle) testcar).getShopTimeLimit());
}
	@Test
public void getShoppingProbability()
{
	assertTrue("small car's shopping probability must be 0.5 ", (0.5== ((Vehicle) testcar).getShoppingProbability()));
}
	@Test
public void getTimeTakenShopping()
{
	assertEquals("small car's time taken must be between 12 and 24",  12, ((Vehicle) testcar).getTimeTakenShopping(), 12 );
}
	@Test
public void getMoneySpentShopping()
{
	assertEquals("small car's money spent must be betweeen 800 to 800 pence", 800, ((Vehicle) testcar).getMoneySpentShopping(), 800 );
}
}
