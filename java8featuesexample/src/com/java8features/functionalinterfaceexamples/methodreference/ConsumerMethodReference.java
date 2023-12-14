package com.java8features.functionalinterfaceexamples.methodreference;
import java.util.List;
import java.util.function.Consumer;

import com.java8features.functionalinterfaceexamples.data.*;
public class ConsumerMethodReference {
static Consumer<Student> lambdac1= s -> System.out.println(s);
static Consumer<Student> methodref = System.out::println;
	
	public static void main(String[] args) {
		List<Student> studenList = StudentDatabase.getAllStudents();
		System.out.println("Using Lambda EXpression");
		studenList.forEach(lambdac1);
		System.out.println("Using Metod Reference");
		studenList.forEach(methodref);

	}

}
