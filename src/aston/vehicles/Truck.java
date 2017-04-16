package aston.vehicles;

import aston.resources.Config;
import aston.station.PetrolStation;

public class Truck extends Vehicle{


public Truck(PetrolStation ps) {
		super(ps);
		
		if (Config.truck_tankRange > 0)
		{
			tank = Config.truck_tank + petrolStation.rand.nextInt(Config.truck_tankRange);
		}
		else
		{
			tank = Config.truck_tank;}
		
}

	
	
}
	