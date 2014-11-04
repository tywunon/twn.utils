package twn.util;

import java.util.HashMap;
import java.util.HashSet;

public final class Collection {
	public final static <T> java.util.Collection<T> fromItem(T item) {
		HashSet<T> set = new HashSet<>();
		set.add(item);
		return set;
	}
	
	public final static <K,V> java.util.Map<K, V> fromPair(K key, V value){
		HashMap<K, V> map = new HashMap<>();
		map.put(key, value);
		return map;
	}
}
