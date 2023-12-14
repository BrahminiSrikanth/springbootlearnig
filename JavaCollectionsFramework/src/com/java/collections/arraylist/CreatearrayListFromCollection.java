package com.java.collections.arraylist;

import java.util.ArrayList;
import java.util.List;

public class CreatearrayListFromCollection {

	public static void main(String[] args) {
		//create arrylist from the collection using constructor
		List<Integer> prime=new ArrayList<>();
		prime.add(2);
		prime.add(3);
		prime.add(5);
		prime.add(7);
		prime.add(11);
		
		List<Integer> tenPrimes=new ArrayList<>(prime);
		tenPrimes.add(13);
		tenPrimes.add(17);
		System.out.println(tenPrimes);
		
		//demo of addall
		List<Integer> subseqprime = new ArrayList<>();
		subseqprime.add(19);
		subseqprime.add(21);
		subseqprime.add(23);
		subseqprime.add(29);
		
		tenPrimes.addAll(subseqprime);
		System.out.println(tenPrimes);

	}

}
