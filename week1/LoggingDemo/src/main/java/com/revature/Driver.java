package com.revature;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Driver {
	
	private static Logger log = Logger.getLogger(Driver.class);
	// The Log4J logger has a static method to obtain a specific logger that is
	// bound to a specific class
	// Generally, we will make these loggers as a private static variable
	
	/*
	 * Log4J has several "Logging Levels"
	 * OFF: No logging at all
	 * ALL: Turns on all levels of logging
	 * TRACE: Adds more information to our DEBUG logs
	 * DEBUG: Primarily a logging level for Developers (Turn  on all of the following levels)
	 * INFO: Represent important business processes, used for defining when they have completed
	 *  and that the current application state is "as expected"
	 *  Generally speaking System Administrators will monitor INFO logs to track Application status
	 * 
	 * WARN: Suggest that the application might be continued, but you should take extra caution
	 * ERROR: Shouts that something has gone very wrong and should be investigated immediately
	 * FATAL: Very uncommon, but signals that something is terribly wrong, and will likely result
	 * 	in application failure
	 */

	public static void main(String[] args) throws FileNotFoundException {
		log.info("The application has started");
		
		try {
			recur();
		} catch(Error err) {
			log.error("Oh no! Something is wrong!", err);
		}
		
		log.info("The application has survived, but maybe it shouldn't have");

		List<Object> list = new ArrayList<>();
		
		try {
			while(true) {
				list.add(new Object());
			}
		} catch(Error err) {
			log.error("Something else has gone horribly wrong!", err);
		}
	}
	
	public static void recur() {
		recur();
	}
}
