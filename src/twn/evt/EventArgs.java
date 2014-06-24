package twn.evt;

public class EventArgs {
	private Object sender;
	private boolean handled;
	private final boolean shouldBeHandled;

	public EventArgs() {
		this(true);
	}
	
	protected EventArgs(boolean shouldBeHandled){
		handled = false;
		this.shouldBeHandled = shouldBeHandled;
	}
	
	public Object getSender() {
		return sender;
	}

	public boolean hasSender(){
		return (sender != null);
	}
	
	void overrideSender(Object sender){
		this.sender = null;
		setSender(sender);
	}
	
	void setSender(Object sender) {
		if (!hasSender())
			this.sender = sender;
		else if(!isSender(sender)){
			IllegalEventOperationException.throwCatchAndPrintNewIllegalEventOperationException("sender can only be set once.");
		}
	}
	
	public boolean isSender(Object sender){
		return (this.sender == sender);
	}

	public boolean shouldBeHandled(){
		return shouldBeHandled;
	}
	
	public boolean isNotHandled() {
		return !handled && shouldBeHandled;
	}

	public boolean isHandled() {
		return handled && shouldBeHandled;
	}

	public void setHandled() {
		this.handled = true;
	}
	public static final EventArgs Empty = new EventArgs(false);
}
