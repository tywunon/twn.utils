package twn.util;

import twn.evt.Event;
import twn.evt.EventArgs;

public class Property<T> {
	private T value;
	private final Object eventOwner = new Object();
	public final Event<PropertyChangedEventArgs<T>> propertyChanged = new Event<>(eventOwner);
	
	public T get() {
		return value;
	}
	
	public void set(T value){
		if(value != this.value){
			T oldValue = this.value;
			this.value = value;
			propertyChanged.fire(eventOwner, this, new PropertyChangedEventArgs<T>(value, oldValue));
		}
	}
	
	public static class PropertyChangedEventArgs<T> extends EventArgs {
		public final T newValue;
		public final T oldValue;
		
		public PropertyChangedEventArgs(T newValue, T oldValue) {
			super(false);
			this.newValue = newValue;
			this.oldValue = oldValue;
		}
	}
}
