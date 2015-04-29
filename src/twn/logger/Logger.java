package twn.logger;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Logger {
	public static boolean export;
	private static Set<OutputStream> logStreams;
	private static Set<OutputStream> simpleLogStreams;
	private static List<LogItem> logItems;
	
	static{
		export = false;
		logStreams = new HashSet<OutputStream>();
		simpleLogStreams = new HashSet<OutputStream>();
		logItems = new ArrayList<>();
	}
	
	public static void addStream(OutputStream outStream) {
		addStream(outStream, true);
	}
	
	public static void addStream(OutputStream outStream, boolean simple) {
		if(outStream == null) return;
		if(simple) {
			simpleLogStreams.add(outStream);
		} else {
			logStreams.add(outStream);
		}
	}
	
	public static void log(Object obj) {
		if(obj == null) log("null");
		else log(obj.toString());
	}
	
	public static void log(String msg) {
		LogItem item = new LogItem(msg);
		logItems.add(item);
		if(export) {
			simpleLogStreams.forEach((stream) -> printSimpleItem(stream, item));
			logStreams.forEach((stream) -> printItem(stream, item));
		}
	}
	
	public static void printToStream(OutputStream outStream, int amount) {
		printToStream(outStream, amount, false, true);
	}
	
	public static void printToStream(OutputStream outStream, int amount, boolean add, boolean simple) {
		if(add) addStream(outStream, simple);
		logItems.sort((LogItem item1, LogItem item2) -> Long.compare(item1.timestamp, item2.timestamp));
		for(int i=0; i<amount; i++) {
			LogItem item = logItems.get(i);
			if(simple) { printSimpleItem(outStream, item); }
			else { printItem(outStream, item); }
		}
	}
	
	public static void printAllToStream(OutputStream outStream) {
		printAllToStream(outStream, false, true);
	}
	
	public static void printAllToStream(OutputStream outStream, boolean add, boolean simple) {
		printToStream(outStream, logItems.size(), add, simple);
	}
	
	private static void printSimpleItem(OutputStream outStream, LogItem item) {
		String message = String.format("Logger -> %s", item.message);
		printItem(outStream, message);
	}
	
	private static void printItem(OutputStream outStream, LogItem item) {
		String message = String.format("[%1$tD - %1$tT] Logger -> %2$s", new Date(item.timestamp), item.message);
		printItem(outStream, message);
	}
	
	private static void printItem(OutputStream outStream, String message) {
		if(outStream == null || message == null) return;
		message += "\n";
		try {
			outStream.write(message.getBytes());
		} catch (IOException e) { }
	}
}
