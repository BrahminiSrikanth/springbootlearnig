package com.java.collections.linkedlist;

import java.util.LinkedList;
import java.util.List;

//add()
//add(int index,Element e)
//addFirst()
//addLast()
public class CreateLinkedListExample {

	public static void main(String[] args) {
		LinkedList<String> fruits= new LinkedList<>();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Mango");
		fruits.add(null);
		fruits.add(null);
		fruits.add(null);
		System.out.println("Iterating Elements in LinkedList -->"+fruits);
		fruits.add(2, "Watermelon");
		System.out.println("Inserting Element in LinkedList -->"+fruits);
		fruits.set(1, "Green Banana");
		System.out.println("Replacing Element in LinkedList -->"+fruits);
		fruits.addFirst("BlueBerries");
		System.out.println("Adding First Element in LinkedList -->"+fruits);
		fruits.addLast("StrawBerries");
		System.out.println("Adding Last Element in LinkedList -->"+fruits);	
	}

}
