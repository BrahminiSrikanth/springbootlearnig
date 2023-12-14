package com.java.collections;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<String> collection = new ArrayList<>();
		collection.add("banana");
		collection.add("apple");
		collection.add("mango");
		System.out.println(collection);
		collection.remove("banana");
		System.out.println(collection);
		System.out.println(collection.contains("apple"));
		collection.forEach(System.out::println);
		

	}

}
