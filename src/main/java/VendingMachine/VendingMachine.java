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
