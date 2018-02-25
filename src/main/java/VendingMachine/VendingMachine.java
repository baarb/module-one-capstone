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

	public VendingMachine(Map<String, Stack<Item>> inventory) {
		this.inventory = inventory;
	}

	public String inventoryDisplay() {
		String output = "";

		for (String key : inventory.keySet()) {
			String itemName;
			BigDecimal price;

			if (inventory.get(key).isEmpty()) {
				itemName = "SOLD OUT";
				price = BigDecimal.ZERO;
			} else {
				itemName = inventory.get(key).peek().getName();
				price = inventory.get(key).peek().getPrice();
			}
			int stackSize = inventory.get(key).size();
			output += key + " | " + itemName + " | " + price + " | " + stackSize + "\n";
		}

		return output;
	}

	public void feedMoney(BigDecimal inputMoney) {
		balance = balance.add(inputMoney);

	}

	public Item dispense(String slotId) {
		Stack<Item> selectedStack = inventory.get(slotId);
		if (selectedStack.size() > 0) {
			BigDecimal selectedItemPrice = selectedStack.peek().getPrice();
			if (selectedItemPrice.compareTo(balance) <= 0) {
				Item currentItem = selectedStack.pop();
				balance = balance.subtract(selectedItemPrice);
				LogWriter.newLogEntry(currentItem.getName() + " " + slotId + " " + selectedItemPrice + " " + balance);
				return currentItem;

			} else {
				System.out.println("Insufficient funds, please add more money.");
			}
		}

		else {
			System.out.println("SOLD OUT");
		}
		return null;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Map<String, Stack<Item>> getInventory() {
		return inventory;
	}

}
