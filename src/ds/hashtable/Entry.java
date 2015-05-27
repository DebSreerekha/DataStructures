package ds.hashtable;
/**
 * this class represents the entry in the hashtable with collision resolution implementation
 * @author sreerekha
 *
 * @param <K>
 * @param <V>
 */
public class Entry<K,V> {
	
	private K key ;
	private V value ;
	private Entry<K, V> nextEntry;
	
	public Entry(K key2, V value2) {
		this.key = key2 ;
		this.setValue(value2) ;
		setNextEntry(null) ;
	}
	
	
	public K getKey()
	{
		return key;
		
	}
	public void setKey(K key)
	{
		this.key = key ;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Entry<K, V> getNextEntry() {
		return nextEntry;
	}

	public void setNextEntry(Entry<K, V> nextEntry) {
		this.nextEntry = nextEntry;
	}

}
