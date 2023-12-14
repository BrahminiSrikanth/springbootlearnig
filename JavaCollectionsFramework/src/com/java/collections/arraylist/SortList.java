package com.java.collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {
	public static void main(String[] args) {
	List<Integer> list = new ArrayList<>();
	list.add(10);
	list.add(30);
	list.add(20);
	list.add(50);
	list.add(40);
	System.out.println("Before sorting ");
	System.out.println(list);
	//ascending order
	Collections.sort(list);
	System.out.println("After sorting ");
	System.out.println(list);
	//descendingorder
	Collections.reverse(list);
	System.out.println("After reversing ");
	System.out.println(list);
	
	
	}

}
