package com.java.collections.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWritearrayListExample {

	public static void main(String[] args) {
	//demo of concurrentmodification exception
		/*List<String> list=new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
	
		for(Iterator itr=list.iterator();itr.hasNext();){
			String str=(String) itr.next();
			if(str.equals("one")) {
				list.remove("one");
			}
			if(str.equals("three")) {
				list.add("four");
			}
		}
*/
		//CopyOnwritearrayList demo
		List<String> list=new CopyOnWriteArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
	System.out.println("Before List iterator");
	System.out.println(list);
		for(Iterator itr=list.iterator();itr.hasNext();){
			String str=(String) itr.next();
			if(str.equals("one")) {
				list.remove("one");
			}
			if(str.equals("three")) {
				list.add("four");
			}
		}
		System.out.println("After List operations");
		System.out.println(list);
	}

}
