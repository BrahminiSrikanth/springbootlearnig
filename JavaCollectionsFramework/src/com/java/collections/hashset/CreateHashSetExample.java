package com.java.collections.hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateHashSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> plang = new HashSet<>();
		plang.add("C");
		plang.add("C++");
		plang.add("java");
		System.out.println(plang);
		//Add Duplicate Elements
		plang.add("C++");
		System.out.println(plang);
		//create a hashset from another collection
		//1. Using HashSet Constuctor
		Set<Integer> firstfiveEven = new HashSet<Integer>();
		firstfiveEven.add(2);
		firstfiveEven.add(4);
		firstfiveEven.add(6);
		firstfiveEven.add(8);
		firstfiveEven.add(10);
        System.out.println("First Five Even Numbers are"+firstfiveEven);	
		Set<Integer> tenEven = new HashSet<Integer>(firstfiveEven);
		tenEven.add(12);
		tenEven.add(14);
		tenEven.add(16);
		tenEven.add(18);
		tenEven.add(20);
		System.out.println("Ten Even numbers are"+tenEven);
		//create hashset from another collection using List
		List<Integer> lastFiveEven = new ArrayList<>();
		lastFiveEven.add(100);
		lastFiveEven.add(98);
		lastFiveEven.add(96);
		lastFiveEven.add(94);
		HashSet<Integer> lastTen = new HashSet<>(lastFiveEven);
		lastTen.add(92);
		lastTen.add(90);
		lastTen.add(88);
		lastTen.add(86);
		System.out.println("Last Ten Even elements are"+lastTen);
		
		
		//2. Demo fo Add all
	   Set<Integer> nextFive = new HashSet<>();
	   nextFive.add(22);
	   nextFive.add(24);
	   nextFive.add(26);
	   nextFive.add(28);
	   nextFive.add(30);
	   tenEven.addAll(nextFive);
	   System.out.println("Using Add all demo is"+tenEven);

	}

}
