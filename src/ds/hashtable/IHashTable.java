package ds.hashtable;
import java.util.ArrayList;




/**
 * Simple interface to capture the contracts of a hashtable .
 * The hashtable has methods to put data , get data  delete an entry or delete all the entries
 * @author sreerekha
 *
 * @param <K>
 * @param <V>
 */
public interface IHashTable<K,V> {

	public void put(K key,V value);
	
	public ArrayList<V> get(K key);
	
	public void delete(K key);
	
	public void removeAll();
	
	public int entriesCount();
	
	public void putPairs(K[] keys,V[] values);

}
