package twn.lang;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import twn.evt.Event;
import twn.evt.EventArgs;
import twn.util.Cast;
import twn.util.Clazz;

// TODO: Auto-generated Javadoc
/**
 * The Class Property contains a single value of any Type. The value can be set or received and will always fire an event when the value changes.
 * It is recommended to declare all usages to this class final.
 *
 * @param <T> the generic type
 */
public class Property<T> {
	
	/** The value. */
	private T value;
	
	/** The event lock. */
	private final Object eventLock = new Object();
	
	/** The value changed event. */
	public final Event<ValueChangedEventArgs<T>> valueChanged = new Event<>(eventLock);
	
	/**
	 * The willSet function will be called whenever the set method is called as long as willSet is not null, otherwise willSet is ignored. If willSet returns false the setting attempt will be aborted.
	 * The apply method will be called with the old and the new Value. <br>
	 * <code>willSet.accept(oldValue, newValue)</code>
	 */
	public BiFunction<T, T, Boolean> willSet = null;
	
	/**
	 * The didSet function will be called whenever the set method is called and the willSet function returns true or is null, regardless if the current value was set to a new value or not.
	 * The accept method will be called with the old and the new Value. <br>
	 * <code>didSet.accept(oldValue, newValue)</code>
	 */
	public BiConsumer<T, T> didSet = null;
	
	/**
	 * Instantiates a new property.
	 */
	public Property() {}
	
	/**
	 * Instantiates a new property.
	 *
	 * @param initValue the init value
	 */
	public Property (T initValue) {
		set(initValue);
	}
	
	/**
	 * Instantiates a new property.
	 *
	 * @param willSet the will set function
	 */
	public Property(BiFunction<T, T, Boolean> willSet) {
		this.willSet = willSet;
	}
	
	/**
	 * Instantiates a new property.
	 *
	 * @param didSet the did set function
	 */
	public Property(BiConsumer<T, T> didSet) {
		this.didSet = didSet;
	}
	
	
	
	/**
	 * Instantiates a new property.
	 *
	 * @param willSet the will set
	 * @param didSet the did set
	 */
	public Property(BiFunction<T, T, Boolean> willSet, BiConsumer<T, T> didSet) {
		this.willSet = willSet;
		this.didSet = didSet;
	}
	
	/**
	 * Instantiates a new property.
	 *
	 * @param value the value
	 * @param willSet the will set
	 * @param didSet the did set
	 */
	public Property(T value, BiFunction<T, T, Boolean> willSet,
			BiConsumer<T, T> didSet) {
		super();
		this.value = value;
		this.willSet = willSet;
		this.didSet = didSet;
	}

	/**
	 * Gets the Value
	 *
	 * @return the value
	 */
	public T get() {
		return value;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new Property value
	 */
	public void set(T value) {
		T oldValue = this.value;
		T newValue = value;
		if(willSet != null){
			if(!willSet.apply(oldValue, newValue))
				return;
		}
		if(oldValue != newValue){
			this.value = newValue;
			valueChanged.fire(eventLock, this, new ValueChangedEventArgs<T>(oldValue, newValue));
		}
		if(didSet != null) {
			didSet.accept(oldValue, newValue);
		}
	}
	
	@Override
	public String toString() {
		return String.format("Property %s: %s", value.getClass().getSimpleName(), value);
	}
	
	/**
	 * The Class PropertyChangedEventArgs is the value delivered by the propertyChanged event from the Property class.
	 *
	 * @param <T> the generic type
	 */
	public static class ValueChangedEventArgs<T> extends EventArgs {
		
		/** The old value. */
		public final T oldValue;
		
		/** The new value. */
		public final T newValue;
		
		/**
		 * Instantiates a new value changed event args.
		 *
		 * @param oldValue the old value
		 * @param newValue the new value
		 */
		public ValueChangedEventArgs(T oldValue, T newValue) {
			super(false);
			this.oldValue = oldValue;
			this.newValue = newValue;
		}
	}
	
	/**
	 * The Class PropertyContainer is supposed to be derived by any other class that uses the Property class.
	 * It will provide an event lock, an containerChanged event and will automatically register to all valueChanged events. 
	 * And fire it's own propertyChanged, when one property changes.
	 * Therefore the derived class should call initProperty after all it's fields of class Property are initialized.
	 */
	public static abstract class PropertyContainer {
		
		/** The event lock. */
		private final Object eventLock;
		
		/** The property changed event. */
		public final Event<PropertyChangedArgs> propertyChanged;
		
		/**
		 * Instantiates a new property container.
		 */
		protected PropertyContainer() {
			eventLock = new Object();
			propertyChanged = new Event<>(eventLock);
		}
		
		/**
		 * Call this to register to all initialized Properties propertyChanged events.
		 */
		protected final void initPropertys() {
			Set<Field> fields = Clazz.getAllFields(this.getClass());
			fields.stream()
			.filter((f) -> f.getType().equals(Property.class))
			.forEach(
					(f) -> {
						boolean accessible = f.isAccessible();
						try {
							f.setAccessible(true);
							Property<?> prop = Cast.as(f.get(this), Property.class);
							if(prop != null) {
								prop.valueChanged.subscribe(this::propertyChanged);
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
		
		/**
		 * This Method will be registered as handle for all Properties declared in derived classes.
		 *
		 * @param fireingProperty the fireing property
		 * @param args the ValueChangedEventArgs
		 */
		protected final void propertyChanged(Object fireingProperty, ValueChangedEventArgs<?> args) {
			Clazz.getAllFields(this.getClass()).stream()
			.filter(
				(f) -> {
					boolean accessible = f.isAccessible();
					boolean result = false;
					try {
						f.setAccessible(true);
						Object fieldRef = f.get(this);
						result = fieldRef == fireingProperty;
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						f.setAccessible(accessible);
					}
					return result;
				}
			)
			.forEach((f) -> { raisePropertyChanged(f.getName(), args.oldValue, args.newValue); });
		}
		
		/**
		 * Raise property changed.
		 *
		 * @param <T> the generic type
		 * @param propertyName the property name
		 * @param oldValue the old value
		 * @param newValue the new value
		 */
		protected final <T> void raisePropertyChanged(String propertyName, T oldValue, T newValue){
			propertyChanged.fire(eventLock, this, new PropertyChangedArgs(this, propertyName, newValue.getClass(), oldValue, newValue));
		}
	}
	
	/**
	 * The Class PropertyChangedArgs.
	 */
	public static class PropertyChangedArgs extends EventArgs{
		
		/** The container. */
		public final PropertyContainer container;
		
		/** The property name. */
		public final String propertyName;
		
		/** The value type. */
		public final Class<?> valueType;
		
		/** The old value. */
		public final Object oldValue;
		
		/** The new value. */
		public final Object newValue;
		
		/**
		 * Instantiates a new property changed args.
		 *
		 * @param container the container
		 * @param propertyName the property
		 * @param valueType the value type
		 * @param oldValue the old value
		 * @param newValue the new value
		 */
		public PropertyChangedArgs(PropertyContainer container, String propertyName, Class<?> valueType, Object oldValue, Object newValue) {
			super(false);
			this.container = container;
			this.propertyName = propertyName;
			this.valueType = valueType;
			this.oldValue = oldValue;
			this.newValue = newValue;
		}
	}	
}
