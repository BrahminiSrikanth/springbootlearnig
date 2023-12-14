package com.java8features.streamsexamples;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.java8features.functionalinterfaceexamples.data.*;
public class StreamsMapExample {

	public static List<String> namesList(){
		
		List<String> nameList = StudentDatabase.getAllStudents()
				                .stream() //returns Stream<Student>
				                .map(Student::getName)
				                .map(String::toUpperCase)
				                .collect(Collectors.toList());
		return nameList;
	}
	public static Set<String> namesSet(){
		Set<String> names = StudentDatabase.getAllStudents()
				            .stream()
				            .map(Student::getName)
				            .map(String::toUpperCase)
				            .collect(Collectors.toSet());
		return names;
	}
	
	public static void main(String[] args) {
		
		System.out.println("names list is:"+namesList());
		System.out.println("names set is"+namesSet());
	}

}
