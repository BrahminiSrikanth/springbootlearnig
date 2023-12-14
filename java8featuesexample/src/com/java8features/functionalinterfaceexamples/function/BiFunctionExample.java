package com.java8features.functionalinterfaceexamples.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {
	//here List<student>,Predicate<Student> are inputs and Map is output
	static BiFunction<List<Student>,Predicate<Student>,Map<String,Double>> biFunction =  (students,studentPredicate) -> {
		
		Map<String,Double> studGradeMap = new HashMap<>();
	    students.forEach((s)->{if (studentPredicate.test(s)) {
	    	studGradeMap.put(s.getName(),s.getGpa());
	    }
	    });
	    return studGradeMap;
	    };	
		
	public static void main(String[] args) {
		Predicate<Student> studPred = (s) -> s.getGpa()>3.5;
	System.out.println(biFunction.apply(StudentDatabase.getAllStudents(),studPred));
	
	
	}
	

}
