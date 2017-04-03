package com.revature.logging;

import org.apache.log4j.Logger;

public class Logging {
private static org.apache.log4j.Logger Log=Logger.getRootLogger();

public void someMethod(){
	Log.trace("Trace msg");
	Log.trace("Debug msg");
	Log.trace("Info msg");
	Log.trace("Warn msg");
	Log.trace("Error msg");
}
public void giveFatal(Throwable t){
	Log.fatal(t.getMessage());
}

}
