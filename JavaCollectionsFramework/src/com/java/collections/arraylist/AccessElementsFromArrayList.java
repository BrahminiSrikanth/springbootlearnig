package com.java.collections.arraylist;

import java.util.ArrayList;
import java.util.List;

public class AccessElementsFromArrayList {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//demo isEmpty(),size(),get(),set()
		List<String> planguage=new ArrayList<>();
		System.out.println("Top Programming Language is empty"+planguage.isEmpty());
		planguage.add("C");
		planguage.add("Java");
		planguage.add("Python");
		System.out.println("Size of Programming Language is "+planguage.size());
		//retrieve element at given index
		String bestpl=planguage.get(1);
		System.out.println("Best Programming Language is "+bestpl);
		//set elment
		planguage.set(0,"JavaScript");
		System.out.println("Programming language list after set is"+planguage);
		

		
	}

}
