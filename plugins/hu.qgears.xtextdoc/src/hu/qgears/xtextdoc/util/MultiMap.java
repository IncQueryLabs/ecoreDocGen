package hu.qgears.xtextdoc.util;

import java.util.Collection;
import java.util.Map;

/**
 * Interface for maps that map keys to lists of objects.
 * Any objects can be added to all keys and they are collected into the list.
 * @author rizsi
 *
 * @param <K> Type of keys
 * @param <V> Type of the values
 */
public interface MultiMap<K,V> extends Map<K, Collection<V>> {
	/**
	 * Put a single object to the key.
	 * The object will be added to the end of the list
	 * that is referenced by the key.
	 * @param key
	 * @param value
	 */
	void putSingle(K key, V value);
	/**
	 * Remove a single object from the key.
	 * @param key
	 * @param value
	 */
	void removeSingle(K key, V value);
}
