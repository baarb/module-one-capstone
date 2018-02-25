package VendingMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import Items.Beverages;
import Items.Candy;
import Items.Chips;
import Items.Gum;
import Items.ItemsClass;

public class InventoryReader
{
	public Map<String, Stack<ItemsClass>> generateInventory() throws FileNotFoundException
	{
		File inventoryCSV = new File("vendingmachine.csv");
		Map<String, Stack<ItemsClass>> inventory = new HashMap<>();
		try (Scanner fileScanner = new Scanner(inventoryCSV))
		{
			while (fileScanner.hasNextLine())
			{
				Stack<ItemsClass> itemStack = new Stack<>();
				String line = fileScanner.nextLine();
				String[] lineArray = line.trim().split("\\|");
				String mapLocation = lineArray[0];
				String itemName = lineArray[1];
				BigDecimal price = new BigDecimal(lineArray[2]);
				if (mapLocation.startsWith("A"))
				{
					Chips tempItem = new Chips(itemName, price);
					for (int i = 0; i < 5; i++)
					{
						itemStack.push(tempItem);
					}
					inventory.put(mapLocation, itemStack);
				}
				else if (mapLocation.startsWith("B"))
				{
					Candy tempItem = new Candy(itemName, price);
					for (int i = 0; i < 5; i++)
					{
						itemStack.push(tempItem);
					}
					inventory.put(mapLocation, itemStack);
				}
				else if (mapLocation.startsWith("C"))
				{
					Beverages tempItem = new Beverages(itemName, price);
					for (int i = 0; i < 5; i++)
					{
						itemStack.push(tempItem);
					}
					inventory.put(mapLocation, itemStack);
				}
				else
				{
					Gum tempItem = new Gum(itemName, price);
					for (int i = 0; i < 5; i++)
					{
						itemStack.push(tempItem);
					}
					inventory.put(mapLocation, itemStack);
				}
			}
			return inventory;
		}
	}
}

// Should be able to return a full map of inventory
//
