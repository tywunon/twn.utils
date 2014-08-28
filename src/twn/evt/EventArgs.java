package twn.evt;

/**
 * The Class EventArgs.
 * This class is the base class for all event args processed by the {@link Event} class
 */
public class EventArgs {
	private Object sender;
	private boolean handled;
	public final boolean shouldBeHandled;

	public EventArgs() {
		this(true);
	}
	
	/**
	 * Instantiates a new event args.
	 *
	 * @param shouldBeHandled if <b>true</b> the event will write a notification on the Console 
	 * if none of the listeners setted the handled flag to <b>true</b>. 
	 * Otherwise the event will remain silent even if no listener sets the handled flag.
	 */
	protected EventArgs(boolean shouldBeHandled){
		handled = false;
		this.shouldBeHandled = shouldBeHandled;
	}
	
	/**
	 * Gets the sender.
	 *
	 * @return the sender
	 */
	public Object getSender() {
		return sender;
	}

	/**
	 * Checks for sender.
	 *
	 * @return true, if sender is not <b>null</b>
	 */
	public boolean hasSender(){
		return (sender != null);
	}
	
	/**
	 * Overrides the sender even if setted before.
	 *
	 * @param sender the new sender
	 */
	void overrideSender(Object sender){
		this.sender = null;
		setSender(sender);
	}
	
	/**
	 * Sets the sender.
	 *
	 * @param sender the new sender
	 */
	void setSender(Object sender) {
		if (!hasSender())
			this.sender = sender;
		else if(!isSender(sender)){
			IllegalEventOperationException.throwCatchAndPrintNewIllegalEventOperationException("sender can only be set once.");
		}
	}
	
	/**
	 * Checks if is sender.
	 *
	 * @param sender the sender
	 * @return true, if is sender
	 */
	public boolean isSender(Object sender){
		return (this.sender == sender);
	}
	
	/**
	 * Checks if is not handled.
	 * Returns always false if the shouldBeHandled flag is false
	 *
	 * @return true, if event was not handled
	 */
	public boolean isNotHandled() {
		return !handled && shouldBeHandled;
	}

	/**
	 * Checks if is handled.
	 * Returns always false if the shouldBeHandled flag is false
	 *
	 * @return true, if event was handled
	 */
	public boolean isHandled() {
		return handled && shouldBeHandled;
	}

	/**
	 * Sets the event to be handled.
	 */
	public void setHandled() {
		this.handled = true;
	}
	
	/** The Constant Empty. */
	public static final EventArgs Empty = new EventArgs(false);
}
