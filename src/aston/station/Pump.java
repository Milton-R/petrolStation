package aston.station;

import aston.vehicles.*;
import aston.resources.*;

public class Pump {
	
	Vehicle currentVehicle;
	VehicleQueue currentQueue;
	int pumpSpeed = Config.gallonPerTick;
	
	public void pumpFuel()
	{
		currentVehicle.fillTank(pumpSpeed);
	}

}
