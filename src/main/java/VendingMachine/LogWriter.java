package VendingMachine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter
{
	
	public static void newLogEntry(String entry) {
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("Log.txt", true));
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime = LocalDateTime.now();
			String formattedDateTime = dateTime.format(formatter);
			
			pw.write(formattedDateTime + " " + entry + '\n');
			pw.close();
		}
		catch(IOException ex) {
			
		}
		
		
	}
	
}
