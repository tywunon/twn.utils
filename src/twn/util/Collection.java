package twn.util;

import java.util.HashMap;
import java.util.HashSet;

public class Collection {
	public static <T> java.util.Set<T> fromSingle(T item) {
		HashSet<T> set = new HashSet<>();
		set.add(item);
		return set;
	}
	
	public static <K,V> java.util.Map<K, V> fromPair(K key, V value){
		HashMap<K, V> map = new HashMap<>();
		map.put(key, value);
		return map;
	}
}
