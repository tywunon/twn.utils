package twn.util;

public class SetOnce<T> {
	private boolean isSet = false;
	private T value = null;

	public SetOnce() {}
	public SetOnce(T value) {
		setValue(value);
	}
	
	public boolean isSet(){
		return isSet;
	}
	
	public T value(){
		return value;
	}
	
	public boolean setValue(T value) {
		if(!isSet) {
			this.value = value;
			isSet = true;
			return true;
		}
		return false;
	}
}
