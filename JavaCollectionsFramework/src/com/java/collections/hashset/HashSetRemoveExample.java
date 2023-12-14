package com.java.collections.hashset;

import java.util.HashSet;
import java.util.Set;

//remove()
//removeAll()
//clear()
public class HashSetRemoveExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Set<Integer> numbers = new HashSet<>();
       numbers.add(1);
       numbers.add(2);
       numbers.add(3);
       numbers.add(4);
       numbers.add(5);
       numbers.add(6);
       numbers.add(7);
       numbers.add(8);
       numbers.add(9);
       numbers.add(10);
       System.out.println("Initial hash Set is"+numbers);
       //Using remove()
       System.out.println(numbers.remove(5));
       System.out.println("The elements  remained in hashset is"+numbers);
       //Using removeAll()
       Set<Integer> evenNumbers = new HashSet<>();
       evenNumbers.add(2);
       evenNumbers.add(4);
       evenNumbers.add(6);
       evenNumbers.add(8);
       evenNumbers.add(10);
       System.out.println(numbers.removeAll(evenNumbers));
       System.out.println("The elements  remained in hashset is"+numbers);
       numbers.clear();
       //using clear() method
       System.out.println("The hash Set Remained is"+numbers);
       
       
       
	}

}
