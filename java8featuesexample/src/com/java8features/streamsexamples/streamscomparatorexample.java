package com.java8features.streamsexamples;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.java8features.functionalinterfaceexamples.data.Student;
import com.java8features.functionalinterfaceexamples.predicate.StudentDatabase;

public class streamscomparatorexample {
	public static List<Student> sortStudentsByName(){
		
		return StudentDatabase.getAllStudents()
				.stream()
				.sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sort Students Using By Name:");
		sortStudentsByName().forEach(System.out::println);
		System.out.println("Sort Students Using By name Method"+sortStudentsByName());
		

	}

}
