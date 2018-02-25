package VendingMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import Items.Item;

public class VendingMachine {
	private BigDecimal balance = new BigDecimal("0.00");
	private Map<String, Stack<Item>> inventory;
	private List<Item> itemBin;

	public VendingMachine(Map<String, Stack<Item>> inventory) {
		this.inventory = inventory;
	}

	public String inventoryDisplay(VendingMachine machine) throws FileNotFoundException {
		File inventoryCSV = new File("vendingmachine.csv");
		Map<String, Stack<Item>> inventory = new HashMap<>();
		try (Scanner fileScanner = new Scanner(inventoryCSV)) {
			while (fileScanner.hasNextLine()) {
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

	public void feedMoney(BigDecimal inputMoney) {
		balance = balance.add(inputMoney);

	}

	public Stack<Item> dispence(String slotId) {
		return inventory.get(slotId);
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<Item> getItemBin() {
		return itemBin;
	}

	public void setItemBin(List<Item> itemBin) {
		this.itemBin = itemBin;
	}

	public Map<String, Stack<Item>> getInventory() {
		return inventory;
	}

}
