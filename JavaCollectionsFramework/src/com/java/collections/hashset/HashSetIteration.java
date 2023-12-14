package com.java.collections.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetIteration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Iterate using Enhanced for loop
		Set<String> courses = new HashSet<String>();
		courses.add("C");
		courses.add("C++");
		courses.add("java");
		courses.add("Python");
		System.out.println("Using For Each Loop is");
		for(String course: courses) {
			System.out.println("course is: "+course);
		}
		
		//2. Basic loop with iterator
		System.out.println("Course using iterator is");
		for(Iterator<String> courseitr=courses.iterator();courseitr.hasNext();) {
			String course = courseitr.next();
			System.out.println("course is: "+course);
		}
		
		//3.while loop using iterator
		Iterator<String> course2itr = courses.iterator();
		System.out.println("courses iterating using while loop");
		while(course2itr.hasNext()) {
			System.out.println(course2itr.next());
		}
		
		//for each with lambda ()
		System.out.println("For Each using lambda");
		courses.forEach(System.out::println);
		
		//using stream +foreach()+lambda
		System.out.println("Stream For Each using lambda");
		courses.stream().filter(course -> !"java".equals(course)).forEach(System.out::println);

	}

}
