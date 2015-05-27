package test;
import java.util.ArrayList;
import java.util.Iterator;

import ds.hashtable.MyHashTable;


public class MyHashTableTest {
	
	public static void main(String []args)
	{
		String [] KeysArray = {"V","I","B","G","Y","O","R","V"};
		String [] ValuesArray = {"Violet","Indigo","Blue","Green","Yellow","Orange","Red","Vitriol"};
		int size = KeysArray.length ;
		MyHashTable<String, String> ht = new MyHashTable<String , String>(size);
		
		for(int i =0;i<size;i++)
		{
			ht.put(KeysArray[i], ValuesArray[i]);
		}
		ArrayList<String> list = ht.get("V");
		
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
		
	}

}
