package com.java.learning.collections;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Cache
 * 
 * @author shvetap
 *
 */
public class Cache2 {

	private int cacheSize;
	private ConcurrentHashMap<Integer, Integer> cache;

	public Cache2(int initialCapacity) {
		this.cacheSize = initialCapacity;
		cache = new ConcurrentHashMap<>(cacheSize);
	}

	/**
	 * Adds if not present and updates most recently used
	 * 
	 * @param key
	 */
	public void add(Integer key) {
		if (!cache.containsKey(key)) {
			boolean removalRequired = cache.size() == cacheSize;
			Iterator<Integer> iterator = cache.keySet().iterator();
			while (iterator.hasNext()) {
				Integer iteratorKey = iterator.next();
				if (removalRequired && cache.get(iteratorKey) == cacheSize) {
					cache.remove(iteratorKey);
				} else {
					cache.put(iteratorKey, cache.get(iteratorKey) + 1);
				}
			}
		} else {
			Integer presentRequestValue = cache.get(key);
			Iterator<Integer> iterator = cache.keySet().iterator();
			while (iterator.hasNext()) {
				Integer iteratorKey = iterator.next();
				if (cache.get(iteratorKey) < presentRequestValue) {
					cache.put(iteratorKey, cache.get(iteratorKey) + 1);
				}
			}
		}
		cache.put(key, 1);
	}

}
