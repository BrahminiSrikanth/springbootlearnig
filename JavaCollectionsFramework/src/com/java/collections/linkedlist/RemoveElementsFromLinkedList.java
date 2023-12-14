package com.java.collections.linkedlist;

import java.util.LinkedList;

public class RemoveElementsFromLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> fruits= new LinkedList<>();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Mango");
		fruits.add("WaterMelon");
		fruits.add("BlueBerries");
		fruits.add("StrawBerries");
		fruits.add("pineapple");
	    System.out.println("Intial LinkedList--->"+fruits);
	    fruits.removeFirst();
	    System.out.println("Removong First ELement From LinkedList"+fruits);
	    fruits.removeLast();
	    System.out.println("Removong Last ELement From LinkedList"+fruits);
	    System.out.println("Removong a particular ELement using index From LinkedList "+fruits.remove(2));
	    //returns booleanSystem.out.println("Removong a particular ELement  From LinkedList"+ fruits.remove("StrawBerries"));
	    System.out.println("LinkedList--->"+fruits);
	    fruits.remove();
	    System.out.println("LinkedList--->"+fruits);
        fruits.add("Mango");
        fruits.add("Mango");
        System.out.println("LinkedList--->"+fruits);
        fruits.removeFirstOccurrence("Mango");
        System.out.println("LinkedList--->"+fruits);
        fruits.removeLastOccurrence("Mango");
        System.out.println("LinkedList--->"+fruits);
	    
	    

	    

	}

}
