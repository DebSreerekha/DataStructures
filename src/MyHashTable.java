import java.util.ArrayList;
import java.util.HashSet;
import java.util.SortedSet;



/**
 * This class is an implementation of the user defined hashtable without synchronization support .
 * @author sreerekha
 * @param <V>
 *
 */
public class MyHashTable<K,V> implements IHashTable<K, V>{
	
	public static final int SIZE = 37 ;
	private Entry<K,V> entriesArray[] ;
	private HashSet<K> keySet ;
	
	@SuppressWarnings("unchecked")
	public MyHashTable ()
	{
		entriesArray = new Entry[SIZE];
		keySet = new HashSet<K>();
	}
	
	@SuppressWarnings("unchecked")
	public MyHashTable (int size)
	{
		entriesArray = new Entry[size] ;
		keySet = new HashSet<K>();
	}
	

	@Override
	public void put(K key, V value) {
		
		int index = hashFunction(key);
		System.out.println("index is :"+index);
		Entry<K,V> entry = new Entry<K,V>(key,value);
		entry.setNextEntry(null);
		if (entriesArray[index] == null ) // for putting the first element
		{
			entriesArray[index] = entry ;
		}
		else // if there is already a list of elements , traverse to the end and add the entry.
		{
			Entry<K, V> tempEntry = entriesArray[index];
			Entry<K, V> prevEntry = tempEntry ;
			while(tempEntry != null)
			{   
				prevEntry = tempEntry ;
				tempEntry = tempEntry.getNextEntry();
			}
			prevEntry.setNextEntry(entry);
		}		
		
	}

	@Override
	public ArrayList<V> get(K key) {
		int index = hashFunction(key);
		Entry<K, V> entry = entriesArray[index];
		
		ArrayList <V> ValuesList  = new ArrayList<V>();
		while (entry != null)
		{
			K tempKey = entry.getKey() ;
			if(tempKey == key)
			{
				V Value = entry.getValue();
				ValuesList.add(Value);
			}
			
			entry = entry.getNextEntry();
		}
		return ValuesList;
	}

	@Override
	public void delete(K key) {
		
		int index = hashFunction(key);
		entriesArray[index] = null ;
		
	}

	@Override
	public void removeAll() {
		
		for(int i = 0 ; i< size();i++ )
		{
			entriesArray[i] = null ;
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.entriesArray.length;
	}
	/**
	 * this function is supposed to calculate the index in the array where the corresponding entry needs to be stored.
	 * @param Key
	 * @return
	 */
	private int hashFunction(K Key)
	{
		int hashedIndex = Key.hashCode();
		//System.out.println("Hashcodes :"+hashedIndex);
		int sizeOfTable = size() ;
		if (hashedIndex > sizeOfTable )
		{
			hashedIndex = Math.abs(hashedIndex)%sizeOfTable ;
		}
		return hashedIndex;
	
	}

	@Override
	public SortedSet<K> keys() {
		
		return null;
	}

	
	

}
