package com.java8features.streamsexamples;

import java.util.List;
import java.util.stream.Collectors;

import com.java8features.functionalinterfaceexamples.data.Student;
import com.java8features.functionalinterfaceexamples.data.StudentDatabase;

public class StreamsFilterExample {

	public static  List<Student> filterStudents(){
		return StudentDatabase.getAllStudents().stream()//stream<student>
				.filter((s)->s.getGender().equals("female"))//stream<student>
				.collect(Collectors.toList());
		
	}
	public static void main(String[] args) {
		System.out.println("Filter Students are");
		filterStudents().forEach(System.out::println);
		System.out.println("filter students is"+filterStudents());

	}

}
