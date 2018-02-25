package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.view.Menu;

import Items.Item;
import VendingMachine.Change;
import VendingMachine.DeliveryBin;
import VendingMachine.InventoryReader;
import VendingMachine.LogWriter;
import VendingMachine.VendingMachine;

public class VendingMachineCLI
{

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS =
	{ MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	
	private static final String SECOND_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String SECOND_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String SECOND_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private String[] SECOND_MENU_OPTIONS =
	{ SECOND_MENU_OPTION_FEED_MONEY, SECOND_MENU_OPTION_SELECT_PRODUCT, SECOND_MENU_OPTION_FINISH_TRANSACTION, };
	
	private static final String[] THIRD_MENU_OPTION_LOCATION =
	{ "A1", "A2", "A3", "A4", "B1", "B2", "B3", "B4", "C1", "C2", "C3", "C4", "D1", "D2", "D3", "D4" };

	private Menu menu;

	public VendingMachineCLI(Menu menu) throws FileNotFoundException
	{
		this.menu = menu;
	}

	public void run() throws FileNotFoundException
	{
		InventoryReader inventoryReader = new InventoryReader();
		VendingMachine vendOMatic = new VendingMachine(inventoryReader.generateInventory());
		DeliveryBin bin = new DeliveryBin();

		
		String choice = "";

		
		while (true)
		{
			if (choice == "") {
				choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS,
						"Current balance is: $" + vendOMatic.getBalance() + ".");
			}

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS))
			{
				System.out.println(vendOMatic.inventoryDisplay());
				choice = "";

			}
			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE))
			{
				Scanner userInput = new Scanner(System.in);
				String secondChoice = (String) menu.getChoiceFromOptions(SECOND_MENU_OPTIONS,
						"Current balance is: $" + vendOMatic.getBalance() + ".");

				if (secondChoice.equals(SECOND_MENU_OPTION_FEED_MONEY))
				{
					BigDecimal inputMoney = menu.getAmountFromUserInput();
					vendOMatic.feedMoney(inputMoney);
					LogWriter.newLogEntry("FEED MONEY: $" + inputMoney + " $" + vendOMatic.getBalance());
				}
				else if (secondChoice.equals(SECOND_MENU_OPTION_SELECT_PRODUCT))
				{
					String keyInput = (String) menu.getChoiceFromOptions(THIRD_MENU_OPTION_LOCATION,
							"Current balance is: $" + vendOMatic.getBalance() + ".");
					
					Item boughtItem = vendOMatic.dispense(keyInput);
					
					if (boughtItem != null) {
						bin.addToDeliveryBin(boughtItem);
					}

					
				}
				
				else if(secondChoice.equals(SECOND_MENU_OPTION_FINISH_TRANSACTION)) {
					//Consume
					System.out.println();
					
					for(Item itemInBin : bin.getDeliveryBin()) {
						System.out.println(itemInBin.getName() + ": " + itemInBin.makeSound());
					}
					
					BigDecimal remainingBalance = vendOMatic.getBalance();
					Change returnedChange = new Change();
					String finalChange = returnedChange.makeChange(remainingBalance);
					vendOMatic.setBalance(BigDecimal.ZERO.setScale(2));
					
					System.out.println();
					System.out.println(finalChange);
					choice = "";
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

}
