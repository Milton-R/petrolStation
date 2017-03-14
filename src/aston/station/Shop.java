package aston.station;
import aston.resources.*;

public class Shop {
	
	int numTills = Config.numberOftills;
	Till[] tills = new Till[numTills];
	
	public Shop()
	{
		for (int i = 0; i < numTills; i++)
		{
			Till t = new Till();
			tills[i] = t;
		}
	}

}
