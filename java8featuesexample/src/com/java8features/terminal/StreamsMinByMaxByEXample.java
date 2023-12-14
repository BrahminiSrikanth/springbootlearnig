package com.java8features.terminal;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java8features.functionalinterfaceexamples.data.Student;
import com.java8features.functionalinterfaceexamples.data.StudentDatabase;

public class StreamsMinByMaxByEXample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional<Student> minbByEx = StudentDatabase.getAllStudents().stream().collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
		System.out.println("minByex is"+minbByEx);
		Optional<Student> maxbyEx = StudentDatabase.getAllStudents().stream().collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
		System.out.println("maxByex is"+maxbyEx);
	}

}
