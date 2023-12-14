package com.java8features.terminal;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.java8features.functionalinterfaceexamples.data.StudentDatabase;

public class StreamsMappingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Mapping Example Demo");
		List<String> nameslist = StudentDatabase.getAllStudents().stream().collect(Collectors.mapping(s->s.getName(),Collectors.toList()));
		Set<String> namesset = StudentDatabase.getAllStudents().stream().collect(Collectors.mapping(s->s.getName(),Collectors.toSet()));
		System.out.println("names list is"+nameslist);
		System.out.println("names set is"+namesset);
	

	}

}
