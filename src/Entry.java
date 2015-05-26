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
	private Entry nextEntry;
	
	public Entry(K key2, V value2) {
		this.key = key2 ;
		this.value = value2 ;
		nextEntry = null ;
	}

}
