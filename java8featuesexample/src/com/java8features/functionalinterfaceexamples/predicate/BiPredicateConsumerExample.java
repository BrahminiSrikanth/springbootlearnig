package com.java8features.functionalinterfaceexamples.predicate;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;


import com.java8features.functionalinterfaceexamples.StudentDatabase;

public class BiPredicateConsumerExample {
static BiPredicate<Integer,Double> bipred = (grade,gpa)-> grade >=3 && gpa>=3.9;
static BiConsumer<String,List<String>> bicons = (name,activities) -> System.out.println(name+":"+activities);
	public static void main(String[] args) {
		
		Consumer<Student> cons =  (s) -> { if(bipred.test(s.getGradeLevel(),s.getGpa())) {
			bicons.accept(s.getName(),s.getActivities());
		}};
		
	   List<Student> studlist = StudentDatabase.getAllStudents();
		studlist.forEach(cons);
		
		
	
		

	}

}
