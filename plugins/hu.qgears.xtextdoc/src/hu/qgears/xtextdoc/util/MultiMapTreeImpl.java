package hu.qgears.xtextdoc.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

/**
 * Implementation of <code>MultiMap</code>
 * based on <code>TreeMap</code>. 
 * @author rizsi
 *
 * @param <K>
 * @param <V>
 */
public class MultiMapTreeImpl<K, V> extends TreeMap<K, Collection<V>> implements MultiMap<K, V>{

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<V> get(Object key) {
		List<V> ret=(List<V>)super.get(key);
		if(ret==null)
		{
			ret=new ArrayList<V>();
			put((K)key, ret);
		}
		return ret;
	}
	@Override
	public void putSingle(K key, V value)
	{
		List<V> list=get(key);
		list.add(value);
	}
	@Override
	public void removeSingle(K key, V value) {
		List<V> list=get(key);
		list.remove(value);
		if(list.size()==0)
		{
			remove(key);
		}
	}
}
