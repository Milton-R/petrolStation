package aston.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import aston.resources.Config;
import aston.station.PetrolStation;
import aston.vehicles.FamilySedan;


	
public class FamilySedanTest {
	
	String n = "2";
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
	assertEquals("the tank size must be between 12", 12 ,testcar.getTankSize(), 6);
}
	@Test
public void testGetVehicleSize()
{
	assertTrue("Family Sedan's size must be 1.5",( 1.5 == testcar.getVehicleSize()));
}
	@Test
public void getShopTimeLimit()
{
	assertEquals("Family Sedan's shop time limit bust be 60", 60, ( testcar.getShopTimeLimit()));
}
	@Test
public void getShoppingProbability()
{
	assertTrue("Family Sedan's shopping probability must be 0.5 ", (0.5== testcar.getShoppingProbability()));
}
	@Test
public void getTimeTakenShopping()
{
	assertEquals("Family Sedan's time taken must be between 12 and 24",  12, testcar.getTimeTakenShopping(), 12 );
}
	@Test
public void getMoneySpentShopping()
{
	assertEquals("Family Sedan's money spent must be betweeen 800 to 800 pence", 800, testcar.getMoneySpentShopping(), 800 );
}
}
