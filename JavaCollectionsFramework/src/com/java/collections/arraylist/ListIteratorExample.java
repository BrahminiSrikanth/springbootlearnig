package com.java.collections.arraylist;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {

	public static void main(String[] args) {
		List<String> plang=Arrays.asList("Java","C","C++","Python");
		
		//listiterator demo
		ListIterator listIterator=plang.listIterator();
		System.out.println("Forward direction using listiteartor");
		while(listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		System.out.println("Backward direction using listiteartor");
		ListIterator listIterator1=plang.listIterator(plang.size());
		while(listIterator1.hasPrevious()) {
			System.out.println(listIterator1.previous());
		}
	}

}
