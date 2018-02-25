package VendingMachine;

import java.util.ArrayList;
import java.util.List;

import Items.ItemsClass;

public class DeliveryBin
{
	
	
	private List<ItemsClass> deliveryBin = new ArrayList<ItemsClass>();
	
	public void addToDeliveryBin(ItemsClass vendingItem) {
		deliveryBin.add(vendingItem);
	}
		
	
	public List<ItemsClass> getDeliveryBin()
	{
		return deliveryBin;
	}
	

}
