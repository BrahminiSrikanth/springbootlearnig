package com.java.collections.linkedlist;

import java.util.LinkedList;

public class LinkedListSearchIterationExample {
	public static void main(String[] args) {
		
		LinkedList<String> progLangs = new LinkedList<>();
		progLangs.add("C");
		progLangs.add("C++");
		progLangs.add("Core Java");
		progLangs.add("Java EE");
		progLangs.add("Spring Framework");
		progLangs.add("Hibernate Framework");
		progLangs.add("Spring Framework");
		System.out.println(progLangs.contains("C"));
		//find the index of first occurence of element
		System.out.println("First occurence of SpringFramework is "+progLangs.indexOf("Spring Framework"));
		//Last index of occurence of element
		System.out.println("Last occurence of SpringFramework is "+progLangs.lastIndexOf("Spring Framework"));

		
	}
	}

