package aston.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import aston.resources.Config;
import aston.station.PetrolStation;
import aston.vehicles.Truck;
import aston.vehicles.Vehicle;

public class TruckTestClass {

	String n = "4";
	int steps= 30;
	PetrolStation ps = new PetrolStation(new Config());
	Truck testcar = new Truck(n, ps, steps);

	@Test 
	public void testGetTankSize()
	{
		assertEquals("truck's tank size is 30", 30,testcar.getTankSize(), 10);

	}
	
	@Test 
	public void testGetVehicleSize()
	{
		assertTrue("Truck's size must be 2",( 2 == testcar.getVehicleSize()));
		
	}
	
	
	//make it loop , and keep using if it's done filling up
	//when it's false , it is done
	//store the number of steps taken to fill it up and make sure it lies within the tank size range
		

  @Test 
   public void testGetShoppingtime()
   {
	  assertEquals("Truck's shop time limit must be 48", 48 ,testcar.getShopTimeLimit(), 12);
   }
  
  @Test 
  public void testGetShoppingProbability()
  {
	  assertTrue("Trucks's shopping probability must be 0.3 ", (1 == testcar.getShoppingProbability()));
  }
  
  @Test 
  public void testGetMoneySpentShopping()
  {
	  assertEquals("Trucks's money spent must be betweeen 500 to 1000 pence", 1500, testcar.getMoneySpentShopping(), 500 );
  }
	
	
	
	
	
	
	
	
	
}
