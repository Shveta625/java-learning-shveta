package com.java.learning.collections;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Cache
 * 
 * @author shvetap
 *
 */
public class Cache extends LinkedHashSet<Integer> {

	private static final long serialVersionUID = -3942883321804789973L;
	private int cacheSize;

	public Cache(int initialCapacity) {
		super(initialCapacity);
		this.cacheSize = initialCapacity;
	}

	@Override
	public boolean add(Integer e) {
		boolean exists = remove(e);
		if (!exists && this.size() == cacheSize) {
			this.remove(this.iterator().next());
		}
		super.add(e);
		return exists;
	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		boolean stateChanged = false;
		for (Integer integer : c) {
			if (!add(integer)) {
				stateChanged = true;
			}
		}
		return stateChanged;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Cache)) {
			return false;
		}
		return super.equals(o) && this.cacheSize == ((Cache) o).cacheSize;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
