package com.java8features.functionalinterfaceexamples;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerexample {
	public static void nameandActivities() {
		BiConsumer<String,List<String>> bicons = (name,activities) -> System.out.println(name + ":" + activities);
		List<Student> studentList=StudentDatabase.getAllStudents();
		studentList.forEach(s->bicons.accept(s.getName(),s.getActivities()));
	}

	public static void main(String[] args) {
		BiConsumer<String,String> bicons=(a,b)-> System.out.println("first argument is"+a+", Second argument is"+b);
        bicons.accept("Java7", "Java8");
        BiConsumer<Integer,Integer> multiply=(s1,s2) -> System.out.println("Multiplication is"+s1*s2);
        BiConsumer<Integer,Integer> divison=(s1,s2) -> System.out.println("Divison is"+s1/s2);
        multiply.andThen(divison).accept(20, 10);
        nameandActivities();
	}

}
