package twn.evt;

import java.util.Collection;
import java.util.HashSet;

public class Event<T extends EventArgs> {

	private final Object owner;
	private Collection<IEventHandler<T>> handlerList = new HashSet<>();

	public Event(Object owner) {
		this.owner = owner;
	}
	
	public boolean subscribe(IEventHandler<T> eventHandler) {
		return handlerList.add(eventHandler);
	}

	public boolean unsubscribe(IEventHandler<T> eventhandler) {
		return handlerList.remove(eventhandler);
	}

	public void fire(Object owner, Object sender, T eventArgs) {
		
		if(eventArgs == null){
			IllegalEventOperationException
			.throwCatchAndPrintNewIllegalEventOperationException("EventArgs can not be null");
			return;
		}
		if (this.owner != owner) {
			IllegalEventOperationException
					.throwCatchAndPrintNewIllegalEventOperationException("Owner mismatch. Fire event aborded.");
			return;
		}
		eventArgs.overrideSender(sender);
		for (IEventHandler<T> eventHandler : handlerList) {
			eventHandler.handleEvent(sender, eventArgs);
		}
		if (eventArgs.isNotHandled() && eventArgs.shouldBeHandled()) {
			IllegalEventOperationException
					.throwCatchAndPrintNewIllegalEventOperationException("Event of Type \""
							+ eventArgs.getClass() + "\" was not Handled");
		}
	}
}
