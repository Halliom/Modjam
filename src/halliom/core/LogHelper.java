package halliom.core;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogHelper 
{
	
	private static Logger log = Logger.getLogger("Backpacked");
	
	public static void log(String message)
	{
		log.log(Level.INFO, message);
	}
	
	public static void logError(String message)
	{
		log.log(Level.SEVERE, message);
	}
	
}
