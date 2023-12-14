package com.java.collections.hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CreateHashMapExample {

	public static void main(String[] args) {
		Map<String,Integer> numberMapping = new HashMap<>();
		//add key value pair to map
		numberMapping.put("one", 1);
		numberMapping.put("two", 2);
		numberMapping.put("three",3);
		numberMapping.put("four",4);
		numberMapping.put("five",5);
		//add only one null key - null key is allowed
		numberMapping.put(null,6);
		numberMapping.put(null,10);
		System.out.println("only null value is"+numberMapping);
		//check hash map is empty
		System.out.println("checking empty of hash map is "+numberMapping.isEmpty());
		//size of hashMap
		System.out.println("size of hashMap is"+numberMapping.size());
		//check if key exists in hashmap
		if(numberMapping.containsKey("four")) {
			System.out.println("key value Exists");
		}
		else {
			System.out.println("Key value not Exists");
		}
		//check if value exists in HashMap
		if(numberMapping.containsValue(1)) {
			System.out.println("Value Exist");
		}
		else {
			System.out.println("Value not exists");
		}
        //get value by key
		Integer v1 = numberMapping.get("one");
		System.out.println("value for key one is "+v1);
		//to remove keys from hashmap
		System.out.println(numberMapping.remove("one"));
		System.out.println("After removing the element from the hash map is"+numberMapping);
		
		//get only keys from hashmap
	     Set<String> keyset = numberMapping.keySet();
	     System.out.println("Keyset are"+keyset);
	     
	     //get only values from hashmap
	    Collection<Integer> values= numberMapping.values();
	    System.out.println("Values are"+values);
		
	    //ways to iterate over hashmap
	    //using enhanced for each loop
	    for(Map.Entry<String, Integer> mapitr: numberMapping.entrySet()) {
	    	System.out.println("key entry is"+mapitr.getKey());
	    	System.out.println("key value is"+mapitr.getValue());
	    }
	    
	    //using entries
	    Set<Map.Entry<String, Integer>> entries=numberMapping.entrySet();
	    Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
	    while(iterator.hasNext()) {
	    	Map.Entry<String, Integer> entry = iterator.next();
	    	System.out.println("key is"+entry.getKey());
	    	System.out.println("value is"+entry.getValue());
	    }
	    
	    //using java8 for each
	    numberMapping.forEach((k,v) -> {
	    	System.out.println("key is"+k);
	    	System.out.println("value is"+v);
	    });
	    
	    
		
	}

}
