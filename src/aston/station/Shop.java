package aston.station;
import aston.resources.*;

public class Shop {
	
	
	public Shop(int numTills)
	{
		Till[] tills = new Till[numTills];
		for (int i = 0; i < numTills; i++)
		{
			Till t = new Till();
			tills[i] = t;
		}
	}

}
