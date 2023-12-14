package com.java8features.functionalinterfaceexamples.predicate;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumerExample {

	static Predicate<Student> gpaPredi = s -> s.getGpa() >= 3.5;
	static Predicate<Student> gradePredi = s -> s.getGradeLevel() >= 3;
	static BiConsumer<String,List<String>> biconsStud = (name,activities) -> System.out.println(name+":"+activities);
	
	public static void main(String[] args) {
		Consumer<Student> stconsumer = (s) -> {if(gradePredi.and(gpaPredi).test(s)) {
			biconsStud.accept(s.getName(),s.getActivities());
		}
		};
		List<Student> studlist = StudentDatabase.getAllStudents();
		studlist.forEach(stconsumer);
		

	}

}
