package VendingMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import Items.ItemsClass;

public class VendingMachine
{
	private BigDecimal balance = new BigDecimal("0.00");
	private Map<String, Stack<ItemsClass>> inventory;
	private List<ItemsClass> itemBin;
	
	
	public VendingMachine(Map<String, Stack<ItemsClass>> inventory) {
		this.inventory = inventory;
	}

	public String inventoryDisplay(VendingMachine machine) throws FileNotFoundException {
	File inventoryCSV = new File("vendingmachine.csv");
	Map<String, Stack<ItemsClass>> inventory = new HashMap<>();
	try (Scanner fileScanner = new Scanner(inventoryCSV))
	{
		while (fileScanner.hasNextLine())
		{
			String line = fileScanner.nextLine();
			String[] lineArray = line.trim().split("\\|");
			String mapLocation = lineArray[0];
			String itemName = lineArray[1];
			BigDecimal price = new BigDecimal(lineArray[2]);
			int stackSize = machine.getInventory().get(mapLocation).size();

			System.out.println(mapLocation + " | " + itemName + " | " + price + " | " + stackSize);
		}
		return "";
	}
}
			
			
			
	
//	public map inventoryDisplay(Map<String, Stack<ItemsClass>> inventory) {
//		return inventory.entrySet();
//	}
	
	
	public void feedMoney(BigDecimal inputMoney) {
		balance = balance.add(inputMoney);
		
	}
	public Stack<ItemsClass> dispence(String slotId) {
		return inventory.get(slotId);
	}

	public BigDecimal getBalance()
	{
		return balance;
	}


	public void setBalance(BigDecimal balance)
	{
		this.balance = balance;
	}


	public List<ItemsClass> getItemBin()
	{
		return itemBin;
	}


	public void setItemBin(List<ItemsClass> itemBin)
	{
		this.itemBin = itemBin;
	}


	public Map<String, Stack<ItemsClass>> getInventory()
	{
		return inventory;
	}
	
	
	
	
	
	
	
	//Methods
//	deposite
//	VendingMachine(Map<String, Stack<Item>>)
//	dispence(String slotId);
//	finish();//Consume all items, give back balance
	
	//Stack.size for quantity of items
}
