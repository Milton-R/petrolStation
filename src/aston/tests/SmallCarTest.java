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
	public void testSmallCar()
	{
		String n = "3";
		PetrolStation ps = new PetrolStation(new Config());
		SmallCar testcar = new SmallCar(n, ps);
		assertEquals("small car's fuel tank must be between 7 and 9", 7, ((Vehicle) testcar).getTankSize(), 2 );
		assertEquals("small car's size must be 1", 1.0, ((Vehicle) testcar).getVehicleSize());
		assertEquals("small car's shop time limit bust be 30", 30, ((Vehicle) testcar).getShopTimeLimit());
		assertEquals("small car's shopping probability must be 0.3 ", 0.3, ((Vehicle) testcar).getShoppingProbability());
		assertEquals("small car's time taken must be between 12 and 24",  12, ((Vehicle) testcar).getTimeTakenShopping(), 12 );
		assertEquals("small car's money spent must be betweeen 500 to 1000 pence", 500, ((Vehicle) testcar).getMoneySpentShopping(), 500 );
	}
	
}
