package twn.logger;

public class LogItem {
	public final long timestamp;
	public final String message;
	
	public LogItem(long timestamp, String message) {
		this.timestamp = timestamp;
		this.message = message;
	}
	
	public LogItem(String message) {
		this(System.currentTimeMillis(), message);
	}
}
