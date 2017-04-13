package aston.vehicles;

import aston.resources.Config;
import aston.station.*;

public class Customer {
	
	Vehicle owndenVehicle;
	int shoppingTime;
	Shop shop;
	
	public Customer(Vehicle ov, int shoppingTime)
	{
		owndenVehicle = ov;
		this.shoppingTime = shoppingTime;
	}
	
	public int getShoppingTime()
	{		
		return shoppingTime;
	}
	
	public void setShop(Shop s)
	{
		shop = s;
	}
	
	public void passTime()
	{
		shoppingTime -= Config.secondsPerTick;
		if (shoppingTime <= 0)
		{
			shop.sendToTill(this);
		}
	}
}
