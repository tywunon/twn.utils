package twn.evt;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author TyWuNon
 *
 * @param <T> extends {@link EventArgs}
 * 
 * This class is the code class for the event functionality. In objects of this class listeners subscribe and unsubscribe and the event will be called through the fire method
 */
public class Event<T extends EventArgs> {

	
	/** The lock. */
	private final Object lock;
	
	/** The handler. */
	private Collection<IEventHandler<T>> handler = new HashSet<>();

	/**
	 * Instantiates a new event.
	 *
	 * @param lock the event Lock
	 * 
	 * The given Lock is a shared secret between the event and the possible senders of this Event.
	 * Only if the same Object reference is hand over in the fire Method the event will actually fire and call all the subscribers.
	 * <pre>for example: <code>
	 * private final Object eventLock = new Object();
	 * public final Event<EventArgs> = new Event<>(eventLock);</code></pre>
	 * Now only the the class containing this code can fire an event, because no Other class can hand over the right eventLock, but can subscribe to it
	 */
	public Event(Object lock) {
		this.lock = lock;
	}
	
	
	/**
	 * Subscribe.
	 *
	 * @param eventHandler the event handler
	 * @return true, if successful
	 */
	public boolean subscribe(IEventHandler<T> eventHandler) {
		return handler.add(eventHandler);
	}

	
	
	/**
	 * Unsubscribe.
	 *
	 * @param eventHandler the event handler
	 * @return true, if successful
	 */
	public boolean unsubscribe(IEventHandler<T> eventHandler) {
		return handler.remove(eventHandler);
	}

	/**
	 * Fire.
	 *
	 * @param lock the event lock
	 * @param sender the sender
	 * @param eventArgs the event args
	 */
	public void fire(Object lock, Object sender, T eventArgs) {
		
		if(eventArgs == null){
			IllegalEventOperationException
			.throwCatchAndPrintNewIllegalEventOperationException("EventArgs can not be null");
			return;
		}
		if (this.lock != lock) {
			IllegalEventOperationException
					.throwCatchAndPrintNewIllegalEventOperationException("Lock mismatch. Fire event aborded.");
			return;
		}
		eventArgs.overrideSender(sender);
		for (IEventHandler<T> eventHandler : handler) {
			eventHandler.handleEvent(sender, eventArgs);
		}
		if (eventArgs.isNotHandled() && eventArgs.shouldBeHandled) {
			IllegalEventOperationException
					.throwCatchAndPrintNewIllegalEventOperationException("Event of Type \""
							+ eventArgs.getClass() + "\" was not Handled");
		}
	}
}
