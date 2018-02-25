package VendingMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

import Items.Beverages;
import Items.Candy;
import Items.Chips;
import Items.Gum;
import Items.Item;

public class InventoryReader {
	public Map<String, Stack<Item>> generateInventory() throws FileNotFoundException {
		File inventoryCSV = new File("vendingmachine.csv");
		Map<String, Stack<Item>> inventory = new TreeMap<>();
		
		try (Scanner fileScanner = new Scanner(inventoryCSV)) {
			
			while (fileScanner.hasNextLine()) {
				Stack<Item> itemStack = new Stack<>();
				String line = fileScanner.nextLine();
				String[] lineArray = line.trim().split("\\|");
				String mapLocation = lineArray[0];
				String itemName = lineArray[1];
				BigDecimal price = new BigDecimal(lineArray[2]);
				Item tempItem;
				
				if (mapLocation.startsWith("A")) {
					tempItem = new Chips(itemName, price);
				} else if (mapLocation.startsWith("B")) {
					tempItem = new Candy(itemName, price);
				} else if (mapLocation.startsWith("C")) {
					tempItem = new Beverages(itemName, price);
				} else {
					tempItem = new Gum(itemName, price);
				}
				
				for (int i = 0; i < 5; i++) {
					itemStack.push(tempItem);
				}
				
				inventory.put(mapLocation, itemStack);
			}
			return inventory;
		}
	}
}

