package twn.lang;

public final class Cast {
	public final static <T> T as(Object obj, Class<T> clazz){
		if(clazz.isInstance(obj))
			return clazz.cast(obj);
		return null;
	}
}
