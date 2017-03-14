package aston.station;

import aston.vehicles.*;
import aston.resources.*;

public class Pump {
	
	Vehicle currentVehicle;
	Queue currentQueue;
	int pumpSpeed = Config.gallonPerTick;
	
	public void pumpFuel()
	{
		currentVehicle.fillTank(pumpSpeed);
	}

}
