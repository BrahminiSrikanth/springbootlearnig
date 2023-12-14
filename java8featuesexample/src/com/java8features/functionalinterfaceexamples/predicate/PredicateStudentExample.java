package com.java8features.functionalinterfaceexamples.predicate;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {
	public static Predicate<Student> p1= s1 -> s1.getGradeLevel()>=3;
	public static Predicate<Student> p2= s2 -> s2.getGpa()>=3.5;
	public static void main(String[] args) {
		List<Student> studentList=StudentDatabase.getAllStudents();
		filterStudents_Gpa(studentList);
		
		
	}
	public static void filterStudents_Gpa(List<Student> studentList) {
		studentList.forEach(s -> {if(p1.test(s)) {
			System.out.println(s);
		}
		});
	}

}
