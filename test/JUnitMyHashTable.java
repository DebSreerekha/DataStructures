import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

import ds.hashtable.MyHashTable;


public class JUnitMyHashTable {

	@Test
	public void checkDataInsertionForOneItem() {
		MyHashTable<String,String> hashtable = new MyHashTable<String,String> ();
		hashtable.put("Key", "Value");
		ArrayList<String> Values = (ArrayList<String>) hashtable.get("Key");
		assertSame("Value",Values.get(0));
	} 
	@Test
	public void checkDataInsertionForManyItems() {
		MyHashTable<String,String> hashtable = new MyHashTable<String,String> ();
		
		String [] KeysArray = {"V","I","B","G","Y","O","R","V"};
		String [] ValuesArray = {"Violet","Indigo","Blue","Green","Yellow","Orange","Red","Vitriol"};
		int size = KeysArray.length ;
		
		for(int i =0;i<size;i++)
		{
			hashtable.put(KeysArray[i], ValuesArray[i]);
		}
		ArrayList<String> list = hashtable.get("V");
		
		assertEquals("Violet",list.get(0));
		assertEquals("Vitriol",list.get(1));
	}
	
	@Test
	public void checkDeleteOneRecord(){
		MyHashTable<String,String> hashtable = new MyHashTable<String,String> ();
		
		String [] KeysArray = {"V","I","B","G","Y","O","R","V"};
		String [] ValuesArray = {"Violet","Indigo","Blue","Green","Yellow","Orange","Red","Vitriol"};
		int size = KeysArray.length ;
		
		for(int i =0;i<size;i++)
		{
			hashtable.put(KeysArray[i], ValuesArray[i]);
		}
		
		hashtable.delete("I");
		
		ArrayList<String> deletedList = hashtable.get("I");
		
		System.out.println("after delete");
		int arraySize = deletedList.size();
		assertEquals(0,arraySize);
	}

	@Test
	public void checkDeleteMultipleRecords(){
		MyHashTable<String,String> hashtable = new MyHashTable<String,String> ();
		
		String [] KeysArray = {"V","I","B","G","Y","O","R","V"};
		String [] ValuesArray = {"Violet","Indigo","Blue","Green","Yellow","Orange","Red","Vitriol"};
		int size = KeysArray.length ;
		
		for(int i =0;i<size;i++)
		{
			hashtable.put(KeysArray[i], ValuesArray[i]);
		}
		
		hashtable.delete("V");
		
		ArrayList<String> deletedList = hashtable.get("V");
		
		System.out.println("after delete");
		int arraySize = deletedList.size();
		assertEquals(0,arraySize);
	}
	@Test
	public void checkDeleteAll(){
		MyHashTable<String,String> hashtable = new MyHashTable<String,String> ();
		
		String [] KeysArray = {"V","I","B","G","Y","O","R","V"};
		String [] ValuesArray = {"Violet","Indigo","Blue","Green","Yellow","Orange","Red","Vitriol"};
		int size = KeysArray.length ;
		
		for(int i =0;i<size;i++)
		{
			hashtable.put(KeysArray[i], ValuesArray[i]);
		}
		
		hashtable.removeAll();
		
		ArrayList<String> deletedList = hashtable.get("I");
		
		System.out.println("after delete");
		int arraySize = deletedList.size();
		assertEquals(0,arraySize);
	}
	@Test
	public void checkEntriesCount(){
		MyHashTable<String,String> hashtable = new MyHashTable<String,String> ();
		
		String [] KeysArray = {"V","I","B","G","Y","O","R","V"};
		String [] ValuesArray = {"Violet","Indigo","Blue","Green","Yellow","Orange","Red","Vitriol"};
		int size = KeysArray.length ;
		
		for(int i =0;i<size;i++)
		{
			hashtable.put(KeysArray[i], ValuesArray[i]);
		}
		
		assertEquals(size,hashtable.entriesCount());
	}
}
