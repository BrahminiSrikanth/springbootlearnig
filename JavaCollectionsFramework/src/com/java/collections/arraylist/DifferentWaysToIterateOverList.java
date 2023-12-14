package com.java.collections.arraylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class DifferentWaysToIterateOverList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<String> courses=Arrays.asList("java","spring","hibernate");
       //basic for loop
        for(int i=0;i<courses.size();i++) {
        	System.out.println(courses.get(i));
        }
        //enhnaced for loop
        for(String course:courses) {
        	System.out.println(course);
        }
        System.out.println("Using Iterator for loop");
        for (Iterator iterator = courses.iterator(); iterator.hasNext();) {
			String course = (String) iterator.next();
			System.out.println(course);	
		}
        System.out.println("Using Iterator While loop");
        Iterator iterator = courses.iterator();
        while(iterator.hasNext()) {
        	String course=(String) iterator.next();
        	System.out.println(course);		
        }
        //demo of stream java8+lambda
        System.out.println("demo of stream java8+lambda");
        courses.stream().forEach(course->System.out.println(course));
        //demo of onlylambda
        System.out.println("demo of java8+lambda");
        courses.forEach(course->System.out.println(course));
	}

}
