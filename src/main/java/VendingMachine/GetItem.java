package VendingMachine;

import java.util.Map;
import java.util.Stack;

import Items.ItemsClass;

public class GetItem extends VendingMachine
{
	public GetItem(Map<String, Stack<ItemsClass>> inventory)
	{
		super(inventory);
		// TODO Auto-generated constructor stub
	}

	public String getItem(String slotId) {
		VendingMachine machine = new VendingMachine(getInventory());
		String itemName = machine.getInventory().get(slotId).peek().getName();
		return itemName;
	}
	
	
	

}
