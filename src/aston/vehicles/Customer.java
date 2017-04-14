package aston.vehicles;

import aston.resources.Config;
import aston.station.*;

public class Customer {
	
	private Vehicle owndenVehicle;
	private String name;
	private int shoppingTime;
	private Shop shop;
	
	public Customer(Vehicle ov, int shoppingTime)
	{
		owndenVehicle = ov;
		this.shoppingTime = shoppingTime;
		String vName = ov.getName();
		name = "Customer" + vName.substring(0,1) + vName.substring(vName.length()-1);
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
	
	public String getName()
	{
		return name;
	}
}
