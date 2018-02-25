package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options, String message) {
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options);
			out.println(message);
			out.flush();
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}
	public Object getChoiceFromOptions(Object[] options) {
		return getChoiceFromOptions( options, "");
	}
	
	public BigDecimal getAmountFromUserInput() {
		for(;;){
			out.println();
			out.print("Please enter number of whole dollars >>>");
			out.flush();

			String userInput = in.nextLine();
			try {
				int userInputInt = Integer.parseInt(userInput);
				if(userInputInt % 1 == 0) {
				return new BigDecimal(userInput).setScale(2);}
			} catch(NumberFormatException ex) {
				out.println("Please enter a valid number.");
				out.println();
				out.flush();
			}
		}
	}

	public Object getChoiceFromUserInput(Object[] options) {
		out.print("\nPlease choose an option >>> ");
		out.flush();
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if(selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {
			out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.flush();
	}
}
