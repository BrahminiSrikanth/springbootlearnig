package com.java8features.terminal;
import com.java8features.functionalinterfaceexamples.data.StudentDatabase;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java8features.functionalinterfaceexamples.data.Student;


public class GroupingMinByMaxByExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Grouping Min By example is");
		Map<Integer,Optional<Student>> studMap=StudentDatabase.getAllStudents().stream().collect(Collectors.groupingBy(Student::getGradeLevel,Collectors.minBy(Comparator.comparing(Student::getGpa))));
        System.out.println("studMpa is"+studMap);
	}

}
