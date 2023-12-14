package com.java.collections.linkedlist;

import java.util.LinkedList;

//getFirst()
//getLast()//get()//getall()(iterating all elements)
public class RetrieveLinkedListElements {

	public static void main(String[] args) {
		LinkedList<String> fruits= new LinkedList<>();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Mango");
		fruits.add("WaterMelon");
		fruits.add("BlueBerries");
		fruits.add("StrawBerries");
		fruits.add("pineapple");
		//Retrieving Elements from linkedlist
		System.out.println("Retrieving First Element From LinkedList  "+fruits.getFirst());
		System.out.println("Retrieving Last Element From LinkedList     "+fruits.getLast());
		System.out.println("-------------------------------");
		System.out.println("Retriving 3 element from linkedlist"+fruits.get(2));
		System.out.println("---------------------------------");
		System.out.println("Retrieving all elements from linkedlist");
		fruits.forEach(System.out::println);

	}

}
