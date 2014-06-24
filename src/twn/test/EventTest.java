package twn.test;

import static org.junit.Assert.*;

import org.junit.Test;

import twn.evt.Event;
import twn.evt.EventArgs;

public class EventTest {

	@Test
	public void eventRecived() {
		EventHolder evh = new EventHolder();
		new EventReciever (evh);
		evh.invoke();
	}

	private static class EventHolder {
		private final Object eventOwner = new Object();
		public final Event<EventArgs> event = new Event<>(eventOwner);
		
		public void invoke() {
			event.fire(eventOwner, this, EventArgs.Empty);
		}
	}
	
	private static class EventReciever {
		public EventReciever(EventHolder evh){
			evh.event.subscribe(this::handle);
		}
		
		private void handle(Object sender, EventArgs eventArgs) {
			assertTrue("Event recieved", true);
		}
	}
}
