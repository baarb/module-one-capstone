package VendingMachine;

import java.util.Map;
import java.util.Stack;

import Items.Item;

public class GetItem extends VendingMachine
{
	public GetItem(Map<String, Stack<Item>> inventory)
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
