package aston.vehicles;

import aston.resources.Config;
import aston.station.*;

public class Customer {
	
	private Vehicle ownedVehicle;
	private String name;
	private int shoppingTime;
	private Shop shop;
	
	public Customer(Vehicle ov, int shoppingTime)
	{
		ownedVehicle = ov;
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
		if (shoppingTime <= 0)
		{
			shop.sendToTill(this);
			System.out.println(name + " goes to till");
		}
		shoppingTime -= Config.secondsPerTick;
	}
	
	public void leave()
	{
		ownedVehicle.vLeave();
		System.out.println(name + " drives away");
	}
	
	public String getName()
	{
		return name;
	}
}
