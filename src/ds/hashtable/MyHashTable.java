package ds.hashtable;
import java.util.ArrayList;

/**
 * This class is an implementation of the user defined hashtable without synchronization support .
 * @author sreerekha
 * @param <V>
 *
 */
public class MyHashTable<K,V> implements IHashTable<K, V>{
	
	public static final int SIZE = 199 ;
	private Entry<K,V> entriesArray[] ;
	private int entriesCount;
	
	
	@SuppressWarnings("unchecked")
	public MyHashTable ()
	{
		entriesArray = new Entry[SIZE];
		
	}
	
	@SuppressWarnings("unchecked")
	public MyHashTable (int size)
	{
		entriesArray = new Entry[size] ;
	
	}
	

	@Override
	public void put(K key, V value) {
		
		int index = hashFunction(key );
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
		this.entriesCount++;
		
	}

	@Override
	public ArrayList<V> get(K key) {
		
		int index = hashFunction(key);
		Entry<K, V> entry = entriesArray[index];
		
		ArrayList <V> ValuesList  = new ArrayList<V>();
		while (entry != null)
		{
			K tempKey = entry.getKey() ;
			if(tempKey.equals( key))
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
		Entry<K, V> currentEntry = entriesArray[index];
		Entry<K, V> prevEntry = currentEntry;
		
		while (currentEntry != null){
			
			K tempKey = currentEntry.getKey() ;
			
			if(tempKey.equals( key))
			{
				//remove the current entry
				
				prevEntry = currentEntry.getNextEntry();
				Entry <K,V> tempEntry = null;
				if(prevEntry != null)
				{
					 tempEntry = new Entry<K,V>(prevEntry) ;
				}				
				entriesArray[index] = tempEntry ;
				//currentEntry = null ;
				currentEntry = tempEntry;
			}
			else
			{
				prevEntry = currentEntry ;
				currentEntry = currentEntry.getNextEntry();
			}
		}
		
	}

	@Override
	public void removeAll() {
		
		for(int i = 0 ; i< size();i++ )
		{
			entriesArray[i] = null ;
		}
		
	}

	@Override
	public int entriesCount() {
		// TODO Auto-generated method stub
		return this.entriesCount ;
	}
	
	private int size() {
		// TODO Auto-generated method stub
		return this.entriesArray.length ;
	}
	/**
	 * this function is supposed to calculate the index in the array where the corresponding entry needs to be stored.
	 * @param Key
	 * @return
	 */
	private int hashFunction(K Key)
	{
		int hashedIndex = Key.hashCode();
		
		int sizeOfTable = size() ;
		 hashedIndex = Math.abs(hashedIndex);
		if ( hashedIndex> sizeOfTable )
		{
			hashedIndex = hashedIndex%sizeOfTable ;
		}
		return hashedIndex;
	}

	
}
