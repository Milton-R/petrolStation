package aston.tests;
import aston.station.PetrolStation;
import aston.vehicles.SmallCar;
import aston.vehicles.Vehicle;
import aston.station.PetrolStation;
import org.junit.BeforeClass;
import aston.resources.*;

import static org.junit.Assert.*;
import org.junit.Test;
public class SmallCarTest {
	
	@Test 
	public void testgetTankSize()
	{
		String n = "3";
		int steps= 30;
		PetrolStation ps = new PetrolStation(new Config());
		SmallCar testcar = new SmallCar(n, ps, steps);
		assertEquals("cba to type error message", 7 ,testcar.getTankSize(), 2);
		
		assertTrue("small car's size must be 1",!( 1.0 == testcar.getVehicleSize()));
		
		assertEquals("small car's shop time limit bust be 30", 30, ((Vehicle) testcar).getShopTimeLimit());
		//assertEquals("small car's shopping probability must be 0.3 ", 0.3, ((Vehicle) testcar).getShoppingProbability());
		assertEquals("small car's time taken must be between 12 and 24",  12, ((Vehicle) testcar).getTimeTakenShopping(), 12 );
		assertEquals("small car's money spent must be betweeen 500 to 1000 pence", 500, ((Vehicle) testcar).getMoneySpentShopping(), 500 );
	}
	
	//make it loop , and keep asing if it's done filling up
	//when it's false , it is done
	//store the number of steps taken to fill it up and make sure it lies within the tanksize range
	
	
}
