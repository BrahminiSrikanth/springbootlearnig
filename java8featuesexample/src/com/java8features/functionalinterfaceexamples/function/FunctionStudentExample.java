package com.java8features.functionalinterfaceexamples.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudentExample {
static Function<List<Student>,Map<String,Double>> studentFunction = (students) -> {
	Map<String,Double> studMap = new HashMap<String,Double>();
	students.forEach(s -> studMap.put(s.getName(), s.getGpa()));
	return studMap;
	
};
	public static void main(String[] args) {
		System.out.println(studentFunction.apply(StudentDatabase.getAllStudents()));

	}

}
