package twn.lang;

/**
 * The Class SetOnce holds a single value of any Type that can only be settet once. It have not to be on initialization but can.
 * Any further tries to set the value will be ignored and the old value remain.
 * It is recommended to declare all references to this class final.
 * 
 * @param <T> the generic type
 */
public class SetOnce<T> {
	private boolean isSet = false;
	private T value = null;

	/**
	 * Instantiates a new sets the once.
	 */
	public SetOnce() {}
	
	/**
	 * Instantiates a new SetOnce.
	 *
	 * @param initValue the initValue
	 */
	public SetOnce(T initValue) {
		setValue(initValue);
	}
	
	/**
	 * Checks if the value is set.
	 *
	 * @return true, if value was set before
	 */
	public boolean isSet(){
		return isSet;
	}
	
	/**
	 * Value.
	 *
	 * @return the value
	 */
	public T value(){
		return value;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the value
	 * @return true, if successfully set the value
	 */
	public boolean setValue(T value) {
		if(!isSet) {
			this.value = value;
			isSet = true;
			return true;
		}
		return false;
	}
}
