package twn.lang;

import java.lang.reflect.Field;
import java.util.Set;

import twn.evt.Event;
import twn.evt.EventArgs;
import twn.util.Cast;
import twn.util.Clazz;

public class Property<T> {
	private T value;
	private final Object eventOwner = new Object();
	public final Event<PropertyChangedEventArgs<T>> propertyChanged = new Event<>(eventOwner);
	
	public Property() {}
	
	public Property (T initValue) {
		set(initValue);
	}
	
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
	
	public static abstract class PropertyContainer {
		
		private final Object eventOwner;
		public final Event<PropertyContainerChangedArgs> containerChanged;
		
		protected PropertyContainer() {
			eventOwner = new Object();
			containerChanged = new Event<>(eventOwner);
		}
		
		protected final void initPropertys() {
			Set<Field> fields = Clazz.getAllFields(this.getClass());
			fields.stream()
			.filter(
					(f) -> f.getType().equals(Property.class)
					)
			.forEach(
					(f) -> {
						boolean accessible = f.isAccessible();
						try {
							f.setAccessible(true);
							Property<?> prop = Cast.as(f.get(this), Property.class);
							if(prop != null) {
								prop.propertyChanged.subscribe(this::propertyChanged);
							}
							f.setAccessible(accessible);
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							f.setAccessible(accessible);
						}
					}
			);
		}
		
		protected final void propertyChanged(Object sender, PropertyChangedEventArgs<?> args) {
			Clazz.getAllFields(this.getClass()).stream()
			.filter(
				(f) -> {
					boolean accessible = f.isAccessible();
					boolean result = false;
					try {
						f.setAccessible(true);
						Object obj = f.get(this);
						result = obj == sender;
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						f.setAccessible(accessible);
					}
					return result;
				}
			)
			.forEach(
				(f) -> {
					raiseModelObjectChanged(f.getName(), args.oldValue, args.newValue);
				}
			);
		}
		
		protected final <T> void raiseModelObjectChanged(String propertyName, T oldValue, T newValue){
			containerChanged.fire(eventOwner, this, new PropertyContainerChangedArgs(this, propertyName, newValue.getClass(), oldValue, newValue));
		}
	}
	
	public static class PropertyContainerChangedArgs extends EventArgs{
		public final PropertyContainer container;
		public final String property;
		public final Class<?> valueType;
		public final Object oldValue;
		public final Object newValue;
		
		public PropertyContainerChangedArgs(PropertyContainer container, String property, Class<?> valueType, Object oldValue, Object newValue) {
			super(false);
			this.container = container;
			this.property = property;
			this.valueType = valueType;
			this.oldValue = oldValue;
			this.newValue = newValue;
		}
	}
	
	
}
