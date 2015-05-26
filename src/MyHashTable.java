/**
 * This class is an implementation of the user defined hashtable without synchronization support .
 * @author sreerekha
 * @param <V>
 *
 */
public class MyHashTable<K,V> implements IHashTable<K, V>{
	
	public static final int SIZE = 37 ;
	private K keysArray[] ;
	
	public MyHashTable ()
	{
		keysArray = (K[]) new Object[SIZE] ;
	}
	
	public MyHashTable (int size)
	{
		keysArray = (K[]) new Object[size] ;
	}
	

	@Override
	public void put(K key, V value) {
		
		int index = hashFunction(key);
		System.out.println("index is :"+index);
		if (keysArray[index] == null )
		{
			keysArray[index] = key ;
		//	Entry<K,V> entry = new Entry<K,V>(key,value);
		}
		//else
			
		
	}

	@Override
	public V get(K key) {
		int index = hashFunction(key);
		if (keysArray[index] != null)
		{
		//return (Entry)KeysArray[index].get
		}
		return null;
	}

	@Override
	public void delete(K key) {
		
		int index = hashFunction(key);
		keysArray[index] = null ;
		
	}

	@Override
	public void removeAll() {
		
		for(int i = 0 ; i< size();i++ )
		{
			keysArray[i] = null ;
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.keysArray.length;
	}
	/**
	 * this function is supposed to calculate the index in the array where the corresponding entry needs to be stored.
	 * @param Key
	 * @return
	 */
	private int hashFunction(K Key)
	{
		int hashedIndex = Key.hashCode();
		System.out.println("Hashcodes :"+hashedIndex);
		int sizeOfTable = size() ;
		if (hashedIndex > sizeOfTable )
		{
			hashedIndex = Math.abs(hashedIndex)%sizeOfTable ;
		}
		return hashedIndex;
	
	}

}
