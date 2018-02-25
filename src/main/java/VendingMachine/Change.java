package VendingMachine;

import java.math.BigDecimal;

public class Change

{	
	public Change() {
		
	}
	//Methods
	public String makeChange(BigDecimal balance) {
		int quarterCounter = 0;
		int dimeCounter = 0;
		int nickelCounter = 0;
		
		BigDecimal changeBalance = balance;
		
		while(balance.compareTo(new BigDecimal ("0.00")) >0) {
			if(balance.compareTo(new BigDecimal ("0.25")) >=0) {
				balance = balance.subtract(new BigDecimal ("0.25"));
				quarterCounter++;
			}else if(balance.compareTo(new BigDecimal ("0.10")) >=0) {
				balance = balance.subtract(new BigDecimal ("0.10"));
					dimeCounter++;
			}else if(balance.compareTo(new BigDecimal ("0.05")) >=0) {
				balance = balance.subtract(new BigDecimal ("0.05"));
				nickelCounter++;
			}else {
				balance = new BigDecimal ("0.00");
			}
		}
			LogWriter.newLogEntry("GIVE CHANGE: $" + changeBalance + " $" + balance);
			return "Your change is: " + quarterCounter + " quarter(s), " + dimeCounter + " dime(s), and " + nickelCounter + " nicklel(s).";
	}
}