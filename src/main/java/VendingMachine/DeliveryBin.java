package VendingMachine;

import java.util.ArrayList;
import java.util.List;

import Items.Item;

public class DeliveryBin
{
	
	
	private List<Item> deliveryBin = new ArrayList<Item>();
	
	public void addToDeliveryBin(Item vendingItem) {
		deliveryBin.add(vendingItem);
	}
		
	
	public List<Item> getDeliveryBin()
	{
		return deliveryBin;
	}
	

}
