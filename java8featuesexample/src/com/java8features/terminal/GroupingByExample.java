package com.java8features.terminal;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java8features.functionalinterfaceexamples.data.StudentDatabase;

import com.java8features.functionalinterfaceexamples.data.Student;

public class GroupingByExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Grouping By Example Demo");

		Map<String,List<Student>> groupbyEx = StudentDatabase.getAllStudents().stream().collect(Collectors.groupingBy(Student::getGender));
		System.out.println("Students retrieved based on Gender are"+groupbyEx);
		
		Map<String,List<Student>> customgroupbyEx = StudentDatabase.getAllStudents().stream().collect(Collectors.groupingBy(s -> s.getGpa()>3.7 ? "OUTSTANDING":"AVERAGE"));
		System.out.println("Custom group ex is"+customgroupbyEx);
	}

}
